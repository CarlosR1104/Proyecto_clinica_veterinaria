create database bd_clinica;
use bd_clinica;

CREATE TABLE persona(
	id_persona int(11) NOT NULL,
	nombre_persona varchar(45) DEFAULT NULL,
	profesion_persona varchar(45) DEFAULT NULL,
	telefono_persona varchar(45) DEFAULT NULL,
	tipo_persona int(2) NOT NULL,
	nacimiento_id int(11) NOT NULL,
	PRIMARY KEY (id_persona)
);

CREATE TABLE nacimiento(
	id_nacimiento int(11) NOT NULL AUTO_INCREMENT ,
	ciudad_nacimiento varchar(45) DEFAULT NULL,
	departamento_nacimiento varchar(45) DEFAULT NULL,
	fecha_nacimiento date DEFAULT NULL,
	pais_nacimiento varchar(45) DEFAULT NULL,
	PRIMARY KEY (id_nacimiento)
); 

ALTER TABLE persona 
ADD INDEX fk_persona_nacimiento (nacimiento_id ASC);
;
ALTER TABLE persona
ADD CONSTRAINT fk_persona_nacimiento
	FOREIGN KEY (nacimiento_id)
    REFERENCES nacimiento (id_nacimiento)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;
