CREATE SCHEMA proyect;

use proyect;


CREATE TABLE `proyect`.`login` (
  `user` VARCHAR(25) NOT NULL,
  `pass` VARCHAR(45) NOT NULL,
  `type` ENUM("Director", "Adscripto", "Administrativo", "Coordinador")
);

INSERT INTO LOGIN (user, pass, type) values ('mdeleon', 'srblack', 'Director');
INSERT INTO LOGIN (user, pass, type) values ('alombardi', 'elpapu', 'Administrativo');
INSERT INTO LOGIN (user, pass, type) values ('vbitancourt', 'amolosgatos', 'Coordinador');
INSERT INTO LOGIN (user, pass, type) values ('bsosa', 'negroSabroso', 'Director');
INSERT INTO LOGIN (user, pass, type) values ('cmora', 'pedofiliaDeFurros', 'Adscripto');