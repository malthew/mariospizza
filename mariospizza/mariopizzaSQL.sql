DROP TABLE IF EXISTS ANTAL;
DROP TABLE IF EXISTS ORDRE;
DROP TABLE IF EXISTS PIZZA;

CREATE TABLE ORDRE (
	ORDRENO INTEGER NOT NULL AUTO_INCREMENT,
    OPRETTET DATE NOT NULL,
	CNAME VARCHAR(30) NOT NULL,
    TLFNO VARCHAR(8) NOT NULL,
    AFHENT TIMESTAMP,
    PRIMARY KEY (ORDRENO)
);

CREATE TABLE PIZZA (
	PNUMMER INTEGER NOT NULL,
    PNAVN VARCHAR(20) NOT NULL,
    PRIS INTEGER NOT NULL,
    PRIMARY KEY (PNUMMER)
);

CREATE TABLE ANTAL (
	ANTALP INTEGER NOT NULL,
    ORDRENO INTEGER NOT NULL AUTO_INCREMENT,
    PNUMMER INTEGER NOT NULL,
    FOREIGN KEY (ORDRENO) REFERENCES ORDRE(ORDRENO),
    FOREIGN KEY (PNUMMER) REFERENCES PIZZA(PNUMMER)
);

insert into pizza (pnummer, pnavn, pris) values (1,'Vesuvio',57);
insert into pizza (pnummer, pnavn, pris) values (2,'Amerikaner',53);
insert into pizza (pnummer, pnavn, pris) values (3,'Cacciatore',57);
insert into pizza (pnummer, pnavn, pris) values (4,'Carbona',53);
insert into pizza (pnummer, pnavn, pris) values (5,'Dennis',65);
insert into pizza (pnummer, pnavn, pris) values (6,'Bertil',57);
insert into pizza (pnummer, pnavn, pris) values (7,'Silvia',61);
insert into pizza (pnummer, pnavn, pris) values (8,'Victoria',61);
insert into pizza (pnummer, pnavn, pris) values (9,'Toronfo',61);
insert into pizza (pnummer, pnavn, pris) values (10,'Capricciosa',61);
insert into pizza (pnummer, pnavn, pris) values (11,'Hawaii',61);
insert into pizza (pnummer, pnavn, pris) values (12,'Le Blissola',61);
insert into pizza (pnummer, pnavn, pris) values (13,'Venezia',61);
insert into pizza (pnummer, pnavn, pris) values (14,'Mafia',61);

insert into ordre(afhent, oprettet,  cname, tlfno) values ('2019-05-05 10:50:01', '2019-05-05',  'hans', 20090930); 
insert into ordre(afhent, oprettet,  cname, tlfno) values ('2019-05-05 10:51:01', '2019-05-05',  'tine', 20090931); 
insert into ordre(afhent, oprettet,  cname, tlfno) values ('2019-05-05 10:52:01', '2019-05-05',  'signe', 20090932); 
insert into ordre(afhent, oprettet,  cname, tlfno) values ('2019-05-05 10:53:01', '2019-05-05',  'john', 20090933); 

insert into antal(antalp, ordreno, pnummer) values(2, 1, 4);
insert into antal(antalp, ordreno, pnummer) values(5, 2, 3);
insert into antal(antalp, ordreno, pnummer) values(2, 3, 8);
insert into antal(antalp, ordreno, pnummer) values(4, 4, 1);




    