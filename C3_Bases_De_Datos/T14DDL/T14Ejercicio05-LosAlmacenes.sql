CREATE DATABASE LosAlmacenes;
USE LosAlmacenes;

CREATE TABLE almacenes (
    codigo INT,
    nombre VARCHAR (100),
    lugar VARCHAR(100) NOT NULL,
    capacidad INT,
    PRIMARY KEY (codigo));

CREATE TABLE cajas (
    num_ref CHAR(5),
    contenido VARCHAR(100) NOT NULL,
    valor FLOAT,
    almacen INT,
    PRIMARY KEY (num_ref),
    FOREIGN KEY (almacen) REFERENCES almacenes (codigo) ON DELETE CASCADE ON UPDATE CASCADE);