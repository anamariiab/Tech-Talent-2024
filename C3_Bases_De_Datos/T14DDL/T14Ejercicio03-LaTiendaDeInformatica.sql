DROP DATABASE IF EXISTS LaTiendaDeInformatica;
CREATE DATABASE LaTiendaDeInformatica;
USE LaTiendaDeInformatica;

CREATE TABLE fabricantes (
    codigo INT,
    nombre VARCHAR(100) NOT NULL,
    PRIMARY KEY (codigo));

CREATE TABLE articulos (
    codigo INT NOT NULL,
    nombre VARCHAR(100),
    precio FLOAT,
    fabricante INT,  
    PRIMARY KEY (codigo),
    FOREIGN KEY (fabricante) REFERENCES fabricantes (codigo) ON DELETE CASCADE ON UPDATE CASCADE);

INSERT INTO fabricantes (codigo, nombre) VALUES 
	(1, 'TechnoMágico Inc.'),
	(2, 'ByteFiesta S.A.'),
	(3, 'ElectroLúdico Ltda.'),
	(4, 'ChipChirimbolo Corp.'),
	(5, 'RoboRisas Enterprises'),
	(6, 'CódigoChispa GmbH'),
	(7, 'PixelPachanga & Co.'),
	(8, 'InfoTravesura SRL'),
	(9, 'DataDiversión SL'),
	(10, 'GadgetGiggle Ltd.');
	
INSERT INTO articulos (codigo, nombre, precio, fabricante) VALUES 
	(1, 'Portátil Mágico', 999.99, 1),
	(2, 'Ratón Risueño', 10.99, 1),
	(3, 'Teclado Invisible', 20.50, 2),
	(4, 'Auriculares Alienígenas', 15.75, 2),
	(5, 'Monitor Mágico', 299.99, 3),
	(6, 'Disco Duro Dragón', 99.99, 4),
	(7, 'Teclado Tornado Turbo', 79.95, 5),
	(8, 'Disco Diversión', 89.99, 6),
	(9, 'Altavoz Asombroso', 29.99, 7),
	(10, 'Impresora Ilusión', 249.99, 8);
