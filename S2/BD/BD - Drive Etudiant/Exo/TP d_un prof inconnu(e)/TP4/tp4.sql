SET SERVEROUTPUT ON;

-- 1
DECLARE
	CURSOR c_emprunts IS
		SELECT * FROM Emprunt
		JOIN detail USING (num_emprunt);
	v_month NUMBER := 01;
	v_year NUMBER := 2017;
	v_cptm NUMBER := 0;
	v_cpty NUMBER := 0;
BEGIN
	FOR i IN c_emprunts LOOP
		IF EXTRACT(MONTH FROM i.creele) = v_month THEN
			v_cptm := v_cptm + 1;
		END IF;
		IF EXTRACT(YEAR FROM i.creele) = v_year THEN
			v_cpty := v_cpty + 1;
		END IF;
	END LOOP;
	DBMS_OUTPUT.PUT_LINE('Empruntés ce mois ('||v_month||') : ' || v_cptm);
	DBMS_OUTPUT.PUT_LINE('Empruntés cette année ('||v_year||') : ' || v_cpty);
END;
/

-- 2
DECLARE
	CURSOR c_emprunts IS
		SELECT isbn, COUNT(*) nb FROM detail 
		GROUP BY isbn ORDER BY nb DESC;
	v_cpt NUMBER := 1;
BEGIN
	DBMS_OUTPUT.PUT_LINE('5 Ouvrages les plus empruntés');
	FOR i IN c_emprunts LOOP
		DBMS_OUTPUT.PUT_LINE('Numero : '||v_cpt||' - ISBN : '||i.isbn);
		v_cpt := v_cpt + 1;
		EXIT WHEN v_cpt = 6;
	END LOOP;
END;
/

-- 3
DECLARE
	CURSOR c_membres IS
		SELECT num_membre, nom, adhesion, duree, ADD_MONTHS(adhesion, duree) AS fin_adhesion
		FROM membre;
BEGIN
	FOR i IN c_membres LOOP
		IF (SYSDATE > i.fin_adhesion) OR (ADD_MONTHS(SYSDATE,1) > i.fin_adhesion) THEN
			DBMS_OUTPUT.PUT_LINE('Numero '||i.num_membre||' : '||i.nom);
		END IF;
	END LOOP;
END;
/

















-- 4
DECLARE
	CURSOR c_membre IS
		SELECT num_membre FROM membre 
		WHERE MONTHS_BETWEEN(SYSDATE,ADD_MONTHS(adhesion, duree))>24;
	CURSOR c_emprunt IS
		SELECT * FROM emprunt;
	v_membre NUMBER;
	enRegle BOOLEAN;
BEGIN
	FOR i IN c_membre LOOP
		enRegle := true;
		FOR j IN c_emprunt LOOP
			IF i.num_membre = j.num_membre THEN
				IF j.etat_emprunt = 'EC' THEN
					enRegle := false;
				END IF;
				EXIT WHEN j.etat_emprunt = 'EC';
				UPDATE emprunt SET num_membre = null;
			END IF;
		END LOOP;
		IF enRegle THEN
			DELETE FROM membre WHERE membre.num_membre=i.num_membre;
		END IF;
	END LOOP;
END;
/

-- 5
DECLARE
	CURSOR c_gros IS 
		SELECT num_membre, COUNT(*) AS c FROM emprunt 
		GROUP BY num_membre 
		ORDER BY c DESC;
	CURSOR c_petit IS
		SELECT num_membre, COUNT(*) AS c FROM emprunt 
		GROUP BY num_membre 
		ORDER BY c ASC;
	v_cpt NUMBER :=0;
	v_nom VARCHAR2(32);
BEGIN
	DBMS_OUTPUT.PUT_LINE('Les plus gros emprunteurs :');
	FOR i IN c_gros LOOP
		IF v_cpt < 3 THEN
			SELECT nom INTO v_nom FROM membre
			WHERE i.num_membre = membre.num_membre;
			DBMS_OUTPUT.PUT_LINE(v_nom);
			v_cpt := v_cpt +1;
		END IF;
	END LOOP;
	v_cpt :=0;
	DBMS_OUTPUT.PUT_LINE('Les plus petits emprunteurs :');
	FOR i IN c_petit LOOP
		IF v_cpt < 3 THEN
			SELECT nom INTO v_nom FROM membre
			WHERE i.num_membre = membre.num_membre;
			DBMS_OUTPUT.PUT_LINE(v_nom);
			v_cpt := v_cpt +1;
		END IF;
	END LOOP;
END;
/









-- 6
ALTER TABLE membre MODIFY(mobile CHAR(14));
DECLARE
	CURSOR c_mobile IS
		SELECT mobile, num_membre FROM membre
		ORDER BY num_membre DESC;
	v_1 CHAR(2);
	v_2 CHAR(2);
	v_3 CHAR(2);
	v_4 CHAR(2);
	v_5 CHAR(2);
	v_numero CHAR(14);
BEGIN
	FOR i IN c_mobile LOOP
		v_1 := (SUBSTR(i.mobile, 1, 2));
		v_2 := (SUBSTR(i.mobile, 3, 2));
		v_3 := (SUBSTR(i.mobile, 5, 2));
		v_4 := (SUBSTR(i.mobile, 7, 2));
		v_5 := (SUBSTR(i.mobile, 9, 2));
		v_numero := v_1||' '||v_2||' '||v_3||' '||v_4||' '|| v_5;
		UPDATE membre SET membre.mobile = v_numero WHERE i.num_membre = membre.num_membre;
	END LOOP;
END;
/

-- 7
DECLARE
	CURSOR c_ex IS
		SELECT d.isbn, d.num_exemplaire AS exemplaire, COUNT(*) AS nb_emprunts
		FROM detail d
		JOIN exemplaire e ON d.isbn=e.isbn AND d.num_exemplaire=e.num_exemplaire
		GROUP BY d.isbn, d.num_exemplaire;
	v_etat CHAR(2);
BEGIN
	FOR i IN c_ex LOOP
		IF i.nb_emprunts <= 10 THEN
			v_etat := 'NE';
		ELSE IF i.nb_emprunts <= 25 THEN
			v_etat := 'BO';
		ELSE IF i.nb_emprunts <= 40 THEN
			v_etat := 'MO';
		ELSE
			v_etat := 'MA';
		END IF;
		END IF; /*je sais pas pourquoi mais si j'en met qu'un*/
		END IF;	/*ça marche pas*/
		UPDATE exemplaire e SET code_etat = v_etat
		WHERE i.exemplaire = e.num_exemplaire AND i.isbn = e.isbn;
	END LOOP;
END;
/