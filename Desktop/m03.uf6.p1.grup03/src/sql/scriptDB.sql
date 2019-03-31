DROP DATABASE IF EXISTS gestiohospital;
CREATE DATABASE gestiohospital;
DROP USER IF EXISTS admin_hospital_grup3;
DROP USER IF EXISTS usuari_hospital_grup3;
CREATE USER admin_hospital_grup3 IDENTIFIED BY 'admin';
GRANT ALL PRIVILEGES ON CAP.* TO admin_hospital_grup3 WITH GRANT OPTION;
CREATE USER usuari_hospital_grup3 IDENTIFIED BY 'usuari';
USE gestiohospital;

CREATE TABLE malaltia(
	codiMalaltia INT PRIMARY KEY AUTO_INCREMENT,
    nomMalaltia VARCHAR(20),
    causaBaixa BOOLEAN,
    tractament VARCHAR(500),
    duradaTractament VARCHAR(30)
);

CREATE TABLE visita(
	idVisita INT PRIMARY KEY AUTO_INCREMENT,
    fecha VARCHAR(15),
    codiMalaltia INT,
    codiHistorial INT,
    nifMetge VARCHAR(9)
);



CREATE TABLE pacientHistorial(
	nif VARCHAR(9),
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
    codiHistorial INT AUTO_INCREMENT PRIMARY KEY
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



ALTER TABLE VISITA ADD CONSTRAINT fk_PACIENT_codiHistorialPacient FOREIGN KEY (codiHistorial) REFERENCES pacientHistorial(codiHistorial) ON DELETE SET NULL,
				   ADD CONSTRAINT fk_PACIENT_nifMetge FOREIGN KEY (nifMetge) REFERENCES metge(nif) ON DELETE SET NULL,
                   ADD CONSTRAINT fk_PACIENT_codiMalaltia FOREIGN KEY (codiMalaltia) REFERENCES malaltia(codiMalaltia) ON DELETE SET NULL;

INSERT INTO malaltia(nomMalaltia,causaBaixa,tractament,duradaTractament) VALUES("resfriao",false,"Unas orikas en cama y como nuevo","PT2H");
INSERT INTO malaltia(nomMalaltia,causaBaixa,tractament,duradaTractament) VALUES("Esquizofrenia",true,"Xungo lo veo","PT365H");
INSERT INTO malaltia(nomMalaltia,causaBaixa,tractament,duradaTractament) VALUES("Me desmayo", true,"Pastillas y ya","PT4H");

INSERT INTO metge VALUES("47840738L","935880478","Rafa","Gonzalez","Seliva","111234567890","08191","Terrassa","C encantao",0,5,"ES10000","1","1200");
INSERT INTO metge VALUES("47843738L","933880478","Kevin","Sanchez","Gonzalez","11134567890","08191","Terrassa","C tontin",2,2,"ES1000023","2","1300");
INSERT INTO metge VALUES("47740739Y","935878478","Oscar","Gonzalez","Garcia","111234587890","08191","Rubi","C sevilla",7,0,"ES132420000","3","2500");
INSERT INTO metge(nif,telefon,nom,cognom1,cognom2,numSS,codiPostal,ciutat,carrer,numero,planta,codiCompteCorrent,numEmpleado,salariMensual)VALUES("45986926J","+34634587957","Kevin","fdogn","dsijgond","281234567840","08222","PorfaFunciona","llanto",1,1,"ES10000","1","1200");

INSERT INTO PacientHistorial(nif,telefon,nom,cognom1,cognom2,numSS,codiPostal,ciutat,carrer,numero,planta)VALUES("45986926J","+34634587957","Kevin","fdogn","dsijgond","281234567840","08222","PorfaFunciona","llanto",1,1);

INSERT INTO visita(fecha,codiMalaltia,codiHistorial,nifMetge) VALUES("30/03/2019",3,1,"47840738L");

DELIMITER //
CREATE PROCEDURE test()
BEGIN
    DECLARE z INT;
    SET z=1;
	SELECT z;
END //
delimiter ;


    
SELECT * FROM malaltia;
SELECT * FROM metge;
SELECT * FROM PacientHistorial;
SELECT * FROM visita;