
USE biblio;

CREATE TABLE editorial (
      clave_editorial SMALLINT NOT NULL,
		nombre VARCHAR (60),
		direccion VARCHAR (60),
		telefono VARCHAR (15),
		
		PRIMARY KEY (clave_editorial));

CREATE TABLE tema (
      clave_tema SMALLINT NOT NULL,
		nombre VARCHAR (40),
		
		PRIMARY KEY (clave_tema))
		
CREATE TABLE autor (
      clave_autor INT NOT NULL,
		nombre VARCHAR (60),
		
		PRIMARY KEY (clave_autor));
		
CREATE TABLE socio (
      clave_socio SMALLINT NOT NULL;
		nombre VARCHAR (60),
		direccion VARCHAR (60),
		telefono VARCHAR (15),
		categoria CHAR;
		
		PRIMARY KEY (clave_socio));
		
CREATE TABLE libro (
      clave_libro INT NOT NULL,
      titulo VARCHAR (60),
      idioma VARCHAR (15),
      formato VARCHAR (15),
		claveeditorial SMALLINT,
		PRIMARY KEY (clavelibro),
		KEY (claveeditorial),
		REFERENCES editorial (claveeditorial),
		ON DELETE SET NULL
		ON UPDATE CASCADE);
		
CREATE TABLE ejemplar (
      clave_ejemplar INT NOT NULL,
      clave_libro INT NOT NULL,
      numero_orden SMALLINT NOT NULL,
      edicion SMALLINT,
      ubicacion VARCHAR (15),
      categoria CHAR,
      PRIMARY KEY (claveejemplar),
      FOREIGN KEY (clavelibro),
      REFERENCES libro (clavelibro),
      ON DELETE CASCADE
      ON UPDATE CASCADE);
      
 CREATE TABLE prestamo (
      clave_socio INT,
      clave_ejemplar INT,
      numero_orden SMALLINT,
      fecha_prestamo DATE NOT NULL,
      fecha_devolucion DATE DEFAULT NULL,
      notas BLOB,
      FOREIGN KEY (clave_socio)
      REFERENCES socio (clave_socio)
      ON DELETE SET NULL
      ON UPDATE CASCADE
      FOREIGN KEY (clave_ejemplar)
      REFERENCES ejemplar (clave_ejemplar)
      ON DELETE SET NULL
      ON UPDATE CASCADE);
      
CREATE TABLE trata_sobre (
      clave_libro INT NOT NULL,
      clave_tema SMALLINT NOT NULL,
      FOREIGN KEY (clave_libro)
      REFERENCES libro (clave_libro),
      ON DELETE SET NULL
      ON UPDATE CASCADE)
      FOREIGN KEY (clave_tema)
      REFERENCES tema (clave_tema)
      ON DELETE CASCADE,
      ON UPDATE CASCADE
);      
      
CREATE TABLE escrito_por (
      clave_libro INT NOT NULL,
      clave_autor INT NOT NULL,
      FOREIGN KEY (clave_libro)
      REFERENCES libro (clave_libro),
      ON DELETE CASCADE
      ON UPDATE CASCADE          
      FOREIGN KEY (clave_autor),
      REFERENCES autor (clave_autor),
      ON DELETE CASCADE
      ON UPDATE CASCADE
);
      
      

		