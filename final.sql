-- phpMyAdmin SQL Dump
-- version 4.6.6deb4
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jul 05, 2017 at 02:54 AM
-- Server version: 5.7.18-0ubuntu0.17.04.1
-- PHP Version: 7.0.18-0ubuntu0.17.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ompampassas`
--

-- --------------------------------------------------------

--
-- Table structure for table `comment`
--

CREATE TABLE `comment` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `event_id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `message` varchar(1024) NOT NULL,
  `timestamp` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `comment`
--

INSERT INTO `comment` (`id`, `user_id`, `event_id`, `title`, `message`, `timestamp`) VALUES
(1, 29, 4, '', 'first', '2017-07-04 13:23:02'),
(2, 38, 4, '', 'kalispera', '2017-07-04 00:00:00'),
(3, 36, 4, 'Title', 'my new message', '2017-07-04 13:56:41'),
(4, 21, 4, 'Response', 'a provider message', '2017-07-04 13:57:27'),
(5, 21, 4, 'Πρώτο', 'Κανονικό\r\nσχόλιο\r\n5:44', '2017-07-04 17:44:19'),
(6, 21, 4, 'o ', 'nice place !', '2017-07-04 17:50:19'),
(7, 21, 4, '', '10/10 would rate', '2017-07-04 20:25:47'),
(8, 21, 4, 'asd', 'quite good experience', '2017-07-04 20:38:43'),
(9, 21, 4, 'qwe', 'sda', '2017-07-04 20:42:16'),
(10, 21, 4, 's', 's', '2017-07-04 20:42:29'),
(11, 21, 4, 'hijab', 'allahu \r\n', '2017-07-04 21:19:52'),
(12, 21, 4, 'sa', 'asdas', '2017-07-04 21:45:21'),
(13, 21, 4, 'jdas', 'sd', '2017-07-04 21:47:22'),
(14, 21, 4, 'asdas', 'asdasdasd', '2017-07-04 21:47:31'),
(15, 21, 4, 'xg', 'g', '2017-07-04 22:07:24');

-- --------------------------------------------------------

--
-- Table structure for table `event`
--

CREATE TABLE `event` (
  `id` int(11) NOT NULL,
  `place_id` int(11) NOT NULL,
  `provider_id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `description` varchar(1024) NOT NULL,
  `category` varchar(255) NOT NULL,
  `start_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  `number_of_tickets` int(10) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `event`
--

INSERT INTO `event` (`id`, `place_id`, `provider_id`, `title`, `description`, `category`, `start_time`, `end_time`, `number_of_tickets`, `price`) VALUES
(1, 3, 2, 'a', 'a', 'a', '2017-01-01 01:00:00', '2017-01-01 01:00:00', 1, 0),
(2, 4, 28, 'E', 'D', 'eD', '2017-01-01 01:00:00', '2017-01-01 01:00:00', 1, 0),
(3, 7, 2, 'Cooking Live', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit ,sed do eiusmod tempor incididunt ut labore et dolore magna aliqua', 'learning', '2017-09-03 14:02:00', '2017-09-04 03:01:00', 5, 0),
(4, 9, 2, 'Ergasia', 'Ελληνικά, motherfucker, do you speak it?', 'Education', '2017-07-05 13:00:00', '2018-01-01 01:00:00', 76, 5),
(5, 10, 2, 'test', 'aaa', 'a', '2017-01-01 02:00:00', '2017-01-01 01:00:00', 10, 6),
(6, 11, 2, 'PARTY HARD', 'Η παρουσίαση στον πελάτη θα πρέπει να αποτελεί ένα πλήρως λειτουργικό live demo της εφαρμογής σας, καλύπτοντας όλα τα σενάρια χρήσης κι όλους τους ρόλους που υποστηρίζονται από την πλατφόρμα σας, δίνοντας έμφαση στις διεπαφές χρήσης και στους επιχειρησιακούς κανόνες λειτουργίας της. Περιοριστείτε στις ελάχιστες δυνατές διαφάνειες και επικεντρωθείτε στη ζωντανή αφήγηση/παρουσίαση των χαρακτηριστικών της εφαρμογής, ώστε να δώσετε στον πελάτη την καλύτερη δυνατή εικόνα της πλατφόρμας σας.\r\n\r\nΗ παρουσίαση θα πρέπει να γίνει από τα μέλη της ομάδας που δεν έχουν λάβει συμμετοχή σε καμία αντίστοιχη παρουσίαση ή συνεδρία του μαθήματος έως τώρα (πέραν των παρουσιάσεων που έγιναν στο πλαίσιο της 3ης εργασίας). Σε κάποιες ομάδες είναι ένα το μέλος αυτό, σε κάποιες είναι δύο, ενώ για τις ομάδες 8 και 9, θα πρέπει  η παρουσίαση να γίνει και από τα δύο μέλη της ομάδας.\r\n\r\n', 'Party', '2017-07-06 00:12:00', '2017-07-16 00:12:00', 200, 100),
(7, 12, 36, 'Τιτλος', 'Η εξέταση της εργασίας θα γίνει σε Linux μηχάνημα του τμήματος, στο οποίο θα πρέπει να εγκαταστήσετε το σύνολο του λογισμικού της πλατφόρμας σας και να το θέσετε σε λειτουργία. Λάβετε υπόψη ότι θα σας διατεθεί ένα ξεχωριστό non-priviliged user account ανά ομάδα, στο οποίο θα είναι διαθέσιμη πρόσφατη έκδοση της Java 8 και του Apache Tomcat 8.5. Το λογισμικό σας θα πρέπει να χτίζεται από το build.gradle (παραγωγή του αρχείου war), αφού έχετε κάνει clone το git repository της εργασίας σας. Τα όποια πρόσθετα λογισμικά (π.χ. database) θα πρέπει να τα κατεβάσετε επί τόπου από την επίσημη σελίδα διάθεσής τους, ενώ κρίνεται απαραίτητο να έχετε προβλέψει και μια διαδικασία φόρτωσης δοκιμαστικών δεδομένων για τη διευκόλυνση της τεχνικής παρουσίασης - εξέτασης.\r\n\r\nΚατά την τεχνική εξέταση της εργασίας είναι υποχρεωτική η παρουσία όλων των μελών της ομάδας.', '????????', '2017-07-14 15:33:00', '2017-07-25 02:02:00', 14, 14),
(9, 14, 2, 'Το Παρτυ του Σπυρου', 'Φαϊ, Ποτό και τραγούδι ', 'Παρτυ', '2017-11-11 11:11:00', '2017-02-22 11:11:00', 22, 12),
(10, 15, 2, 'ασδασδ', 'σαδχζψωψωχχψω', 'αααα', '2017-11-11 01:02:00', '2017-12-01 14:02:00', 22, 12),
(13, 18, 36, 'a', 'ασδσαδασδασ αδασ χσα ', 'a', '2017-01-01 01:00:00', '2017-01-01 01:00:00', 4, 3),
(14, 19, 2, 'Συναυλία', 'Scorpions LIVE', 'Μουσική', '2017-07-06 11:11:00', '2017-07-09 11:11:00', 111, 33);

-- --------------------------------------------------------

--
-- Table structure for table `parent_metadata`
--

CREATE TABLE `parent_metadata` (
  `user_id` int(11) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `points` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `parent_metadata`
--

INSERT INTO `parent_metadata` (`user_id`, `first_name`, `last_name`, `phone`, `points`) VALUES
(29, 'Άγγελος', 'Τουμάσης', '2106666666', 0),
(32, 'emilios', 'kalantzis', '1234567890', 740),
(34, 'parent', 'test', '111111', 4),
(37, 'Ηλίας', 'Ραφαήλ', '111111', 1200),
(38, 'Σπύρος', 'Αναστασίου', '1', 0),
(41, 'Κωνσταντίνος', 'Καρατσενίδης', '111111', 0),
(44, 'Παναγιώτης', 'Σιφωνιός', '12312', 700);

-- --------------------------------------------------------

--
-- Table structure for table `place`
--

CREATE TABLE `place` (
  `id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `longitude` double NOT NULL,
  `latitude` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `place`
--

INSERT INTO `place` (`id`, `title`, `address`, `longitude`, `latitude`) VALUES
(2, 'Mexico', 'Zapopan, Mexico', 22.9375057220459, -30.55948257446289),
(3, 'Erfurt', 'Erfurt, Germany', 39.78233337402344, 15.179384231567383),
(4, 'A', 'Xaxazana, Eastern Cape, South Africa', 144.96266174316406, -37.63843536376953),
(5, 'Athens', 'Yfasiou 15, Zografou, Greece', 23.769195556640625, 37.972747802734375),
(6, 'aaaaaaaaaa', 'Kallithea, South Athens, Greece', 23.702096939086914, 37.955894470214844),
(7, 'aaaaaaaaaa', '', 23.702096939086914, 37.955894470214844),
(8, 'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa', 'Zografou, Central Athens, Greece', 23.761737823486328, 37.97682571411133),
(9, 'aa', 'Zografou, Central Athens, Greece', 23.761737823486328, 37.97682571411133),
(10, 'Kentro', 'Athens, Central Athens, Greece', 23.7275390625, 37.98381042480469),
(11, 'asdasdasd', 'Ibiza, Balearic Islands, Spain', 1.4821481704711914, 39.0200080871582),
(12, '??', '?????, ????????? ?????? ??????, ??????', 137.40420532226562, 34.74616622924805),
(13, 'aaa', 'Arizona, United States', 10.89778995513916, 48.37054443359375),
(14, 'sadasd', 'Athens, Central Athens, Greece', 3.776992082595825, 50.630428314208984),
(15, 'asdasd', 'Athens, Central Athens, Greece', 3.776992082595825, 50.630428314208984),
(16, '??', '??????????????????, ???????????, ??????', 27.287723541259766, 36.89150619506836),
(17, '??', '??????????????????, ???????????, ??????', 27.287723541259766, 36.89150619506836),
(18, 'aaa', 'a', 10.89778995513916, 48.37054443359375),
(19, 'qweqwe', '', 23.736003875732422, 38.02235794067383),
(20, 'a', 'Arizona, United States', 10.89778995513916, 48.37054443359375);

-- --------------------------------------------------------

--
-- Table structure for table `provider_metadata`
--

CREATE TABLE `provider_metadata` (
  `user_id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `company_name` varchar(255) NOT NULL,
  `vat_number` varchar(20) NOT NULL,
  `tax_office_id` int(11) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `fax` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `zip_code` varchar(20) NOT NULL,
  `region` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `rating` int(11) NOT NULL,
  `number_of_ratings` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `provider_metadata`
--

INSERT INTO `provider_metadata` (`user_id`, `title`, `company_name`, `vat_number`, `tax_office_id`, `phone`, `fax`, `address`, `zip_code`, `region`, `city`, `rating`, `number_of_ratings`) VALUES
(2, 'ftitle', 'fcompname', '2', 1101, 'tilefwno', 'fax', 'dieuthynsi', 'tax kwdikas', 'perioxi', 'poli', 12, 3),
(5, '2', '3', '5', 1101, '6', '7', '8', '9', '10', '11', 1, 16),
(16, 'asdf', 'pantatoum', '16', 1101, '6', '7', '8', '9', '10', '11', 13, 19),
(28, 'Forks', 'RazorForks', '28', 1101, '6', '7', '8', '9', '10', '11', 30, 15),
(32, 'Flowers', '', '', 1101, 'dasfafds', 'adsfafdsafsd', 'fdsafdasadsf', 'fdsadfsaasdf', 'dfsadsafasdf', 'dsafasdfsafdasd', 0, 0),
(36, 'provider', 'test', '111111', 1101, '111111', '111111', '111111', '111111', '111111', '111111', 0, 0),
(39, 'rrrrrr', '<script>alert(1);</script>', 'r', 1101, 'a', 'a', 'a', 'a', 'a', 'a', 0, 30),
(42, 'rainbow', 'Rainbow.co', '222222', 1104, '111111', '111111', '111111', '111111', '111111', '111111', 0, 0),
(43, '111111', '333333', '333333', 1101, '111111', '111111', '111111', '111111', '111111', '111111', 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `tax_office`
--

CREATE TABLE `tax_office` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tax_office`
--

INSERT INTO `tax_office` (`id`, `name`) VALUES
(1101, 'Α\' Αθηνών'),
(1104, 'Δ\' Αθηνών'),
(1106, 'ΣΤ\' Αθηνών'),
(1112, 'ΙΒ\' Αθηνών'),
(1113, 'ΙΓ\' Αθηνών'),
(1114, 'ΙΔ\' Αθηνών'),
(1117, 'ΙΖ\' Αθηνών'),
(1118, 'Μεγάλων Επιχειρήσεων'),
(1125, 'Κατοίκων Εξωτερικού'),
(1129, 'Αγίου Δημητρίου'),
(1130, 'Καλλιθέας'),
(1131, 'Νέας Ιωνίας'),
(1132, 'Νέας Σμύρνης'),
(1133, 'Παλαιού Φαλήρου'),
(1134, 'Χαλανδρίου'),
(1135, 'Αμαρουσίου'),
(1136, 'Αγίων Αναργύρων'),
(1137, 'Αιγάλεω'),
(1138, 'Α\' Περιστερίου'),
(1139, 'Γλυφάδας'),
(1145, 'Ν. Ηρακλείου'),
(1151, 'Χολαργού'),
(1152, 'Βύρωνα'),
(1153, 'Κηφισιάς'),
(1157, 'Β\' Περιστερίου'),
(1159, 'Φ.Α.Ε. Αθηνών'),
(1173, 'Ηλιούπολης'),
(1175, 'Ψυχικού'),
(1179, 'Γαλατσίου'),
(1201, 'Α\' Πειραιά'),
(1203, 'Γ\' Πειραιά'),
(1204, 'Δ\' Πειραιά'),
(1205, 'Ε\' Πειραιά'),
(1206, 'Φ.Α.Ε. Πειραιά'),
(1207, 'Πλοίων Πειραιά'),
(1211, 'Μοσχάτου'),
(1220, 'Νικαίας'),
(1302, 'Αχαρνών'),
(1303, 'Ελευσίνας'),
(1304, 'Κορωπίου'),
(1312, 'Παλλήνης'),
(1411, 'Θηβών'),
(1421, 'Λιβαδειάς'),
(1511, 'Αγρινίου'),
(1531, 'Μεσολογγίου'),
(1611, 'Καρπενησίου'),
(1722, 'Κύμης'),
(1732, 'Χαλκίδας'),
(1832, 'Λαμίας'),
(1912, 'Άμφισσας'),
(2111, 'Άργους'),
(2122, 'Ναυπλίου'),
(2211, 'Τρίπολης'),
(2311, 'Αιγίου'),
(2331, 'Α\' Πατρών'),
(2333, 'Γ\' Πατρών'),
(2411, 'Αμαλιάδας'),
(2412, 'Πύργου'),
(2513, 'Κορίνθου'),
(2632, 'Σπάρτης'),
(2711, 'Καλαμάτας'),
(3111, 'Καρδίτσας'),
(3211, 'Α\' Λάρισας'),
(3232, 'Β\'-Γ\' Λάρισας'),
(3321, 'Βόλου'),
(3323, 'Ν. Ιωνίας Βόλου'),
(3412, 'Τρικάλων'),
(4112, 'Βέροιας'),
(4211, 'Α\' Θεσσαλονίκης'),
(4214, 'Δ\' Θεσσαλονίκης'),
(4215, 'Ε\' Θεσσαλονίκης'),
(4216, 'ΣΤ\' Θεσσαλονίκης'),
(4217, 'Ζ\' Θεσσαλονίκης'),
(4222, 'Λαγκαδά'),
(4224, 'Φ.Α.Ε. Θεσσαλονίκης'),
(4228, 'Η\' Θεσσαλονίκης'),
(4232, 'Καλαμαριάς'),
(4233, 'Αμπελοκήπων'),
(4234, 'Ιωνίας Θεσσαλονίκης'),
(4311, 'Καστοριάς'),
(4411, 'Κιλκίς'),
(4521, 'Γρεβενών'),
(4531, 'Πτολεμαΐδας'),
(4541, 'Κοζάνης'),
(4611, 'Έδεσσας'),
(4621, 'Γιαννιτσών'),
(4711, 'Κατερίνης'),
(4812, 'Φλώρινας'),
(4921, 'Νέων Μουδανιών'),
(4922, 'Πολυγύρου'),
(5111, 'Δράμας'),
(5211, 'Αλεξανδρούπολης'),
(5221, 'Ορεστιάδας'),
(5321, 'Καβάλας'),
(5411, 'Ξάνθης'),
(5511, 'Κομοτηνής'),
(5611, 'Α\' Σερρών'),
(6111, 'Άρτας'),
(6211, 'Ηγουμενίτσας'),
(6311, 'Ιωαννίνων'),
(6411, 'Πρέβεζας'),
(7121, 'Θήρας'),
(7151, 'Νάξου'),
(7161, 'Πάρου'),
(7171, 'Σύρου'),
(7172, 'Μυκόνου'),
(7231, 'Μυτιλήνης'),
(7322, 'Σάμου'),
(7411, 'Χίου'),
(7531, 'Κω'),
(7542, 'Ρόδου'),
(8111, 'Α\' Ηρακλείου'),
(8112, 'Ηρακλείου'),
(8113, 'Β\' Ηρακλείου'),
(8221, 'Αγίου Νικολάου'),
(8341, 'Ρεθύμνου'),
(8431, 'Χανίων'),
(9111, 'Ζακύνθου'),
(9211, 'Κέρκυρας'),
(9311, 'Αργοστολίου'),
(9421, 'Λευκάδας');

-- --------------------------------------------------------

--
-- Table structure for table `ticket`
--

CREATE TABLE `ticket` (
  `id` int(11) NOT NULL,
  `parent_id` int(11) NOT NULL,
  `event_id` int(11) NOT NULL,
  `num_of_tickets` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ticket`
--

INSERT INTO `ticket` (`id`, `parent_id`, `event_id`, `num_of_tickets`) VALUES
(2, 44, 4, 5),
(4, 44, 4, 10),
(5, 44, 4, 9),
(6, 44, 4, 3),
(7, 44, 4, 3),
(8, 44, 4, 1),
(9, 44, 4, 4),
(10, 44, 4, 20);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` enum('ROLE_ADMIN','ROLE_PROVIDER','ROLE_PARENT') NOT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `email`, `password`, `role`, `enabled`) VALUES
(1, 'user@test.com', '$2a$10$K2GS6Oq67AXLZJmEIXf42eZaxMb4K.dlPqtVPnotHQFQtmPDtoJVO', 'ROLE_ADMIN', 1),
(2, 'aaa@aaa.com', '$2a$10$QgINf4CU7wfpJb1anIEaEujQ6QB6jhpeBdyEpgq/egEpNmutzj0P2', 'ROLE_PROVIDER', 1),
(5, 'bbb@bbb.gr', '$2a$10$v5OkAAtK5ObshZEJ48A/zO3Yp77DY2SxOohq.rHPEFuq8AunQUTKK', 'ROLE_PROVIDER', 0),
(7, 'ddd@ddd.gr', '$2a$10$5T4gHn0RX6/zV.9KgBswu.oT2QFaMK/krIxhEBE.QuQb3mzQiA5/K', 'ROLE_ADMIN', 0),
(9, 'eee@eee.gr', '$2a$10$kW46NLfktkuURna79fTu5OKpRwgSS2j8alfu.qOWrtt/DhVawde3a', 'ROLE_ADMIN', 1),
(10, 'fff@fff.gr', '$2a$10$dr.6EaQZ2FdL/Dpa7j33g.8MB0PGplqOUI5Wf1CQyX7Zfuofy3Bwe', 'ROLE_ADMIN', 1),
(11, 'ggg@ggg.gr', '$2a$10$Zyc819ihyVC2Fpip1hVj3OlgEYBOaQUH8EIJO7RN5ghzxxS9nmZOy', 'ROLE_ADMIN', 1),
(12, 'hhh@hhh.gr', '$2a$10$1e972qi8ANNafAKKPJHVHeCEWk1TpjE00Wdi/gaAB9ZeZFGstmVdS', 'ROLE_ADMIN', 1),
(15, 'aaaa@aaa.com', '$2a$10$HZypsvu8UV83IPsZqPSaqelDdcpgyhFHX98S6TIJMtdVu5R4bZ0dO', 'ROLE_ADMIN', 1),
(16, 'aaaaqqa@aaa.com', '$2a$10$NjpoRIa3G3XOwQfNWihZs.i4RZmqLGeEYChMZvwbPXberjvUE3IVa', 'ROLE_PROVIDER', 1),
(17, 'atest@email.com', '$2a$10$YyEIiodGF1nwtvLt040zSe56oTQ8MyUe81wmAE7aDjcvUV/tLBjMm', 'ROLE_ADMIN', 1),
(18, 're@gmail.com', '$2a$10$lHnra4u4uqH8cO7t08AhjOx/XS1DmQ./wsOf2uGtNondA8Wwqh8kG', 'ROLE_ADMIN', 1),
(19, 'www@wwwcom', '$2a$10$vllJ8OtKSK1p1vue80oXLuHPA17zBeQ4jDBO/HcR5LLzV6JesLZ4u', 'ROLE_ADMIN', 1),
(20, 'axne@dengmail.com', '$2a$10$AdmA7RhLmQ4.jkOnBewDfeDyCyZlh/AAPw1TL.T4ekcDINdyEDDwC', 'ROLE_ADMIN', 1),
(21, 'xxx@xxx.xxx', '$2a$10$87d8XHpQRAUusNfIwdFyM.Vkqkhir6.eZiTrH8YZ7v1ZTsnRkA3AC', 'ROLE_ADMIN', 1),
(22, 'karatse@karatse.co', '$2a$10$cB/VKcO/bRyqsb7zRlQWl.4mwXLdpotOhhxPLfZrdyqREVOQCdSYK', 'ROLE_ADMIN', 1),
(23, 'karatse2@karatse.co', '$2a$10$Ke4OBniGD9OIgnl.7p24SOcPQ6KFB8DcLUbcikYrKM3fpNsPawOTO', 'ROLE_ADMIN', 1),
(24, 'asd@fghcom', '$2a$10$FruvtLO.5k7YH3OEiKjgoeo5Rf0FqcHGbsKu6519so.Vx6VxCdYeG', 'ROLE_ADMIN', 1),
(28, 'qqq@qqq.com', '$2a$10$AWsxdFUrp77PpyhCAhaJDeZvsk7NGflEB1DJRWPiQb2vZUtMrBhD2', 'ROLE_PROVIDER', 1),
(29, 'rere@gmail.com', '$2a$10$j4m0UBv.dsBQgwRmU/NnBO4nQEcme5wcS1nwXZwMVueKmTk2/I146', 'ROLE_PARENT', 1),
(32, 'emilios@emilios.com', '$2a$10$f9luywvHQoUSpqBdL6sVbetANy5d2RMDv3BkbIvQyFcft0vKyhijW', 'ROLE_PROVIDER', 0),
(34, 'parent@test.com', '$2a$10$j64rRjDv5flYPq5lY6YlZ.YVHovU9fb4E269dj54IcdkJirw158Ka', 'ROLE_PARENT', 1),
(36, 'provider@test.com', '$2a$10$GNAkQz4vWyllXPQT0vbCxukRiejPQHYQx92eexh.OeKTt6JyCwoSa', 'ROLE_PROVIDER', 1),
(37, 'asd@asd.asd', '$2a$10$zWcUXZX0S11A7rB7VWLhvujqH/1UCjHAYztMSwCiT8YfZwXkTkZGS', 'ROLE_PARENT', 1),
(38, 'r@r', '$2a$10$Nzvp275jBH.ZYJhfjvwRDeFgyfZZlP0HNB99YL5V.2m6kaoILHVTO', 'ROLE_PARENT', 1),
(39, 'rr@rr', '$2a$10$/9efwZSuDS/9d7G65c8m3ulHVnHKAPpTJPSlgIUr9Ogyn9ZIJsaJ6', 'ROLE_PROVIDER', 1),
(41, 'test@last.com', '$2a$10$M7.xIAbalonOuqGuYK27guH/QZy2SYVBL/5Q7tk5sFOYtZ9mdHvoS', 'ROLE_PARENT', 1),
(42, 'last@test.com', '$2a$10$u8riqlQuB.NvjQE88LgJTOkur/cG30Zuf40GF.93m.3UuqGc2iFci', 'ROLE_PROVIDER', 1),
(43, 'dab@dab.dab', '$2a$10$ySEZwqJPacLNMWcyRWeXc.BWbDoFbBRVrJF60No7r8LrM75JN0hN2', 'ROLE_PROVIDER', 1),
(44, 'spy@a.com', '$2a$10$UB2DFf.oE8gW4Q5C6.9sVOm2jwm4TCAk6SNJtiEloHh/cpS2W0qU.', 'ROLE_PARENT', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `parent_id` (`user_id`),
  ADD KEY `event_id` (`event_id`);

--
-- Indexes for table `event`
--
ALTER TABLE `event`
  ADD PRIMARY KEY (`id`),
  ADD KEY `provider_id` (`provider_id`),
  ADD KEY `place_id` (`place_id`);

--
-- Indexes for table `parent_metadata`
--
ALTER TABLE `parent_metadata`
  ADD PRIMARY KEY (`user_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `place`
--
ALTER TABLE `place`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `provider_metadata`
--
ALTER TABLE `provider_metadata`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `company_name` (`company_name`),
  ADD UNIQUE KEY `vat_number` (`vat_number`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `fk_provider_metadata_tax_office1_idx` (`tax_office_id`);

--
-- Indexes for table `tax_office`
--
ALTER TABLE `tax_office`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`id`),
  ADD KEY `parent_id` (`parent_id`),
  ADD KEY `event_id` (`event_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `comment`
--
ALTER TABLE `comment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `event`
--
ALTER TABLE `event`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `place`
--
ALTER TABLE `place`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT for table `ticket`
--
ALTER TABLE `ticket`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`event_id`) REFERENCES `event` (`id`);

--
-- Constraints for table `event`
--
ALTER TABLE `event`
  ADD CONSTRAINT `event_ibfk_1` FOREIGN KEY (`provider_id`) REFERENCES `provider_metadata` (`user_id`),
  ADD CONSTRAINT `fk_events_places1` FOREIGN KEY (`place_id`) REFERENCES `place` (`id`);

--
-- Constraints for table `parent_metadata`
--
ALTER TABLE `parent_metadata`
  ADD CONSTRAINT `fk_parentMetadata_users1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `provider_metadata`
--
ALTER TABLE `provider_metadata`
  ADD CONSTRAINT `fk_provider_metadata_tax_office1` FOREIGN KEY (`tax_office_id`) REFERENCES `tax_office` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_provider_metadata_users1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `ticket_ibfk_1` FOREIGN KEY (`parent_id`) REFERENCES `parent_metadata` (`user_id`),
  ADD CONSTRAINT `ticket_ibfk_2` FOREIGN KEY (`event_id`) REFERENCES `event` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
