CREATE TABLE Cities (
  ID int(11) NOT NULL AUTO_INCREMENT,
  Name_ascii varchar(2000) DEFAULT NULL,
  Name varchar(2000) DEFAULT NULL,
  Country varchar(255) NOT NULL,
  Latitude decimal(10,5) DEFAULT NULL,
  Longitude decimal(10,5) DEFAULT NULL,
  Population int(11) DEFAULT NULL,
  PRIMARY KEY (ID)
);