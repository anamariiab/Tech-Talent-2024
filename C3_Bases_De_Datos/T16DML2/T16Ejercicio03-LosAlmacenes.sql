-- Inserta 10 tuplas válidas por cada tabla creada.
INSERT INTO almacenes (codigo, nombre, lugar, capacidad) VALUES
    (1, 'Almacén A', 'Reus', 2),
    (2, 'Almacén B', 'Tarragona', 5),
    (3, 'Almacén C', 'Salou', 3),
    (4, 'Almacén D', 'Cambrils', 10),
    (5, 'Almacén E', 'La Selva Del Camp', 15),
    (6, 'Almacén F', 'Riudoms', 17),
    (7, 'Almacén G', 'Valls', 20),
    (8, 'Almacén H', 'Siurana', 30),
    (9, 'Almacén I', 'Lleida', 6),
    (10, 'Almacén J', 'Sitges', 7);

INSERT INTO cajas (num_ref, contenido, valor, almacen) VALUES
    ('CA001', 'Libros', 50.50, 1),
    ('CA002', 'Electrodomésticos', 980, 1),
    ('CA003', 'Ropa', 110.70, 3),
    ('CA004', 'Herramientas', 120, 4),
    ('CA005', 'Juguetes', 40.70, 5),
    ('CA006', 'Joyería', 1250, 1),
    ('CA007', 'Material de jardinería', 330, 7),
    ('CA008', 'Equipos de deporte', 110, 8),
    ('CA009', 'Material de oficina', 60, 9),
    ('CA010', 'Instrumentos musicales', 150, 10);



-- 3.1 Obtener todos los almacenes.
SELECT * FROM almacenes;

-- 3.2 Obtener todas las cajas cuyo contenido tenga un valor superior a 150€.
SELECT * FROM cajas WHERE valor > 150;

-- 3.3 Obtener los tipos de contenido de las cajas.
SELECT contenido FROM cajas;

-- 3.4 Obtener el valor medio de todas las cajas.
SELECT AVG(valor) AS valor_medio FROM cajas;

-- 3.5 Obtener el valor medio de las cajas de cada almacén.  
SELECT almacen, AVG(valor) AS valor_medio_almacen FROM cajas
GROUP BY almacen;

-- 3.6 Obtener los códigos de los almacenes en los cuales el valor medio de las cajas sea superior a 150€.
SELECT almacen FROM cajas GROUP BY almacen HAVING AVG(valor) > 150;

-- 3.7 Obtener el número de referencia de cada caja junto con el nombre de la ciudad en el que se encuentra. 
SELECT cajas.num_ref, almacenes.lugar AS ciudad FROM cajas JOIN almacenes ON cajas.almacen = almacenes.codigo;

-- 3.8 Obtener el número de cajas que hay en cada almacén.
SELECT almacen, COUNT(*) AS num_cajas FROM cajas GROUP BY almacen;

-- 3.9 Obtener los códigos de los almacenes que están saturados, es decir, donde el número de cajas es superior a la capacidad.
SELECT almacen FROM cajas GROUP BY almacen HAVING COUNT(*) > (SELECT capacidad FROM almacenes WHERE almacenes.codigo = cajas.almacen);

-- 3.10 Obtener los números de referencia de las cajas que están en Bilbao.
INSERT INTO almacenes (codigo, nombre, lugar, capacidad) VALUES
    (11, 'Almacén K', 'Bilbao', 5);

-- 3.11 Insertar un nuevo almacén en Barcelona con capacidad para 3 cajas.
INSERT INTO almacenes (codigo, nombre, lugar, capacidad) VALUES 
    (12,'Almacén L', 'Barcelona', 3);

-- 3.12 Insertar una nueva caja con número de referencia 'H5RT', con contenido 'Papel', valor 200, situada en el almacén 2.
INSERT INTO cajas (num_ref, contenido, valor, almacen) VALUES
    (13, 'Papel', 200, 2);

-- 3.13 Rebajar el valor de todas las cajas un 15%.
UPDATE cajas SET valor = valor * 0.85;

-- 3.14 Rebajar un 20% el valor de todas las cajas cuyo valor sea superior al valor medio de todas las cajas.
UPDATE cajas SET valor = valor * 0.8 WHERE valor > (SELECT AVG(valor) FROM cajas); 

-- 3.15 Eliminar todas las cajas cuyo valor sea inferior a 100€.
DELETE FROM cajas WHERE valor < 100;

-- 3.16 Vaciar el contenido de los almacenes que están saturados. 
DELETE FROM almacenes WHERE codigo IN (SELECT almacen FROM cajas GROUP BY almacen 
HAVING COUNT(*) > (SELECT capacidad FROM almacenes WHERE almacenes.codigo = cajas.almacen));