-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 22, 2017 at 08:39 PM
-- Server version: 5.6.26
-- PHP Version: 5.6.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_apotek`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE IF NOT EXISTS `account` (
  `kode_account` varchar(10) NOT NULL,
  `username` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL,
  `jabatan` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`kode_account`, `username`, `password`, `jabatan`) VALUES
('admin', 'admin', 'admin', 'admin'),
('apo001', 'apoteker', '12345', 'apoteker'),
('dokspe001', 'fajarshid', '12345', 'dokter'),
('dokum001', 'manggaweh', '12345', 'dokter'),
('kas001', 'deyahif', '12345', 'kasir');

-- --------------------------------------------------------

--
-- Table structure for table `dokter`
--

CREATE TABLE IF NOT EXISTS `dokter` (
  `kode_dokter` varchar(12) NOT NULL,
  `nama_dokter` varchar(50) NOT NULL,
  `spesialis` varchar(100) NOT NULL,
  `alamat` varchar(150) NOT NULL,
  `jenis_kelamin` varchar(10) NOT NULL,
  `kode_account` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dokter`
--

INSERT INTO `dokter` (`kode_dokter`, `nama_dokter`, `spesialis`, `alamat`, `jenis_kelamin`, `kode_account`) VALUES
('dokspeku001', 'Fajar Shidiq Ramadhani', 'THT', 'Kp. Pulo', 'Laki-laki', 'dokspe001'),
('dokum001', 'Raynata Triyadi', 'Umum', 'Kiaracondong', 'Laki-laki', 'dokum001');

-- --------------------------------------------------------

--
-- Table structure for table `obat`
--

CREATE TABLE IF NOT EXISTS `obat` (
  `kode_obat` varchar(12) NOT NULL,
  `nama_obat` varchar(50) NOT NULL,
  `kategori_obat` varchar(25) NOT NULL,
  `sub_kategori` varchar(100) NOT NULL,
  `kemasan` varchar(12) NOT NULL,
  `harga` double NOT NULL,
  `stok` int(11) NOT NULL,
  `keterangan` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pasien`
--

CREATE TABLE IF NOT EXISTS `pasien` (
  `id_pasien` varchar(12) NOT NULL,
  `nama_pasien` varchar(150) NOT NULL,
  `alamat` varchar(200) NOT NULL,
  `umur` int(11) NOT NULL,
  `jenis_kelamin` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pasien`
--

INSERT INTO `pasien` (`id_pasien`, `nama_pasien`, `alamat`, `umur`, `jenis_kelamin`) VALUES
('pas001', 'Wulan Purwanti', 'Subang', 21, 'Perempuan'),
('pas002', 'Wanda Gusdya Purnama', 'Sarijadi', 29, 'Laki-laki');

-- --------------------------------------------------------

--
-- Table structure for table `pemusnahan_obat`
--

CREATE TABLE IF NOT EXISTS `pemusnahan_obat` (
  `kode_pemusnahan` int(11) NOT NULL,
  `kode_obat` varchar(12) NOT NULL,
  `tgl_pemusnahan` date NOT NULL,
  `jumlah` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `resep`
--

CREATE TABLE IF NOT EXISTS `resep` (
  `kode_resep` varchar(12) NOT NULL,
  `kode_dokter` varchar(12) NOT NULL,
  `pathResep` varchar(100) NOT NULL,
  `status` varchar(20) NOT NULL,
  `id_pasien` varchar(12) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `resep`
--

INSERT INTO `resep` (`kode_resep`, `kode_dokter`, `pathResep`, `status`, `id_pasien`) VALUES
('001', 'dokum001', 'apple logo.png', 'Sudah dilayani', 'pas001'),
('1', 'dokspeku001', '5saih.jpg', 'Sudah dilayani', 'pas001'),
('2', 'dokspeku001', '1280-healthcare-pharmacy-patient-shutterstock-97313783.jpg', 'Sudah dilayani', 'pas001'),
('3', 'dokspeku001', '5.png', 'Sudah dilayani', 'pas001'),
('asfasf', 'dokspeku001', '7.png', 'Sudah dilayani', 'pas002'),
('dokray002', 'dokum001', 'Screenshot (3).png', 'Sudah dilayani', 'pas001'),
('thtfaj001', 'dokspeku001', '18a9bf8bafaf9ff76dd4c61eee8aa9e1.png', 'Sudah dilayani', 'pas001'),
('thtfaj003', 'dokspeku001', 'Screenshot_2015-04-22-22-13-55.png', 'Sudah dilayani', 'pas002'),
('thtfaj007', 'dokspeku001', 'sYsWcHH.jpg', 'Sudah dilayani', 'pas001'),
('thtfaj008', 'dokspeku001', 'nx6gkp.jpg', 'Sudah dilayani', 'pas002'),
('ththfaj002', 'dokspeku001', 'jadwalprak2.PNG', 'Sudah dilayani', 'pas001'),
('umray002', 'dokum001', 'Screenshot_2014_09_20_12_32_47.jpg', 'Sudah dilayani', 'pas002'),
('umray004', 'dokum001', 'jadwal kuliah.png', 'Sudah dilayani', 'pas002'),
('umray005', 'dokum001', 'Screenshot_2014_09_20_12_32_47.jpg', 'Sudah dilayani', 'pas002'),
('umray006', 'dokum001', 'Screenshot_2015-04-22-22-13-55.png', 'Sudah dilayani', 'pas002'),
('umray007', 'dokum001', 'Screenshot (2).png', 'Sudah dilayani', 'pas001'),
('umray009', 'dokum001', 'Screenshot (5).png', 'Sudah dilayani', 'pas002');

-- --------------------------------------------------------

--
-- Table structure for table `resep_obat`
--

CREATE TABLE IF NOT EXISTS `resep_obat` (
  `id` int(11) NOT NULL,
  `qty` int(11) NOT NULL,
  `total_harga` double DEFAULT NULL,
  `kode_obat` varchar(12) NOT NULL,
  `kode_resep` varchar(12) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE IF NOT EXISTS `transaksi` (
  `kode_transaksi` int(12) NOT NULL,
  `id_pasien` varchar(12) NOT NULL,
  `kode_resep` varchar(12) NOT NULL,
  `tgl_transaksi` date NOT NULL,
  `total` double NOT NULL,
  `status` varchar(25) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`kode_transaksi`, `id_pasien`, `kode_resep`, `tgl_transaksi`, `total`, `status`) VALUES
(1, 'pas001', '1', '2015-12-22', 200000, 'Sudah dilayani'),
(2, 'pas002', 'thtfaj001', '2015-12-22', 400000, 'Belum dilayani'),
(3, 'pas002', 'umray005', '2015-12-27', 0, 'Belum dilayani'),
(4, 'pas002', 'umray006', '2015-12-27', 8000, 'Belum dilayani'),
(5, 'pas001', 'thtfaj007', '2015-12-28', 20000, 'Belum dilayani'),
(6, 'pas002', 'thtfaj008', '2015-12-28', 20000, 'Belum dilayani'),
(7, 'pas001', 'umray007', '2015-12-29', 8000, 'Sudah dilayani'),
(8, 'pas002', 'umray009', '2016-01-06', 12000, 'Belum dilayani'),
(9, 'pas001', '001', '2017-04-23', 20000, 'Sudah dilayani');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`kode_account`);

--
-- Indexes for table `dokter`
--
ALTER TABLE `dokter`
  ADD PRIMARY KEY (`kode_dokter`),
  ADD KEY `kode_account` (`kode_account`);

--
-- Indexes for table `obat`
--
ALTER TABLE `obat`
  ADD PRIMARY KEY (`kode_obat`);

--
-- Indexes for table `pasien`
--
ALTER TABLE `pasien`
  ADD PRIMARY KEY (`id_pasien`);

--
-- Indexes for table `pemusnahan_obat`
--
ALTER TABLE `pemusnahan_obat`
  ADD PRIMARY KEY (`kode_pemusnahan`),
  ADD KEY `kode_obat` (`kode_obat`);

--
-- Indexes for table `resep`
--
ALTER TABLE `resep`
  ADD PRIMARY KEY (`kode_resep`),
  ADD KEY `nama_dokter` (`kode_dokter`),
  ADD KEY `kode_dokter` (`kode_dokter`),
  ADD KEY `id_pasien` (`id_pasien`),
  ADD KEY `kode_dokter_2` (`kode_dokter`),
  ADD KEY `id_pasien_2` (`id_pasien`);

--
-- Indexes for table `resep_obat`
--
ALTER TABLE `resep_obat`
  ADD PRIMARY KEY (`id`),
  ADD KEY `kode_obat` (`kode_obat`,`kode_resep`),
  ADD KEY `kode_resep` (`kode_resep`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`kode_transaksi`),
  ADD KEY `id_pasien` (`id_pasien`),
  ADD KEY `kode_resep` (`kode_resep`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pemusnahan_obat`
--
ALTER TABLE `pemusnahan_obat`
  MODIFY `kode_pemusnahan` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `resep_obat`
--
ALTER TABLE `resep_obat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=20;
--
-- AUTO_INCREMENT for table `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `kode_transaksi` int(12) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `dokter`
--
ALTER TABLE `dokter`
  ADD CONSTRAINT `dokter_ibfk_1` FOREIGN KEY (`kode_account`) REFERENCES `account` (`kode_account`);

--
-- Constraints for table `pemusnahan_obat`
--
ALTER TABLE `pemusnahan_obat`
  ADD CONSTRAINT `pemusnahan_obat_ibfk_1` FOREIGN KEY (`kode_obat`) REFERENCES `obat` (`kode_obat`);

--
-- Constraints for table `resep`
--
ALTER TABLE `resep`
  ADD CONSTRAINT `resep_ibfk_1` FOREIGN KEY (`kode_dokter`) REFERENCES `dokter` (`kode_dokter`),
  ADD CONSTRAINT `resep_ibfk_2` FOREIGN KEY (`id_pasien`) REFERENCES `pasien` (`id_pasien`);

--
-- Constraints for table `resep_obat`
--
ALTER TABLE `resep_obat`
  ADD CONSTRAINT `resep_obat_ibfk_1` FOREIGN KEY (`kode_resep`) REFERENCES `resep` (`kode_resep`),
  ADD CONSTRAINT `resep_obat_ibfk_2` FOREIGN KEY (`kode_obat`) REFERENCES `obat` (`kode_obat`);

--
-- Constraints for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`id_pasien`) REFERENCES `pasien` (`id_pasien`),
  ADD CONSTRAINT `transaksi_ibfk_3` FOREIGN KEY (`kode_resep`) REFERENCES `resep` (`kode_resep`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
