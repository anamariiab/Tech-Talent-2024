DROP DATABASE IF EXISTS AcademiaDeIdiomas;
CREATE DATABASE AcademiaDeIdiomas;
USE AcademiaDeIdiomas;

CREATE TABLE profesores (
    DNI VARCHAR(9),
    nombre VARCHAR(80) NOT NULL,
    apellido_1 VARCHAR(60) NOT NULL,
    apellido_2 VARCHAR(60),
    direccion VARCHAR(200),
    titulo VARCHAR(60) NOT NULL,
    gana FLOAT NOT NULL,
    PRIMARY KEY (DNI),
    UNIQUE KEY nombre_apellido (nombre, apellido_1));
    
CREATE TABLE cursos (
    codigo INT,
    nombre_curso VARCHAR(150) UNIQUE NOT NULL,
    num_max_alumnos INT,
    num_horas INT NOT NULL,
    fecha_inicio DATETIME DEFAULT CURRENT_TIMESTAMP,
    fecha_finalizacion DATETIME DEFAULT NULL,
    DNI_profesor VARCHAR(9) NOT NULL,
    PRIMARY KEY (codigo),
    FOREIGN KEY (DNI_profesor) REFERENCES profesores(DNI) ON DELETE CASCADE ON UPDATE CASCADE,
    CHECK (fecha_inicio < fecha_finalizacion));
    
CREATE TABLE alumnos (
    DNI VARCHAR(9),
    nombre VARCHAR(80) NOT NULL,
    apellido_1 VARCHAR(60) NOT NULL,
    apellido_2 VARCHAR(60),
    direccion VARCHAR(200),
    fecha_nacimiento DATE NOT NULL,
    sexo CHAR(1) CHECK (sexo IN ('M', 'H')),                                          -- restriccion de 'chequeo' para asegurar que el valor almacenado solo pueda ser M o H
    codigo_curso INT NOT NULL,
	 PRIMARY KEY (DNI),
	 FOREIGN KEY (codigo_curso) REFERENCES cursos(codigo) ON DELETE CASCADE ON UPDATE CASCADE);

    
 