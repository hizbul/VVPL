-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 13, 2015 at 05:13 PM
-- Server version: 5.6.11
-- PHP Version: 5.5.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `db_apotek`
--
CREATE DATABASE IF NOT EXISTS `db_apotek` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `db_apotek`;

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
  PRIMARY KEY (`kode_dokter`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  `keterangan` varchar(100) NOT NULL,
  PRIMARY KEY (`kode_obat`)
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
  `jenis_kelamin` varchar(10) NOT NULL,
  PRIMARY KEY (`id_pasien`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pemusnahan_obat`
--

CREATE TABLE IF NOT EXISTS `pemusnahan_obat` (
  `kode_pemusnahan` int(11) NOT NULL AUTO_INCREMENT,
  `kode_obat` varchar(12) NOT NULL,
  `tgl_pemusnahan` date NOT NULL,
  `jumlah` int(11) NOT NULL,
  PRIMARY KEY (`kode_pemusnahan`),
  KEY `kode_obat` (`kode_obat`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `resep`
--

CREATE TABLE IF NOT EXISTS `resep` (
  `kode_resep` varchar(12) NOT NULL,
  `kode_dokter` varchar(12) NOT NULL,
  `spesialis` varchar(50) NOT NULL,
  `status` varchar(20) NOT NULL,
  `id_pasien` varchar(12) NOT NULL,
  PRIMARY KEY (`kode_resep`),
  KEY `nama_dokter` (`kode_dokter`),
  KEY `kode_dokter` (`kode_dokter`),
  KEY `id_pasien` (`id_pasien`),
  KEY `kode_dokter_2` (`kode_dokter`),
  KEY `id_pasien_2` (`id_pasien`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE IF NOT EXISTS `transaksi` (
  `kode_transaksi` int(11) NOT NULL AUTO_INCREMENT,
  `id_pasien` varchar(12) NOT NULL,
  `kode_dokter` varchar(12) NOT NULL,
  `kode_resep` varchar(12) NOT NULL,
  `tgl_transaksi` date NOT NULL,
  `list_obat` varchar(250) NOT NULL,
  `total` double NOT NULL,
  `status` varchar(25) NOT NULL,
  PRIMARY KEY (`kode_transaksi`),
  KEY `id_pasien` (`id_pasien`),
  KEY `kode_dokter` (`kode_dokter`),
  KEY `kode_resep` (`kode_resep`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `pemusnahan_obat`
--
ALTER TABLE `pemusnahan_obat`
  ADD CONSTRAINT `pemusnahan_obat_ibfk_1` FOREIGN KEY (`kode_obat`) REFERENCES `obat` (`kode_obat`);

--
-- Constraints for table `resep`
--
ALTER TABLE `resep`
  ADD CONSTRAINT `resep_ibfk_2` FOREIGN KEY (`id_pasien`) REFERENCES `pasien` (`id_pasien`),
  ADD CONSTRAINT `resep_ibfk_1` FOREIGN KEY (`kode_dokter`) REFERENCES `dokter` (`kode_dokter`);

--
-- Constraints for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_3` FOREIGN KEY (`kode_resep`) REFERENCES `resep` (`kode_resep`),
  ADD CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`id_pasien`) REFERENCES `pasien` (`id_pasien`),
  ADD CONSTRAINT `transaksi_ibfk_2` FOREIGN KEY (`kode_dokter`) REFERENCES `dokter` (`kode_dokter`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
