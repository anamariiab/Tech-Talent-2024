DROP DATABASE IF EXISTS LosInvestigadores;
CREATE DATABASE LosInvestigadores;
USE LosInvestigadores;

CREATE TABLE facultad (
    codigo INT,
    nombre VARCHAR(100) NOT NULL,
    PRIMARY KEY (codigo));

CREATE TABLE investigadores (
    DNI VARCHAR (9),
    nom_apels VARCHAR(255) NOT NULL,
    facultad INT,
    PRIMARY KEY (DNI),
    FOREIGN KEY (facultad) REFERENCES facultad (codigo) ON DELETE CASCADE ON UPDATE CASCADE);
    
CREATE TABLE equipos (
    num_serie CHAR (4),
    nombre VARCHAR(100) NOT NULL,
    facultad INT NOT NULL,
    PRIMARY KEY (num_serie),
    FOREIGN KEY (facultad) REFERENCES facultad (codigo) ON DELETE CASCADE ON UPDATE CASCADE);   
	 
CREATE TABLE reserva (
    DNI VARCHAR (9) NOT NULL,
    num_serie CHAR(4) NOT NULL,
    comienzo DATETIME,                                       -- para obtener la fecha y hora actuales al momento de la insercion de datos en la columna
    fin DATETIME DEFAULT NULL,
    PRIMARY KEY (DNI, num_serie),
    FOREIGN KEY (DNI) REFERENCES investigadores (DNI) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (num_serie) REFERENCES equipos (num_serie) ON DELETE CASCADE ON UPDATE CASCADE);
	   	  
    
    