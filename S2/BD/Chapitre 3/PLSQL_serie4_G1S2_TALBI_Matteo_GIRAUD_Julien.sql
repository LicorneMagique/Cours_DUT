/* Série 4 */

/* Ex 1 */
SET SERVEROUTPUT ON
BEGIN
    FOR v_emp IN (SELECT ename, comm FROM emp) LOOP
        IF v_emp.comm IS NOT NULL THEN
            DBMS_OUTPUT.put_line('L''employé '|| v_emp.ename||' a une commission de '|| v_emp.comm ||' dollars.'); 
        ELSE
            DBMS_OUTPUT.put_line('L''employé '|| v_emp.ename ||' n''a pas de commission.'); 
        END IF;
    END LOOP;
END;

/* Ex 2 */
SET SERVEROUTPUT ON
CREATE TABLE employees AS SELECT * FROM hr.employees;
ALTER TABLE employees ADD etoiles VARCHAR2(50);

DECLARE
CURSOR curseur_etoiles IS
    SELECT employee_id, NVL(ROUND(salary/1000),0) sal_et
    FROM employees 
    FOR UPDATE OF etoiles;
    v_etoiles curseur_etoiles%ROWTYPE;
BEGIN
    OPEN curseur_etoiles; LOOP
        FETCH curseur_etoiles INTO v_etoiles;
        EXIT WHEN curseur_etoiles%NOTFOUND;
        UPDATE employees SET etoiles = RPAD('*', v_etoiles.sal_et,'*')
        WHERE current of curseur_etoiles;
    END LOOP;
    COMMIT;
    CLOSE curseur_etoiles;
    END;

SELECT employee_id, salary, etoiles
FROM employees;
    
DROP TABLE employees;

/* Ex 3 */
CREATE TABLE departments AS SELECT * FROM hr.departments
SET SERVEROUTPUT ON 
DECLARE 
    CURSOR curseur_dept IS 
        SELECT department_id,department_name 
        FROM    departments 
        WHERE department_id < 100 
        ORDER BY    department_id; 
        
    CURSOR curseur_emp(v_deptno NUMBER) IS 
        SELECT last_name,job_id,hire_date,salary 
        FROM    employees 
        WHERE  department_id = v_deptno AND employee_id < 120; 
  
  enrg_dept curseur_dept%ROWTYPE; 
  enrg_emp curseur_emp%ROWTYPE; 

BEGIN 
    FOR enrg_dept in curseur_dept LOOP 
        DBMS_OUTPUT.PUT_LINE ('N° dept : ' ||  enrg_dept.department_id ||  '  Dept : ' || enrg_dept.department_name); 
        FOR enrg_emp in curseur_emp(enrg_dept.department_id) LOOP 
            DBMS_OUTPUT.PUT_LINE (RPAD(enrg_emp.last_name,20) ||RPAD(enrg_emp.job_id,20) || RPAD(enrg_emp.hire_date,20) ||enrg_emp.salary);    
        END LOOP; 
        DBMS_OUTPUT.PUT_LINE(LPAD('-',66,'-')); 
    END LOOP;        
END; 

DROP TABLE departments;