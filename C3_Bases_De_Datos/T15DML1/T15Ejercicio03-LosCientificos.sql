INSERT INTO cientificos (DNI, nom_apels) VALUES
  ('X12345678', 'Johnny Bravo'),
  ('Y23456789', 'Sherlock Holmes'),
  ('X34567890', 'Daenerys Targaryen'),
  ('Y45678901', 'Indiana Jones'),
  ('X56789012', 'Walter White'),
  ('Y67890123', 'Lara Croft'),
  ('X78901234', 'Harry Potter'),
  ('Y89012345', 'Ron Weasley'),
  ('X90123456', 'Peter Parker'),
  ('Y01234567', 'Jason Bourne');
  
INSERT INTO proyecto (ID, nombre, horas) VALUES 
	('PR01', 'TechTalent', 600),
	('PR02', 'Los Detectives de Depuración', 200),
	('PR03', 'Los Desenredadores de Código Espagueti', 150),
	('PR04', 'El Snob de la Sintaxis', 320),
	('PR05', 'La Búsqueda y Destrucción de Bugs', 100),
	('PR06', 'El Wifi Gratis de Mordor', 400),
	('PR07', 'El Doctor Doom del Spam', 700),
	('PR08', 'La Clínica de Computadoras Enfermas', 600),
	('PR09', 'La Fábrica de Aplicaciones Mágicas', 500),
	('PR10', 'Los Maestros del Código Ninja', 700);
	
INSERT INTO asignado_a (cientifico, proyecto) VALUES	
	('X12345678', 'PR01'),  
	('Y23456789', 'PR02'),
	('X34567890', 'PR03'),
	('Y45678901', 'PR04'),
	('X56789012', 'PR05'),
	('Y67890123', 'PR06'),
	('X78901234', 'PR07'),
	('Y89012345', 'PR08'),
	('X90123456', 'PR09'),
	('Y01234567', 'PR10');