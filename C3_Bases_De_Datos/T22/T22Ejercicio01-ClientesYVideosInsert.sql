USE clientesyvideos;

INSERT INTO cliente (nombre, apellido, direccion, dni, fecha) VALUES
('Juan', 'Perez', 'Av. Siempre Viva 123', 12345678, '2017-01-15'),
('Maria', 'Lopez', 'Calle Falsa 456', 23456789, '2022-02-20'),
('Pedro', 'Martinez', 'Calle Verdadera 789', 34567890, '2016-03-25'),
('Ana', 'Garcia', 'Av. Principal 1011', 45678901, '2022-04-30'),
('Luis', 'Fernandez', 'Calle Secundaria 1213', 56789012, '2018-05-05'),
('Laura', 'Gomez', 'Av. Libertad 1415', 67890123, '2023-06-10'),
('Carlos', 'Sanchez', 'Calle Progreso 1617', 78901234, '2021-07-15'),
('Lucia', 'Ramirez', 'Av. Paz 1819', 89012345, '2015-08-20'),
('Miguel', 'Torres', 'Calle Esperanza 2021', 90123456, '2020-09-25'),
('Sofia', 'Vargas', 'Av. Victoria 2223', 12345670, '2023-10-30');

INSERT INTO videos (title, director, cli_id) VALUES
('La Aventura', 'Alfredo Gomez', 1),
('El Misterio del Bosque', 'Beatriz Lopez', 2),
('Viaje al Espacio', 'Carlos Martinez', 3),
('El Ultimo Verano', 'Diana Garcia', 4),
('El Camino de los Sueños', 'Eduardo Fernandez', 5),
('La Ciudad Perdida', 'Fernando Gomez', 6),
('Historias de la Noche', 'Gabriela Sanchez', 7),
('Secretos del Mar', 'Hector Ramirez', 8),
('El Enigma de la Montaña', 'Isabel Torres', 9),
('Aventuras en la Selva', 'Jorge Vargas', 10);

