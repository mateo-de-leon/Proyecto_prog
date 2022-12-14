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
  PRIMARY KEY (`ci`),
  CHECK(ci > 10000000 and ci < 99999999));

CREATE TABLE `proyect`.`absences` (
  `ci` INT NOT NULL,
  `initDate` DATE NOT NULL,
  `finalDate` DATE NOT NULL,
  `groupsAffected` VARCHAR(90) NOT NULL,
  `reason` VARCHAR(90) NOT NULL,
  CHECK(initDate < finalDate),
  CHECK(ci > 10000000 and ci < 99999999)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_spanish_ci;
ALTER TABLE `proyect`.`absences` 
ADD COLUMN `name` VARCHAR(70) NOT NULL AFTER `finalDate`;




INSERT INTO LOGIN (ci, user, pass, type, name) values (12345678, 'mdeleon', 'srblack', 'Director', 'Mateo De León');
INSERT INTO LOGIN (ci, user, pass, type, name) values (13345678, 'alombardi', 'elpapu', 'Administrativo', 'Axel Lombardi');
INSERT INTO LOGIN (ci, user, pass, type, name) values (14345678, 'vbitancourt', 'amolosgatos', 'Coordinador', 'Valeria Bitancourt');
INSERT INTO LOGIN (ci, user, pass, type, name) values (15345678, 'bsosa', 'juancho', 'Director', 'Brandon Sosa');
INSERT INTO LOGIN (ci, user, pass, type, name) values (16345678, 'cmora', 'xXmaestroCarlitosProXx', 'Adscripto', 'Carlos Mora');
INSERT INTO teacher (name, ci) VALUES ('Christian Barrios', 12345678);
INSERT INTO teacher (name, ci) VALUES ('Nora Hernández', 22345678);
INSERT INTO teacher (name, ci) VALUES ('Laura Gorosito', 32345678);
INSERT INTO teacher (name, ci) VALUES ('Mario Rodríguez', 42345678);

INSERT INTO absences (name, ci, initDate, finalDate, groupsAffected, reason) VALUES ("Christian Barrios", 12345678, '2022-12-23', '2022-12-24', '2IC 1IA 3IB', "He didn't want to go lol");
INSERT INTO absences (name, ci, initDate, finalDate, groupsAffected, reason) VALUES ("Nora Hernández", 22345678, '2022-12-26', '2022-12-27', '2IC', "She didn't want to go lol");
INSERT INTO absences (name, ci, initDate, finalDate, groupsAffected, reason) VALUES ("Laura Gorosito", 32345678, '2022-12-27', '2022-12-28', '2IA 3IB 2IH', "She didn't want to go lol");
INSERT INTO absences (name, ci, initDate, finalDate, groupsAffected, reason) VALUES ("Mario Rodríguez", 42345678, '2022-12-17', '2022-12-18', '2IA', "He didn't want to go lol");
