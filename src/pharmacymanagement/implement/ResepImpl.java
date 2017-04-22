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
import pharmacymanagement.interfaces.ResepInter;
import pharmacymanagement.models.Resep_M;

/**
 *
 * @author drag me to hell
 */
public class ResepImpl implements ResepInter {

    connection con;

    @Override
    public void insert(Resep_M resep) {
        con = new connection();
        PreparedStatement ps;
        try {
            ps = con.connect().prepareStatement("insert into resep (kode_resep, kode_dokter, pathResep, `status`) values(?,?,?,?)");
            ps.setString(1, resep.getKodeResep());
            ps.setString(2, resep.getKodeDokter());
            ps.setString(3, resep.getPathResep());
            ps.setString(4, resep.getStatus());
            //ps.setString(5, resep.getIdPasien());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ObservableList<Resep_M> tampilResep() {
        con =  new connection();
        ObservableList<Resep_M> listResep =  FXCollections.observableArrayList();
        try {
            String sql = "SELECT resep.kode_resep, dokter.nama_dokter, dokter.spesialis, resep.status from resep, dokter, pasien where resep.kode_dokter = dokter.kode_dokter group by resep.kode_resep order by resep.status";
            ResultSet rs = con.connect().createStatement().executeQuery(sql);
            while(rs.next()){
                Resep_M resep = new Resep_M();
                resep.setKodeResep(rs.getString(1));
                resep.setNamaDokter(rs.getString(2));
                resep.setSpesialis(rs.getString(3));
                resep.setStatus(rs.getString(4));
                listResep.add(resep);
            }
        } catch (Exception e) {
             e.printStackTrace();
        }
        return listResep;
    }

    @Override
    public void update(Resep_M resep, String kodePasien, String kodeResep) {
        con =  new connection();
        PreparedStatement ps;
        try {
            ps = con.connect().prepareStatement("UPDATE resep SET status = 'Sudah dilayani', id_pasien = ? WHERE resep.kode_resep = '"+kodeResep+"'");
            //ps.setString(2, kodeResep);
            ps.setString(1, kodePasien);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
            //Logger.getLogger(implBiodata.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public ObservableList<Resep_M> tampilResepPasien(String kodeResep) {
        con =  new connection();
        ObservableList<Resep_M> listResep =  FXCollections.observableArrayList();
        try {
            String sql = "SELECT resep.kode_resep, dokter.nama_dokter, dokter.spesialis, resep.status, pasien.id_pasien, pasien.nama_pasien, pasien.umur, resep.pathResep from resep, dokter, pasien where resep.kode_dokter = dokter.kode_dokter and pasien.id_pasien = resep.id_pasien and resep.kode_resep = '"+kodeResep+"' group by resep.kode_resep";
            ResultSet rs = con.connect().createStatement().executeQuery(sql);
            while(rs.next()){
                Resep_M resep = new Resep_M();
                resep.setKodeResep(rs.getString(1));
                resep.setNamaDokter(rs.getString(2));
                resep.setSpesialis(rs.getString(3));
                resep.setStatus(rs.getString(4));
                resep.setIdPasien(rs.getString(5));
                resep.setNamaPasien(rs.getString(6));
                resep.setumur(rs.getInt(7));
                resep.setPathResep(rs.getString(8));
                listResep.add(resep);
            }
        } catch (Exception e) {
             e.printStackTrace();
        }
        return listResep;
    }

    @Override
    public ObservableList<Resep_M> tampilResepByNamaPasien(String namaPasien) {
        con =  new connection();
        ObservableList<Resep_M> listResep =  FXCollections.observableArrayList();
        try {
            String sql = "SELECT resep.kode_resep, dokter.nama_dokter, dokter.spesialis, resep.status, pasien.nama_pasien FROM resep, dokter, pasien WHERE resep.kode_dokter = dokter.kode_dokter AND pasien.id_pasien = resep.id_pasien AND pasien.nama_pasien LIKE '%"+namaPasien+"%' GROUP BY resep.kode_resep ORDER BY resep.status";
            ResultSet rs = con.connect().createStatement().executeQuery(sql);
            while(rs.next()){
                Resep_M resep = new Resep_M();
                resep.setKodeResep(rs.getString(1));
                resep.setNamaDokter(rs.getString(2));
                resep.setSpesialis(rs.getString(3));
                resep.setStatus(rs.getString(4));
                listResep.add(resep);
            }
        } catch (Exception e) {
             e.printStackTrace();
        }
        return listResep;
    }

}
