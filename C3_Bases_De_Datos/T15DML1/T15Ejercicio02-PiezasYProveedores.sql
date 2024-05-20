INSERT INTO piezas (codigo, nombre) VALUES
    (1, 'Tornillo'),
    (2, 'Arandela'),
    (3, 'Tuerca'),
    (4, 'Martillo'),
    (5, 'Destornillador'),
    (6, 'Llave inglesa'),
    (7, 'Sierra'),
    (8, 'Taladro'),
    (9, 'Amoladora'),
    (10, 'Lijadora');
    
INSERT INTO proveedores (ID, nombre) VALUES
    ('PR01', 'Llaves Maestras'),
    ('PR02', 'Manitas Express'),
    ('PR03', 'El Clavo'),
    ('PR04', 'Hierros y Herramientas'),
    ('PR05', 'Star Wars: Ferretería Espacial'),
    ('PR06', 'Harry Potter y la Tienda de Magia y Herramientas'),
    ('PR07', 'El Señor de los Tornillos'),
    ('PR08', 'El Rincón del Bricolaje'),
    ('PR09', 'Destornilladores Sonrientes'),
    ('PR10', 'Herramientas para Dummies');
	 
INSERT INTO suministra (codigo_pieza, ID_proveedor, precio) VALUES
    (1, 'PR01', 0.50),
    (2, 'PR02', 0.90),
    (3, 'PR03', 1.30),
    (4, 'PR04', 10.00),
    (5, 'PR05', 5.00),
    (6, 'PR06', 15.75),
    (7, 'PR07', 20.00),
    (8, 'PR08', 33.25),
    (9, 'PR09', 41.15),
    (10, 'PR10', 53.25);	     