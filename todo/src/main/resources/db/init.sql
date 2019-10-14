CREATE TABLE `work` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ending_date` datetime DEFAULT NULL,
  `starting_date` datetime DEFAULT NULL,
  `work_name` varchar(255) NOT NULL,
  `work_status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_15x1xm9y8wpdfdcy45ex68496` (`work_name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
