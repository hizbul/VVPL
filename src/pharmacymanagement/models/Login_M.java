/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagement.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author drag me to hell
 */
public class Login_M {
    private final StringProperty kodeAccount = new SimpleStringProperty();
    private final StringProperty username = new SimpleStringProperty();
    private final StringProperty password = new SimpleStringProperty();
    private final StringProperty jabatan = new SimpleStringProperty();
    
    public Login_M(){}
    
    public String getKodeAccount() {
        return kodeAccount.get();
    }
 
    public void setKodeAccount(String value) {
        kodeAccount.set(value);
    }
 
    public StringProperty kodeAccountProperty() {
        return kodeAccount;
    }
    
    public String getUsername(){
        return username.get();
    }
    
    public void setUsername(String value){
        username.set(value);
    }
    
    public  StringProperty usernameProperty(){
        return username;
    }
    
    public String getPassword(){
        return password.get();
    }
    
    public void setPassword(String value){
        password.set(value);
    }
    
    public StringProperty passwordProperty(){
        return password;
    }
    
    public String getJabatan(){
        return jabatan.get();
    }
    
    public void setJabatan(String value){
        jabatan.set(value);
    }
    
    public StringProperty jabatanProperty(){
        return jabatan;
    }
}
