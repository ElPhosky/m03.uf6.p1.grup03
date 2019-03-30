DROP DATABASE IF EXISTS gestiohospital;
CREATE DATABASE gestiohospital;
DROP USER IF EXISTS CapAdmin;
CREATE USER CapAdmin IDENTIFIED BY 'CapPass';
GRANT ALL PRIVILEGES ON CAP.* TO CapAdmin WITH GRANT OPTION;
USE gestiohospital;

CREATE TABLE malaltia(
	codiMalaltia INT PRIMARY KEY,
    nomMalaltia VARCHAR(20),
    causaBaixa BOOLEAN,
    tractament VARCHAR(500),
    duradaTractament VARCHAR(30)
);

CREATE TABLE visita(
	idVisita INT PRIMARY KEY,
    fecha VARCHAR(15),
    codiMalaltia INT,
    nifPacient VARCHAR(9),
    nifMetge VARCHAR(9)
);



CREATE TABLE pacientHistorial(
	nif VARCHAR(9) PRIMARY KEY,
    telefon VARCHAR(12),
    nom VARCHAR(30),
    cognom1 VARCHAR(30),
    cognom2 VARCHAR(30),
    numSS VARCHAR(12),
    codiPostal VARCHAR(5),
    ciutat VARCHAR(30),
    carrer VARCHAR(50),
    numero INT,
    planta INT,
    codiHistorial INT
);

CREATE TABLE metge(
	nif VARCHAR(9) PRIMARY KEY,
    telefon VARCHAR(12),
    nom VARCHAR(30),
    cognom1 VARCHAR(30),
    cognom2 VARCHAR(30),
    numSS VARCHAR(12),
    codiPostal VARCHAR(5),
    ciutat VARCHAR(30),
    carrer VARCHAR(50),
    numero INT,
    planta INT,
    codiCompteCorrent VARCHAR(30),
    numEmpleado VARCHAR(20),
    salariMensual VARCHAR(15)
);



ALTER TABLE VISITA ADD CONSTRAINT fk_PACIENT_nifPacient FOREIGN KEY (nifPacient) REFERENCES pacientHistorial(nif) ON DELETE SET NULL,
				   ADD CONSTRAINT fk_PACIENT_nifMetge FOREIGN KEY (nifMetge) REFERENCES metge(nif) ON DELETE SET NULL,
                   ADD CONSTRAINT fk_PACIENT_codiMalaltia FOREIGN KEY (codiMalaltia) REFERENCES malaltia(codiMalaltia) ON DELETE SET NULL;

INSERT INTO malaltia VALUES(1,"resfriao",false,"Unas orikas en cama y como nuevo","PT2H");
INSERT INTO malaltia VALUES(2,"Esquizofrenia",true,"Xungo lo veo","PT365H");
INSERT INTO malaltia VALUES(3,"Me desmayo", true,"Pastillas y ya","PT4H");

INSERT INTO metge VALUES("47840738L","935880478","Rafa","Gonzalez","Seliva","111234567890","08191","Terrassa","C encantao",0,5,"ES10000","1","1200");
INSERT INTO metge VALUES("47843738L","933880478","Kevin","Sanchez","Gonzalez","111345678990","08191","Terrassa","C tontin",2,2,"ES1000023","2","1300");
INSERT INTO metge VALUES("47740739Y","935878478","Oscar","Gonzalez","Garcia","111234587890","08191","Rubi","C sevilla",7,0,"ES132420000","3","2500");

INSERT INTO PacientHistorial VALUES("45986926J","+34634587957","Kevin","fdogn","dsijgond","281234567840","08222","PorfaFunciona","llanto",1,1,1);

INSERT INTO visita VALUES(1,"30/03/2019",3,"45986926J","47840738L");

SELECT * FROM malaltia;
SELECT * FROM metge;
SELECT * FROM PacientHistorial;
SELECT * FROM visita;