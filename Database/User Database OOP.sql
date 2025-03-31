-- phpMyAdmin SQL Dump
-- version 5.2.2
-- https://www.phpmyadmin.net/
--
-- Host: db:3306
-- Generation Time: Mar 31, 2025 at 03:56 PM
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
(2, 2, '67070174@kmutt.ac.th', 'student01', '$2a$10$kYtLzAV8G0oWwiNkygjxD.h6DqTvq7Nh.gSvcdJ0fFxQsVCbspeaa', 1, 'ศักดิธัช', 'ปิ่นแก้ว', NULL, NULL, '67070174', NULL, 'Information Technology', 'Information Technology', '2'),
(3, 3, NULL, 'prof01', '$2a$10$Vrrky95YCn5BvJei7JlBGuknw39eUAid7C3T0qR/dn3ZP0FQT13B6', 1, 'สุขสันต์', 'ทุกข์ระทม', NULL, NULL, NULL, '2555070001', NULL, NULL, NULL),
(4, 1, NULL, 'admin01', '$2a$10$SGdtBIHBlfzxuwcHzoe2juIrrxGoG2HZvk0dIOBUGbWCTqwUeqKui', 2, 'สมศรี', 'มีโชค', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(5, 2, NULL, 'student02', 'student02_password', 1, 'นาย A', 'รักแฟน', NULL, NULL, '67070191', NULL, 'Information Technology', 'Information Technology', '1'),
(6, 3, NULL, 'prof02', 'prof02_password', 1, 'แล้วแต่', 'แบงค์', NULL, NULL, NULL, '2555070002', '', NULL, NULL),
(7, 1, NULL, 'Admin02', '$2a$10$OJCKVkOW32CYVWMieocdQODY1AEVNaDFyA.zfrpvNyNCL2fcjhoCy', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(8, 2, 'stdtest@kmitl.ac.th', 'StudentTest', '$2a$10$g3NbtCIoqKfokKYczEhn4e3CQPkR5PjAWx5BqYwn4B4kyq01rY0kO', 1, 'Phos', 'Zaza', '0878889999', NULL, '67070000', NULL, 'Information Technology', 'Information Technology', '1'),
(9, 2, 'stdtest2@kmitl.ac.th', 'StudentTest2', '$2a$10$BLH55hXc3hrX41IxRKfVdedkcbkJFSJ99djepARk7SzJzuAHffX1q', 1, 'Asitara', 'Phumdokmai', '0999999999', NULL, '66070199', NULL, 'Information Technology', 'Information Technology', NULL),
(10, 2, '', '', '$2a$10$wIcmJ0Ws07Si6gj42OSLgezvzzbT5ArALUJ17h3g8EI.WkXc8EQuW', 1, '', '', '', '', '', NULL, '', '', NULL),
(13, 2, '60000000@kmitl.ac.th', 'Student03', '$2a$10$rCpfit40AujaOiF2Br3XC.ppSIY5d8D4ZRrGN.1ii0QkK2Jx3mG9u', 1, 'มีโชค', 'โบกปูน', '0123456789', 'เมืองมาซาระ ภูมิภาคคันโต', '60000000', NULL, 'เทคโนโลยีสารสนเทศ', 'เทคโนโลยีสารสนเทศ', NULL);

--
-- Indexes for dumped tables
--

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
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
