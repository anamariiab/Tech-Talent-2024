DROP DATABASE IF EXISTS LosDirectores;
CREATE DATABASE LosDirectores;
USE LosDirectores;

CREATE TABLE despachos (
    numero INT,
    capacidad INT NOT NULL,
    PRIMARY KEY (numero));

CREATE TABLE directores (
    DNI VARCHAR (9),
    nom_apels VARCHAR(255),
    DNI_jefe VARCHAR (8),
    despacho INT NOT NULL,
    PRIMARY KEY (DNI),
    FOREIGN KEY (DNI_jefe) REFERENCES directores (DNI) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (despacho) REFERENCES despachos (numero) ON DELETE CASCADE ON UPDATE CASCADE);