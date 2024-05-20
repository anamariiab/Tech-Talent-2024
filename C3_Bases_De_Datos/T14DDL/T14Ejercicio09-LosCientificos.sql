DROP DATABASE IF EXISTS LosCientíficos;
CREATE DATABASE LosCientíficos;
USE LosCientíficos;

CREATE TABLE cientificos (
    DNI VARCHAR (9),
    nom_apels VARCHAR(255) NOT NULL,
    PRIMARY KEY (DNI));

CREATE TABLE proyecto (
    ID CHAR (4),
    nombre VARCHAR(255) NOT NULL,
    horas INT,
    PRIMARY KEY (ID));
    
CREATE TABLE asignado_a (
    cientifico VARCHAR (9) NOT NULL,
    proyecto CHAR(4)NOT NULL,
    PRIMARY KEY (cientifico, proyecto),
    FOREIGN KEY (cientifico) REFERENCES cientificos (DNI) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (proyecto) REFERENCES proyecto (ID) ON DELETE CASCADE ON UPDATE CASCADE);