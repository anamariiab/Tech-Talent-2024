INSERT INTO despachos (capacidad) VALUES 
    (11),(8),(3),(5),(14),(22),(21),(5),(19),(23);
    
INSERT INTO directores (DNI, nom_apels, DNI_jefe, despacho) VALUES
	('12345678', 'Juan Pérez López', NULL, 1),
	('87654321', 'María Gómez Rodríguez', NULL, 2),
	('98765432', 'Pedro Sánchez Martínez', NULL, 3),
	('43210987', 'Ana Martín García', '12345678', 4),
	('56789012', 'José López Fernández', '87654321', 5),
	('21098765', 'Isabel González Pérez', '98765432', 6),
	('32109876', 'David García Martínez', '43210987', 7),
	('43215678', 'Laura Fernández Gómez', '56789012', 8),
	('54326789', 'Carlos Pérez López', '21098765', 9),
	('65437890', 'Marta González Rodríguez', '32109876', 10);