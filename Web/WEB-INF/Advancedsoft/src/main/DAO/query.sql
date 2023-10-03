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
