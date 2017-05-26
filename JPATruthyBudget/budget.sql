-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema budget
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `budget` ;

-- -----------------------------------------------------
-- Schema budget
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `budget` DEFAULT CHARACTER SET utf8 ;
USE `budget` ;

-- -----------------------------------------------------
-- Table `budget`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `budget`.`user` ;

CREATE TABLE IF NOT EXISTS `budget`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `budget`.`category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `budget`.`category` ;

CREATE TABLE IF NOT EXISTS `budget`.`category` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL DEFAULT '',
  `description` TEXT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `budget`.`item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `budget`.`item` ;

CREATE TABLE IF NOT EXISTS `budget`.`item` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL DEFAULT '',
  `value` DECIMAL NOT NULL DEFAULT 0.0,
  `date` TIMESTAMP(4) NOT NULL DEFAULT CURRENT_TIMESTAMP(4),
  `notes` TEXT NULL,
  `user_id` INT NOT NULL,
  `category_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_item_user_idx` (`user_id` ASC),
  INDEX `fk_item_category1_idx` (`category_id` ASC),
  CONSTRAINT `fk_item_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `budget`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_item_category`
    FOREIGN KEY (`category_id`)
    REFERENCES `budget`.`category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
GRANT USAGE ON *.* TO budgetuser;
 DROP USER budgetuser;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
CREATE USER 'budgetuser' IDENTIFIED BY 'budgetuser';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE `budget`.* TO 'budgetuser';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `budget`.`user`
-- -----------------------------------------------------
START TRANSACTION;
USE `budget`;
INSERT INTO `budget`.`user` (`id`, `email`, `password`) VALUES (1, 'shaundashjian@gmail.com', 'password');

COMMIT;


-- -----------------------------------------------------
-- Data for table `budget`.`category`
-- -----------------------------------------------------
START TRANSACTION;
USE `budget`;
INSERT INTO `budget`.`category` (`id`, `name`, `description`) VALUES (1, 'food', 'I need this to stay alive');
INSERT INTO `budget`.`category` (`id`, `name`, `description`) VALUES (2, 'book', 'I need this to keep learning');

COMMIT;


-- -----------------------------------------------------
-- Data for table `budget`.`item`
-- -----------------------------------------------------
START TRANSACTION;
USE `budget`;
INSERT INTO `budget`.`item` (`id`, `name`, `value`, `date`, `notes`, `user_id`, `category_id`) VALUES (1, 'Raw Goat Milk', 70.00, '2017-05-25 03:14:07', 'Healthy food', 1, 1);
INSERT INTO `budget`.`item` (`id`, `name`, `value`, `date`, `notes`, `user_id`, `category_id`) VALUES (2, 'Cracking the Coding Interview', 25.00, '2017-05-24 03:14:07', 'Great book', 1, 2);

COMMIT;

