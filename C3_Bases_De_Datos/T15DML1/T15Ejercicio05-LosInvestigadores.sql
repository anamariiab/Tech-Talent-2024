INSERT INTO facultad (codigo, nombre) VALUES
	(1, 'Facultad de Informática'),
	(2, 'Facultad de Ingeniería'),
	(3, 'Facultad de Ciencias de la Salud'),
	(4, 'Facultad de Ciencias Sociales y Humanas'),
	(5, 'Facultad de Educación'),
	(6, 'Facultad de Derecho'),
	(7, 'Facultad de Economía y Empresa'),
	(8, 'Facultad de Bellas Artes'),
	(9, 'Facultad de Ciencias del Deporte'),
	(10, 'Facultad de Ciencias Políticas');

INSERT INTO investigadores (DNI, nom_apels, facultad) VALUES  
	('Z12345678', 'Juan Pérez López', 10),
	('X87654321', 'María Gómez García', 9),
	('Z38765432', 'Pedro Sánchez Rodríguez', 8),
	('X43210987', 'Ana Martínez Fernández', 7),
	('Z54321098', 'José González Díaz', 6),
	('X65432109', 'Isabel López Ruiz', 5),
	('Z76543210', 'David García Martínez', 4),
	('X87654323', 'Laura Fernández González', 3),
	('Z98765433', 'Carlos Díaz López', 2), 
	('X10987654', 'Cristina Ruiz García', 1);

INSERT INTO equipos (num_serie, nombre, facultad) VALUES
	('1001', 'Equipo 1', 1),
	('1002', 'Equipo 2', 2),
	('1003', 'Equipo 3', 3),
	('1004', 'Equipo 4', 4),
	('1005', 'Equipo 5', 5),
	('1006', 'Equipo 6', 6),
	('1007', 'Equipo 7', 7),
	('1008', 'Equipo 8', 8),
	('1009', 'Equipo 9', 9),
	('1010', 'Equipo 10', 10);

INSERT INTO reserva (DNI, num_serie, comienzo, fin) VALUES
	('Z12345678', '1001', '2024-04-17', '2024-04-20'),  
	('X87654321', '1002', '2024-04-18', '2024-04-21'),  
	('Z38765432', '1003', '2024-04-19', '2024-04-22'),  
	('X43210987', '1004', '2024-04-20', '2024-04-23'),  
	('Z54321098', '1005', '2024-04-21', '2024-04-24'),  
	('X65432109', '1006', '2024-04-22', '2024-04-25'),  
	('Z76543210', '1007', '2024-04-23', '2024-04-26'),  
	('X87654323', '1008', '2024-04-24', '2024-04-27'),  
	('Z98765433', '1009', '2024-04-25', '2024-04-28'),  
	('X10987654', '1010', '2024-04-26', '2024-04-29');