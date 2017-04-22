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
import pharmacymanagement.interfaces.PemusnahanInter;
import pharmacymanagement.models.PemusnahanObat_M;

/**
 *
 * @author drag me to hell
 */
public class PemusnahanImpl implements PemusnahanInter{

    connection con;
    
    @Override
    public void insert(PemusnahanObat_M po) {
        con = new connection();
        PreparedStatement ps;
        try {
            ps = con.connect().prepareStatement("insert into pemusnahan_obat (kode_obat, tgl_pemusnahan, jumlah) values(?,?,?)");
            ps.setString(1, po.getKodeObat());
            ps.setString(2, po.getTanggalPemusnahan());
            ps.setInt(3, po.getJmlPemusnahan());
            //ps.setString(5, resep.getIdPasien());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ObservableList<PemusnahanObat_M> tampilPemusnahan() {
        con =  new connection();
        ObservableList<PemusnahanObat_M> listPemusnahan =  FXCollections.observableArrayList();
        try {
            String sql = "SELECT pemusnahan_obat.kode_obat, obat.nama_obat, obat.kategori_obat, pemusnahan_obat.tgl_pemusnahan, pemusnahan_obat.jumlah from obat, pemusnahan_obat where obat.kode_obat = pemusnahan_obat.kode_obat";
            ResultSet rs = con.connect().createStatement().executeQuery(sql);
            while(rs.next()){
                PemusnahanObat_M po = new PemusnahanObat_M();
                po.setKodeObat(rs.getString(1));
                po.setNamaObat(rs.getString(2));
                po.setKategoriObat(rs.getString(3));
                po.setTanggalPemusnahan(rs.getString(4));
                po.setJmlPemusnahan(rs.getInt(5));
                listPemusnahan.add(po);
            }
        } catch (Exception e) {
             e.printStackTrace();
        }
        return listPemusnahan;
    }

    @Override
    public ObservableList<PemusnahanObat_M> tampilPemusnahanByNamaObat(String namaObat) {
        con =  new connection();
        ObservableList<PemusnahanObat_M> listPemusnahan =  FXCollections.observableArrayList();
        try {
            String sql = "SELECT pemusnahan_obat.kode_obat, obat.nama_obat, obat.kategori_obat, pemusnahan_obat.tgl_pemusnahan, pemusnahan_obat.jumlah from obat, pemusnahan_obat where obat.kode_obat = pemusnahan_obat.kode_obat AND obat.nama_obat like'%"+namaObat+"%'";
            ResultSet rs = con.connect().createStatement().executeQuery(sql);
            while(rs.next()){
                PemusnahanObat_M po = new PemusnahanObat_M();
                po.setKodeObat(rs.getString(1));
                po.setNamaObat(rs.getString(2));
                po.setKategoriObat(rs.getString(3));
                po.setTanggalPemusnahan(rs.getString(4));
                po.setJmlPemusnahan(rs.getInt(5));
                listPemusnahan.add(po);
            }
        } catch (Exception e) {
             e.printStackTrace();
        }
        return listPemusnahan;
    }
    
}
