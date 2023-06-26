-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 26, 2023 at 09:35 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library`
--

-- --------------------------------------------------------

--
-- Table structure for table `admins`
--

CREATE TABLE `admins` (
  `firstname` varchar(60) NOT NULL,
  `secondname` varchar(60) NOT NULL,
  `regno` varchar(20) NOT NULL,
  `username` varchar(60) NOT NULL,
  `password` varchar(40) NOT NULL,
  `security` varchar(40) NOT NULL,
  `answer` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admins`
--

INSERT INTO `admins` (`firstname`, `secondname`, `regno`, `username`, `password`, `security`, `answer`) VALUES
('admin', 'admin', '1', 'admin', '12345678', 'What is your favorite color?', 'black');

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `booktitle` varchar(60) NOT NULL,
  `bookid` varchar(15) NOT NULL,
  `price` varchar(60) NOT NULL,
  `categ` varchar(60) NOT NULL,
  `publishers` varchar(60) NOT NULL,
  `edition` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`booktitle`, `bookid`, `price`, `categ`, `publishers`, `edition`) VALUES
('Harry Potter', '100', '20', 'Fantasy', 'JK Rowling', '1'),
('The Lord of the Rings', '102', '25', 'Fantasy / Fiction', 'J. R. R. Tolkien', '1'),
('Brave New World', '104', '25', 'Science Fiction', 'Aldous Huxley', '3'),
('Beloved', '106', '10', 'Novel', 'Toni Morrison', '1');

-- --------------------------------------------------------

--
-- Table structure for table `issued`
--

CREATE TABLE `issued` (
  `ID` int(16) NOT NULL,
  `names` varchar(60) NOT NULL,
  `regno` varchar(60) NOT NULL,
  `yearOfStudy` varchar(60) NOT NULL,
  `faculty` varchar(60) NOT NULL,
  `department` varchar(60) NOT NULL,
  `email` varchar(60) NOT NULL,
  `dateIssued` varchar(60) NOT NULL,
  `bookId` varchar(60) NOT NULL,
  `booktitle` varchar(60) NOT NULL,
  `price` varchar(60) NOT NULL,
  `category` varchar(60) NOT NULL,
  `publishers` varchar(60) NOT NULL,
  `edition` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `issued`
--

INSERT INTO `issued` (`ID`, `names`, `regno`, `yearOfStudy`, `faculty`, `department`, `email`, `dateIssued`, `bookId`, `booktitle`, `price`, `category`, `publishers`, `edition`) VALUES
(13, 'user1', '2', '3', 'Computer Science', 'Science', 'user1@gmail.com', '2023-04-30', '105', 'The Slight EdgeBook by Jeff Olson', '15', 'Self Improvement', 'Greenleaf Book Group Press', '2'),
(15, 'user2', '3', '3', 'Chemistry', 'Sciences', 'user2@gmail.com', '2023-04-30', '101', 'Game Of Thrones', '30', 'Fantasy / History', 'Bantam Spectra', '2'),
(16, 'user3', '4', '3', 'Math', 'Sciences', 'user3@gmail.com', '2023-04-30', '103', 'To Kill a Mockingbird', '25', 'Fantasy / Fiction', 'Harper Lee', '1');

-- --------------------------------------------------------

--
-- Table structure for table `returned`
--

CREATE TABLE `returned` (
  `ID` int(16) NOT NULL,
  `booktitle` varchar(60) NOT NULL,
  `bookid` varchar(60) NOT NULL,
  `price` varchar(60) NOT NULL,
  `category` varchar(60) NOT NULL,
  `publishers` varchar(60) NOT NULL,
  `edition` varchar(60) NOT NULL,
  `regno` varchar(60) NOT NULL,
  `name` varchar(60) NOT NULL,
  `yearOfStudy` varchar(60) NOT NULL,
  `faculty` varchar(60) NOT NULL,
  `department` varchar(60) NOT NULL,
  `email` varchar(60) NOT NULL,
  `dateIssued` varchar(60) NOT NULL,
  `dateReturned` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `returned`
--

INSERT INTO `returned` (`ID`, `booktitle`, `bookid`, `price`, `category`, `publishers`, `edition`, `regno`, `name`, `yearOfStudy`, `faculty`, `department`, `email`, `dateIssued`, `dateReturned`) VALUES
(10, 'Harry Potter', '100', '20', 'Fantasy', 'JK Rowling', '1', '4', 'user3', '3', 'Math', 'Sciences', 'user3@gmail.com', '2023-04-30', '2023-04-30'),
(11, 'Game Of Thrones', '101', '30', 'Fantasy / History', 'Bantam Spectra', '2', '3', 'user2', '3', 'Chemistry', 'Sciences', 'user2@gmail.com', '2023-04-30', '2023-04-30'),
(12, 'Brave New World', '104', '25', 'Science Fiction', 'Aldous Huxley', '3', '2', 'user1', '3', 'Computer Science', 'Science', 'user1@gmail.com', '2023-04-30', '2023-04-30');

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `fname` varchar(48) NOT NULL,
  `sname` varchar(48) NOT NULL,
  `regno` varchar(16) NOT NULL,
  `year` varchar(20) NOT NULL,
  `faculty` varchar(48) NOT NULL,
  `department` varchar(48) NOT NULL,
  `email` varchar(48) NOT NULL,
  `noIssued` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`fname`, `sname`, `regno`, `year`, `faculty`, `department`, `email`, `noIssued`) VALUES
('user1', 'user1', '2', '3', 'Computer Science', 'Science', 'user1@gmail.com', 1),
('user2', 'user2', '3', '3', 'Chemistry', 'Sciences', 'user2@gmail.com', 1),
('user3', 'user3', '4', '3', 'Math', 'Sciences', 'user3@gmail.com', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admins`
--
ALTER TABLE `admins`
  ADD PRIMARY KEY (`regno`);

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`bookid`);

--
-- Indexes for table `issued`
--
ALTER TABLE `issued`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `returned`
--
ALTER TABLE `returned`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`regno`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `issued`
--
ALTER TABLE `issued`
  MODIFY `ID` int(16) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `returned`
--
ALTER TABLE `returned`
  MODIFY `ID` int(16) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
