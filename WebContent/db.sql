-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.29 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             12.0.0.6468
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for test
DROP DATABASE IF EXISTS `test`;
CREATE DATABASE IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `test`;

-- Dumping structure for table test.appointment
DROP TABLE IF EXISTS `appointment`;
CREATE TABLE IF NOT EXISTS `appointment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `diagnosisId` int DEFAULT NULL,
  `patientId` int DEFAULT NULL,
  `doctorId` int DEFAULT NULL,
  `appDate` datetime DEFAULT NULL,
  `timeslot` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `isDiagnosed` varchar(50) DEFAULT NULL,
  `remark` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table test.appointment: ~9 rows (approximately)
DELETE FROM `appointment`;
INSERT INTO `appointment` (`id`, `diagnosisId`, `patientId`, `doctorId`, `appDate`, `timeslot`, `isDiagnosed`, `remark`) VALUES
	(4, 8, 4, 1, '2022-06-28 00:00:00', '3pm-4pm', 'true', NULL),
	(5, NULL, 6, 1, '2022-06-27 00:00:00', '3pm-4pm', NULL, NULL),
	(6, NULL, 5, 1, '2022-06-22 00:00:00', '1pm-2pm', NULL, NULL),
	(7, NULL, 4, 2, '2022-06-14 00:00:00', '3pm-4pm', NULL, NULL),
	(8, NULL, 4, 3, '2022-06-14 00:00:00', '3pm-4pm', NULL, NULL),
	(9, NULL, 4, 5, '2022-06-29 00:00:00', '3pm-4pm', NULL, NULL),
	(10, NULL, 4, 2, '2022-06-28 00:00:00', '10am-11am', NULL, NULL),
	(11, NULL, 4, 2, '2022-06-28 00:00:00', '10am-11am', NULL, NULL),
	(12, NULL, 4, 2, '2022-06-28 00:00:00', '10am-11am', NULL, NULL),
	(13, 9, 7, 1, '2022-07-01 00:00:00', '4pm-5pm', 'true', NULL);

-- Dumping structure for table test.diagnosis
DROP TABLE IF EXISTS `diagnosis`;
CREATE TABLE IF NOT EXISTS `diagnosis` (
  `id` int NOT NULL AUTO_INCREMENT,
  `appoId` varchar(100) NOT NULL DEFAULT '',
  `patientId` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
  `doctorId` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
  `remark` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table test.diagnosis: ~0 rows (approximately)
DELETE FROM `diagnosis`;
INSERT INTO `diagnosis` (`id`, `appoId`, `patientId`, `doctorId`, `remark`) VALUES
	(8, '4', '4', '1', 'Firat ja sakali thoda'),
	(9, '13', '7', '1', 'PARAT 3 Tarkhela Yaa');

-- Dumping structure for table test.doctor
DROP TABLE IF EXISTS `doctor`;
CREATE TABLE IF NOT EXISTS `doctor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) NOT NULL DEFAULT '',
  `password` varchar(50) NOT NULL DEFAULT '',
  `firstName` varchar(50) DEFAULT NULL,
  `lastName` varchar(50) DEFAULT NULL,
  `emailId` varchar(50) DEFAULT NULL,
  `phoneNo` varchar(50) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `bloodGroup` varchar(100) DEFAULT NULL,
  `gender` varchar(100) DEFAULT NULL,
  `degree` varchar(100) DEFAULT NULL,
  `speciality` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table test.doctor: ~5 rows (approximately)
DELETE FROM `doctor`;
INSERT INTO `doctor` (`id`, `userName`, `password`, `firstName`, `lastName`, `emailId`, `phoneNo`, `address`, `bloodGroup`, `gender`, `degree`, `speciality`) VALUES
	(1, 'doctor1', 'pass1', 'Dr.Ram', 'Chavan', 'ram@gmail.com', '9191919191', 'Aurangabad,MH', 'O+', 'Male', 'M.B.B.S , M.D(Dermatology)', 'Dermatologist'),
	(2, 'doctor3', 'pass1', 'Dr.Gajanan', 'Mardikar', 'gajanan@gmail.com', '9191919193', 'Parbhani,MH', 'AB+', 'Male', 'M.B.B.S , M.D(Pediatrics)', 'Pediatrician '),
	(3, 'doctor4', 'pass1', 'Dr.Shrinivas', 'Kulkarni', 'shrinivas@gmail.com', '9191919194', 'Selu,MH', 'O+', 'Male', 'M.B.B.S , M.D(Medicine)', 'Heart specialist'),
	(4, 'doctor5', 'pass1', 'Dr.Shawn', 'Murphy', 'shawn@gmail.com', '9191919195', 'Pune,MH', 'O+', 'Male', 'M.B.B.S , M.S', 'Surgon'),
	(5, 'doctor2', 'pass1', 'Dr.Shital', 'Patil', 'shital@gmail.com', '9191919192', 'Nanded,MH', 'A-', 'Female', 'M.B.B.S , M.D(Gynaecology)', 'Gynaecologist');

-- Dumping structure for table test.patient
DROP TABLE IF EXISTS `patient`;
CREATE TABLE IF NOT EXISTS `patient` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `firstName` varchar(50) DEFAULT NULL,
  `middleName` varchar(50) DEFAULT NULL,
  `lastName` varchar(50) DEFAULT NULL,
  `age` varchar(50) DEFAULT NULL,
  `bloodGroup` varchar(50) DEFAULT NULL,
  `phoneNo` varchar(50) DEFAULT NULL,
  `gender` varchar(50) DEFAULT NULL,
  `emailId` varchar(50) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `dob` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `userName` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table test.patient: ~4 rows (approximately)
DELETE FROM `patient`;
INSERT INTO `patient` (`id`, `userName`, `password`, `firstName`, `middleName`, `lastName`, `age`, `bloodGroup`, `phoneNo`, `gender`, `emailId`, `address`, `dob`) VALUES
	(3, 'wdkbd', 'jhvsjhv', 'ketan', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(4, 'user1', 'pass', 'Krishna', 'V', 'Jadhav', '2', 'AB-', '9911919199', 'Male', 'sar@gmail.com', 'SDKWGKDW', '2022-06-07'),
	(5, 'user2', 'pass', 'sachin', 'ramesh', 'tendulkar', '2', 'AB-', '9911919199', 'Male', 'sar@gmail.com', 'SDKWGKDW', '2022-06-07'),
	(6, 'user3', 'pass', 'jimmy', 'ramesh', 'carter', '2', 'AB-', '9911919199', 'Male', 'sar@gmail.com', 'SDKWGKDW', '2022-06-07'),
	(7, 'user4', 'pass', 'John', 'V', 'Doe', '2', 'AB-', '9911919199', 'Male', 'sar@gmail.com', 'SDKWGKDW', '2022-06-07');

-- Dumping structure for table test.prescription
DROP TABLE IF EXISTS `prescription`;
CREATE TABLE IF NOT EXISTS `prescription` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `patientid` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `doctorid` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `drugs` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `remark` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `diagnosisid` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table test.prescription: ~0 rows (approximately)
DELETE FROM `prescription`;
INSERT INTO `prescription` (`id`, `patientid`, `doctorid`, `drugs`, `remark`, `diagnosisid`) VALUES
	(11, '4', '1', 'PPP', NULL, '8'),
	(12, '4', '1', 'dddddddd', NULL, '8'),
	(13, '4', '1', 'nnnnnn', NULL, '8'),
	(14, '7', '1', 'PARACITAMOL', NULL, '9'),
	(15, '7', '1', 'C. ZINTAC ', NULL, '9'),
	(16, '7', '1', 'T. DOLO', NULL, '9'),
	(17, '7', '1', 'T. CINARIST', NULL, '9');

-- Dumping structure for table test.roles
DROP TABLE IF EXISTS `roles`;
CREATE TABLE IF NOT EXISTS `roles` (
  `id` int NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `details` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table test.roles: ~0 rows (approximately)
DELETE FROM `roles`;

-- Dumping structure for table test.tests
DROP TABLE IF EXISTS `tests`;
CREATE TABLE IF NOT EXISTS `tests` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `patientid` varchar(50) DEFAULT NULL,
  `doctorid` varchar(50) DEFAULT NULL,
  `tests` varchar(50) DEFAULT NULL,
  `remark` varchar(50) DEFAULT NULL,
  `diagnosisid` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table test.tests: ~0 rows (approximately)
DELETE FROM `tests`;
INSERT INTO `tests` (`id`, `patientid`, `doctorid`, `tests`, `remark`, `diagnosisid`) VALUES
	(11, '4', '1', 'CNC', NULL, '8'),
	(12, '4', '1', 'PNG', NULL, '8'),
	(13, '4', '1', 'JPEG', NULL, '8'),
	(14, '7', '1', 'CBC', NULL, '9'),
	(15, '7', '1', 'HB', NULL, '9'),
	(16, '7', '1', 'MRI', NULL, '9');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
