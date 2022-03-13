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
    
CREATE TABLE mascotas(
id_mascota BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL,
color VARCHAR(45),
nombre VARCHAR(45),
raza VARCHAR(45),
sexo VARCHAR(45),
persona_id INT(11)
);

ALTER TABLE `bd_clinica`.`mascotas` 
ADD INDEX `FK_Persona_Mascota_idx` (`persona_id` ASC) VISIBLE;
;
ALTER TABLE `bd_clinica`.`mascotas` 
ADD CONSTRAINT `FK_Persona_Mascota`
  FOREIGN KEY (`persona_id`)
  REFERENCES `bd_clinica`.`persona` (`id_persona`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

CREATE TABLE personas_productos(
persona_id INT(11),
producto_id INT(11)
);

CREATE TABLE productos(
id_producto INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
nombre_producto VARCHAR(45),
precio_producto DOUBLE
);

ALTER TABLE `bd_clinica`.`personas_productos` 
ADD INDEX `FK_Persona_Productos_idx` (`persona_id` ASC) VISIBLE;
;
ALTER TABLE `bd_clinica`.`personas_productos` 
ADD CONSTRAINT `FK_Persona_Productos`
  FOREIGN KEY (`persona_id`)
  REFERENCES `bd_clinica`.`persona` (`id_persona`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
ALTER TABLE `bd_clinica`.`personas_productos` 
ADD INDEX `FK_Productos_Persona_idx` (`producto_id` ASC) VISIBLE;
;
ALTER TABLE `bd_clinica`.`personas_productos` 
ADD CONSTRAINT `FK_Productos_Persona`
  FOREIGN KEY (`producto_id`)
  REFERENCES `bd_clinica`.`productos` (`id_producto`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
