DROP DATABASE IF EXISTS Empleados;
CREATE DATABASE Empleados;
USE Empleados;

CREATE TABLE departamentos (
    codigo INT,
    nombre VARCHAR(100) NOT NULL,
    presupuesto FLOAT,
    PRIMARY KEY (codigo));

CREATE TABLE empleados (
    DNI VARCHAR(9),
    nombre VARCHAR(100) NOT NULL,
    apellidos VARCHAR(255) NOT NULL,
    departamento INT,
    PRIMARY KEY (DNI),
    FOREIGN KEY (departamento) REFERENCES departamentos (codigo) ON DELETE CASCADE ON UPDATE CASCADE);