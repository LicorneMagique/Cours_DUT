SET SERVEROUTPUT ON;

--1
DECLARE
    v_nom emp.ename%TYPE;
BEGIN
    SELECT ename INTO v_nom FROM emp
    WHERE empno = 7844;
    
    DBMS_OUTPUT.PUT_LINE(v_nom);
END;
/

--2
DECLARE
    v_dept dept%ROWTYPE;
BEGIN
    SELECT * INTO v_dept FROM dept
    WHERE dname = 'RESEARCH';
    
    DBMS_OUTPUT.PUT_LINE('No : '|| v_dept.deptno);
    DBMS_OUTPUT.PUT_LINE('Name : '|| v_dept.dname);
    DBMS_OUTPUT.PUT_LINE('Location : '|| v_dept.loc);
END;
/

--3.1
DECLARE
	CURSOR c_dept IS
		SELECT * FROM dept;
BEGIN
	FOR i IN c_dept LOOP
		DBMS_OUTPUT.PUT_LINE('No : '|| i.deptno);
		DBMS_OUTPUT.PUT_LINE('Name : '|| i.dname);
		DBMS_OUTPUT.PUT_LINE('Location : '|| i.loc);
		DBMS_OUTPUT.PUT_LINE('');
	END LOOP;
END;
/

--3.2
DECLARE
	CURSOR c_dept IS
		SELECT deptno, dname, loc, COUNT(empno) AS nbemp FROM dept
		LEFT OUTER JOIN emp USING (deptno)
		GROUP BY deptno, dname, loc
		ORDER BY deptno ASC;
BEGIN
	FOR i IN c_dept LOOP
		DBMS_OUTPUT.PUT_LINE('No : '|| i.deptno);
		DBMS_OUTPUT.PUT_LINE('Name : '|| i.dname);
		DBMS_OUTPUT.PUT_LINE('Location : '|| i.loc);
		DBMS_OUTPUT.PUT_LINE('Employees : '|| i.nbemp);
		DBMS_OUTPUT.PUT_LINE('');
	END LOOP;
END;
/

--4
DECLARE
	CURSOR c_grade4 IS
		SELECT ename, job, sal FROM emp
		JOIN dept USING(deptno)
		JOIN salgrade ON sal BETWEEN losal AND hisal
		WHERE dname = 'SALES' AND grade = 4;
BEGIN
	FOR i IN c_grade4 LOOP
		DBMS_OUTPUT.PUT_LINE('Name : '|| i.ename);
		DBMS_OUTPUT.PUT_LINE('Job : '|| i.job);
		DBMS_OUTPUT.PUT_LINE('Salary : '|| i.sal);
		DBMS_OUTPUT.PUT_LINE('');
	END LOOP;
END;
/

--5
DECLARE
	CURSOR c_grade4 IS
		SELECT emp.ename, emp.job, emp.sal, man.ename AS manname FROM emp
		JOIN dept USING(deptno)
		JOIN salgrade ON sal BETWEEN losal AND hisal
		JOIN emp man ON emp.mgr = man.empno
		WHERE dname = 'SALES' AND grade = 4;
BEGIN
	FOR i IN c_grade4 LOOP
		DBMS_OUTPUT.PUT_LINE('Name : '|| i.ename);
		DBMS_OUTPUT.PUT_LINE('Job : '|| i.job);
		DBMS_OUTPUT.PUT_LINE('Salary : '|| i.sal);
		DBMS_OUTPUT.PUT_LINE('Manager : '|| i.manname);
		DBMS_OUTPUT.PUT_LINE('');
	END LOOP;
END;
/

--6
ALTER TABLE dept ADD (nbemp NUMBER DEFAULT 0);
COMMIT;