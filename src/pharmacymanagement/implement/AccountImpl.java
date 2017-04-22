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
import pharmacymanagement.interfaces.AccountInter;
import pharmacymanagement.models.Account_M;
import pharmacymanagement.models.Dokter_M;

/**
 *
 * @author drag me to hell
 */
public class AccountImpl implements AccountInter{
    connection con;
    @Override
    public void insert(Account_M akun) {
        con = new connection();
        PreparedStatement ps;
        try {
            ps = con.connect().prepareStatement("insert into account (kode_account, username, password, jabatan) values(?,?,?,?)");
            ps.setString(1, akun.getKodeAccount());
            ps.setString(2, akun.getUsername());
            ps.setString(3, akun.getPassword());
            ps.setString(4, akun.getJabatan());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Account_M akun) {
        con = new connection();
        PreparedStatement ps;
        try {
            ps = con.connect().prepareStatement("delete from account where kode_account = ?");
            ps.setString(1, akun.getKodeAccount());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
            //Logger.getLogger(implBiodata.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void update(Account_M akun) {
        con =  new connection();
        PreparedStatement ps;
        try {
            ps = con.connect().prepareStatement("update account set username=?, password=?, jabatan=? where kode_account = ?");
            ps.setString(4, akun.getKodeAccount());
            ps.setString(1, akun.getUsername());
            ps.setString(2, akun.getPassword());
            ps.setString(3, akun.getJabatan());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
            //Logger.getLogger(implBiodata.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public ObservableList<Account_M> getAll() {
        con =  new connection();
        ObservableList<Account_M> listAccount =  FXCollections.observableArrayList();
        try {
            String sql = "select kode_account, username, password, jabatan from account";
            ResultSet rs = con.connect().createStatement().executeQuery(sql);
            while(rs.next()){
                Account_M d = new Account_M();
                d.setKodeAccount(rs.getString(1));
                d.setUsername(rs.getString(2));
                d.setPassword(rs.getString(3));
                d.setJabatan(rs.getString(4));
                listAccount.add(d);
            }
        } catch (Exception e) {
             e.printStackTrace();
        }
        return listAccount;
    }

    @Override
    public ObservableList<Account_M> likeByUsername(String a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
