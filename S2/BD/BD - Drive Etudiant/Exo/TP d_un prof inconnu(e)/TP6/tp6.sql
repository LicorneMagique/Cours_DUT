SET SERVEROUTPUT ON;

--1
CREATE OR REPLACE FUNCTION ps_FinValidite(mem membre.num_membre%TYPE) RETURN DATE
IS
	v_fin_adhesion DATE;
BEGIN
	SELECT ADD_MONTHS(adhesion, duree) INTO v_fin_adhesion
	FROM membre
	WHERE num_membre=mem;
	
	RETURN v_fin_adhesion;
EXCEPTION
	WHEN NO_DATA_FOUND THEN RAISE_APPLICATION_ERROR(-20002, 'Ce membre est inconnu', TRUE);
END;
/

--2
CREATE OR REPLACE FUNCTION ps_AdhesionAJour(pNum NUMBER) RETURN BOOLEAN
IS
BEGIN
	IF (ps_FinValidite(pNum) >= SYSDATE) THEN
		RETURN TRUE;
	ELSE
		RETURN FALSE;
	END IF;
END;
/

DECLARE
	v_num NUMBER := 1;
BEGIN
	IF (ps_AdhesionAJour(v_num)) THEN
		DBMS_OUTPUT.PUT_LINE('Membre n°'||v_num||' : adhésion à jour ');
	ELSE
		DBMS_OUTPUT.PUT_LINE('Membre n°'||v_num||' : adhésion terminée ');
	END IF;
END;
/

--3
CREATE OR REPLACE FUNCTION ps_mesureActivite(pMonths NUMBER) RETURN NUMBER
IS
	v_cpt NUMBER := 0;
	c_activity CURSOR IS
		SELECT num_membre, COUNT(*) FROM emprunt
		WHERE CREELE BETWEEN ADD_MONTHS(SYSDATE, -(pMonths)) AND SYSDATE
		GROUP BY num_membre
		ORDER BY COUNT(*) DESC;
BEGIN
	FOR i IN c_activity LOOP
		EXIT WHEN v_cpt = 1;
	END LOOP;
END;
/