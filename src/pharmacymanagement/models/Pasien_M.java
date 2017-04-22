/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagement.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author drag me to hell
 */
public class Pasien_M {
    private StringProperty idPasien = new SimpleStringProperty();
    private StringProperty namaPasien = new SimpleStringProperty();
    private StringProperty alamat = new SimpleStringProperty();
    private IntegerProperty umur = new SimpleIntegerProperty();
    private StringProperty jenisKelamin = new SimpleStringProperty();
    
    public Pasien_M(){}
    
    public String getIdPasien() {
        return idPasien.get();
    }

    public void setIdPasien(String value) {
        idPasien.set(value);
    }
    
    public StringProperty idPasienProperty() {
        return idPasien;
    }
    
    public String getNamaPasien() {
        return namaPasien.get();
    }

    public void setNamaPasien(String value) {
        namaPasien.set(value);
    }
    
    public StringProperty namaPasienProperty() {
        return namaPasien;
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
    
    public int getUmur() {
        return umur.get();
    }

    public void setUmur(int value) {
        umur.set(value);
    }
    
    public IntegerProperty umurProperty() {
        return umur;
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
}
