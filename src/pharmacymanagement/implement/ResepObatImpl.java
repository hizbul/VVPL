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
import pharmacymanagement.interfaces.ResepObatInter;
import pharmacymanagement.models.ResepObat_M;


/**
 *
 * @author drag me to hell
 */
public class ResepObatImpl implements ResepObatInter{
    connection con;
    @Override
    public ObservableList<ResepObat_M> getAllResepObat(String resepObat) {
        con =  new connection();
        ObservableList<ResepObat_M> listResepObat =  FXCollections.observableArrayList();
        try {
            String sql = "SELECT obat.nama_obat, obat.harga, resep_obat.qty, resep_obat.total_harga, resep_obat.kode_resep, resep_obat.kode_obat FROM obat, resep_obat, resep WHERE resep.kode_resep = resep_obat.kode_resep AND obat.kode_obat = resep_obat.kode_obat AND resep.kode_resep = '"+resepObat+"'";
            ResultSet rs = con.connect().createStatement().executeQuery(sql);
            while(rs.next()){
                ResepObat_M t = new ResepObat_M();
                t.setNamaObat(rs.getString(1));
                t.setHarga(rs.getDouble(2));
                t.setQty(rs.getInt(3));
                t.setTotalHarga(rs.getDouble(4));
                t.setKodeObat(rs.getString(5));
                t.setKodeResep(rs.getString(6));
                listResepObat.add(t);
            }
        } catch (Exception e) {
             e.printStackTrace();
        }
        return listResepObat;
    }

    @Override
    public void insert(ResepObat_M resepObat, String kodeObat, String kodeResep, double jumlahHarga) {
        con = new connection();
        PreparedStatement ps;
        try {
            ps = con.connect().prepareStatement("insert into resep_obat (qty, total_harga, kode_obat, kode_resep) values(?,?,?,?)");
            ps.setInt(1, resepObat.getQty());
            ps.setDouble(2, jumlahHarga);
            ps.setString(3, kodeObat);
            ps.setString(4, kodeResep);
            //ps.setString(5, resep.getIdPasien());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
