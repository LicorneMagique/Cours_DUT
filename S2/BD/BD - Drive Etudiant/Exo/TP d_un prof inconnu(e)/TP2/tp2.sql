-- 1
/*For*/
SET SERVEROUTPUT ON;
DECLARE
  v_i NUMBER;
BEGIN
  FOR v_i IN 8..507 LOOP
    INSERT INTO genre VALUES (v_i, 'GENRE'||TO_CHAR(v_i));
  END LOOP;
END;
/

/*Loop*/
SET SERVEROUTPUT ON;
DECLARE
  v_i NUMBER;
BEGIN
  v_i := 8;
  LOOP
    INSERT INTO genre VALUES (v_i, 'GENRE'||TO_CHAR(v_i));
    EXIT WHEN v_i = 507;
    v_i := v_i + 1;
  END LOOP;
END;
/

/*While*/
SET SERVEROUTPUT ON;
DECLARE
  v_i NUMBER;
BEGIN
  v_i := 8;
  WHILE v_i <= 507 LOOP
    INSERT INTO genre VALUES (v_i, 'GENRE'||TO_CHAR(v_i));
    v_i := v_i + 1;
  END LOOP;
END;
/

--2
/*COUNT(*)*/
SET SERVEROUTPUT ON;
DECLARE
  v_num NUMBER;
BEGIN
  SELECT COUNT(*) INTO v_num FROM genre WHERE libellegenre LIKE 'GENRE%';
  dbms_output.put_line('Nb lignes : ' || TO_CHAR(v_num));
END;
/

/*Curseur*/
SET SERVEROUTPUT ON;
DECLARE
  v_num NUMBER := 0;
  CURSOR cGenre IS
    SELECT * FROM genre WHERE libellegenre LIKE 'GENRE%';
BEGIN
  FOR vGenre in cGenre LOOP
    v_num := v_num+1;
  END LOOP;
  dbms_output.put_line('Nb lignes : ' || TO_CHAR(v_num));
END;
/

--3
DECLARE
  v_num NUMBER;
  CURSOR salle_sup IS
    SELECT numcinema, numsalle FROM salle
    JOIN cinema USING (numcinema)
    WHERE nom = 'Utopia'
    MINUS (
            SELECT numcinema, numsalle FROM programmation
            JOIN cinema USING (numcinema)
            WHERE nom = 'Utopia'
          );
BEGIN
  FOR v_num IN salle_sup LOOP
    DELETE FROM salle
    WHERE salle.numsalle = v_num.numsalle AND salle.numcinema = v_num.numcinema;
  END LOOP;
END;
/

--4
DECLARE
  CURSOR rec IS
    SELECT titre, budget FROM film
    ORDER BY budget DESC;
   v_i NUMBER := 1;
BEGIN
  FOR j IN rec LOOP
    IF v_i < 6 THEN
      DBMS_OUTPUT.PUT_LINE('Classement : ' || TO_CHAR(v_i) || ' - Nom : ' || j.titre || ' - Budget : ' || j.budget);
    END IF;
    v_i := v_i + 1;
  END LOOP;
END;
/