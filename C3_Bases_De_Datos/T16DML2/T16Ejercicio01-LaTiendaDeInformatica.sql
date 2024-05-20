-- Inserta 10 tuplas validas por cada tabla creada.
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
		

-- 1.1 Obtener los nombres de los productos de la tienda.
SELECT nombre FROM articulos;

-- 1.2 Obtener los nombres y los precios de los productos de la tienda.
SELECT nombre, precio FROM articulos;

-- 1.3 Obtener el nombre de los productos cuyo precio sea menor o igual a 200€.
SELECT nombre FROM articulos WHERE precio <= 200;

-- 1.4 Obtener todos los datos de los artículos cuyo precio esté entre los 60€ y los 120€.
SELECT * FROM articulos WHERE precio BETWEEN 60 AND 120;

-- 1.5 Obtener el nombre y el precio en pesetas (es decir, el precio en euros multiplicado por 166,386).
SELECT nombre, precio * 166.386 AS `precio en pesetas` FROM articulos;

-- 1.6 Seleccionar el precio medio de todos los productos.
SELECT AVG(precio) AS `precio medio articulos` FROM articulos;

-- 1.7 Obtener el precio medio de los artículos cuyo código de fabricante sea 2.
SELECT AVG(precio) AS `precio medio articulos del fabr. 2` FROM articulos WHERE fabricante = 2;

-- 1.8 Obtener el número de artículos cuyo precio sea mayor o igual a 180€. 
SELECT COUNT(*) AS `número de articulos` FROM articulos WHERE precio >= 180;

-- 1.9 Obtener el nombre y precio de los artículos cuyo precio sea mayor o igual a 180€ y ordenarlos descendentemente por precio, y luego ascendentemente por nombre.
SELECT nombre, precio FROM articulos WHERE precio >= 180 ORDER BY precio DESC, nombre ASC;

-- 1.10 Obtener un listado completo de artículos, incluyendo por cada artículo los datos del artículo y de su fabricante.
SELECT articulos.*, fabricantes.*
FROM articulos INNER JOIN fabricantes ON articulos.fabricante = fabricantes.codigo;

-- 1.11 Obtener un listado de artículos, incluyendo el nombre del artículo, su precio, y el nombre de su fabricante.
SELECT articulos.nombre, articulos.precio, fabricantes.nombre
FROM articulos INNER JOIN fabricantes ON articulos.fabricante = fabricantes.codigo;

-- 1.12 Obtener el precio medio de los productos de cada fabricante, mostrando solo los códigos de fabricante.
SELECT articulos.fabricante AS `código fabricante`, AVG(articulos.precio) AS precio_medio
FROM articulos GROUP BY articulos.fabricante;
	
-- 1.13 Obtener el precio medio de los productos de cada fabricante, mostrando el nombre del fabricante.
SELECT fabricantes.nombre, AVG(articulos.precio) AS precio_medio
FROM articulos INNER JOIN fabricantes ON articulos.fabricante = fabricantes.codigo 
GROUP BY fabricantes.nombre;

-- 1.14 Obtener los nombres de los fabricantes que ofrezcan productos cuyo precio medio sea mayor o igual a 150€.
SELECT fabricantes.nombre 
FROM articulos INNER JOIN fabricantes ON articulos.fabricante = fabricantes.codigo 
GROUP BY articulos.fabricante HAVING AVG(articulos.precio) >= 150;	

-- 1.15 Obtener el nombre y precio del articulo mas barato.
SELECT nombre, precio FROM articulos WHERE precio = (SELECT MIN(precio) FROM articulos);

-- 1.16 Obtener una lista con el nombre y precio de los artículos más caros de cada proveedor (incluyendo el nombre del proveedor).
SELECT articulos.nombre AS `nombre articulo`, articulos.precio, fabricantes.nombre AS `nombre fabricante`
FROM articulos, fabricantes WHERE articulos.fabricante = fabricantes.codigo AND articulos.precio = (SELECT MAX(art.precio)
FROM articulos art WHERE art.fabricante = fabricantes.codigo)
ORDER BY articulos.fabricante;

-- 1.17 Añadir un nuevo producto: Altavoces de 70€ del fabricante 2.
INSERT INTO articulos (codigo, nombre, precio, fabricante) VALUES 
	(10, 'Altavoces', 70, 2);

-- 1.18 Cambiar el nombre del producto 8 a 'Impresora Laser'. 
UPDATE articulos SET nombre = 'Impresora Laser' WHERE codigo = 8;

-- 1.19 Aplicar un descuento del 10% (multiplicar el precio 0,9) a todos los productos.
UPDATE articulos SET precio = precio * 0.9;

-- 1.20 Aplicar un descuento de 10€ a todos los productos cuyo precio sea mayor o igual a 120€.
UPDATE articulos SET precio = precio - 10 WHERE precio >= 120;
