CREATE TABLE `user_info` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into user_info values(1,'a','a');


DROP TABLE IF EXISTS `account`;

CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `facility`;

CREATE TABLE `facility` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `keeperId` int(11) NOT NULL,
  `facilityName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

ALTER TABLE `facility` ADD CONSTRAINT facility_keeperId_fk FOREIGN KEY(keeperId) REFERENCES user(id);

insert into facility values(NULL, 1, "X-ray Diffraction"),(NULL, 1, "Transmission Electron Microscope");

DROP TABLE IF EXISTS `schedule`;

CREATE TABLE `schedule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `facilityId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `startTime` datetime NOT NULL,
  `endTime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

ALTER TABLE `schedule` ADD CONSTRAINT schedule_facilityId_fk FOREIGN KEY(facilityId) REFERENCES facility(id);

insert into schedule values(NULL, 8, 2, "2015-05-04 11:00:00", "2015-05-04 12:00:00" ),(NULL, 8, 2, "2015-05-05 15:30:00", "2015-05-05 17:30:00");
