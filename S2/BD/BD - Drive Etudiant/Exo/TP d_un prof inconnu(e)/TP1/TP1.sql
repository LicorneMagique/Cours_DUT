--1
SELECT nuwagon FROM wagon
WHERE typewagon='frigo' AND nomgare='tours' AND capacite > 10;

--2
SELECT DISTINCT typewagon FROM wagon, train
WHERE wagon.nuwagon = train.nuwagon
  AND nutrain=4002;

--3
SELECT * FROM reseau
WHERE nomgareorigine = 'tours';

--4
SELECT nutrain FROM trafic, reseau
WHERE trafic.nuligne = reseau.nuligne
  AND nujour = TO_DATE('12/03/13','DD/MM/YY')
  AND nomgareorigine = 'angers'
  AND nomgaredestination = 'beziers';
  
--5
SELECT nuwagon FROM trafic, reseau, train
WHERE trafic.nuligne = reseau.nuligne
  AND train.nutrain = trafic.nutrain
  AND nujour = TO_DATE('12/03/13','DD/MM/YY')
  AND nomgareorigine = 'angers'
  AND nomgaredestination = 'beziers';

--6
SELECT nuligne, COUNT(nuligne) FROM trafic
GROUP BY nuligne
HAVING COUNT(*) = (SELECT COUNT(DISTINCT nujour) FROM trafic);
  
--7
SELECT nomgaredestination FROM reseau
WHERE nuligne = 10;

--8
SELECT SUM(capacite+poidsvide) AS PoidsEnCharge FROM wagon
WHERE nuwagon IN (SELECT nuwagon FROM train WHERE nutrain = 4002);

--9
SELECT * FROM ligne
WHERE nuligne IN (
  SELECT nuligne FROM reseau
  WHERE nomgareorigine='angers' AND nomgaredest='beziers');

--10
SELECT nutrain, COUNT(nuwagon) FROM train
GROUP BY nutrain;

--11
SELECT nutrain, COUNT(nuwagon) FROM train
GROUP BY nutrain
HAVING COUNT(nuwagon) >= 2;

--12
CREATE VIEW vueq12 AS (
  SELECT nutrain, wagon.nuwagon, typewagon, capacite FROM wagon, train
  WHERE train.nuwagon = wagon.nuwagon);