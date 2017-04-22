/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagement.models;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author drag me to hell
 */
public class PemusnahanObat_M {
    private final StringProperty kodeObat = new SimpleStringProperty();
    private final StringProperty namaObat = new SimpleStringProperty();
    private final StringProperty kategoriObat = new SimpleStringProperty();
    private final StringProperty tanggalPemusnahan = new SimpleStringProperty();
    private final IntegerProperty jmlPemusnahan = new SimpleIntegerProperty();
    
    public PemusnahanObat_M (){}
    
    
    
    public String getKodeObat() {
        return kodeObat.get();
    }
 
    public void setKodeObat(String value) {
        kodeObat.set(value);
    }
 
    public StringProperty kodeObatProperty() {
        return kodeObat;
    }
    
    public String getNamaObat() {
        return namaObat.get();
    }
 
    public void setNamaObat(String value) {
        namaObat.set(value);
    }
 
    public StringProperty namaObatProperty() {
        return namaObat;
    }
    
    public String getKategoriObat() {
        return kategoriObat.get();
    }
 
    public void setKategoriObat(String value) {
        kategoriObat.set(value);
    }
 
    public StringProperty kategoriObatProperty() {
        return kategoriObat;
    }
    
    public String getTanggalPemusnahan() {
        return tanggalPemusnahan.get();
    }
 
    public void setTanggalPemusnahan(String value) {
        tanggalPemusnahan.set(value);
    }
 
    public StringProperty tanggalPemusnahanProperty() {
        return tanggalPemusnahan;
    }
    
    public int getJmlPemusnahan() {
        return jmlPemusnahan.get();
    }
 
    public void setJmlPemusnahan(int value) {
        jmlPemusnahan.set(value);
    }
 
    public IntegerProperty jmlPemusnahanProperty() {
        return jmlPemusnahan;
    }
}
