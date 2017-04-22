/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagement.implement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pharmacymanagement.connections.connection;
import pharmacymanagement.interfaces.TransaksiInter;
import pharmacymanagement.models.ResepObat_M;
import pharmacymanagement.models.Transaksi_M;

/**
 *
 * @author drag me to hell
 */
public class TransaksiImpl implements TransaksiInter{
    connection con;
    @Override
    public ObservableList<Transaksi_M> tampilTransaksi() {
        con =  new connection();
        ObservableList<Transaksi_M> listTransaksi =  FXCollections.observableArrayList();
        try {
            String sql = "SELECT transaksi.kode_transaksi, transaksi.kode_resep, dokter.nama_dokter, dokter.spesialis, transaksi.status FROM dokter, resep, transaksi WHERE resep.kode_resep = transaksi.kode_resep AND dokter.kode_dokter = resep.kode_dokter ORDER BY status";
            ResultSet rs = con.connect().createStatement().executeQuery(sql);
            while(rs.next()){
                Transaksi_M t = new Transaksi_M();
                t.setKodeTransaksi(rs.getInt(1));
                t.setKodeResep(rs.getString(2));
                t.setNamaDokter(rs.getString(3));
                t.setSpesialis(rs.getString(4));
                t.setStatus(rs.getString(5));
                listTransaksi.add(t);
            }
        } catch (Exception e) {
             e.printStackTrace();
        }
        return listTransaksi;
    }

    @Override
    public ObservableList<Transaksi_M> transaksi(String kodeResep) {
        con =  new connection();
        ObservableList<Transaksi_M> listLayani =  FXCollections.observableArrayList();
        try {
            String sql = "SELECT pasien.id_pasien, pasien.nama_pasien, pasien.umur, dokter.nama_dokter, dokter.spesialis, transaksi.kode_resep, transaksi.total, transaksi.kode_transaksi, transaksi.status FROM dokter, resep, transaksi, pasien WHERE resep.kode_resep = transaksi.kode_resep AND dokter.kode_dokter = resep.kode_dokter AND pasien.id_pasien = transaksi.id_pasien AND transaksi.kode_resep = '"+kodeResep+"'";
            ResultSet rs = con.connect().createStatement().executeQuery(sql);
            while(rs.next()){
                Transaksi_M t = new Transaksi_M();
                t.setIdPasien(rs.getString(1));
                t.setNamaPasien(rs.getString(2));
                t.setumur(rs.getInt(3));
                t.setNamaDokter(rs.getString(4));
                t.setSpesialis(rs.getString(5));
                t.setKodeResep(rs.getString(6));
                t.setTotalPembayaran(rs.getDouble(7));
                t.setKodeTransaksi(rs.getInt(8));
                t.setStatus(rs.getString(9));
                listLayani.add(t);
            }
        } catch (Exception e) {
             e.printStackTrace();
        }
        return listLayani;
    }

    @Override
    public void insert(Transaksi_M transaksi) {
        con = new connection();
        PreparedStatement ps;
        try {
            ps = con.connect().prepareStatement("insert into transaksi (id_pasien, kode_resep, tgl_transaksi, total, status) values(?,?,?,?,?)");
            ps.setString(1, transaksi.getIdPasien());
            ps.setString(2, transaksi.getKodeResep());
            ps.setObject(3, transaksi.getTanggalTransaksi());
            ps.setDouble(4, transaksi.getTotalPembayaran());
            ps.setString(5, transaksi.getStatus());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    


    @Override
    public ObservableList<ResepObat_M> getTransaksiResepObat(String resepObat) {
         con =  new connection();
        ObservableList<ResepObat_M> listResepObat =  FXCollections.observableArrayList();
        try {
            String sql = "SELECT obat.nama_obat, obat.harga, resep_obat.qty, resep_obat.total_harga, obat.kode_obat FROM obat, resep_obat, resep, transaksi WHERE resep.kode_resep = resep_obat.kode_resep AND obat.kode_obat = resep_obat.kode_obat AND resep.kode_resep = transaksi.kode_resep AND resep.kode_resep = '"+resepObat+"'";
            ResultSet rs = con.connect().createStatement().executeQuery(sql);
            while(rs.next()){
                ResepObat_M t = new ResepObat_M();
                t.setNamaObat(rs.getString(1));
                t.setHarga(rs.getDouble(2));
                t.setQty(rs.getInt(3));
                t.setTotalHarga(rs.getDouble(4));
                t.setKodeObat(rs.getString(5));
                listResepObat.add(t);
            }
        } catch (Exception e) {
             e.printStackTrace();
        }
        return listResepObat;
    }

    @Override
    public void update(Transaksi_M transaksi, int kodeTransaksi) {
        con =  new connection();
        PreparedStatement ps;
        try {
            ps = con.connect().prepareStatement("UPDATE transaksi SET status = 'Sudah dilayani' WHERE transaksi.kode_transaksi = '"+kodeTransaksi+"'");
            //ps.setString(2, kodeResep);
            //ps.setString(1, kodePasien);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
            //Logger.getLogger(implBiodata.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public ObservableList<Transaksi_M> transaksiByNama(String namaPasien) {
        con =  new connection();
        ObservableList<Transaksi_M> listTransaksi =  FXCollections.observableArrayList();
        try {
            String sql = "SELECT transaksi.kode_transaksi, transaksi.kode_resep, dokter.nama_dokter, dokter.spesialis, transaksi.status FROM dokter, resep, transaksi, pasien WHERE resep.kode_resep = transaksi.kode_resep AND dokter.kode_dokter = resep.kode_dokter AND pasien.id_pasien = transaksi.id_pasien AND pasien.nama_pasien like'%"+namaPasien+"%' ORDER BY status";
            ResultSet rs = con.connect().createStatement().executeQuery(sql);
            while(rs.next()){
                Transaksi_M t = new Transaksi_M();
                t.setKodeTransaksi(rs.getInt(1));
                t.setKodeResep(rs.getString(2));
                t.setNamaDokter(rs.getString(3));
                t.setSpesialis(rs.getString(4));
                t.setStatus(rs.getString(5));
                listTransaksi.add(t);
            }
        } catch (Exception e) {
             e.printStackTrace();
        }
        return listTransaksi;
    }
}
