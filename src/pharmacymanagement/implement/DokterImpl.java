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
import pharmacymanagement.interfaces.DokterInter;
import pharmacymanagement.models.Dokter_M;

/**
 *
 * @author drag me to hell
 */
public class DokterImpl implements DokterInter{
    connection con;
    @Override
    public void insert(Dokter_M dokter) {
        con = new connection();
        PreparedStatement ps;
        try {
            ps = con.connect().prepareStatement("insert into dokter (kode_dokter, nama_dokter, spesialis, alamat, jenis_kelamin) values(?,?,?,?,?)");
            ps.setString(1, dokter.getKodeDokter());
            ps.setString(2, dokter.getNamaDokter());
            ps.setString(3, dokter.getSpesialis());
            ps.setString(4, dokter.getAlamat());
            ps.setString(5, dokter.getJenisKelamin());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Dokter_M dokter) {
        con = new connection();
        PreparedStatement ps;
        try {
            ps = con.connect().prepareStatement("delete from dokter where kode_dokter = ?");
            ps.setString(1, dokter.getKodeDokter());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
            //Logger.getLogger(implBiodata.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void update(Dokter_M dokter) {
        con =  new connection();
        PreparedStatement ps;
        try {
            ps = con.connect().prepareStatement("update dokter set nama_dokter=?, spesialis=?, alamat=?, jenis_kelamin=? where kode_dokter = ?");
            ps.setString(5, dokter.getKodeDokter());
            ps.setString(1, dokter.getNamaDokter());
            ps.setString(2, dokter.getSpesialis());
            ps.setString(3, dokter.getAlamat());
            ps.setString(4, dokter.getJenisKelamin());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
            //Logger.getLogger(implBiodata.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public ObservableList<Dokter_M> getAll() {
        con =  new connection();
        ObservableList<Dokter_M> listDokter =  FXCollections.observableArrayList();
        try {
            String sql = "select kode_dokter, nama_dokter, spesialis, alamat, jenis_kelamin from dokter";
            ResultSet rs = con.connect().createStatement().executeQuery(sql);
            while(rs.next()){
                Dokter_M d = new Dokter_M();
                d.setKodeDokter(rs.getString(1));
                d.setNamaDokter(rs.getString(2));
                d.setSpesialis(rs.getString(3));
                d.setAlamat(rs.getString(4));
                d.setJenisKelamin(rs.getString(5));
                listDokter.add(d);
            }
        } catch (Exception e) {
             e.printStackTrace();
        }
        return listDokter;
    }

    @Override
    public ObservableList<Dokter_M> likeByNama(String a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObservableList<Dokter_M> getAccount(String a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObservableList<Dokter_M> getDokter() {
        con =  new connection();
        ObservableList<Dokter_M> listDokter =  FXCollections.observableArrayList();
        try {
            String sql = "select kode_dokter, nama_dokter from dokter where kode_account is null";
            ResultSet rs = con.connect().createStatement().executeQuery(sql);
            while(rs.next()){
                Dokter_M d = new Dokter_M();
                d.setKodeDokter(rs.getString(1));
                d.setNamaDokter(rs.getString(2));
                listDokter.add(d);
            }
        } catch (Exception e) {
             e.printStackTrace();
        }
        return listDokter;
    }

    @Override
    public void updateAkunDokter(String kodeDokter, String kodeAkun) {
         con =  new connection();
        PreparedStatement ps;
        try {
            ps = con.connect().prepareStatement("update dokter set kode_account='"+kodeAkun+"' where dokter.kode_dokter = '"+kodeDokter+"'");
//            ps.setString(5, dokter.getKodeDokter());
//            ps.setString(1, dokter.getNamaDokter());
//            ps.setString(2, dokter.getSpesialis());
//            ps.setString(3, dokter.getAlamat());
//            ps.setString(4, dokter.getJenisKelamin());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
            //Logger.getLogger(implBiodata.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
}
