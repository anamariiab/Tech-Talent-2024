INSERT INTO cajeros (codigo, nom_apels) VALUES
	(101, 'Pedro Picapiedra'),
	(102, 'Wilma Flinstone'),
	(103, 'Fred Flintstone'),
	(104, 'Barney Rubble'),
	(105, 'Betty Rubble'),
	(106, 'Popeye el Marino'),
	(107, 'Olivia Oyl'),
	(108, 'Bluto'),
	(109, 'Wimpy'),
	(110, 'Swee Pea');

INSERT INTO productos (codigo, nombre, precio) VALUES
	(201, 'Camiseta de Goku Super Saiyajin', 19.99),
	(202, 'Pantalones Cortos de Bart Simpson', 24.95),
	(203, 'Zapatillas Luminosas', 29.99),
	(204, 'Chaqueta de Vaquero con Hombreras', 39.99),
	(205, 'Mochila 4D de Doraemon', 49.99),
	(206, 'Libro de Instrucciones para la Vida (Edición Humorística)', 14.95),
	(207, 'Película de Terror con Final Inesperado (o no)', 9.99),
	(208, 'CD de Música Retro para Bailar sin Parar', 4.99),
	(209, 'Juego de Mesa Monopoly Edición Springfield', 19.99),
	(210, 'Muñeca Poseída (Edición Limitada)', 14.99);

INSERT INTO maquinas_registradoras (codigo, piso) VALUES
	(301, 1),
	(302, 2),
	(303, 3),
	(304, 4),
	(305, 5),
	(306, 6),
	(307, 7),
	(308, 8),
	(309, 9),
	(310, 10);

INSERT INTO venta (cajero, maquina, producto) VALUES
	(101, 301, 201),
	(102, 302, 202),
	(103, 303, 203),
	(104, 304, 204),
	(105, 305, 205),
	(106, 306, 206),
	(107, 307, 207),
	(108, 308, 208),
	(109, 309, 209),
	(110, 310, 210);