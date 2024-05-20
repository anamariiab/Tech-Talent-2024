-- Inserta 10 tuplas validas por cada tabla creada.
INSERT INTO departamentos (codigo, nombre, presupuesto) VALUES 
	(1, 'Management', 50000),
	(2, 'Marketing', 60000),
	(3, 'Producción', 80000),
	(4, 'Recursos Humanos', 45000),
	(5, 'Finanzas', 70000),
	(6, 'Operaciones', 55000),
	(7, 'Servicio al Cliente', 60000),
	(8, 'Ventas', 55000),
	(9, 'Logística', 65000),
	(10, 'Legal', 90000);
	
INSERT INTO empleados (DNI, nombre, apellidos, departamento) VALUES 
	('X23456789', 'Juan', 'García Pérez', 3),
	('Z87654321', 'María', 'López Martínez', 7),
	('X56123789', 'Carlos', 'González Sánchez', 1),
	('Z89123456', 'Laura', 'Rodríguez Fernández', 5),
	('X21654987', 'Pedro', 'Martín Gómez', 2),
	('Z54987321', 'Ana', 'Díaz Ruiz', 8),
	('X47258369', 'David', 'Hernández López', 8),
	('Z58369147', 'Sara', 'Pérez García', 8),
	('X69147258', 'Pablo', 'Fernández Rodríguez', 9),
	('Z87123654', 'Elena', 'Sánchez Martínez', 10);	
	
-- 2.1 Obtener los apellidos de los empleados.	
SELECT apellidos FROM empleado;

-- 2.2 Obtener los apellidos de los empleados sin repeticiones.
SELECT DISTINCT apellidos FROM empleado;

-- 2.3 Obtener todos los datos de los empleados que se apellidan 'López'. 
SELECT * FROM empleado WHERE apellidos = 'López'; 

-- 2.4 Obtener todos los datos de los empleados que se apellidan 'López' Obtener y los que se apellidan 'Pérez'.
SELECT * FROM empleado WHERE apellidos = 'López' OR apellidos = 'Pérez'; 

-- 2.5 Obtener todos los datos de los empleados que trabajan para el departamento 14.
INSERT INTO departamento (codigo, nombre, presupuesto) VALUES 
	(14, 'Nuevo Departamento14', 100000);
INSERT INTO empleado (DNI, nombre, apellidos, departamento) VALUES 
	('T23456789', 'Nuevo', 'Empleado1', 14),
	('Y87654321', 'Nuevo', 'Empleado2', 14);
SELECT * FROM empleado WHERE departamento = 14;

-- 2.6 Obtener todos los datos de los empleados que trabajan para el departamento 37 y para el departamento 77. 
INSERT INTO departamento (codigo, nombre, presupuesto) VALUES 
	(37, 'Nuevo Departamento37', 111000),
	(77, 'Nuevo Departamento77', 23100);
INSERT INTO empleado (DNI, nombre, apellidos, departamento) VALUES 
	('T23456782', 'Nuevo', 'Empleado3', 37),
	('Y87654322', 'Nuevo', 'Empleado4', 77);
SELECT * FROM empleado WHERE departamento = 37 OR departamento = 77; 

-- 2.7 Obtener todos los datos de los empleados cuyo apellido comienze por 'P'
SELECT * FROM empleado WHERE apellidos LIKE 'P%';

-- 2.8 Obtener el presupuesto total de todos los departamentos.
SELECT SUM(presupuesto) AS presupuesto_total FROM departamento;

-- 2.9 Obtener el numero de empleados en cada departamento. 
SELECT departamento, COUNT(*) AS numero_empleado FROM empleado GROUP BY departamento;

-- 2.10 Obtener un listado completo de empleados, en cada departamento. 
SELECT departamento.nombre AS `nombre departamento`, empleado.* FROM departamento JOIN empleado ON departamento.codigo = empleado.departamento
ORDER BY departamento.nombre, empleado.apellidos;

-- 2.11 Obtener un listado completo de empleados, incluyendo el nombre y apellidos del empleado junto al nombre y presupuesto de su departamento.
SELECT empleado.nombre AS `nombre empleado`, empleado.apellidos AS `apellidos empleado`, departamento.nombre AS nombre_departamento, departamento.presupuesto AS presupuesto_departamento
FROM empleado JOIN departamento ON empleado.departamento = departamento.codigo ORDER BY empleado.apellidos;

-- 2.12 Obtener los nombres y apellidos de los empleados que trabajen en departamentos cuyo presupuesto sea mayor de 60.000€.
SELECT empleado.nombre, empleado.apellidos
FROM empleado JOIN departamento ON empleado.departamento = departamento.codigo WHERE departamento.presupuesto > 60000;

-- 2.13 Obtener los datos de los departamentos cuyo presupuesto es superior al presupuesto medio de todos los departamentos.
SELECT * FROM departamento 
WHERE presupuesto > ROUND((SELECT AVG(presupuesto) FROM departamento), 2);

-- 2.14 Obtener los nombres (únicamente los nombres) de los departamentos que tienen más de dos empleados.
SELECT departamento.nombre FROM departamento JOIN empleado ON departamento.codigo = empleado.departamento
GROUP BY departamento.nombre HAVING COUNT(*) > 2;
	
-- 2.15 Añadir un nuevo departamento 'Calidad' con presupuesto de 40.000€ y codigo11. Añadir un empleado vinculado al departamento recién creado: Esther Vásquez, DNI 89267109
INSERT INTO departamento (codigo, nombre, presupuesto)VALUES 
	(11, 'Calidad', 40000);
INSERT INTO empleado (DNI, nombre, apellidos, departamento) VALUES 
	('N89267109', 'Esther', 'Vásquez', 11);	
	
-- 2.16 Aplicar un recorte presupuestario del 10 % a todos los departamentos.
UPDATE departamento SET presupuesto = presupuesto * 0.9;

-- 2.17 Reasignar a los empleados del departamento de investigación (código 77) al departamento de informática (codigo 14).
INSERT INTO departamento (codigo, nombre, presupuesto) VALUES 
	(77, 'Investigación', 125466),
    (14, 'Informática', 333333);
UPDATE empleado SET departamento = 14 WHERE departamento = 77;

-- 2.18 Despedir a todos los empleados que trabajan para el departamento de informática (codigo 14).
DELETE FROM empleado WHERE departamento = 14; 

-- 2.19 Despedir a todos los empleados que trabajen para departamentos cuyo presupuesto sea superior a los 60.000€. 
DELETE FROM empleado WHERE departamento IN (SELECT codigo FROM departamento WHERE presupuesto > 60000);

-- 2.20 Despedir a todos los empleados. 
DELETE FROM empleado;