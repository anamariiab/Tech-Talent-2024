USE meteo;
CREATE TABLE estacion (
             
				 identificador MEDIUMINT UNSIGNED NOT NULL,
				 latitud VARCHAR(15) NOT NULL,
				 altitud MEDIUMINT NOT NULL,
				 PRIMARY KEY (identificador)
);
         				 
			