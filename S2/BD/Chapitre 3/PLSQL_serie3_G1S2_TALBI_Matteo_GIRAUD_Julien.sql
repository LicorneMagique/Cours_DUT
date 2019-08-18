Série 3
/* Ex1 */
SET SERVEROUTPUT ON 
DECLARE
v_nb_emp NUMBER(3);
BEGIN
SELECT COUNT(empno) INTO v_nb_emp FROM emp;
DBMS_OUTPUT.PUT_LINE('Le nombre total d''employés est : '||v_nb_emp);
END;


/* Ex2 */
/* a et b*/
ACCEPT num_emp prompt 'Entrez un numéro d''employé :'
DECLARE 
sal_moy_emp emp.sal%type; 
v_emp_sal emp.sal%type; 
v_job emp.job%TYPE;
BEGIN 
    SELECT job 
    INTO v_job 
    FROM emp 
    WHERE empno=&p_nb;

    SELECT AVG(sal) INTO sal_moy_emp 
    FROM emp 
    WHERE job = (SELECT job FROM emp WHERE empno = &num_emp); 
    DBMS_OUTPUT.put_line('Moyenne des salaires des '||v_job||': '||sal_moy_emp||'¤'); 
    
    IF v_emp_sal < sal_moy_emp THEN 
        v_emp_sal := sal_moy_emp; 
    ELSE 
        v_emp_sal := v_emp_sal*1.1; 
    END IF; 
    DBMS_OUTPUT.put_line('Nouveau salaire : ' ||v_emp_sal); 
    UPDATE emp SET sal = v_emp_sal WHERE empno=&num_emp; 
    COMMIT; 
    
EXCEPTION 
    WHEN INVALID_NUMBER THEN 
        RAISE_APPLICATION_ERROR(-20101,'ERREUR DE TYPE INVALID_NUMBER :'|| SQLERRM || ' CODE ERREUR' || SQLCODE); 
   
    WHEN NO_DATA_FOUND THEN 
        DBMS_OUTPUT.put_line('EMPLOYE INCONNU ' || SQLERRM); 
        RAISE; 

    WHEN OTHERS THEN 
        RAISE_APPLICATION_ERROR(-20111,'Erreur: '|| SQLERRM || ' Code erreur' || SQLCODE); 
END; 

/* c */
UPDATE emp a 
SET sal = (
    SELECT decode(least(a.sal, AVG(sal)), AVG(sal),a.sal*1.1, AVG(sal)) 
    FROM emp 
    WHERE job=a.job) 
WHERE empno=&num;  
COMMIT;


/* Ex3 */
SET SERVEROUTPUT ON
Accept nb prompt 'Entrez le nombre pour la factorielle:' 
DECLARE 
nb_to_big exception; 
nb_negatif exception; 
v_fact number :=1; 
v_saisi number(3); 

BEGIN 
    v_saisi := to_number(&nb); 
    IF v_saisi > 33 THEN 
        RAISE nb_to_big; 
    ELSIF v_saisi < 0 THEN 
        RAISE nb_negatif; 

    END IF; 
    
    FOR i in 1.. v_saisi LOOP 
    v_fact := v_fact*i; 
    END LOOP; 
    
    DBMS_OUTPUT.PUT_LINE('Factorielle : '|| v_fact); 

EXCEPTION 
    WHEN VALUE_ERROR THEN 
        RAISE_APPLICATION_ERROR(-20110,'Erreur de type : '|| SQLERRM|| ' Code erreur ' || SQLCODE); 

    WHEN nb_negatif THEN 
        RAISE_APPLICATION_ERROR(-20111,'Erreur - le nombre saisi ne doit pas être négatif '|| SQLERRM || ' Code erreur ' || SQLCODE); 

    WHEN nb_to_big THEN 
        RAISE_APPLICATION_ERROR(-20112,'Erreur - le nombre saisi doit être inférieur à 84 '|| SQLERRM || ' Code erreur ' || SQLCODE); 

    WHEN OTHERS THEN 
        RAISE_APPLICATION_ERROR(-20113,'Erreur: '|| SQLERRM || ' Code erreur ' || SQLCODE); 
END; 

/* Ex4 */
CREATE TABLE amorti (
Duree number(2) 
CONSTRAINT amorti_pk primary key, 
Somme_due number(8,2), 
Remb_An number(7,2), 
Intérêt number(7,2), 
Annuité number(7,2)); 

ACCEPT somme prompt 'Entrez la somme empruntée :'
ACCEPT duree prompt 'Entrez la durée de l''emprunt en années :'
ACCEPT taux prompt 'Entrez le taux d''intérêt en % :'

DECLARE 
v_remb_annuel amorti.somme_due%type := &somme/&duree; 
v_interet amorti.intérêt%type; 
v_annuite amorti.annuité%type; 
v_somme amorti.somme_due%type; 
BEGIN 
    v_somme := &somme; 
    FOR i IN 1..&duree LOOP 
        v_interet := (v_somme * &taux)/100; 
        v_annuite := v_remb_annuel + v_interet; 
        INSERT INTO amorti VALUES (i, v_somme, v_remb_annuel, v_interet, v_annuite); 
        v_somme := v_somme - v_remb_annuel; 
    END LOOP; 
    COMMIT; 
END; 

/* Ex5.a-b */
SET SERVEROUTPUT ON
ACCEPT p_nb PROMPT 'Numéro à multiplier';
DECLARE 
    TYPE multi IS TABLE OF NUMBER(3) INDEX BY BINARY_INTEGER;
    v_multi multi;
BEGIN
    DBMS_OUTPUT.PUT_LINE('col1'|| ' ' ||'col2'); 
    FOR i IN 1..9 LOOP
        v_multi(i) := &p_nb * i;
        DBMS_OUTPUT.PUT_LINE(i ||chr(9)|| v_multi(i));
    END LOOP;
END;

/* Ex6 */
DROP TABLE amorti; 
CREATE TABLE amorti (
Duree number(2) CONSTRAINT amorti_pk primary key, 
Somme_due number(10,2), 
Remb_An number(8,2), 
Intérêt number(8,2), 
Annuité number(8,2)); 

SET SERVEROUTPUT ON 
ACCEPT somme prompt 'Somme empruntée : '
ACCEPT duree prompt 'Durée d''emprunt : '
ACCEPT taux prompt 'Taux d''intérêt : ' 

DECLARE 
v_remb_annuel amorti.somme_due%type := &somme/&duree; 
v_interet amorti.intérêt%type; 
v_annuite amorti.annuité%type; 
v_somme amorti.somme_due%type; 

BEGIN 
    v_somme := &somme; 
    FOR i IN 1..&duree LOOP 
    v_interet := (v_somme * &taux)/100; 
    v_annuite := v_remb_annuel + v_interet; 
    INSERT INTO amorti VALUES (i, v_somme, v_remb_annuel, v_interet, v_annuite); 
    v_somme := v_somme - v_remb_annuel; 
    END LOOP; 
    COMMIT; 

    DBMS_OUTPUT.PUT_LINE(rpad('Duree',7)||rpad('Intérêt',10)||'Annuité'); 
    FOR enr_amorti IN (SELECT * FROM amorti) LOOP 
        DBMS_OUTPUT.PUT_LINE(rpad(enr_amorti.duree,7)||rpad( enr_amorti.intérêt,10)||enr_amorti.annuité); 
    END LOOP; 
END; 


/* Ex7.a */
/* Solution SQL  */
CREATE TABLE dept as SELECT * FROM scott.dept; 
CREATE TABLE emp as SELECT * FROM scott.emp; 
ALTER TABLE dept ADD (budget number(10,2) DEFAULT 0); 

UPDATE dept 
    SET budget = (SELECT nvl(sum(sal),0) FROM emp WHERE deptno = dept.deptno); 
    COMMIT; 

DROP TABLE dept; 
DROP TABLE emp; 

/* Solution PL/SQL  */    
SET SERVEROUTPUT ON 
CREATE TABLE dept as SELECT * FROM scott.dept; 
CREATE TABLE emp as SELECT * FROM scott.emp; 
ALTER TABLE dept ADD (budget number(10,2) DEFAULT 0); 

DECLARE 
CURSOR curseur_budget IS 
    SELECT deptno, SUM(sal) budget 
    FROM emp 
    GROUP BY deptno; 
BEGIN 
    FOR enr IN curseur_budget LOOP 
        DBMS_OUTPUT.PUT_LINE('Deptno '||enr.deptno||' Budget '|| enr.budget); 
        UPDATE dept 
        SET budget = enr.budget 
        WHERE deptno = enr.deptno; 
    END LOOP; 
COMMIT; 
END; 

DROP TABLE dept; 
DROP TABLE emp;


/* Ex7.b */
/* Solution SQL */  
CREATE TABLE dept as SELECT * FROM scott.dept; 
CREATE TABLE emp as SELECT * FROM scott.emp; 
UPDATE emp 
    SET sal = sal*1.1 
    WHERE deptno IN (
        SELECT deptno 
        FROM dept 
        WHERE UPPER(loc) IN ('DALLAS','NEW YORK')); 
    COMMIT; 
    
DROP TABLE dept; 
DROP TABLE emp; 

/* Solution PL/SQL */  
SET SERVEROUTPUT ON 
CREATE TABLE dept as SELECT * FROM scott.dept; 
CREATE TABLE emp as SELECT * FROM scott.emp; 

DECLARE 
CURSOR curseur_sal IS 
    SELECT sal*1.1 nvsal 
    FROM emp 
    WHERE deptno IN (
        SELECT deptno 
        FROM dept 
        WHERE UPPER(loc) IN ('DALLAS','NEW YORK')) 
FOR UPDATE OF SAL; 

BEGIN 
    FOR enr in curseur_sal LOOP 
        UPDATE emp 
        SET sal = enr.nvsal 
        WHERE current of curseur_sal; 
    END LOOP; 
COMMIT; 
END; 

DROP TABLE dept; 
DROP TABLE emp; 

/* Ex7.c */
/* Solution SQL */ 
CREATE TABLE dept as SELECT * FROM scott.dept; 
CREATE TABLE emp as SELECT * FROM scott.emp; 
ACCEPT num PROMPT 'Nombre de salaires à afficher : ' 
SELECT empno, ename, sal 
FROM (
    SELECT empno, ename, sal 
    FROM emp 
    ORDER BY sal desc) 
WHERE rownum <= &num; 

/* Solution PL/SQL */ 
ACCEPT num PROMPT 'Nombre de salaires à afficher : ' 

DECLARE 
CURSOR curseur_sal IS 
    SELECT empno, ename, sal 
    FROM emp 
    ORDER BY sal DESC; 
v_enrgt curseur_sal%ROWTYPE; 

BEGIN 
    OPEN curseur_sal; 
    FETCH curseur_sal INTO v_enrgt; 
    WHILE curseur_sal%ROWCOUNT <= &num AND curseur_sal%FOUND LOOP 
        DBMS_OUTPUT.PUT_LINE('N°emp ' || v_enrgt.empno|| ' Nom '|| v_enrgt.ename ||' Salaire '|| v_enrgt.sal); 
        FETCH curseur_sal INTO v_enrgt; 
    END LOOP; 
    IF curseur_sal%ROWCOUNT < &num THEN 
        DBMS_OUTPUT.PUT_LINE ('On ne peut afficher seulement ' ||curseur_sal%ROWCOUNT || ' employés'); 
    END IF; 
CLOSE curseur_sal; 
END; 
