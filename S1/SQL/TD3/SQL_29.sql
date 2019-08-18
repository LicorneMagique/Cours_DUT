create table equipement
(
code_equipement varchar(100) PRIMARY KEY ,
nom_equipement varchar(100)
);
create table type_hebergement
(code_type_hebergement varchar(100) PRIMARY KEY,
 nom_type_hebergement varchar(100), 
nombre_de_place integer
);
create table possession 
(code_equipement varchar(100) references equipement(code_equipement),
 code_type_hebergement varchar(100) references type_hebergement(code_type_hebergement),
constraint pk_poss primary key (code_equipement, code_type_hebergement)
); 
create table zone
(code_zone varchar(100) PRIMARY KEY,
 nom_zone varchar(100)
);
create table habitation 
(
nohabitation varchar(100) PRIMARY KEY, 
remarques_particulieres varchar(100), 
code_zone varchar(100) references zone(code_zone), 
code_type_hebergement varchar(100) references type_hebergement(code_type_hebergement)
);

insert into equipement values( '1', 'Refrigerateur');
insert into equipement values('2','Cuisiniere');
insert into equipement values('3','Salon de jardin');
insert into equipement values('4','Cafetiere');
insert into equipement values('5','Couvertures');
insert into equipement values('6','Draps');
insert into equipement values('7','Friteuse');
insert into equipement values('8','Bidon eau');
insert into equipement values('9','Plaque de cuisson');

insert into type_hebergement values('1','Bungalow','6');
insert into type_hebergement values('2','Caravane','4');
insert into type_hebergement values('3','Mobil-home','6');

insert into possession values('1','1'); 
insert into possession values('1','3'); 
insert into possession values('2','1'); 
insert into possession values('2','3'); 
insert into possession values('3','1'); 
insert into possession values('3','3'); 
insert into possession values('4','1'); 
insert into possession values('4','2'); 
insert into possession values('4','3'); 
insert into possession values('5','1'); 
insert into possession values('5','2'); 
insert into possession values('5','3'); 
insert into possession values('6','1'); 
insert into possession values('7','1'); 
insert into possession values('8','2'); 
insert into possession values('9','2'); 

insert into zone values('1','La belle epoque');
insert into zone values('2','Les annees folles');
insert into zone values('3','Les annees Twist');
insert into zone values('4','Far-west');

insert into habitation values('1','Petit jardin devant le bungalow','1','1');
insert into habitation values('2','RAS','2','2');
insert into habitation values('3','RAS','3','2');
insert into habitation values('4','RAS','4','2');
insert into habitation values('5','Television installee','1','2');
insert into habitation values('6','RAS','1','3');
insert into habitation values('7','RAS','4','3');
insert into habitation values('8','RAS','3','2');
insert into habitation values('9','RAS','3','1');
insert into habitation values('10','Logement pour velos','4','3');

SELECT nom_type_hebergement FROM type_hebergement;

SELECT nom_zone FROM zone;

SELECT * FROM habitation;

SELECT nom_type_hebergement FROM type_hebergement WHERE nombre_de_place>4;

SELECT nohabitation  FROM habitation WHERE code_zone=4;

SELECT nom_zone, code_zone FROM zone WHERE nom_zone LIKE 'Le%';

SELECT nohabitation, nom_zone FROM habitation hab, zone zo WHERE hab.code_zone=zo.code_zone;

SELECT nom_equipement FROM equipement eq, type_hebergement tyh, possession po WHERE po.code_equipement=eq.code_equipement AND tyh.nom_type_hebergement='Bungalow';

SELECT nohabitation, nombre_de_place FROM habitation hab, type_hebergement tyh WHERE hab.code_type_hebergement=tyh.code_type_hebergement;

SELEcT nombre_de_place FROM type_hebergement tyh, habitation hab, zone zo WHERE tyh.code_type_hebergement=hab.code_type_hebergement AND hab.code_zone=zo.code_zone AND nom_zone='Far-west';

SELECT MIN(nombre_de_place) FROM type_hebergement;

SELECT MAX(nombre_de_place) FROM type_hebergement;

SELECT COUNT(nohabitation) FROM habitation;

SELECT COUNT(nohabitation) FROM habitation hab, zone zo WHERE hab.code_zone=zo.code_zone AND nom_zone='Far-west';   
