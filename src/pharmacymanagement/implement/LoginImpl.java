/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagement.implement;

import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pharmacymanagement.connections.connection;
import pharmacymanagement.interfaces.LoginInter;
import pharmacymanagement.models.Dokter_M;
import pharmacymanagement.models.Login_M;

/**
 *
 * @author drag me to hell
 */
public class LoginImpl implements LoginInter{
    connection con;
    @Override
    public ObservableList<Login_M> login(String username, String password) {
        
        con = new connection();
        ObservableList<Login_M> listAccount = FXCollections.observableArrayList();
        try {
            String sql = "select * from account where username ='"+username+"' and password ='"+password+"'";
            ResultSet rs = con.connect().createStatement().executeQuery(sql);
            while (rs.next()) {   
                Login_M m = new Login_M();
                m.setKodeAccount(rs.getString(1));
                m.setUsername(rs.getString(2));
                m.setPassword(rs.getString(3));
                m.setJabatan(rs.getString(4));
                listAccount.add(m);
            }
        } catch (Exception ex) {
            Logger.getLogger(LoginImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listAccount;
    }

    @Override
    public ObservableList<Dokter_M> getDokter(String kodeAccount) {
        con = new connection();
        ObservableList<Dokter_M> listDokter = FXCollections.observableArrayList();
        try {
            String sql = "SELECT kode_dokter, dokter.nama_dokter, dokter.spesialis, alamat, jenis_kelamin, dokter.kode_account FROM dokter, account WHERE dokter.kode_account = '"+kodeAccount+"' AND dokter.kode_account = account.kode_account";
            ResultSet rs = con.connect().createStatement().executeQuery(sql);
            while (rs.next()) {   
                Dokter_M d = new Dokter_M();
                d.setKodeDokter(rs.getString(1));
                d.setNamaDokter(rs.getString(2));
                d.setSpesialis(rs.getString(3));
                d.setAlamat(rs.getString(4));
                d.setJenisKelamin(rs.getString(5));
                d.setKodeAccount(rs.getString(6));
                listDokter.add(d);
            }
        } catch (Exception ex) {
            Logger.getLogger(LoginImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listDokter;
    }
    
    
}
