DROP DATABASE IF EXISTS PeliculasYSalas;
CREATE DATABASE PeliculasYSalas;
USE PeliculasYSalas;

CREATE TABLE peliculas (
    codigo INT,
    nombre VARCHAR(100) NOT NULL,
    calificacion_edad INT DEFAULT NULL,
    PRIMARY KEY (codigo));

CREATE TABLE salas (
    codigo INT,
    nombre VARCHAR(100) NOT NULL,
    pelicula INT DEFAULT NULL,
    PRIMARY KEY (codigo),
    FOREIGN KEY (pelicula) REFERENCES peliculas (codigo) ON DELETE CASCADE ON UPDATE CASCADE);


 INSERT INTO peliculas (codigo, nombre, calificacion_edad) VALUES
	(100, 'Pobres Criaturas', 12),
	(101, 'Oppenheimer', 12),
	(102, 'Dune: Parte Dos', 5),
	(103, 'Guardiana de Dragones', 8),
	(104, 'Kung Fu Panda 4', 5),
	(105, 'Civil War', 16),
	(106, 'Abigail', 16),
	(107, 'Garfield', 5),
	(108, 'Amigos Imaginarios', 12),
	(109, 'El Reino del Planeta de los Simios', 12);

INSERT INTO salas (codigo, nombre, pelicula) VALUES
	(1, 'Sala 1', 100),
	(2, 'Sala 2', 101),
	(3, 'Sala 3', 102),
	(4, 'Sala 4', 103),
	(5, 'Sala 5', 104),
	(6, 'Sala 6', 105),
	(7, 'Sala 7', 106),
	(8, 'Sala 8', 107),
	(9, 'Sala 9', 108),
	(10, 'Sala 10', 109);   