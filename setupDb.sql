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
  `idRoom` INT NOT NULL,
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
  `idGuest` INT NOT NULL,
  `firstname` VARCHAR(100) NULL,
  `lastname` VARCHAR(100) NULL,
  `email` VARCHAR(100) NULL,
  PRIMARY KEY (`idGuest`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `boutique_hotel_technikum`.`Reservation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `boutique_hotel_technikum`.`Reservation` (
  `idReservation` INT NOT NULL,
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
  `idExtra` INT NOT NULL,
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
