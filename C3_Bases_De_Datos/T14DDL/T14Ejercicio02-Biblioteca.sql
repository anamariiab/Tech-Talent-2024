DROP DATABASE IF EXISTS Biblioteca;
CREATE DATABASE Biblioteca;
USE Biblioteca;

CREATE TABLE editorial (
	clave_editorial SMALLINT NOT NULL,
	nombre VARCHAR(60),
	direccion VARCHAR(60),
	telefono VARCHAR(15),
	PRIMARY KEY (clave_editorial));

CREATE TABLE tema (
	clave_tema SMALLINT NOT NULL,
	nombre VARCHAR(40),
	PRIMARY KEY (clave_tema));

CREATE TABLE autor (
	clave_autor INT NOT NULL,
	nombre VARCHAR(60),
	PRIMARY KEY (clave_autor));
    
CREATE TABLE socio (
	clave_socio INT NOT NULL,
	nombre VARCHAR(60),
	direccion VARCHAR(60),
	telefono VARCHAR(15),
	categoria CHAR,
	PRIMARY KEY (clave_socio));   

CREATE TABLE libro (
	clave_libro INT NOT NULL, 
	titulo VARCHAR(60), 
	idioma VARCHAR(15), 
	formato VARCHAR(15),    
	clave_editorial SMALLINT, 
	PRIMARY KEY (clave_libro), 
	FOREIGN KEY (clave_editorial) REFERENCES editorial (clave_editorial) ON DELETE SET NULL ON UPDATE CASCADE);
	
CREATE TABLE escrito_por (
	clave_libro INT(11) DEFAULT NULL,
	clave_autor INT(11) DEFAULT NULL,
	FOREIGN KEY (clave_libro) REFERENCES libro (clave_libro) ON DELETE CASCADE ON UPDATE CASCADE,	
	FOREIGN KEY (clave_autor) REFERENCES autor (clave_autor) ON DELETE CASCADE ON UPDATE CASCADE);	
	
CREATE TABLE trata_sobre (
	clave_libro INT(11) DEFAULT NULL,
	clave_tema SMALLINT(11) DEFAULT NULL,
	FOREIGN KEY (clave_libro) REFERENCES libro (clave_libro) ON DELETE CASCADE ON UPDATE CASCADE,	
	FOREIGN KEY (clave_tema) REFERENCES tema (clave_tema) ON DELETE CASCADE ON UPDATE CASCADE);
	
CREATE TABLE ejemplar (
	clave_ejemplar INT(11) NOT NULL,
	clave_libro INT(11) DEFAULT NULL,
	numero_orden SMALLINT(6) NOT NULL,
	edicion SMALLINT(6) DEFAULT NULL,
	ubicacion VARCHAR(15) DEFAULT NULL,
	categoria CHAR(1) DEFAULT NULL,
	PRIMARY KEY (clave_ejemplar),
	FOREIGN KEY (clave_libro) REFERENCES libro (clave_libro) ON DELETE CASCADE ON UPDATE CASCADE);		
		
CREATE TABLE prestamo (
	clave_socio INT(11),
	clave_ejemplar INT(11),
	numero_orden SMALLINT(6),
	fecha_prestamo DATE NOT NULL,
	fecha_devolucion DATE DEFAULT NULL,
	notas BLOB,
	FOREIGN KEY (clave_socio) REFERENCES socio (clave_socio) ON DELETE SET NULL ON UPDATE CASCADE,
	FOREIGN KEY (clave_ejemplar) REFERENCES ejemplar (clave_ejemplar) ON DELETE SET NULL ON UPDATE CASCADE);