Technologies:

Maven
Spring
log4j
Hibernate

In order to use this application first create TABLES.

CREATE TABLE `logger_control` (
  `ID` int(11) NOT NULL,
  `MESSAGE_TYPE` varchar(20) NOT NULL,
  `ACTIVE` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `logger_control` (
  `ID` int(11) NOT NULL,
  `MESSAGE_TYPE` varchar(20) NOT NULL,
  `ACTIVE` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

In this last table add at least one register. In this version we don't check for 
NullPointerException so take in consideration this please. 

Remember that this is a maven project if you are going to use ECLIPSE run:
mvn eclipse:eclipse

Regarding to log4j you should change 
log4j-file.properties                change file location
log4j-database.properties            change database configuration
