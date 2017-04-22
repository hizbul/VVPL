/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagement.implement;

import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pharmacymanagement.connections.connection;
import pharmacymanagement.interfaces.PasienInter;
import pharmacymanagement.models.Pasien_M;

/**
 *
 * @author drag me to hell
 */
public class PasienImpl implements PasienInter{
    connection con;
    @Override
    public ObservableList<Pasien_M> getPasien() {
        con =  new connection();
        ObservableList<Pasien_M> listGetPasien =  FXCollections.observableArrayList();
        try {
            String sql = "SELECT id_pasien, nama_pasien, umur from pasien";
            ResultSet rs = con.connect().createStatement().executeQuery(sql);
            while(rs.next()){
                Pasien_M p = new Pasien_M();
                p.setIdPasien(rs.getString(1));
                p.setNamaPasien(rs.getString(2));
                p.setUmur(rs.getInt(3));
                listGetPasien.add(p);
            }
        } catch (Exception e) {
             e.printStackTrace();
        }
        return listGetPasien;
    }
    
}
