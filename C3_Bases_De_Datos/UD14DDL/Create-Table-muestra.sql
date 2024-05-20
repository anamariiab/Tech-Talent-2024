USE meteo;
CREATE TABLE muestra (
       id_estacion MEDIUMINT,
       fecha DATE NOT NULL,
       temp_minima TINYINT UNSIGNED,
       temp_maxima TINYINT,
       precipitaciones SMALLINT UNSIGNED,
       humedad_minima TINYINT UNSIGNED,
       humedad_maxima TINYINT UNSIGNED,
       velocidad_minima SMALLINT UNSIGNED,
       velocidad_maxima TINYINT UNSIGNED,
       KEY (id_estacion),
       FOREIGN KEY (id_estacion),
       REFERENCES estacion(identificador)
       ON DELETE NO ACTION,
       ON UPDATE CASCADE)
       
       