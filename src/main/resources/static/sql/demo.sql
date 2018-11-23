CREATE TABLE `demo_student` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `status` INT(1),
  `create_at` DATETIME,
  `update_at` DATETIME,
  `code` VARCHAR(12),
  `name` VARCHAR(16),
  `plan_year` CHAR(4),
  `average_score` INT(3),
  `english_score` INT(3),
  `pro_course_score` INT(3),
  `additional_score` INT(3),
  `exam_score` INT(3),
  `exam_rank` INT(3),
  `interview_score` INT(3),
  `comprehensive_score` INT(3),
  `comprehensive_rank` INT(3),
  PRIMARY KEY (`id`)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8;

CREATE TABLE `demo_course` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `status` INT(1),
  `create_at` DATETIME,
  `update_at` DATETIME,
  `name` VARCHAR(16),
  `score` INT(3),
  `student_id` INT(11),
  PRIMARY KEY (`id`)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8;

CREATE TABLE `demo_plan` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `status` INT(1),
  `create_at` DATETIME,
  `update_at` DATETIME,
  `year` CHAR(4),
  `quantity` INT(3),
  `inspection` INT(1),
  `exam` INT(1),
  `interview` INT(1),
  `admission` INT(1),
  PRIMARY KEY (`id`)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8;

CREATE TABLE `demo_user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `status` INT(1),
  `create_at` DATETIME,
  `update_at` DATETIME,
  `name` VARCHAR(3),
  `username` VARCHAR(32),
  `password` VARCHAR(32),
  PRIMARY KEY (`id`)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8;

INSERT INTO demo_user(id, status, create_at, update_at, name, username, password)
VALUES(1, 1, NOW(), NOW(), '管理员', 'admin', '123456');