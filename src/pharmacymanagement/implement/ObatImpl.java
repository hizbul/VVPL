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
import pharmacymanagement.interfaces.ObatInter;
import pharmacymanagement.models.Obat_M;

/**
 *
 * @author drag me to hell
 */
public class ObatImpl implements ObatInter{
    connection con;
    @Override
    public ObservableList<Obat_M> getAllObat() {
        con =  new connection();
        ObservableList<Obat_M> listObat =  FXCollections.observableArrayList();
        try {
            String sql = "select * from obat";
            ResultSet rs = con.connect().createStatement().executeQuery(sql);
            while(rs.next()){
                Obat_M obat = new Obat_M();
                obat.setKodeObat(rs.getString(1));
                obat.setNamaObat(rs.getString(2));
                obat.setKategoriObat(rs.getString(3));
                obat.setSubObat(rs.getString(4));
                obat.setKemasan(rs.getString(5));
                obat.sethargaObat(rs.getDouble(6));
                obat.setStok(rs.getInt(7));
                obat.setDeskripsi(rs.getString(8));
                listObat.add(obat);
            }
        } catch (Exception e) {
             e.printStackTrace();
        }
        return listObat;
    }

    @Override
    public void updateStok(Obat_M obat, int qty, String kodeObat) {
        con =  new connection();
        PreparedStatement ps;
        try {
            ps = con.connect().prepareStatement("UPDATE obat SET stok = "+qty+" WHERE kode_obat = '"+kodeObat+"'");
            //ps.setString(2, kodeResep);
            //ps.setString(1, kodePasien);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
            //Logger.getLogger(implBiodata.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public ObservableList<Obat_M> getTransaksiObat(String kodeResep, String kodeObat) {
        con =  new connection();
        ObservableList<Obat_M> listTransaksiObat =  FXCollections.observableArrayList();
        try {
            String sql = "SELECT obat.nama_obat, obat.stok, obat.kode_obat FROM obat, resep_obat, resep WHERE resep.kode_resep = resep_obat.kode_resep AND obat.kode_obat = resep_obat.kode_obat AND resep.kode_resep = '"+kodeResep+"' AND obat.kode_obat ='"+kodeObat+"'";
            ResultSet rs = con.connect().createStatement().executeQuery(sql);
            while(rs.next()){
                Obat_M o = new Obat_M();
                o.setNamaObat(rs.getString(1));
                o.setStok(rs.getInt(2));
                o.setKodeObat(rs.getString(3));
                listTransaksiObat.add(o);
            }
        } catch (Exception e) {
             e.printStackTrace();
        }
        return listTransaksiObat;
    }

    @Override
    public ObservableList<Obat_M> getObat(String kodeObat) {
         con =  new connection();
        ObservableList<Obat_M> listObat =  FXCollections.observableArrayList();
        try {
            String sql = "select * from obat where kode_obat ='"+kodeObat+"'";
            ResultSet rs = con.connect().createStatement().executeQuery(sql);
            while(rs.next()){
                Obat_M obat = new Obat_M();
                obat.setKodeObat(rs.getString(1));
                obat.setNamaObat(rs.getString(2));
                obat.setKategoriObat(rs.getString(3));
                obat.setSubObat(rs.getString(4));
                obat.setKemasan(rs.getString(5));
                obat.sethargaObat(rs.getDouble(6));
                obat.setStok(rs.getInt(7));
                obat.setDeskripsi(rs.getString(8));
                listObat.add(obat);
            }
        } catch (Exception e) {
             e.printStackTrace();
        }
        return listObat;
    }

    @Override
    public ObservableList<Obat_M> getPengadaanObat() {
        con =  new connection();
        ObservableList<Obat_M> listObat =  FXCollections.observableArrayList();
        try {
            String sql = "select * from obat where stok < 15";
            ResultSet rs = con.connect().createStatement().executeQuery(sql);
            while(rs.next()){
                Obat_M obat = new Obat_M();
                obat.setKodeObat(rs.getString(1));
                obat.setNamaObat(rs.getString(2));
                obat.setKategoriObat(rs.getString(3));
                obat.setSubObat(rs.getString(4));
                obat.setKemasan(rs.getString(5));
                obat.sethargaObat(rs.getDouble(6));
                obat.setStok(rs.getInt(7));
                obat.setDeskripsi(rs.getString(8));
                listObat.add(obat);
            }
        } catch (Exception e) {
             e.printStackTrace();
        }
        return listObat;
    }

    @Override
    public ObservableList<Obat_M> getObatByNama(String namaObat) {
        con =  new connection();
        ObservableList<Obat_M> listObat =  FXCollections.observableArrayList();
        try {
            String sql = "select * from obat where nama_obat like '%"+namaObat+"%'";
            ResultSet rs = con.connect().createStatement().executeQuery(sql);
            while(rs.next()){
                Obat_M obat = new Obat_M();
                obat.setKodeObat(rs.getString(1));
                obat.setNamaObat(rs.getString(2));
                obat.setKategoriObat(rs.getString(3));
                obat.setSubObat(rs.getString(4));
                obat.setKemasan(rs.getString(5));
                obat.sethargaObat(rs.getDouble(6));
                obat.setStok(rs.getInt(7));
                obat.setDeskripsi(rs.getString(8));
                listObat.add(obat);
            }
        } catch (Exception e) {
             e.printStackTrace();
        }
        return listObat;
    }

    @Override
    public void insert(Obat_M obat) {
        con = new connection();
        PreparedStatement ps;
        try {
            ps = con.connect().prepareStatement("insert into obat values(?,?,?,?,?,?,?,?)");
            ps.setString(1, obat.getKodeObat());
            ps.setString(2, obat.getNamaObat());
            ps.setString(3, obat.getKategoriObat());
            ps.setString(4, obat.getSubObat());
            ps.setString(5, obat.getKemasan());
            ps.setDouble(6, obat.getHargaObat());
            ps.setInt(7, obat.getStok());
            ps.setString(8, obat.getDeskripsi());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Obat_M obat) {
         con =  new connection();
        PreparedStatement ps;
        try {
            ps = con.connect().prepareStatement("update obat set nama_obat=?, kategori_obat=?, sub_kategori=?, kemasan=?, harga=?, stok=?, keterangan=? where kode_obat = ?");
            ps.setString(8, obat.getKodeObat());
            ps.setString(1, obat.getNamaObat());
            ps.setString(2, obat.getKategoriObat());
            ps.setString(3, obat.getSubObat());
            ps.setString(4, obat.getKemasan());
            ps.setDouble(5, obat.getHargaObat());
            ps.setInt(6, obat.getStok());
            ps.setString(7, obat.getDeskripsi());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
            //Logger.getLogger(implBiodata.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void delete(Obat_M obat) {
        con = new connection();
        PreparedStatement ps;
        try {
            ps = con.connect().prepareStatement("delete from obat where kode_obat = ?");
            ps.setString(1, obat.getKodeObat());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
            //Logger.getLogger(implBiodata.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
}
