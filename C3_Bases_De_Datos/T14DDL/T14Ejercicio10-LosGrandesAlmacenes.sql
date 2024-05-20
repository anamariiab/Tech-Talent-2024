DROP DATABASE IF EXISTS LosGrandesAlmacenes;
CREATE DATABASE LosGrandesAlmacenes;
USE LosGrandesAlmacenes;

CREATE TABLE cajeros (
    codigo INT,
    nom_apels VARCHAR(255) NOT NULL,
    PRIMARY KEY (codigo));
    
CREATE TABLE productos (
    codigo INT,
    nombre VARCHAR (100) NOT NULL,
    precio FLOAT,
    PRIMARY KEY (codigo));    
    
CREATE TABLE maquinas_registradoras (
    codigo INT,
    piso INT NOT NULL,
    PRIMARY KEY (codigo));    

CREATE TABLE venta (
    cajero INT NOT NULL,
    maquina INT NOT NULL,
    producto INT NOT NULL,
    PRIMARY KEY (cajero, maquina, producto),
    FOREIGN KEY (cajero) REFERENCES cajeros (codigo) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (maquina) REFERENCES maquinas_registradoras (codigo) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (producto) REFERENCES productos (codigo) ON DELETE CASCADE ON UPDATE CASCADE);