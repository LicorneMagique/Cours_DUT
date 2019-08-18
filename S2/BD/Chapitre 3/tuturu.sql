/*
______________________BASES DE DONNÉES____________________
_________________Exercices série n°3 PL/SQL_________________

->Écrire les blocs PL/SQL suivants :
->Vous utiliserez la base de donnée fournie en exemple par ORACLE (par copie des tables EMP et DEPT du schéma SCOTT).
*/

--Avant de commencer on initialise les tables pour la série :
--Suppression des (éventuelles) tables emp et dept:
DROP TABLE emp;
DROP TABLE dept;
--Copie des bonnes tables depuis le schéma SCOTT :
CREATE TABLE emp AS SELECT * FROM SCOTT.emp;
CREATE TABLE dept AS SELECT * FROM SCOTT.dept;

/*
Exercice 1 :
Écrire un bloc PL/SQL permettant d'obtenir le nombre total d'employés.
Afficher cette valeur en utilisant la procédure PUT_LINE du package DBMS_OUTPUT.
*/
--On active la sortie d'écran :
SET SERVEROUTPUT ON
DECLARE
    v_count_empno NUMBER(2); -->Variable de résultat
BEGIN
    --Début du SELECT
    SELECT COUNT(empno) -->SELECT comme en SQL
    INTO v_count_empno -->On précise que le résultat sera mis dans la variable
    FROM emp; -->Comme en SQL, et on termine par ";" car c'est la fin du SELECT
    DBMS_OUTPUT.PUT_LINE('Nombre total d''employés : ' || v_count_empno); -->Affichage du résultat
END;
    
/*
Exercice 2 : Pour un employé donné (numéro saisi au clavier) :
a) Calculer la moyenne des salaires des employés ayant le même travail.
b) Mettre à jour le salaire de cet employé :
-le mettre égal à la moyenne des salaires si son salaire est inférieur à cette moyenne,
-le majorer dans les autres cas.
c) Fournir une solution SQL pour b)
*/
--On active la sortie d'écran :
SET SERVEROUTPUT ON
/*a)*/
ACCEPT p_empno PROMPT 'Entrez le numéro de l''employé : '
DECLARE
    v_moy_sal emp.sal%TYPE;
BEGIN
    SELECT AVG(sal)
    INTO v_moy_sal
    FROM emp
    WHERE job = (
        SELECT job
        FROM emp
        WHERE empno = &p_empno);
    DBMS_OUTPUT.PUT_LINE('Moyenne des sal/aires des employés ayant le même travail : ' || v_moy_sal);
END;

/*b)*/
ACCEPT p_empno PROMPT 'Entrez le numéro de l''employé : '
DECLARE
    v_moy_sal emp.sal%TYPE;
    v_sal emp.sal%TYPE;
BEGIN
    SELECT AVG(sal)
    INTO v_moy_sal
    FROM emp
    WHERE job = (
        SELECT job
        FROM emp
        --Pas de INTO car la variable n'a pas besoin d'être sauvegardée?
        WHERE empno = &p_empno);
    
    SELECT sal
    INTO v_sal
    FROM emp
    WHERE empno = &p_empno;
    
    IF v_sal < v_moy_sal
    THEN
        v_sal := v_moy_sal;
    ELSE
        v_sal := v_sal * 1.1;
    END IF;
    --Mise à jour de la valeur du salaire dans la variable
    
    UPDATE emp
    SET sal = v_moy_sal
    WHERE empno = &p_empno;
    COMMIT;
    --Mise à jour de la valeur du salaire dans la table
END;

/*c)*/
--Ne fonctionne pas, je ne comprends rien
ACCEPT p_empno PROMPT 'Entrez le numéro de l''employé : '
UPDATE emp
SET sal = (
    SELECT decode(least(emp.sal, AVG(sal)), AVG(sal), emp.sal*1.1, AVG(sal))
    FROM emp
    WHERE job = emp.job)
WHERE empno = &p_empno;
COMMIT;

/*
Exercice 3 : Faire un bloc PL/SQL permettant d'obtenir la factorielle d'un entier.
Note : vous utiliserez, en dehors du bloc PL/SQL, la commande DEFINE pour définir une variable p_num pour fournir la valeur de l'entier.
Exemple : "DEFINE p_num = 5"
Dans le bloc PL/SQL, la valeur de p_num sera obtenu par &p_num
*/

DEFINE p_num = 16

--activation de l'affichage
SET SERVEROUTPUT ON

--déclaration de la variable de résultat
DECLARE
    v_fact NUMBER := 1;

BEGIN
    FOR i IN 1..&p_num LOOP
        v_fact := v_fact * i;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('La factorielle de ' || &p_num || ' est : ' || v_fact);
END;

/*
Exercice 4 : Faire un bloc PL/SQL pour créer un tableau d'amortissement d'emprunt individus (table relationnel SLQ à créer en dehors du bloc PL/SQL).
Rappel de mathématiques financières : à amortissement constant, l'annuité est constituée de l'intérêt sur la somme restant due en début d'année auquel on ajoute le remboursement.
Exemple : pour une somme empruntée de 12000 euros, une durée de " ans et un taux d'intérêts de 4%, on devra pouvoir afficher (par ordre SELECT en dehors du bloc PL/SQL) la table suivante :
Durée    Somme due    Remb. Annuel    Intérêt    Annuité
1        12000        4000            480        4480
2        8000         4000            320        4320
3        4000         4000            160        4160
*/

--on supprime une éventuelle table déjà existante
DROP TABLE amo;

--création de la table en SQL
CREATE TABLE amo (
"Durée" NUMBER(2) PRIMARY KEY,
"Somme due" NUMBER(7, 2),
"Remb. Annuel" NUMBER(6, 2),
"Intérêt" NUMBER(5, 2),
"Annuité" NUMBER(6, 2));

--enregistrement des données pour le calculs
ACCEPT p_duree PROMPT 'Entrer la durée en année';
ACCEPT p_somme PROMPT 'Entrer la somme empruntée';
ACCEPT p_interet PROMPT 'Entrer le taux d''intérêt en %';

DECLARE
    v_remb_an amo."Remb. Annuel"%TYPE := &p_somme / &p_duree;
    v_somme_due amo."Somme due"%TYPE;
    v_interet amo."Intérêt"%TYPE;
    v_annuite amo."Annuité"%TYPE := v_remb_an + v_interet;

BEGIN
    FOR i IN 1..&p_duree LOOP
        v_somme_due := &p_somme - v_remb_an * (i - 1);
        v_interet := v_somme_due * &p_interet / 100;
        v_annuite := v_remb_an + v_interet;
        INSERT INTO amo VALUES (i, v_somme_due, v_remb_an, v_interet, v_annuite);
    END LOOP;
    COMMIT;
END;


--vérification en SQL
--ATTENTION : ne pas lancer en même temps que le bloc PL/SQL
SELECT * FROM amo;

/*
Exercice 5 : Faire un bloc PL/SQL permettant d'afficher la table de multiplication d'un nombre saisi au clavier :
a) Créer un tableau PL/SQL 'résultat comprenant deux colones : 'Col1' et 'Col2' ; qui contiendra les résultats fournis par la table de multiplication.
'Col1' contiendra le rang du calcul et 'Col2' le résultat du produit.
b) Afficher le contenu du tableau dans le bloc PL/SQL.
Il faudra par exemple :
    Col1    Col2
    1       8
    2       16
    3       24
    ...     ...
    10      80
*/

--enregistrement du nombre dont on veut la table
ACCEPT p_nombre PROMPT 'Entrer un nombre';

--création de la table (tableau) PL/SQL
TYPE t_mult IS TABLE OF







































































