DROP DATABASE IF EXISTS Meteo;
CREATE DATABASE Meteo;
USE Meteo;

CREATE TABLE estacion (
    id MEDIUMINT UNSIGNED,
    latitud VARCHAR(15) NOT NULL,
    longitud VARCHAR (15) NOT NULL,
    altitud MEDIUMINT NOT NULL,
    PRIMARY KEY (id));

CREATE TABLE muestra (
    id_estacion MEDIUMINT UNSIGNED NOT NULL,
    fecha DATE NOT NULL,
    temperatura_min TINYINT,
    temperatura_max TINYINT,
    precipitaciones SMALLINT UNSIGNED,
    humedad_min TINYINT UNSIGNED,
    humedad_max TINYINT UNSIGNED,
    velocidad_min SMALLINT UNSIGNED,
    velocidad_max SMALLINT UNSIGNED,
    KEY (id_estacion),
    FOREIGN KEY (id_estacion) REFERENCES estacion (id) ON DELETE CASCADE ON UPDATE CASCADE);