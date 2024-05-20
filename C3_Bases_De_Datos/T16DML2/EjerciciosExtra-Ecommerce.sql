
-- 1. Realizar una consulta que muestre los campos “Empresa” y “Población” de la tabla “Clientes”. 
SELECT EMPRESA, POBLACIÓN FROM clientes;

-- 2. Realizar una consulta que muestre los artículos de la sección “Cerámica”. 
SELECT * FROM productos WHERE SECCIÓN = 'Cerámica';

/* 3. Realizar una consulta que muestre los productos de la sección “Deportes” cuyo precio esté entre 100 y 200 €. En la consulta solo se mostrarán los campos 
“Nombre de artículo” y “Precio”. */  
SELECT NOMBREARTÍCULO, PRECIO FROM productos WHERE SECCIÓN = 'Deportes' AND PRECIO BETWEEN 100 AND 200;

-- 4. Realizar una consulta que muestre los productos cuyo país no sea España. 
SELECT * FROM productos WHERE PAÍSDEORIGEN != 'España';

/* 5. Realizar una consulta que muestre los artículos españoles de la sección “Deportes” o aquellos cuyo precio sea superior a 350 € independientemente de cual
sea su sección o país de origen. */    
SELECT * FROM productos WHERE (SECCIÓN = 'Deportes' AND PAÍSDEORIGEN = 'España') OR (PRECIO > 350);

/* 6. Realizar una consulta que muestre los productos cuya fecha esté entre 1/05/2001 y 15/12/2001. En la consulta solo se visualizarán los campos “Nombre de 
artículo”, “Sección” y “Fecha”. */ 
SELECT NOMBREARTÍCULO, SECCIÓN, FECHA FROM productos WHERE FECHA BETWEEN '01-05-2001' AND '15-12-2001';

/* 7. Realizar una consulta que muestre aquellos productos españoles cuya fecha esté comprendida entre febrero y mayo del 2002. Ordenar los resultados por el 
campo “Nombre artículo” descendentemente. */  
SELECT * FROM productos WHERE PAÍSDEORIGEN = 'España' AND FECHA BETWEEN '01-02-2002' AND '31-05-2002' ORDER BY NOMBREARTÍCULO DESC;

/* 8. Realizar una consulta que muestre los campos “Empresa”, “Dirección” y “Población” de la tabla “Clientes”. Ordenar la consulta por el campo “Población” 
ascendentemente y por “Dirección” descendentemente. */
SELECT EMPRESA, DIRECCIÓN, POBLACIÓN FROM clientes ORDER BY POBLACIÓN ASC, DIRECCIÓN DESC;

-- 9. Realizar una consulta que muestre todos los campos de la tabla “Clientes”. Ordenar los resultados por el campo “Población” ascendentemente. 
SELECT * FROM clientes ORDER BY POBLACIÓN ASC;

/* 10. Realizar una consulta sobre la tabla “Clientes”  que muestre los campos “Dirección”, “Teléfono” y “Población”. Este último debe aparecer en la consulta 
con el nombre de “Residencia”. Los registros aparecerán ordenados descendentemente por el campo “Población”. */
SELECT DIRECCIÓN, TELÉFONO, POBLACIÓN AS Residencia FROM clientes ORDER BY POBLACIÓN DESC;

-- 11. Realizar una consulta que muestre que poblaciones hay en la tabla “Clientes”.
SELECT DISTINCT POBLACIÓN FROM clientes;

/* 12. Realizar una consulta de agrupación que muestre la suma del precio de los artículos de todas las secciones. Mostrar en la consulta los campos sección y 
suma por sección. */
SELECT SECCIÓN, SUM(PRECIO) AS `SUMA_POR_SECCIÓN` FROM productos GROUP BY SECCIÓN;

/* 13. Realizar una consulta de agrupación que muestre la media del precio de todas las secciones menos de juguetería. En la consulta deberán aparecer los campos 
“Sección” y “Media por sección”. */
SELECT SECCIÓN, AVG(PRECIO) AS `MEDIA_POR_SECCIÓN` FROM productos WHERE SECCIÓN != 'Juguetería' GROUP BY SECCIÓN;

/* 14. Realizar Una consulta que muestre cuantos artículos hay de la sección “Deportes”. */
SELECT COUNT(*) AS `CANTIDAD_DE_ARTÍCULOS` FROM productos WHERE SECCIÓN = 'Deportes';

-- 15. Busca la media de precios de Ferretería  y muestra los precios que sean menores que esa media
SELECT * FROM productos WHERE PRECIO < (SELECT AVG(PRECIO) FROM productos WHERE SECCIÓN='FERRETERÍA');

/* 16. Busca los precios de Juguetería y muestra TODOS los precios de Marruecos que sean MENORES que esa lista de precios de Juguetería (Luego muestra CUALQUIERA 
sea MENOR). */
SELECT PRECIO FROM productos WHERE SECCIÓN = 'Juguetería';

SELECT PRECIO FROM productos WHERE PAÍSDEORIGEN = 'Marruecos' AND PRECIO < (SELECT MIN(PRECIO) FROM PRODUCTOS WHERE SECCIÓN = 'Juguetería')
LIMIT 1;

/* 17. Realizar una consulta que visualice los  registros de la tabla PRODUCTOS con un precio entre 200 y 500 y además los registros de la tabla PRODUCTOSNUEVOS 
donde el precio sea superior a 1100. */
SELECT * FROM productos WHERE PRECIO BETWEEN 200 AND 500
UNION ALL
SELECT * FROM productosnuevos WHERE PRECIO > 1100;

/* 18. Realizar una consulta visualizando los campos FECHA, SECCIÓN, NOMBRE ARTÍCULO y PRECIO de la tabla PRODUCTOS sólo a los artículos de la sección CERÁMICA. 
También que se vean los productos de ALTA COSTURA de la tabla PRODUCTOSNUEVOS. */
SELECT FECHA, SECCIÓN, NOMBREARTÍCULO, PRECIO FROM productos WHERE SECCIÓN = 'CERÁMICA'
UNION ALL
SELECT FECHA, SECCIÓN, NOMBREARTÍCULO, PRECIO FROM productosnuevos
WHERE SECCIÓN = 'ALTA COSTURA';

-- 19. Une las dos tablas  mostrando solo los productos del año 2001. Da igual si hay campos repetidos, muéstralos.
SELECT * FROM productos WHERE FECHA LIKE '2001%'
UNION ALL
SELECT * FROM productosnuevos WHERE FECHA LIKE '2001%';

-- 20. Queremos saber los clientes que han hecho pedidos de Madrid.
SELECT * FROM clientes WHERE CÓDIGOCLIENTE IN 
(SELECT CÓDIGOCLIENTE FROM pedidos WHERE CÓDIGOCLIENTE = clientes.CÓDIGOCLIENTE)
AND POBLACIÓN = 'Madrid';

/* 21. Queremos mostrar los clientes con pedidos de Madrid solo los siguientes campos CÓDIGO CLIENTE (de la tabla Clientes), POBLACIÓN, DIRECCIÓN, NÚMERODEPEDIDO, 
CÓDIGO CLIENTE (de la tabla Pedidos) y FORMADEPAGO. */


/* 22. Muestra los clientes que han hecho pedidos de "A Coruña". Muestra solo los campos Código cliente (de la tabla pedidos), el nombre de la empresa, el teléfono 
y la forma de pago. */


-- 23. Mostrar los campos  NOMBREARTÍCULO y PRECIO de la tabla "PRODUCTOS" y UNIDADES de la tabla  "PRODUCTOS- PEDIDOS", 


-- 24. Mostrar solo los artículos que se han vendido más de 20 unidades. 
SELECT * FROM productos WHERE CÓDIGOARTÍCULO IN 
(SELECT CÓDIGOARTÍCULO FROM productos_pedidos WHERE UNIDADES > 20);

/* 25. Realizar una consulta que visualice los campos NOMBRE ARTÍCULO, SECCIÓN, PRECIO de la tabla PRODUCTOS y un campo nuevo que nombramos con el texto “DESCUENTO_7”. 
Debe mostrar el resultado de aplicar sobre el campo PRECIO un descuento de un 7 %. El formato del nuevo campo para debe aparecer con 2 lugares decimales. */ 
SELECT NOMBREARTÍCULO, SECCIÓN, PRECIO, ROUND(PRECIO * 0.93, 2) AS DESCUENTO FROM productos;

/* 26. Realizar una consulta visualizando los campos FECHA, SECCIÓN, NOMBRE ARTÍCULO y PRECIO de la tabla PRODUCTOS y un campo nuevo que nombramos con el texto “DTO2 
€_EN_CERÁMICA”. Debe mostrar el resultado de aplicar sobre el campo PRECIO la resta de 2 € sólo a los artículos de la sección CERÁMICA. El formato del nuevo campo 
debe aparecer con 2 lugares decimales. Ordenar el resultado de la consulta por el campo FECHA descendente. */



/* 27. Realizar una consulta visualizando los campos NOMBRE ARTÍCULO, SECCIÓN, PRECIO de la tabla PRODUCTOS y un campo nuevo que nombramos con el texto 
“PRECIO_AUMENTADO_EN_2”. Debe mostrar el PRECIO con un incremento de un 2% del PRECIO. Sólo debemos tener en cuenta los registros de la sección FERRETERÍA. 
El nuevo campo debe aparecer en Euros y con 2 lugares decimales. */



