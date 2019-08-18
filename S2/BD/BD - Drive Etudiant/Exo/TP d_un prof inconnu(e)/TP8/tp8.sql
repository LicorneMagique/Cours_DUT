SET SERVEROUTPUT ON;

--1
CREATE OR REPLACE FUNCTION nbemp(numDept emp.deptno%TYPE)
RETURN NUMBER
IS
	v_nb NUMBER;
BEGIN
	SELECT COUNT(*) INTO v_nb FROM emp WHERE deptno = numDept;
	RETURN v_nb;
EXCEPTION
	WHEN NO_DATA_FOUND THEN RAISE_APPLICATION_ERROR(-20002, 'This department does not exist', TRUE); /*bof*/
END;
/

--2
CREATE OR REPLACE FUNCTION deptno_by_dname(deptName dept.dname%TYPE)
RETURN dept.deptno%TYPE
IS
	v_no dept.deptno%TYPE;
BEGIN
	SELECT deptno INTO v_no FROM dept WHERE dname = deptName;
	RETURN v_no;
EXCEPTION
	WHEN NO_DATA_FOUND THEN RAISE_APPLICATION_ERROR(-20002, 'This department does not exist', TRUE);
END;
/

--3
CREATE OR REPLACE FUNCTION nbemp_by_dname(deptName dept.dname%TYPE)
RETURN NUMBER
IS
	v_nb NUMBER;
BEGIN
	SELECT COUNT(*) INTO v_nb FROM emp JOIN dept USING (deptno)
	WHERE dname = deptName;
	RETURN v_nb;
EXCEPTION
	WHEN NO_DATA_FOUND THEN RAISE_APPLICATION_ERROR(-20002, 'This department does not exist', TRUE);/*bof*/
END;
/

--4
CREATE OR REPLACE PROCEDURE augmentation(numEmp IN emp.empno%TYPE, percent IN NUMBER) IS
BEGIN
	UPDATE emp SET sal = (1+(percent)/100)*sal
	WHERE empno = numEmp;
	COMMIT;
END;
/

DECLARE
	v_no NUMBER := 7369;
	v_sal emp.sal%TYPE;
BEGIN
	DBMS_OUTPUT.PUT_LINE('-----Avant modif-----');
	SELECT sal INTO v_sal FROM emp WHERE empno = v_no;
	DBMS_OUTPUT.PUT_LINE('Salaire de '||v_no||' : '||v_sal);
	
	DBMS_OUTPUT.PUT_LINE('-----Après modif (+10%) -----');
	augmentation(v_no, 10);
	SELECT sal INTO v_sal FROM emp WHERE empno = v_no;
	DBMS_OUTPUT.PUT_LINE('Salaire de '||v_no||' : '||v_sal);
END;
/



--5
CREATE OR REPLACE PROCEDURE nom_minuscules(v_emp IN OUT emp%ROWTYPE)
IS
BEGIN
	v_emp.ename := LOWER(v_emp.ename);
	COMMIT;
END;
/

DECLARE
	CURSOR c_emp IS
		SELECT * FROM emp;
BEGIN
	FOR i IN c_emp LOOP
		nom_minuscules(i);
		DBMS_OUTPUT.PUT_LINE(i.empno||' - '||i.ename);
	END LOOP;
END;
/