/* suppression si la table existe déjà avant de la renommer*/
drop table DETAIL cascade constraints;


drop table DETAILEMPRUNT cascade constraints;drop table EDITEUR cascade constraints;drop table EMPRUNT cascade constraints;drop table EXEMPLAIRE cascade constraints;drop table GENRE cascade constraints;drop table MEMBRE cascade constraints;drop table OUVRAGE cascade constraints;/*==============================================================*//* Table : DETAILEMPRUNT                                        *//*==============================================================*/create table DETAILEMPRUNT (   NUM_EMPRUNT          NUMBER(10)           not null,   NUMERO               INTEGER              not null,   ISBN                 NUMBER(10)           not null,   NUM_EXEMPLAIRE       NUMBER(3)            not null,   RENDULE              DATE,   constraint PK_DETAILEMPRUNT primary key (NUM_EMPRUNT, NUMERO),   constraint UQ_DETAILEMPRUNT unique (NUM_EMPRUNT, ISBN, NUM_EXEMPLAIRE));/*==============================================================*//* Table : EDITEUR                                              *//*==============================================================*/create table EDITEUR (   NUM_EDITEUR          INTEGER              not null,   NOM_EDITEUR          VARCHAR2(80)         not null,   constraint PK_EDITEUR primary key (NUM_EDITEUR));/*==============================================================*//* Table : EMPRUNT                                              *//*==============================================================*/create table EMPRUNT (   NUM_EMPRUNT          NUMBER(10)           not null,   NUM_MEMBRE           NUMBER(6)            not null,   CREELE               DATE                 default sysdate not null, -- ATTENTION default sysdate se met avant not null   constraint PK_EMPRUNT primary key (NUM_EMPRUNT));/*==============================================================*//* Table : EXEMPLAIRE                                           *//*==============================================================*/create table EXEMPLAIRE (   ISBN                 NUMBER(10)           not null,   NUM_EXEMPLAIRE       NUMBER(3)            not null,   CODE_ETAT            CHAR(5)              not null,   constraint PK_EXEMPLAIRE primary key (ISBN, NUM_EXEMPLAIRE),   constraint CK_EXEMPLAIRE_CODE_ETAT check (CODE_ETAT IN ('NE','BO','MO','MA')));/*==============================================================*//* Table : GENRE                                                *//*==============================================================*/create table GENRE (   CODE_GENRE           CHAR(5)              not null,   LIBELLE_GENRE        VARCHAR2(80)         not null,   constraint PK_GENRE primary key (CODE_GENRE));/*==============================================================*//* Table : MEMBRE                                               *//*==============================================================*/create table MEMBRE (   NUM_MEMBRE           NUMBER(6)            not null,   NOM                  VARCHAR2(80)         not null,   PRENOM               VARCHAR2(80)         not null,   RUE                  VARCHAR2(100)        not null,   CP                   CHAR(5)              not null,   VILLE                VARCHAR2(50)         not null,   TELEPHONE            CHAR(10),   ADHESION             DATE                 not null,   DUREE                NUMBER(2)            not null,   constraint PK_MEMBRE primary key (NUM_MEMBRE),   constraint CK_MEMBRE_DUREE check (DUREE>0));/*==============================================================*//* Table : OUVRAGE                                              *//*==============================================================*/create table OUVRAGE (   ISBN                 NUMBER(10)           not null,   CODE_GENRE           CHAR(5)              not null,   NUM_EDITEUR          INTEGER              not null,   TITRE                VARCHAR2(80)         not null,   AUTEUR               VARCHAR2(80),   constraint PK_OUVRAGE primary key (ISBN));alter table DETAILEMPRUNT   add constraint FK_DETAILEMPRUNT_EMPRUNT foreign key (NUM_EMPRUNT)      references EMPRUNT (NUM_EMPRUNT);alter table DETAILEMPRUNT   add constraint FK_DETAILEMPRUNT_EXEMPLAIRE foreign key (ISBN, NUM_EXEMPLAIRE)      references EXEMPLAIRE (ISBN, NUM_EXEMPLAIRE);alter table EMPRUNT   add constraint FK_EMPRUNT_MEMBRE foreign key (NUM_MEMBRE)      references MEMBRE (NUM_MEMBRE);alter table EXEMPLAIRE   add constraint FK_EXEMPLAIRE_OUVRAGE foreign key (ISBN)      references OUVRAGE (ISBN);alter table OUVRAGE   add constraint FK_OUVRAGE_CODE_GENRE foreign key (CODE_GENRE)      references GENRE (CODE_GENRE);alter table OUVRAGE   add constraint FK_OUVRAGE_EDITEUR foreign key (NUM_EDITEUR)      references EDITEUR (NUM_EDITEUR);

Alter table MEMBRE add constraint UQ_MEMBRE unique (NOM, PRENOM, TELEPHONE);

Alter table MEMBRE add MOBILE char(10);Alter table MEMBRE add constraint CK_MEMBRE_MOBILE check (MOBILE like '06%' OR MOBILE like '07%' OR MOBILE is null); -- et non (MOBILE like '06%' OR '07%')
Create index IDX_OUVRAGE_CODE_GENRE on OUVRAGE(CODE_GENRE);Create index IDX_OUVRAGE_NUM_EDITEUR on OUVRAGE(NUM_EDITEUR);Create index IDX_EXEMPLAIRE_NUM_EXEMPLAIRE on EXEMPLAIRE(ISBN);Create index IDX_EMPRUNT_NUM_MEMBRE on EMPRUNT(NUM_MEMBRE);Create index IDX_DETAILEMP_EXEMPLAIRE on DETAILEMPRUNT(ISBN, NUM_EXEMPLAIRE);Create index IDX_DETAILEMP_NUM_EMPRUNT on DETAILEMPRUNT(NUM_EMPRUNT);Alter table DETAILEMPRUNT drop constraint FK_DETAILEMPRUNT_EMPRUNT;
Alter table DETAILEMPRUNT add constraint FK_DETAILEMPRUNT_EMPRUNT foreign key(NUM_EMPRUNT) references EMPRUNT(NUM_EMPRUNT) on delete cascade;

Alter table EXEMPLAIRE modify(CODE_ETAT char(2) default 'NE');

Rename DETAILEMPRUNT to DETAIL;

/* suppression si la séquence existe déjà avant de la créer */
drop sequence MEMBRE_SEQ;
Create sequence MEMBRE_SEQ;


-- Insertion dans la table MEMBRE
Insert into MEMBRE (NUM_MEMBRE, NOM, PRENOM, RUE, CP, VILLE, MOBILE, ADHESION, DUREE) values (MEMBRE_SEQ.nextval, 'ALBERT', 'Anne', '13 rue des alpes', '74000', 'Annecy', '0601020304', sysdate-60, 1);Insert into MEMBRE (NUM_MEMBRE, NOM, PRENOM, RUE, CP, VILLE, MOBILE, ADHESION, DUREE) values (MEMBRE_SEQ.nextval, 'BERNAUD', 'Barnabé', '6 rue des bécasses', '69007', 'Lyon', '0602030105', sysdate-10, 3);
Insert into MEMBRE (NUM_MEMBRE, NOM, PRENOM, RUE, CP, VILLE, MOBILE, ADHESION, DUREE) values (MEMBRE_SEQ.nextval, 'CUVARD', 'Camille', '52 rue des cerisiers', '74000', 'Annecy', '0602010509', sysdate-100, 6);
Insert into MEMBRE (NUM_MEMBRE, NOM, PRENOM, RUE, CP, VILLE, MOBILE, ADHESION, DUREE) values (MEMBRE_SEQ.nextval, 'DUPOND', 'Daniel', '11 rue des daims', '74000', 'Annecy', '0610236515', sysdate-250, 12);
Insert into MEMBRE (NUM_MEMBRE, NOM, PRENOM, RUE, CP, VILLE, MOBILE, ADHESION, DUREE) values (MEMBRE_SEQ.nextval, 'EVROUX', 'Eglantine', '34 rue des elfes', '74000', 'Annecy', '0658963125', sysdate-150, 6);
Insert into MEMBRE (NUM_MEMBRE, NOM, PRENOM, RUE, CP, VILLE, MOBILE, ADHESION, DUREE) values (MEMBRE_SEQ.nextval, 'FREGEON', 'Fernand', '11 rue des Francs', '74940', 'Annecy le Vieux', '0602036987', sysdate-400, 6);
Insert into MEMBRE (NUM_MEMBRE, NOM, PRENOM, RUE, CP, VILLE, MOBILE, ADHESION, DUREE) values (MEMBRE_SEQ.nextval, 'GORIT', 'Gaston', '96 rue de la glacerie ', '69008', 'Lyon', '0684235781', sysdate-150, 1);
Insert into MEMBRE (NUM_MEMBRE, NOM, PRENOM, RUE, CP, VILLE, MOBILE, ADHESION, DUREE) values (MEMBRE_SEQ.nextval, 'HEVARD', 'Hector', '12 rue haute', '74230', 'Thones', '0608546578', sysdate-250, 12);
Insert into MEMBRE (NUM_MEMBRE, NOM, PRENOM, RUE, CP, VILLE, MOBILE, ADHESION, DUREE) values (MEMBRE_SEQ.nextval, 'INGRAND', 'Irene', '54 rue des iris', '74100', 'Annemasse', '0605020409', sysdate-50, 12);
Insert into MEMBRE (NUM_MEMBRE, NOM, PRENOM, RUE, CP, VILLE, MOBILE, ADHESION, DUREE) values (MEMBRE_SEQ.nextval, 'JUSTE', 'Julien', '5 place des Jacobins', '73000', 'Chambery', '0603069876', sysdate-100, 6); 

-- Insertion dans la table GENRE
Insert into GENRE (code_genre,libelle_genre) values ('REC','Recit');
Insert into GENRE (code_genre,libelle_genre) values ('POL','Policier');
Insert into GENRE (code_genre,libelle_genre) values ('BD','Bande Dessinee');
Insert into GENRE (code_genre,libelle_genre) values ('INF','Informatique');
Insert into GENRE (code_genre,libelle_genre) values ('THE','Theatre');
Insert into GENRE (code_genre,libelle_genre) values ('ROM','Roman');

-- Insertion dans la table EDITEUR
Insert into EDITEUR (num_editeur,nom_editeur) values (1,'Casterman');
Insert into EDITEUR (num_editeur,nom_editeur) values (2,'ENI');
Insert into EDITEUR (num_editeur,nom_editeur) values (3,'POCKET');
Insert into EDITEUR (num_editeur,nom_editeur) values (4,'Gallimard');
Insert into EDITEUR (num_editeur,nom_editeur) values (5,'Flammarion');
Insert into EDITEUR (num_editeur,nom_editeur) values (6,'Fallois');
Insert into EDITEUR (num_editeur,nom_editeur) values (7,'LGF');
Insert into EDITEUR (num_editeur,nom_editeur) values (8,'Seuil');
Insert into EDITEUR (num_editeur,nom_editeur) values (9,'Larousse');
Insert into EDITEUR (num_editeur,nom_editeur) values (10,'Oracle Press');
Insert into EDITEUR (num_editeur,nom_editeur) values (11,'Livre de poche');

-- Insertion dans la table OUVRAGE
Insert into OUVRAGE (isbn, titre, auteur, code_genre, num_editeur)
	values (2203314168, 'LEFRANC-L''ultimatum', 'Martin Carin', 'BD', 1);
Insert into OUVRAGE (isbn, titre, auteur, code_genre, num_editeur)
	values (2746021285, 'HTML entrainez-vous pour maitriser le code source', 'Luc Van Lancker', 'INF', 2);
Insert into OUVRAGE (isbn, titre, auteur, code_genre, num_editeur)
	values (2746026090, 'MySQL Guide', ' P. Dubois', 'INF', 2);
Insert into OUVRAGE (isbn, titre, auteur, code_genre, num_editeur)
	values (2266085816, 'Pantagruel', 'Francois RABELAIS', 'ROM', 3);
Insert into OUVRAGE (isbn, titre, auteur, code_genre, num_editeur)
	values (2266091611, 'Voyage au centre de la terre', 'Jules Verne', 'ROM', 3);
Insert into OUVRAGE (isbn, titre, auteur, code_genre, num_editeur)
	values (2253010219, 'Le crime de l''Orient Express', 'Agatha Christie', 'POL', 11);
Insert into OUVRAGE (isbn, titre, auteur, code_genre, num_editeur)
	values (2070400816, 'Le Bourgeois gentilhomme', 'Moliere', 'THE', 4);
Insert into OUVRAGE (isbn, titre, auteur, code_genre, num_editeur)
	values (2070367177, 'Le cure de Tours', 'Honore de Balzac', 'ROM', 4);
Insert into OUVRAGE (isbn, titre, auteur, code_genre, num_editeur)
	values (2080720872, 'Boule de suif', 'Guy de Maupassant', 'REC', 5);
Insert into OUVRAGE (isbn, titre, auteur, code_genre, num_editeur)
	values (2877065073, 'La gloire de mon pere', 'Marcel Pagnol', 'ROM', 6);
Insert into OUVRAGE (isbn, titre, auteur, code_genre, num_editeur)
	values (2020549522, 'L''aventure des manuscrits de la mer morte', default,'REC', 8);
Insert into OUVRAGE (isbn, titre, auteur, code_genre, num_editeur)
	values (2253006327, 'Vingt mille lieues sous les mers ', 'Jules Verne','ROM', 7);
Insert into OUVRAGE (isbn, titre, auteur, code_genre, num_editeur)
	values (2038704015, 'De la terre a la lune', 'Jules Verne', 'ROM', 9);
Insert into OUVRAGE (isbn, titre, auteur, code_genre, num_editeur)
	values (2080703234, 'Cinq semaines en ballon', 'Jules Verne', 'ROM', 5);

-- Insertion dans la table EXEMPLAIRE
/* Le script suivant permet d'inserer les donnees suivantes dans la table des exemplaires :
2203314168	1	MO
2203314168	2	BO
2203314168	3	NE
2746021285	3	BO
Pour tous les autres titres, il existe un exemplaire (le numero 1) a l'etat Bon ('BO')
et un second exemplaire (le numero 2) a  l'etat moyen ('MO')
Pour gagner en concision dans le script, il faut travailler en plusieurs etapes.
Tout d'abord, traitez tous les exemplaires de la meme facon. Puis supprimez les informations ajoutees en trop.
Enfin, ajoutez les informations specifiques aux quelques exemplaires listes sous forme de tableau.*/
-- etape 1 :
Insert into exemplaire(isbn, num_exemplaire, code_etat)
	select isbn, 1,'BO' from ouvrage;
Insert into exemplaire(isbn, num_exemplaire, code_etat)
	select isbn, 2,'MO' from ouvrage;
-- etape 2 :
Delete from exemplaire where isbn=2746021285 and num_exemplaire=2;
-- etape 3 :
Update exemplaire set code_etat='MO' where isbn=2203314168 and num_exemplaire=1;
Update exemplaire set code_etat='BO' where isbn=2203314168 and num_exemplaire=2;
Insert into exemplaire(isbn, num_exemplaire, code_etat)
	values(2203314168,3,'NE');

-- Insertion dans la table EMPRUNT
insert into EMPRUNT (num_emprunt, num_membre, creele) values(1,1,sysdate-200);
insert into EMPRUNT (num_emprunt, num_membre, creele) values(2,3,sysdate-190);
insert into EMPRUNT (num_emprunt, num_membre, creele) values(3,4,sysdate-180);
insert into EMPRUNT (num_emprunt, num_membre, creele) values(4,1,sysdate-170);
insert into EMPRUNT (num_emprunt, num_membre, creele) values(5,5,sysdate-160);
insert into EMPRUNT (num_emprunt, num_membre, creele) values(6,2,sysdate-150);
insert into EMPRUNT (num_emprunt, num_membre, creele) values(7,4,sysdate-140);
insert into EMPRUNT (num_emprunt, num_membre, creele) values(8,1,sysdate-130);
insert into EMPRUNT (num_emprunt, num_membre, creele) values(9,9,sysdate-120);
insert into EMPRUNT (num_emprunt, num_membre, creele) values(10,6,sysdate-110);
insert into EMPRUNT (num_emprunt, num_membre, creele) values(11,1,sysdate-100);
insert into EMPRUNT (num_emprunt, num_membre, creele) values(12,6,sysdate-90);
insert into EMPRUNT (num_emprunt, num_membre, creele) values(13,2,sysdate-80);
insert into EMPRUNT (num_emprunt, num_membre, creele) values(14,4,sysdate-70);
insert into EMPRUNT (num_emprunt, num_membre, creele) values(15,1,sysdate-60);
insert into EMPRUNT (num_emprunt, num_membre, creele) values(16,3,sysdate-50);
insert into EMPRUNT (num_emprunt, num_membre, creele) values(17,1,sysdate-40);
insert into EMPRUNT (num_emprunt, num_membre, creele) values(18,5,sysdate-30);
insert into EMPRUNT (num_emprunt, num_membre, creele) values(19,4,sysdate-20);
insert into EMPRUNT (num_emprunt, num_membre, creele) values(20,1,sysdate-10);

-- Insertion dans la table DETAIL
insert into DETAIL (num_emprunt, numero, isbn, num_exemplaire, rendule) values(1,1,2038704015,1,sysdate-195);
insert into DETAIL (num_emprunt, numero, isbn, num_exemplaire, rendule) values(1,2,2070367177,2,sysdate-190);
insert into DETAIL (num_emprunt, numero, isbn, num_exemplaire, rendule) values(2,1,2080720872,1,sysdate-180);
insert into DETAIL (num_emprunt, numero, isbn, num_exemplaire, rendule) values(2,2,2203314168,1,sysdate-179);
insert into DETAIL (num_emprunt, numero, isbn, num_exemplaire, rendule) values(3,1,2038704015,1,sysdate-170);
insert into DETAIL (num_emprunt, numero, isbn, num_exemplaire, rendule) values(4,1,2203314168,2,sysdate-155);
insert into DETAIL (num_emprunt, numero, isbn, num_exemplaire, rendule) values(4,2,2080720872,1,sysdate-155);
insert into DETAIL (num_emprunt, numero, isbn, num_exemplaire, rendule) values(4,3,2266085816,1,sysdate-159);
insert into DETAIL (num_emprunt, numero, isbn, num_exemplaire, rendule) values(5,1,2038704015,1,sysdate-140);
insert into DETAIL (num_emprunt, numero, isbn, num_exemplaire, rendule) values(6,1,2266085816,2,sysdate-141);
insert into DETAIL (num_emprunt, numero, isbn, num_exemplaire, rendule) values(6,2,2080720872,2,sysdate-130);
insert into DETAIL (num_emprunt, numero, isbn, num_exemplaire, rendule) values(6,3,2746021285,1,sysdate-133);
insert into DETAIL (num_emprunt, numero, isbn, num_exemplaire, rendule) values(7,1,2070367177,2,sysdate-100);
insert into DETAIL (num_emprunt, numero, isbn, num_exemplaire, rendule) values(8,1,2080720872,1,sysdate-116);
insert into DETAIL (num_emprunt, numero, isbn, num_exemplaire, rendule) values(9,1,2038704015,1,sysdate-100);
insert into DETAIL (num_emprunt, numero, isbn, num_exemplaire, rendule) values(10,1,2080720872,2,sysdate-107);
insert into DETAIL (num_emprunt, numero, isbn, num_exemplaire, rendule) values(10,2,2746026090,1,sysdate-78);
insert into DETAIL (num_emprunt, numero, isbn, num_exemplaire, rendule) values(11,1,2746021285,1,sysdate-81);
insert into DETAIL (num_emprunt, numero, isbn, num_exemplaire, rendule) values(12,1,2203314168,1,sysdate-86);
insert into DETAIL (num_emprunt, numero, isbn, num_exemplaire, rendule) values(12,2,2038704015,1,sysdate-60);
insert into DETAIL (num_emprunt, numero, isbn, num_exemplaire, rendule) values(13,1,2070367177,1,sysdate-65);
insert into DETAIL (num_emprunt, numero, isbn, num_exemplaire, rendule) values(14,1,2266091611,1,sysdate-66);
insert into DETAIL (num_emprunt, numero, isbn, num_exemplaire, rendule) values(15,1,2070400816,1,sysdate-50);
insert into DETAIL (num_emprunt, numero, isbn, num_exemplaire, rendule) values(16,1,2253010219,2,sysdate-41);
insert into DETAIL (num_emprunt, numero, isbn, num_exemplaire, rendule) values(16,2,2070367177,2,sysdate-41);
insert into DETAIL (num_emprunt, numero, isbn, num_exemplaire, rendule) values(17,1,2877065073,2,sysdate-36);
insert into DETAIL (num_emprunt, numero, isbn, num_exemplaire, rendule) values(18,1,2070367177,1,sysdate-14);
insert into DETAIL (num_emprunt, numero, isbn, num_exemplaire, rendule) values(19,1,2746026090,1,sysdate-12);
insert into DETAIL (num_emprunt, numero, isbn, num_exemplaire, rendule) values(20,1,2266091611,1,default);
insert into DETAIL (num_emprunt, numero, isbn, num_exemplaire, rendule) values(20,2,2253010219,1,default);

Alter table emprunt add(etat_emprunt char(2) default 'EC');Alter table emprunt add constraint ck_emprunt_etat_emprunt check (etat_emprunt in ('EC','RE'));Update emprunt set etat_emprunt='RE' where etat_emprunt='EC' and num_emprunt not in (select num_emprunt from detail where rendule is null);

insert into detail(num_emprunt, numero, isbn, num_exemplaire, rendule) values(7,2,2038704015,1,sysdate-136);
insert into detail(num_emprunt, numero, isbn, num_exemplaire, rendule) values(8,2,2038704015,1,sysdate-127);
insert into detail(num_emprunt, numero, isbn, num_exemplaire, rendule) values(11,2,2038704015,1,sysdate-95);
insert into detail(num_emprunt, numero, isbn, num_exemplaire, rendule) values(15,2,2038704015,1,sysdate-54);
insert into detail(num_emprunt, numero, isbn, num_exemplaire, rendule) values(16,3,2038704015,1,sysdate-43);
insert into detail(num_emprunt, numero, isbn, num_exemplaire, rendule) values(17,2,2038704015,1,sysdate-36);
insert into detail(num_emprunt, numero, isbn, num_exemplaire, rendule) values(18,2,2038704015,1,sysdate-24);
insert into detail(num_emprunt, numero, isbn, num_exemplaire, rendule) values(19,2,2038704015,1,sysdate-13);
insert into detail(num_emprunt, numero, isbn, num_exemplaire, rendule) values(20,3,2038704015,1,sysdate-3);
UPDATE exemplaire SET code_etat='NE' WHERE isbn=2038704015 and num_exemplaire=1;

commit;

