CREATE SCHEMA proyect;

use proyect;


CREATE TABLE `proyect`.`login` (
  `user` VARCHAR(25) NOT NULL,
  `pass` VARCHAR(45) NOT NULL,
  `type` ENUM("Director", "Adscripto", "Administrativo", "Coordinador")
);
ALTER TABLE `proyect`.`login` 
COLLATE = utf8mb4_spanish_ci ,
ADD COLUMN `name` VARCHAR(70) NOT NULL AFTER `type`;
ALTER TABLE `login` ADD COLUMN `ci` int NOT NULL AFTER `user`;

CREATE TABLE `proyect`.`teacher` (
  `name` VARCHAR(70) NOT NULL,
  `ci` INT NOT NULL,
  PRIMARY KEY (`ci`));


INSERT INTO LOGIN (ci, user, pass, type, name) values (12345678, 'mdeleon', 'srblack', 'Director', 'Mateo De León');
INSERT INTO LOGIN (ci, user, pass, type, name) values (13345678, 'alombardi', 'elpapu', 'Administrativo', 'Axel Lombardi');
INSERT INTO LOGIN (ci, user, pass, type, name) values (14345678, 'vbitancourt', 'amolosgatos', 'Coordinador', 'Valeria Bitancourt');
INSERT INTO LOGIN (ci, user, pass, type, name) values (15345678, 'bsosa', 'negroSabroso', 'Director', 'Brandon Sosa');
INSERT INTO LOGIN (ci, user, pass, type, name) values (16345678, 'cmora', 'pedofiliaDeFurros', 'Adscripto', 'Carlos Mora');
INSERT INTO teacher (name, ci) VALUES ('Christian Barrios', 12345678);
INSERT INTO teacher (name, ci) VALUES ('Nora Hernández', 22345678);
INSERT INTO teacher (name, ci) VALUES ('Laura Gorosito', 32345678);
INSERT INTO teacher (name, ci) VALUES ('Mario Rodríguez', 42345678);