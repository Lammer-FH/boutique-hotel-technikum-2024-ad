-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema boutique_hotel_technikum
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema boutique_hotel_technikum
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `boutique_hotel_technikum` DEFAULT CHARACTER SET utf8 ;
USE `boutique_hotel_technikum` ;

-- -----------------------------------------------------
-- Table `boutique_hotel_technikum`.`Room`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `boutique_hotel_technikum`.`Room` (
  `idRoom` INT NOT NULL AUTO_INCREMENT,
  `imagePath` VARCHAR(1000) NULL,
  `title` VARCHAR(1000) NULL,
  `description` VARCHAR(10000) NULL,
  `price` DECIMAL NULL,
  PRIMARY KEY (`idRoom`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `boutique_hotel_technikum`.`Guest`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `boutique_hotel_technikum`.`Guest` (
  `idGuest` INT NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(100) NULL,
  `lastname` VARCHAR(100) NULL,
  `email` VARCHAR(100) NULL,
  PRIMARY KEY (`idGuest`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `boutique_hotel_technikum`.`Reservation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `boutique_hotel_technikum`.`Reservation` (
  `idReservation` INT NOT NULL AUTO_INCREMENT,
  `guest_idGuest` INT NOT NULL,
  `room_idRoom` INT NOT NULL,
  `from` DATETIME NULL,
  `to` DATETIME NULL,
  `doBreakfast` TINYINT NULL,
  PRIMARY KEY (`idReservation`, `guest_idGuest`, `room_idRoom`),
  INDEX `fk_Reservation_Guest_idx` (`guest_idGuest` ASC) VISIBLE,
  INDEX `fk_Reservation_Room1_idx` (`room_idRoom` ASC) VISIBLE,
  CONSTRAINT `fk_Reservation_Guest`
    FOREIGN KEY (`guest_idGuest`)
    REFERENCES `boutique_hotel_technikum`.`Guest` (`idGuest`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reservation_Room1`
    FOREIGN KEY (`room_idRoom`)
    REFERENCES `boutique_hotel_technikum`.`Room` (`idRoom`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `boutique_hotel_technikum`.`Extra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `boutique_hotel_technikum`.`Extra` (
  `idExtra` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL,
  PRIMARY KEY (`idExtra`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `boutique_hotel_technikum`.`Room_has_Extra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `boutique_hotel_technikum`.`Room_has_Extra` (
  `room_idRoom` INT NOT NULL,
  `extra_idExtra` INT NOT NULL,
  PRIMARY KEY (`room_idRoom`, `extra_idExtra`),
  INDEX `fk_Room_has_Extra_Extra1_idx` (`extra_idExtra` ASC) VISIBLE,
  INDEX `fk_Room_has_Extra_Room1_idx` (`room_idRoom` ASC) VISIBLE,
  CONSTRAINT `fk_Room_has_Extra_Room1`
    FOREIGN KEY (`room_idRoom`)
    REFERENCES `boutique_hotel_technikum`.`Room` (`idRoom`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Room_has_Extra_Extra1`
    FOREIGN KEY (`extra_idExtra`)
    REFERENCES `boutique_hotel_technikum`.`Extra` (`idExtra`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO boutique_hotel_technikum.Room (imagePath, title, description, price) VALUES ('0.jpg', 'Room 1', 'Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua.', 50);
INSERT INTO boutique_hotel_technikum.Room (imagePath, title, description, price) VALUES ('1.jpg', 'Room 2', 'Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua.', 65);
INSERT INTO boutique_hotel_technikum.Room (imagePath, title, description, price) VALUES ('2.jpg', 'Room 3', 'Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua.', 45);
INSERT INTO boutique_hotel_technikum.Room (imagePath, title, description, price) VALUES ('3.jpg', 'Room 4', 'Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua.', 234);
INSERT INTO boutique_hotel_technikum.Room (imagePath, title, description, price) VALUES ('4.jpg', 'Room 5', 'Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua.', 123);
INSERT INTO boutique_hotel_technikum.Room (imagePath, title, description, price) VALUES ('5.jpg', 'Room 6', 'Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua.', 23);

INSERT INTO boutique_hotel_technikum.Extra (name) VALUES ('AIR_CONDITIONING');
INSERT INTO boutique_hotel_technikum.Extra (name) VALUES ('FREE_WIFI');
INSERT INTO boutique_hotel_technikum.Extra (name) VALUES ('BALCONY');
INSERT INTO boutique_hotel_technikum.Extra (name) VALUES ('FLAT_SCREEN_TV');

INSERT INTO boutique_hotel_technikum.Room_has_Extra (room_idRoom, extra_idExtra) VALUES (1, 1);
INSERT INTO boutique_hotel_technikum.Room_has_Extra (room_idRoom, extra_idExtra) VALUES (2, 1);
INSERT INTO boutique_hotel_technikum.Room_has_Extra (room_idRoom, extra_idExtra) VALUES (1, 2);
INSERT INTO boutique_hotel_technikum.Room_has_Extra (room_idRoom, extra_idExtra) VALUES (2, 2);
INSERT INTO boutique_hotel_technikum.Room_has_Extra (room_idRoom, extra_idExtra) VALUES (3, 2);
INSERT INTO boutique_hotel_technikum.Room_has_Extra (room_idRoom, extra_idExtra) VALUES (3, 3);
INSERT INTO boutique_hotel_technikum.Room_has_Extra (room_idRoom, extra_idExtra) VALUES (3, 1);

INSERT INTO Guest (firstname, lastname, email)
VALUES ('Gustav', 'Ganz', 'gustav@email.test'),
('Tom', 'Heu', 'tom.heu@email.test'),
('Lehr', 'Gos', 'gustav@email.test');

INSERT INTO Reservation (guest_idGuest, room_idRoom, `from`, `to`, doBreakfast)
VALUES (1, 1, '2024-06-01', '2024-06-3', true);