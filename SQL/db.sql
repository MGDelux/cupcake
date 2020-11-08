DROP DATABASE IF EXISTS `cupcake`;
CREATE DATABASE IF NOT EXISTS `cupcake`;
USE cupcake;


CREATE TABLE `kunde` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL,
  `salt` binary(16) NOT NULL,
  `secret` binary(32) NOT NULL,
  `kredit` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
ALTER TABLE kunde auto_increment=100;


CREATE TABLE `toppings` (
  `id` int NOT NULL AUTO_INCREMENT,
  `navn` varchar(45) NOT NULL,
  `pris` double NOT NULL,
  PRIMARY KEY (`id`)
  
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
INSERT INTO toppings (navn,pris) VALUES ("Chocolate",5.00);
INSERT INTO toppings (navn,pris) VALUES ("Blueberry",5.00);
INSERT INTO toppings (navn,pris) VALUES ("Rasberry",5.00);
INSERT INTO toppings (navn,pris) VALUES ("Crispy",5.00);
INSERT INTO toppings (navn,pris) VALUES ("Strawberry",6.00);
INSERT INTO toppings (navn,pris) VALUES ("Rum/Raisin",7.00);
INSERT INTO toppings (navn,pris) VALUES ("Orange",8.00);
INSERT INTO toppings (navn,pris) VALUES ("Lemon",8.00);
INSERT INTO toppings (navn,pris) VALUES ("Blue cheese",9.00);


CREATE TABLE `buttoms` (
  `id` int NOT NULL AUTO_INCREMENT,
  `navn` varchar(45) NOT NULL,
  `pris` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
INSERT INTO buttoms (navn,pris) VALUES ("Chocolate",5.00);
INSERT INTO buttoms (navn,pris) VALUES ("Vanilla",5.00);
INSERT INTO buttoms (navn,pris) VALUES ("Nutmeg",5.00);
INSERT INTO buttoms (navn,pris) VALUES ("Pistacio",6.00);
INSERT INTO buttoms (navn,pris) VALUES ("Almond",7.00);



CREATE TABLE Orders (
	OrderId int NOT NULL, 
    UserId int,
    OrderDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    OrderPrice double NOT NULL, 
	PRIMARY KEY (OrderId)
);
CREATE TABLE OrderContent(
OrderId int not null,
cupcake int not null,
Top int not null,
Bot int not null,
  PRIMARY KEY (`OrderId`),
  FOREIGN KEY (OrderId) REFERENCES Orders (OrderId)
);




