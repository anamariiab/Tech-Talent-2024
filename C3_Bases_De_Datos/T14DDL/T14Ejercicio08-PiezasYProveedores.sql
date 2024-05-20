DROP DATABASE IF EXISTS PiezasYProveedores;
CREATE DATABASE PiezasYProveedores;
USE PiezasYProveedores;

CREATE TABLE piezas (
    codigo INT,
    nombre VARCHAR(100) NOT NULL,
    PRIMARY KEY (codigo));
    
CREATE TABLE proveedores (
    ID CHAR (4),
    nombre VARCHAR(100) NOT NULL,
    PRIMARY KEY (ID));    

CREATE TABLE suministra (
    codigo_pieza INT NOT NULL,
    ID_proveedor CHAR(4) NOT NULL,
    precio FLOAT NOT NULL,
    PRIMARY KEY (codigo_pieza, ID_proveedor),
    FOREIGN KEY (codigo_pieza) REFERENCES piezas (codigo) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (ID_proveedor) REFERENCES proveedores (ID) ON DELETE CASCADE ON UPDATE CASCADE);