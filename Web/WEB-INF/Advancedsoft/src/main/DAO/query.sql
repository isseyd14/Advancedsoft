CREATE TABLE account (
                         email VARCHAR(255),
                         pass VARCHAR(255),
                         type VARCHAR(50)
);

INSERT INTO account (email, pass, type)
VALUES ('pass', 'pass', 'customer');

CREATE TABLE `bank`.`accountinfo` (
                                      `Email` VARCHAR(50) NOT NULL,
                                      `Fname` VARCHAR(45) NULL,
                                      `Lname` VARCHAR(45) NULL,
                                      `Address` VARCHAR(45) NULL,
                                      `Phone` VARCHAR(45) NULL,
                                      `balance` VARCHAR(45) NULL,
                                      PRIMARY KEY (`Email`));
ALTER TABLE `bank`.`accountinfo`
    ADD COLUMN `dob` DATE NULL DEFAULT NULL AFTER `balance`;

ALTER TABLE `bank`.`account`
    ADD COLUMN `Fname` VARCHAR(45) NULL AFTER `Type`,
    ADD COLUMN `Lname` VARCHAR(45) NULL AFTER `Fname`,
    ADD COLUMN `Address` VARCHAR(45) NULL AFTER `Lname`,
    ADD COLUMN `Phone` VARCHAR(45) NULL AFTER `Address`,
    ADD COLUMN `Balance` VARCHAR(45) NULL AFTER `Phone`,
    ADD COLUMN `dob` VARCHAR(45) NULL AFTER `Balance`;

ALTER TABLE `bank`.`account`
    CHANGE COLUMN `dob` `dob` DATE NULL DEFAULT NULL ;

ALTER TABLE `bank`.`account`
    CHANGE COLUMN `Balance` `Balance` DOUBLE NULL DEFAULT NULL ;

