-- noinspection SqlDialectInspectionForFile

-- noinspection SqlNoDataSourceInspectionForFile

-- noinspection SqlDialectInspectionForFile

-- noinspection SqlNoDataSourceInspectionForFile

-- V0 PROTOTYPE, TEAM JUMBO SNEGL

DROP TABLE IF EXISTS cupcake;
create database cupcake;
create user cupcake@localhost;
grant all privileges on cupcake.* to cupcake@localhost;
USE cupcake;

CREATE TABLE cupcake.kunde (
  id INT NOT NULL AUTO_INCREMENT,
  email VARCHAR(45) NOT NULL,
  role VARCHAR(45) NOT NULL,
  salt BINARY(16) NOT NULL,
  secret BINARY(32) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE cupcake.ordre (
  ordre_id INT NOT NULL AUTO_INCREMENT,
  date DATETIME NOT NULL,
  PRIMARY KEY (ordre_id));

CREATE TABLE cupcake.orderline (
  id_orderline INT NOT NULL AUTO_INCREMENT,
  idodre INT NOT NULL,
  amount INT NOT NULL,
  sum DOUBLE NOT NULL,
  toping_id INT NOT NULL,
  buttom_id INT NOT NULL,
  PRIMARY KEY (idodre),
  UNIQUE INDEX id_orderline_UNIQUE (id_orderline ASC) VISIBLE,
  CONSTRAINT idOrdre
    FOREIGN KEY (idodre)
    REFERENCES cupcake.ordre (ordre_id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE cupcake.toppings (
  topping_id INT NOT NULL,
  navn VARCHAR(45) NOT NULL,
  pris DOUBLE NOT NULL,
  PRIMARY KEY (topping_id));

CREATE TABLE cupcake.buttoms (
  bottom_id INT NOT NULL,
  navn VARCHAR(45) NOT NULL,
  pris DOUBLE NOT NULL,
  PRIMARY KEY (bottom_id));

CREATE TABLE cupcake.properties (
    name VARCHAR(255) PRIMARY KEY,
    value VARCHAR(255) NOT NULL
);
INSERT INTO cupcake.properties (name, value) VALUES ("version", "0");
INSERT INTO buttoms (navn,pris) VALUES ("Chocolate",5.00);
INSERT INTO buttoms (navn,pris) VALUES ("Vanilla",5.00);
INSERT INTO buttoms (navn,pris) VALUES ("Nutmeg",5.00);
INSERT INTO buttoms (navn,pris) VALUES ("Pistacio",6.00);
INSERT INTO buttoms (navn,pris) VALUES ("Almond",7.00);

INSERT INTO toppings (navn,pris) VALUES ("Chocolate",5.00);
INSERT INTO toppings (navn,pris) VALUES ("Blueberry",5.00);
INSERT INTO toppings (navn,pris) VALUES ("Rasberry",5.00);
INSERT INTO toppings (navn,pris) VALUES ("Crispy",5.00);
INSERT INTO toppings (navn,pris) VALUES ("Strawberry",6.00);
INSERT INTO toppings (navn,pris) VALUES ("Rum/Raisin",7.00);
INSERT INTO toppings (navn,pris) VALUES ("Orange",8.00);
INSERT INTO toppings (navn,pris) VALUES ("Lemon",8.00);
INSERT INTO toppings (navn,pris) VALUES ("Blue cheese",9.00);

