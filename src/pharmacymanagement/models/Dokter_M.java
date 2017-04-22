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
public class Dokter_M {
    private final StringProperty kodeDokter = new SimpleStringProperty();
    private final StringProperty namaDokter = new SimpleStringProperty();
    private final StringProperty spesialis = new SimpleStringProperty();
    private final StringProperty alamat = new SimpleStringProperty();
    private final StringProperty jenisKelamin = new SimpleStringProperty();
    private final StringProperty kodeAccount = new SimpleStringProperty();
    
    public Dokter_M(){}
    
    public String getKodeDokter() {
        return kodeDokter.get();
    }
 
    public void setKodeDokter(String value) {
        kodeDokter.set(value);
    }
 
    public StringProperty kodeDokterProperty() {
        return kodeDokter;
    }
    
    public String getNamaDokter() {
        return namaDokter.get();
    }
 
    public void setNamaDokter(String value) {
        namaDokter.set(value);
    }
 
    public StringProperty namaDokterProperty() {
        return namaDokter;
    }
    
    public String getSpesialis() {
        return spesialis.get();
    }
 
    public void setSpesialis(String value) {
        spesialis.set(value);
    }
 
    public StringProperty spesialisProperty() {
        return spesialis;
    }
    
    public String getAlamat() {
        return alamat.get();
    }
 
    public void setAlamat(String value) {
        alamat.set(value);
    }
 
    public StringProperty alamatProperty() {
        return alamat;
    }
    
    public String getJenisKelamin() {
        return jenisKelamin.get();
    }
 
    public void setJenisKelamin(String value) {
        jenisKelamin.set(value);
    }
 
    public StringProperty jenisKelaminProperty() {
        return jenisKelamin;
    }
    
    public String getKodeAccount() {
        return kodeAccount.get();
    }
 
    public void setKodeAccount(String value) {
        kodeAccount.set(value);
    }
 
    public StringProperty kodeAccountProperty() {
        return kodeAccount;
    }
}
