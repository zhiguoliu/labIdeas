use test;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,

  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

insert into `user` values(1, "lisi@163.com", "lisi");

DROP TABLE IF EXISTS `facility`;

CREATE TABLE `facility` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `keeperId` int(11) NOT NULL,
  `facilityName` varchar(50) DEFAULT NULL,
  `picture` varchar(50) DEFAULT NULL,
  `introduction` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

ALTER TABLE `facility` ADD CONSTRAINT facility_keeperId_fk FOREIGN KEY(keeperId) REFERENCES user(id);

insert into `facility` values(NULL, 1, "X-ray Diffraction"),(NULL, 1, "Transmission Electron Microscope");

DROP TABLE IF EXISTS `schedule`;

CREATE TABLE `schedule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `facilityId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `startTime` varchar(256) NOT NULL,
  `endTime` varchar(256) NOT NULL,
  `appointDate` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

ALTER TABLE `schedule` ADD CONSTRAINT schedule_facilityId_fk FOREIGN KEY(facilityId) REFERENCES facility(id);

insert into `schedule` values(NULL, 8, 2, "1,2,3", "1,2,3", "2015-05-04" ),(NULL, 8, 2, "5,6,7,8", "1,2,3", "2015-05-15" );



