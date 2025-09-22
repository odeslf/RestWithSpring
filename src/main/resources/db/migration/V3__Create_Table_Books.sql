CREATE TABLE `books` (
     `id` INT(10) NOT NULL AUTO_INCREMENT,
     `author` VARCHAR(255) NULL,
     `launch_date` DATETIME(6) NOT NULL,
     `price` DECIMAL(65,2) NOT NULL,
     `title` VARCHAR(255) NULL,
     PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;