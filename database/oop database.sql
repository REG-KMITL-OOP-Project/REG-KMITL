-- phpMyAdmin SQL Dump
-- version 5.2.2
-- https://www.phpmyadmin.net/
--
-- Host: db:3306
-- Generation Time: Apr 02, 2025 at 03:24 AM
-- Server version: 9.2.0
-- PHP Version: 8.2.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `oop`
--

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `course_code` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `course_name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `credits` int NOT NULL,
  `years` int NOT NULL,
  `faculty_id` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `major_id` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `prerequisite` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `note` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`course_code`, `course_name`, `credits`, `years`, `faculty_id`, `major_id`, `prerequisite`, `note`) VALUES
('06016401', 'MATHEMATICS FOR INFORMATION TECHNOLOGY', 3, 2025, '1231', '12311', '-', '-'),
('06016402', 'INFORMATION TECHNOLOGY FUNDAMENTALS', 3, 2025, '1231', '12311', '-', '-'),
('06016408', 'OBJECT-ORIENTED PROGRAMMING', 3, 2025, '1231', '12311', 'รับเฉพาะนักศึกษาคณะไอที', 'รายวิชา หลักสูตร พ.ศ.2560 : สำหรับนักศึกษาเก็บตก'),
('06016411', 'INTRODUCTION TO COMPUTER SYSTEMS', 3, 2025, '1231', '12311', '-', '-'),
('06016777', 'Micro Service', 3, 2568, '1231', '12311', 'สอทด', 'ทดสอบ'),
('06065156', 'CE Example', 3, 2025, '1232', '12321', '-', '-'),
('06066001', 'PROBABILITY AND STATISTICS', 3, 2025, '1231', '12311', 'รับเฉพาะนักศึกษาคณะไอที', 'รายวิชา หลักสูตร พ.ศ.2560 : สำหรับนักศึกษาเก็บตก'),
('06066101', 'BUSINESS FUNDAMENTALS FOR INFORMATION', 3, 2025, '1231', '12311', 'รับเฉพาะนักศึกษาคณะไอที', 'รายวิชา หลักสูตร พ.ศ.2560 : สำหรับนักศึกษาเก็บตก'),
('06066301', 'DATA STRUCTURES AND ALGORITHMS', 3, 2025, '1231', '12311', 'รับเฉพาะนักศึกษาคณะไอที', 'รายวิชา หลักสูตร พ.ศ.2560 : สำหรับนักศึกษาเก็บตก'),
('06066303', 'PROBLEM SOLVING AND COMPUTER PROGRAMMING', 3, 2025, '1231', '12311', '-', '-');

-- --------------------------------------------------------

--
-- Table structure for table `enrollment`
--

CREATE TABLE `enrollment` (
  `enrollment_id` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `std_id` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `section_id` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `enrollment`
--

INSERT INTO `enrollment` (`enrollment_id`, `std_id`, `section_id`) VALUES
('660701991', '66070199', '06016401B'),
('670700011', '67070001', '06016777B'),
('670701741', '67070174', '06016401B'),
('670701742', '67070174', '06016408B'),
('670701743', '67070174', '06016402B'),
('670701744', '67070174', '06016411B'),
('670701745', '67070174', '06066001B'),
('670701746', '67070174', '06066101B'),
('670701747', '67070174', '06066301B'),
('670701748', '67070174', '06066303B'),
('670701911', '67070191', '06016408A'),
('670701912', '67070191', '06066101A'),
('670701913', '67070191', '06016777A');

--
-- Triggers `enrollment`
--
DELIMITER $$
CREATE TRIGGER `validate_enrollment_section` BEFORE INSERT ON `enrollment` FOR EACH ROW BEGIN
    DECLARE student_section VARCHAR(20);
    DECLARE target_section VARCHAR(20);

    -- ดึง section_id ของนักศึกษา (จากตาราง user)
    SELECT section_id INTO student_section
    FROM user
    WHERE std_id = NEW.std_id;

    -- ดึง section ของเซคชั่นที่ต้องการลงทะเบียน (จากตาราง section)
    SELECT section INTO target_section
    FROM section
    WHERE section_id = NEW.section_id;

    -- ตรวจสอบว่า section ของเซคชั่นตรงกับ section_id ของนักศึกษา
    IF student_section != target_section THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'ไม่อนุญาตให้ลงทะเบียนนอกกลุ่มเรียน';
    END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `Event`
--

CREATE TABLE `Event` (
  `id` int NOT NULL,
  `name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Date` date NOT NULL,
  `type` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `Event`
--

INSERT INTO `Event` (`id`, `name`, `description`, `Date`, `type`) VALUES
(1, 'วันเปิดภาคเรียน', 'วันแรกของภาคเรียนที่ 1 ปีการศึกษา 2568', '2025-06-30', 'ภาคการศึกษาที่ 1'),
(2, 'วันสอบกลางภาค', 'วันแรกในการสอบกลางภาค', '2025-08-25', 'ภาคการศึกษาที่ 1'),
(3, 'วันสอบกลางภาค', 'วันแรกในการสอบกลางภาค', '2025-08-31', 'ภาคการศึกษาที่ 1'),
(4, 'วันสอบปลายภาค', 'วันแรกในการสอบปลายภาค', '2025-10-20', 'ภาคการศึกษาที่ 1'),
(5, 'วันสอบปลายภาค', 'วันสุดท้ายในการสอบปลายภาค', '2025-11-03', 'ภาคการศึกษาที่ 1'),
(6, 'วันปิดภาคเรียน', 'วันสุดท้ายของภาคเรียนที่ 1 ปีการศึกษา 2568', '2025-11-04', 'ภาคการศึกษาที่ 1'),
(10, 'วันเปิดภาคเรียน', 'วันแรกของภาคเรียนที่ 2 ปีการศึกษา 2568', '2025-11-24', 'ภาคการศึกษาที่ 2'),
(11, 'วันปิดภาคเรียน', 'วันแรกของภาคเรียนที่ 2 ปีการศึกษา 2568', '2026-03-28', 'ภาคการศึกษาที่ 2'),
(12, 'วันสอบกลางภาค', 'วันแรกในการสอบกลางภาค', '2026-01-19', 'ภาคการศึกษาที่ 2'),
(13, 'วันสอบกลางภาค', 'วันสุดท้ายในการสอบกลางภาค', '2026-01-25', 'ภาคการศึกษาที่ 2'),
(14, 'วันสอบปลายภาค', 'วันแรกในการสอบปลายภาค', '2026-03-16', 'ภาคการศึกษาที่ 2'),
(15, 'วันสอบปลายภาค', 'วันสุดท้ายในการสอบปลายภาค', '2026-03-27', 'ภาคการศึกษาที่ 2'),
(16, 'วันเปิดภาคเรียน', '-', '2026-04-27', 'ภาคการศึกษาพิเศษ'),
(17, 'วันปิดภาคเรียน', '', '2026-06-10', 'ภาคการศึกษาพิเศษ'),
(53, 'นำเสนอโปรเจกต์', 'เย่ๆๆๆๆๆๆๆๆๆ', '2025-04-02', 'ภาคการศึกษาที่ 2');

-- --------------------------------------------------------

--
-- Table structure for table `exam`
--

CREATE TABLE `exam` (
  `ID` int NOT NULL,
  `section_id` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `course_id` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `midterm_date` date DEFAULT NULL,
  `midterm_start_time` time DEFAULT NULL,
  `midterm_end_time` time DEFAULT NULL,
  `final_date` date DEFAULT NULL,
  `final_start_time` time DEFAULT NULL,
  `final_end_time` time DEFAULT NULL,
  `subject` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `type` enum('ทฤษฎี','ปฏิบัติ') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `room` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `prof_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `section` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `exam`
--

INSERT INTO `exam` (`ID`, `section_id`, `course_id`, `midterm_date`, `midterm_start_time`, `midterm_end_time`, `final_date`, `final_start_time`, `final_end_time`, `subject`, `type`, `room`, `prof_name`, `section`) VALUES
(1, '06016408A', '06016408', '2025-01-20', '09:30:00', '12:30:00', '2025-03-17', '13:30:00', '16:30:00', 'OBJECT-ORIENTED PROGRAMMING', 'ทฤษฎี', 'L207', 'สุดตึง ตึงสุด', '1'),
(2, '06016408B', '06016408', '2025-01-20', '09:30:00', '12:30:00', '2025-03-17', '13:30:00', '16:30:00', 'OBJECT-ORIENTED PROGRAMMING', 'ทฤษฎี', 'L309', 'สุดตึง ตึงสุด', '2'),
(3, '06016408C', '06016408', '2025-01-20', '09:30:00', '12:30:00', '2025-03-17', '13:30:00', '16:30:00', 'OBJECT-ORIENTED PROGRAMMING', 'ทฤษฎี', 'L203', 'สุดตึง ตึงสุด', '3'),
(4, '06066001A', '06066001', '2025-01-22', '09:30:00', '12:30:00', '2025-03-19', '13:30:00', '16:30:00', 'PROBABILITY AND STATISTICS', 'ทฤษฎี', 'M21', 'สุดตึง ตึงสุด', '1'),
(5, '06066001B', '06066001', '2025-01-22', '09:30:00', '12:30:00', '2025-03-19', '13:30:00', '16:30:00', 'PROBABILITY AND STATISTICS', 'ทฤษฎี', 'M22', 'สุดตึง ตึงสุด', '2'),
(6, '06066001C', '06066001', '2025-01-22', '09:30:00', '12:30:00', '2025-03-19', '13:30:00', '16:30:00', 'PROBABILITY AND STATISTICS', 'ทฤษฎี', 'M23', 'สุดตึง ตึงสุด', '3'),
(14, '06066101A', '06066101', '2025-03-01', '06:00:00', '06:30:00', '2025-04-03', '06:00:00', '06:30:00', 'BUSINESS FUNDAMENTALS FOR INFORMATION', 'ทฤษฎี', 'M21', 'สุดตึง ตึงสุด', '1'),
(15, '06066101B', '06066101', '2025-03-01', '06:00:00', '06:30:00', '2025-04-03', '06:00:00', '06:30:00', 'BUSINESS FUNDAMENTALS FOR INFORMATION', 'ทฤษฎี', 'M22', 'สุดตึง ตึงสุด', '2'),
(16, '06066101C', '06066101', '2025-03-01', '06:00:00', '06:30:00', '2025-04-03', '06:00:00', '06:30:00', 'BUSINESS FUNDAMENTALS FOR INFORMATION', 'ทฤษฎี', 'M23', 'สุดตึง ตึงสุด', '3'),
(20, '06066301A', '06066301', '2025-03-01', '06:00:00', '06:30:00', '2025-05-03', '06:00:00', '06:30:00', 'DATA STRUCTURES AND ALGORITHMS', 'ทฤษฎี', 'M21', 'สุดตึง ตึงสุด', '1'),
(21, '06066301B', '06066301', '2025-03-01', '06:00:00', '06:30:00', '2025-05-03', '06:00:00', '06:30:00', 'DATA STRUCTURES AND ALGORITHMS', 'ทฤษฎี', 'M22', 'สุดตึง ตึงสุด', '2'),
(22, '06066301C', '06066301', '2025-03-01', '06:00:00', '06:30:00', '2025-05-03', '06:00:00', '06:30:00', 'DATA STRUCTURES AND ALGORITHMS', 'ทฤษฎี', 'M23', 'สุดตึง ตึงสุด', '3'),
(26, '06016401A', '06016401', '2024-08-30', '06:00:00', '06:30:00', '2024-10-29', '06:00:00', '06:30:00', 'MATHEMATICS FOR INFORMATION TECHNOLOGY', 'ทฤษฎี', 'M21', 'สุดตึง ตึงสุด', '1'),
(27, '06016401B', '06016401', '2024-08-30', '06:00:00', '06:30:00', '2024-10-29', '06:00:00', '06:30:00', 'MATHEMATICS FOR INFORMATION TECHNOLOGY', 'ทฤษฎี', 'M22', 'สุดตึง ตึงสุด', '2'),
(28, '06016401C', '06016401', '2024-08-30', '06:00:00', '06:30:00', '2024-10-29', '06:00:00', '06:30:00', 'MATHEMATICS FOR INFORMATION TECHNOLOGY', 'ทฤษฎี', 'M23', 'สุดตึง ตึงสุด', '3'),
(29, '06016402A', '06016402', '2024-08-01', '06:00:00', '06:30:00', '2024-10-01', '06:00:00', '06:30:00', 'INFORMATION TECHNOLOGY FUNDAMENTALS', 'ทฤษฎี', 'M22', 'สุดตึง ตึงสุด', '1'),
(30, '06016402B', '06016402', '2024-08-01', '06:00:00', '06:30:00', '2024-10-01', '06:00:00', '06:30:00', 'INFORMATION TECHNOLOGY FUNDAMENTALS', 'ทฤษฎี', 'M22', 'สุดตึง ตึงสุด', '2'),
(31, '06016402C', '06016402', '2024-08-01', '06:00:00', '06:30:00', '2024-10-01', '06:00:00', '06:30:00', 'INFORMATION TECHNOLOGY FUNDAMENTALS', 'ทฤษฎี', 'M22', 'สุดตึง ตึงสุด', '3'),
(32, '06016411A', '06016411', '2024-08-11', '06:00:00', '06:30:00', '2024-10-11', '06:00:00', '06:30:00', 'INTRODUCTION TO COMPUTER SYSTEMS', 'ทฤษฎี', 'M21', 'สุดตึง ตึงสุด', '1'),
(33, '06016411B', '06016411', '2024-08-11', '06:00:00', '06:30:00', '2024-10-11', '06:00:00', '06:30:00', 'INTRODUCTION TO COMPUTER SYSTEMS', 'ทฤษฎี', 'M21', 'สุดตึง ตึงสุด', '2'),
(34, '06016411C', '06016411', '2024-08-11', '06:00:00', '06:30:00', '2024-10-11', '06:00:00', '06:30:00', 'INTRODUCTION TO COMPUTER SYSTEMS', 'ทฤษฎี', 'M21', 'สุดตึง ตึงสุด', '3'),
(35, '06066303A', '06066303', '2024-08-15', '06:00:00', '06:30:00', '2024-10-16', '06:00:00', '07:00:00', 'PROBLEM SOLVING AND COMPUTER PROGRAMMING', 'ทฤษฎี', 'M23', 'สุดตึง ตึงสุด', '1'),
(36, '06066303B', '06066303', '2024-08-15', '06:00:00', '06:30:00', '2024-10-16', '06:00:00', '07:00:00', 'PROBLEM SOLVING AND COMPUTER PROGRAMMING', 'ทฤษฎี', 'M23', 'สุดตึง ตึงสุด', '2'),
(37, '06066303C', '06066303', '2024-08-15', '06:00:00', '06:30:00', '2024-10-16', '06:00:00', '07:00:00', 'PROBLEM SOLVING AND COMPUTER PROGRAMMING', 'ทฤษฎี', 'M23', 'สุดตึง ตึงสุด', '3'),
(38, '06065156A', '06065156', '2025-08-30', '06:00:00', '07:30:00', '2025-01-20', '06:00:00', '07:30:00', 'CE Example', 'ทฤษฎี', 'M03', 'สุดตึง ตึงสุด', '1'),
(39, '06065156B', '06065156', '2025-08-30', '06:00:00', '07:30:00', '2025-01-20', '06:00:00', '07:30:00', 'CE Example', 'ทฤษฎี', '', 'สุดตึง ตึงสุด', '2'),
(40, '06065156C', '06065156', '2025-08-30', '06:00:00', '07:30:00', '2025-01-20', '06:00:00', '07:30:00', 'CE Example', 'ทฤษฎี', '', 'สุดตึง ตึงสุด', '3'),
(41, '06016777A', '06016777', '2025-01-03', '09:30:00', '12:30:00', '2025-01-30', '09:30:00', '12:30:00', 'Micro Service', 'ทฤษฎี', '', 'สุดตึง ตึงสุด', '1'),
(42, '06016777B', '06016777', '2025-01-03', '09:30:00', '12:30:00', '2025-01-30', '09:30:00', '12:30:00', 'Micro Service', 'ทฤษฎี', '', 'สุดตึง ตึงสุด', '2'),
(43, '06016777C', '06016777', '2025-01-03', '09:30:00', '12:30:00', '2025-01-30', '09:30:00', '12:30:00', 'Micro Service', 'ทฤษฎี', '', 'สุดตึง ตึงสุด', '3');

-- --------------------------------------------------------

--
-- Table structure for table `faculty`
--

CREATE TABLE `faculty` (
  `faculty_id` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `faculty_name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `faculty`
--

INSERT INTO `faculty` (`faculty_id`, `faculty_name`) VALUES
('1231', 'IT'),
('1232', 'ENG'),
('1233', 'SCI');

-- --------------------------------------------------------

--
-- Table structure for table `grade`
--

CREATE TABLE `grade` (
  `grade_id` int NOT NULL,
  `enrollment_id` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `grade` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ;

--
-- Dumping data for table `grade`
--

INSERT INTO `grade` (`grade_id`, `enrollment_id`, `grade`) VALUES
(9, '670701741', 'A'),
(10, '670701743', 'B+'),
(11, '670701744', 'B+'),
(13, '670701746', 'A'),
(14, '670701747', 'A'),
(15, '670701748', 'B+'),
(16, '670701742', 'B+'),
(17, '670701911', 'B+'),
(18, '670701913', 'B+');

-- --------------------------------------------------------

--
-- Table structure for table `major`
--

CREATE TABLE `major` (
  `major_id` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `major_name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `faculty_id` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `major`
--

INSERT INTO `major` (`major_id`, `major_name`, `faculty_id`) VALUES
('12311', 'IT', '1231'),
('12312', 'DSBA', '1231'),
('12313', 'AIT', '1231'),
('12321', 'CE', '1232'),
('12322', 'IOTE', '1232'),
('12331', 'COMSCI', '1233');

-- --------------------------------------------------------

--
-- Table structure for table `score`
--

CREATE TABLE `score` (
  `score_id` int NOT NULL,
  `enrollment_id` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `score1` float DEFAULT NULL,
  `score2` float DEFAULT NULL,
  `score3` float DEFAULT NULL,
  `score4` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `score`
--

INSERT INTO `score` (`score_id`, `enrollment_id`, `score1`, `score2`, `score3`, `score4`) VALUES
(22, '670701742', 20, 20, 20, 20),
(23, '670701911', 59, 100, 100, 100),
(24, '670701913', 20, 15, 20, 10),
(25, '670701745', 20, 10, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `section`
--

CREATE TABLE `section` (
  `section_id` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `course_id` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `prof_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `day_of_week` enum('MON','TUE','WED','THU','FRI','SAT','SUN') COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `start_time` time NOT NULL,
  `end_time` time NOT NULL,
  `building` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `room` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `max_std` int NOT NULL,
  `section` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `prof_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `section`
--

INSERT INTO `section` (`section_id`, `course_id`, `prof_id`, `day_of_week`, `start_time`, `end_time`, `building`, `room`, `max_std`, `section`, `prof_name`) VALUES
('06016401A', '06016401', '2555070002', 'MON', '00:00:00', '00:00:00', 'IT', 'MXX', 66, '1', 'ผศ.ดร. ประพันธ์ ปวรางกูร, ผศ.ดร. สมเกียรติ วังศิริพิทักษ์'),
('06016401B', '06016401', '2555070002', 'MON', '00:00:00', '00:00:00', 'IT', 'MXX', 66, '2', 'ผศ.ดร. ประพันธ์ ปวรางกูร, ผศ.ดร. สมเกียรติ วังศิริพิทักษ์'),
('06016401C', '06016401', '2555070002', 'MON', '00:00:00', '00:00:00', 'IT', 'MXX', 68, '3', 'ผศ.ดร. ประพันธ์ ปวรางกูร, ผศ.ดร. สมเกียรติ วังศิริพิทักษ์'),
('06016402A', '06016402', '2555070002', 'MON', '00:00:00', '00:00:00', 'IT', 'PBX', 66, '1', 'รศ.ดร. กิติ์สุชาต พสุภา, ผศ.ดร. พรสุรีย์ แจ่มศรี, ผศ.ดร.สุวิทย์ ภูมิฤทธิกุล'),
('06016402B', '06016402', '2555070002', 'MON', '00:00:00', '00:00:00', 'IT', 'PBX', 66, '2', 'รศ.ดร. กิติ์สุชาต พสุภา, ผศ.ดร. พรสุรีย์ แจ่มศรี, ผศ.ดร.สุวิทย์ ภูมิฤทธิกุล'),
('06016402C', '06016402', '2555070002', 'MON', '00:00:00', '00:00:00', 'IT', 'PBX', 68, '3', 'รศ.ดร. กิติ์สุชาต พสุภา, ผศ.ดร. พรสุรีย์ แจ่มศรี, ผศ.ดร.สุวิทย์ ภูมิฤทธิกุล'),
('06016408A', '06016408', '2555070002', 'TUE', '06:30:00', '06:30:00', 'IT', 'MXX', 50, '1', 'ผศ.ดร. ธราวิเชษฐ์ ธิติจรูญโรจน์'),
('06016408B', '06016408', '2555070002', 'MON', '11:00:00', '13:00:00', 'IT', 'MXX', 50, '2', 'ผศ.ดร. ธราวิเชษฐ์ ธิติจรูญโรจน์'),
('06016408C', '06016408', '2555070002', 'MON', '13:00:00', '15:00:00', 'IT', 'MXX', 50, '3', 'ผศ.ดร. ธราวิเชษฐ์ ธิติจรูญโรจน์'),
('06016411A', '06016411', '2555070002', 'MON', '00:00:00', '00:00:00', 'IT', 'PBX', 66, '1', 'ศ.ดร. สุขสันต์ พาณิชพาพิบูล, ผศ.ดร. สุภกิจ นุตยะสกุล'),
('06016411B', '06016411', '2555070002', 'MON', '00:00:00', '00:00:00', 'IT', 'PBX', 66, '2', 'ศ.ดร. สุขสันต์ พาณิชพาพิบูล, ผศ.ดร. สุภกิจ นุตยะสกุล'),
('06016411C', '06016411', '2555070002', 'MON', '00:00:00', '00:00:00', 'IT', 'PBX', 68, '3', 'ศ.ดร. สุขสันต์ พาณิชพาพิบูล, ผศ.ดร. สุภกิจ นุตยะสกุล'),
('06016777A', '06016777', '2555070002', 'MON', '09:00:00', '12:00:00', 'IT', 'M22', 50, '1', 'สุดตึง ตึงสุด'),
('06016777B', '06016777', '2555070002', 'MON', '13:00:00', '16:00:00', 'IT', 'M22', 50, '2', 'สุดตึง ตึงสุด'),
('06016777C', '06016777', '2555070002', 'MON', '00:00:00', '00:00:00', '', '', 50, '3', ''),
('06065156A', '06065156', '2555070002', 'MON', '00:00:00', '00:00:00', '', '', 66, '1', ''),
('06065156B', '06065156', '2555070002', 'THU', '09:00:00', '11:00:00', 'อาคารพระเทพ', 'xx', 66, '2', 'รศ.ด. xxxxxxx xxxxxx'),
('06065156C', '06065156', '2555070002', 'MON', '00:00:00', '00:00:00', '', '', 68, '3', ''),
('06066001A', '06066001', '2555070001', 'TUE', '06:30:00', '06:30:00', 'IT', 'PBX', 50, '1', 'ศ.ดร. สุขสันต์ พาณิชพาพิบูล'),
('06066001B', '06066001', '2555070001', 'TUE', '13:00:00', '16:00:00', 'IT', 'PBX', 50, '2', 'ศ.ดร. สุขสันต์ พาณิชพาพิบูล'),
('06066001C', '06066001', '2555070001', 'WED', '13:00:00', '16:00:00', 'IT', 'PBX', 50, '3', 'ศ.ดร. สุขสันต์ พาณิชพาพิบูล'),
('06066101A', '06066101', '2555070002', 'TUE', '06:30:00', '07:00:00', 'IT', 'MXX', 66, '1', 'ศ.ดร. อาริต ธรรมโน, ผศ.ดร. พรสุรีย์ แจ่มศรี'),
('06066101B', '06066101', '2555070002', 'MON', '06:00:00', '06:30:00', 'IT', 'MXX', 66, '2', 'ศ.ดร. อาริต ธรรมโน, ผศ.ดร. พรสุรีย์ แจ่มศรี'),
('06066101C', '06066101', '2555070002', 'MON', '00:00:00', '00:00:00', 'IT', 'MXX', 68, '3', 'ศ.ดร. อาริต ธรรมโน, ผศ.ดร. พรสุรีย์ แจ่มศรี'),
('06066301A', '06066301', '2555070002', 'MON', '00:00:00', '00:00:00', 'IT', 'MXX', 66, '1', 'ผศ.ดร. สุพัณณดา โชติพันธ์'),
('06066301B', '06066301', '2555070002', 'MON', '00:00:00', '00:00:00', 'IT', 'MXX', 66, '2', 'ผศ.ดร. สุพัณณดา โชติพันธ์'),
('06066301C', '06066301', '2555070002', 'MON', '00:00:00', '00:00:00', 'IT', 'MXX', 68, '3', 'ผศ.ดร. สุพัณณดา โชติพันธ์'),
('06066303A', '06066303', '2555070002', 'MON', '00:00:00', '00:00:00', 'IT', 'Slope', 66, '1', 'รศ.ดร. โชติพัชร์ ภรณวลัย'),
('06066303B', '06066303', '2555070002', 'MON', '00:00:00', '00:00:00', 'IT', 'Slope', 66, '2', 'รศ.ดร. โชติพัชร์ ภรณวลัย'),
('06066303C', '06066303', '2555070002', 'MON', '00:00:00', '00:00:00', 'IT', 'Slope', 68, '3', 'รศ.ดร. โชติพัชร์ ภรณวลัย');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int NOT NULL,
  `role` int NOT NULL DEFAULT '2',
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `username` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `prefix` int DEFAULT NULL,
  `fname` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `lname` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `phone` varchar(11) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `address` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `std_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `prof_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `faculty` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `major` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `section_id` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `role`, `email`, `username`, `password`, `prefix`, `fname`, `lname`, `phone`, `address`, `std_id`, `prof_id`, `faculty`, `major`, `section_id`) VALUES
(2, 2, '67070174@kmutt.ac.th', 'student01', '$2a$10$kYtLzAV8G0oWwiNkygjxD.h6DqTvq7Nh.gSvcdJ0fFxQsVCbspeaa', 1, 'ศักดิธัช', 'ปิ่นแก้ว', NULL, 'ซอย หมู่บ้านโคโนฮะ แยก 4 ถนน โฮคาเงะ เขต นารูโตะ', '67070174', NULL, 'Information Technology', 'Information Technology', '2'),
(3, 3, 'AJTest@gmail.com', 'prof01', '$2a$10$Vrrky95YCn5BvJei7JlBGuknw39eUAid7C3T0qR/dn3ZP0FQT13B6', 1, 'สร้างสุข', 'ทุกข์ระทม', NULL, NULL, NULL, '2555070001', NULL, NULL, NULL),
(4, 1, 'AdTest@gmail.com', 'admin01', '$2a$10$SGdtBIHBlfzxuwcHzoe2juIrrxGoG2HZvk0dIOBUGbWCTqwUeqKui', 2, 'สมศรี', 'มีโชค', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(5, 2, NULL, 'student02', 'student02_password', 1, 'นาย A', 'รักแฟน', NULL, NULL, '67070191', NULL, 'Information Technology', 'Information Technology', '1'),
(6, 3, NULL, 'prof02', 'prof02_password', 1, 'แล้วแต่', 'แบงค์', NULL, NULL, NULL, '2555070002', '', NULL, NULL),
(7, 1, NULL, 'Admin02', '$2a$10$OJCKVkOW32CYVWMieocdQODY1AEVNaDFyA.zfrpvNyNCL2fcjhoCy', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(8, 2, 'stdtest@kmitl.ac.th', 'StudentTest', '$2a$10$g3NbtCIoqKfokKYczEhn4e3CQPkR5PjAWx5BqYwn4B4kyq01rY0kO', 1, 'ศักดิธัช', 'ปิ่นแก้ว', '0878889999', NULL, '67070000', NULL, 'Information Technology', 'Information Technology', '1'),
(9, 2, 'stdtest2@kmitl.ac.th', 'StudentTest2', '$2a$10$BLH55hXc3hrX41IxRKfVdedkcbkJFSJ99djepARk7SzJzuAHffX1q', 1, 'Asitara', 'Phumdokmai', '0999999999', NULL, '66070199', NULL, 'Information Technology', 'Information Technology', NULL),
(10, 2, '', '', '$2a$10$wIcmJ0Ws07Si6gj42OSLgezvzzbT5ArALUJ17h3g8EI.WkXc8EQuW', 1, '', '', '', '', '', NULL, '', '', NULL),
(13, 2, '60000000@kmitl.ac.th', 'Student03', '$2a$10$rCpfit40AujaOiF2Br3XC.ppSIY5d8D4ZRrGN.1ii0QkK2Jx3mG9u', 1, 'มีโชค', 'โบกปูน', '0123456789', 'เมืองมาซาระ ภูมิภาคคันโต', '60000000', NULL, 'เทคโนโลยีสารสนเทศ', 'เทคโนโลยีสารสนเทศ', NULL),
(21, 1, 'AdminTest@kmutt.ac.th', 'AdminTest', '$2a$10$gzKdDmUhroKG9L1x0/0HA.JuRZ90MllQprjo1FOgT/Y7XNiMrI5ju', 1, 'set', 'yor', '0888888888', 'คุกวัยหนุ่ม', NULL, NULL, NULL, NULL, NULL),
(22, 2, '67070001@kmutt.ac.th', 'StudentTest3', '$2a$10$Km4UrhAHtoGE09J/5Dyb5ONANeNWCF3ZK0iYlvYQII.RQun69Neu2', 1, 'สุดหล่อ', 'หล่อเท่', '0123456789', 'ซอย โคโนฮะ แยก 2', '67070001', NULL, 'คณะเทคโนโลยีสารสนเทศ', 'IT', '2'),
(23, 3, '2555070003@kmutt.ac.th', 'ProfTest', '$2a$10$vphn1/I7qqxgo4McjqG3u.2nmxA3wPZUgjUGI2iEnZG/yrpMxoAFm', 1, 'สุดตึง', 'ตึงสุด', '0987456321', NULL, NULL, '2555070003', 'คณะเทคโนโลยีสารสนเทศ', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user_request`
--

CREATE TABLE `user_request` (
  `id` int NOT NULL,
  `email` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `field_name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `old_value` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `new_value` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `status` enum('pending','approved','rejected') COLLATE utf8mb4_unicode_ci DEFAULT 'pending',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `user_request`
--

INSERT INTO `user_request` (`id`, `email`, `field_name`, `old_value`, `new_value`, `status`, `created_at`, `updated_at`) VALUES
(3, 'stdtest@kmitl.ac.th', 'fname', 'newTest', 'Phos', 'approved', '2025-03-25 18:40:08', '2025-03-25 18:40:59'),
(4, 'stdtest@kmitl.ac.th', 'lname', 'test2', 'Zaza', 'approved', '2025-03-25 18:40:08', '2025-03-25 18:41:04'),
(5, 'stdtest@kmitl.ac.th', 'phone', '0878889999', '0999999999', 'rejected', '2025-03-25 18:40:08', '2025-03-25 18:41:08'),
(6, '67070174@kmutt.ac.th', 'fname', 'ศักดิธัช', 'Sakditad', 'approved', '2025-03-31 15:32:37', '2025-03-31 15:35:25'),
(7, '67070174@kmutt.ac.th', 'fname', 'Sakditad', 'ศักดิธัช', 'approved', '2025-03-31 15:45:52', '2025-04-01 21:17:11'),
(8, 'stdtest@kmitl.ac.th', 'fname', 'Phos', 'ศักดิธัช', 'approved', '2025-03-31 16:18:24', '2025-04-01 21:17:13'),
(9, 'stdtest@kmitl.ac.th', 'lname', 'Zaza', 'ปิ่นแก้ว', 'approved', '2025-03-31 16:18:33', '2025-04-01 21:17:16'),
(10, '67070174@kmutt.ac.th', 'address', 'null', 'หมู่บ้านโคโนฮะ', 'approved', '2025-03-31 16:55:33', '2025-04-01 21:17:18'),
(11, '67070174@kmutt.ac.th', 'address', 'หมู่บ้านโคโนฮะ', 'เมืองมาซาระ ภูมิภาคคันโต', 'approved', '2025-03-31 17:04:11', '2025-04-01 21:17:21'),
(19, 'AJTest@gmail.com', 'lname', 'ทุกข์ระทม', 'knkkmn', 'approved', '2025-04-01 21:14:54', '2025-04-01 21:17:24'),
(20, 'AJTest@gmail.com', 'fname', 'สร้างสุข', 'สร้างสรรค์', 'approved', '2025-04-01 21:15:10', '2025-04-01 21:17:26'),
(21, '67070174@kmutt.ac.th', 'fname', 'ศักดิธัช', 'ไอทำหม่าน', 'pending', '2025-04-02 02:18:34', '2025-04-02 02:18:34'),
(22, '67070174@kmutt.ac.th', 'lname', 'ปิ่นแก้ว', 'แล้วอ่านทำไม?', 'pending', '2025-04-02 02:18:45', '2025-04-02 02:18:45'),
(23, '67070174@kmutt.ac.th', 'address', 'เมืองมาซาระ ภูมิภาคคันโต', 'ซอย หมู่บ้านโคโนฮะ แยก 4 ถนน โฮคาเงะ เขต นารูโตะ', 'approved', '2025-04-02 02:19:26', '2025-04-02 02:45:39'),
(24, '67070174@kmutt.ac.th', 'fname', 'ศักดิธัช', 'Test', 'pending', '2025-04-02 03:09:03', '2025-04-02 03:09:03');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`course_code`),
  ADD KEY `fk_course_faculty` (`faculty_id`),
  ADD KEY `fk_course_major` (`major_id`);

--
-- Indexes for table `enrollment`
--
ALTER TABLE `enrollment`
  ADD PRIMARY KEY (`enrollment_id`),
  ADD KEY `std_id` (`std_id`),
  ADD KEY `section_id` (`section_id`) USING BTREE;

--
-- Indexes for table `Event`
--
ALTER TABLE `Event`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `exam`
--
ALTER TABLE `exam`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `section_id` (`section_id`),
  ADD KEY `course_id` (`course_id`);

--
-- Indexes for table `faculty`
--
ALTER TABLE `faculty`
  ADD PRIMARY KEY (`faculty_id`);

--
-- Indexes for table `grade`
--
ALTER TABLE `grade`
  ADD PRIMARY KEY (`grade_id`),
  ADD UNIQUE KEY `enrollment_id` (`enrollment_id`) USING BTREE;

--
-- Indexes for table `major`
--
ALTER TABLE `major`
  ADD PRIMARY KEY (`major_id`),
  ADD KEY `faculty_id` (`faculty_id`);

--
-- Indexes for table `score`
--
ALTER TABLE `score`
  ADD PRIMARY KEY (`score_id`),
  ADD KEY `enrollment_id` (`enrollment_id`);

--
-- Indexes for table `section`
--
ALTER TABLE `section`
  ADD PRIMARY KEY (`section_id`),
  ADD KEY `prof_id` (`prof_id`),
  ADD KEY `course_id` (`course_id`) USING BTREE;

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `std_id` (`std_id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `prof_id` (`prof_id`),
  ADD KEY `section_id` (`section_id`) USING BTREE;

--
-- Indexes for table `user_request`
--
ALTER TABLE `user_request`
  ADD PRIMARY KEY (`id`),
  ADD KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Event`
--
ALTER TABLE `Event`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;

--
-- AUTO_INCREMENT for table `exam`
--
ALTER TABLE `exam`
  MODIFY `ID` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT for table `grade`
--
ALTER TABLE `grade`
  MODIFY `grade_id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `score`
--
ALTER TABLE `score`
  MODIFY `score_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `user_request`
--
ALTER TABLE `user_request`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `course`
--
ALTER TABLE `course`
  ADD CONSTRAINT `fk_course_faculty` FOREIGN KEY (`faculty_id`) REFERENCES `faculty` (`faculty_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_course_major` FOREIGN KEY (`major_id`) REFERENCES `major` (`major_id`) ON DELETE CASCADE;

--
-- Constraints for table `enrollment`
--
ALTER TABLE `enrollment`
  ADD CONSTRAINT `enrollment_ibfk_1` FOREIGN KEY (`std_id`) REFERENCES `user` (`std_id`),
  ADD CONSTRAINT `enrollment_ibfk_2` FOREIGN KEY (`section_id`) REFERENCES `section` (`section_id`);

--
-- Constraints for table `exam`
--
ALTER TABLE `exam`
  ADD CONSTRAINT `exam_ibfk_1` FOREIGN KEY (`section_id`) REFERENCES `section` (`section_id`),
  ADD CONSTRAINT `exam_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_code`);

--
-- Constraints for table `grade`
--
ALTER TABLE `grade`
  ADD CONSTRAINT `grade_ibfk_1` FOREIGN KEY (`enrollment_id`) REFERENCES `enrollment` (`enrollment_id`) ON DELETE CASCADE;

--
-- Constraints for table `major`
--
ALTER TABLE `major`
  ADD CONSTRAINT `major_ibfk_1` FOREIGN KEY (`faculty_id`) REFERENCES `faculty` (`faculty_id`);

--
-- Constraints for table `score`
--
ALTER TABLE `score`
  ADD CONSTRAINT `score_ibfk_1` FOREIGN KEY (`enrollment_id`) REFERENCES `enrollment` (`enrollment_id`) ON DELETE CASCADE;

--
-- Constraints for table `section`
--
ALTER TABLE `section`
  ADD CONSTRAINT `section_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_code`) ON DELETE CASCADE,
  ADD CONSTRAINT `section_ibfk_2` FOREIGN KEY (`prof_id`) REFERENCES `user` (`prof_id`) ON DELETE CASCADE;

--
-- Constraints for table `user_request`
--
ALTER TABLE `user_request`
  ADD CONSTRAINT `user_request_ibfk_1` FOREIGN KEY (`email`) REFERENCES `user` (`email`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
