Technologies:

Maven
Spring
log4j
Hibernate

In order to use this application first create TABLES.
```sql
CREATE TABLE logs (
  USER_ID varchar(20) NOT NULL,
  DATED datetime NOT NULL,
  LOGGER varchar(50) NOT NULL,
  LEVEL varchar(10) NOT NULL,
  MESSAGE varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE logger_control (
  ID int(11) NOT NULL AUTO_INCREMENT,
  MESSAGE_TYPE varchar(20) NOT NULL,
  ACTIVE bit(1) DEFAULT NULL,
  PRIMARY KEY (ID),
  UNIQUE KEY MESSAGE_TYPE_UNIQUE (MESSAGE_TYPE)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

INSERT INTO logger_control (MESSAGE_TYPE, ACTIVE) VALUES ('MESSAGE', 1);
```

In this last table add at least one register. In this version we don't check for 
NullPointerException so take in consideration this please. 

Remember that this is a maven project if you are going to use ECLIPSE run:
mvn eclipse:eclipse

Regarding to log4j you should change 
log4j-file.properties                change file location
log4j-database.properties            change database configuration
