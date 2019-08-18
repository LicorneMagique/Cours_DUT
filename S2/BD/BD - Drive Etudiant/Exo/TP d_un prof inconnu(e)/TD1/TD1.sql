--1
SELECT * FROM assure
WHERE age BETWEEN 20 AND 40
  AND sexe='MASCULIN'
  AND prenom LIKE '_M%';

--2
SELECT sexe, COUNT(*) FROM assure
GROUP BY sexe;

--5
SELECT DISTINCT assure.id_ass, nom, prenom, sexe, situation, age FROM assure, contrat
WHERE etat='BLOQUE'
  AND contrat.ID_ASS=assure.ID_ASS;
SELECT * FROM assure;

--6
SELECT org, COUNT(*) FROM contrat
GROUP BY org;

--8
SELECT DISTINCT assure.id_ass, nom, prenom, sexe, situation, age FROM assure, contrat
WHERE contrat.ID_ASS=assure.ID_ASS
  AND (SELECT COUNT(*) FROM contrat 
		WHERE contrat.id_ass=assure.id_ass 
		AND etat='ACTIF' GROUP BY ID_ASS) > 1;
