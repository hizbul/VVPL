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
public class Obat_M {
    private final StringProperty kodeObat = new SimpleStringProperty();
    private final StringProperty namaObat = new SimpleStringProperty();
    private final StringProperty kategoriObat = new SimpleStringProperty();
    private final StringProperty subObat = new SimpleStringProperty();
    private final StringProperty kemasan = new SimpleStringProperty();
    private final DoubleProperty hargaObat = new SimpleDoubleProperty();
    private final IntegerProperty stok = new SimpleIntegerProperty();
    private final StringProperty deskripsi = new SimpleStringProperty();
    
    public Obat_M (){}
    
    
    
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
    
    public String getSubObat() {
        return subObat.get();
    }
 
    public void setSubObat(String value) {
        subObat.set(value);
    }
 
    public StringProperty subObatProperty() {
        return subObat;
    }
    
    public String getKemasan() {
        return kemasan.get();
    }
 
    public void setKemasan(String value) {
        kemasan.set(value);
    }
 
    public StringProperty kemasanProperty() {
        return kemasan;
    }
    
    public Double getHargaObat() {
        return hargaObat.get();
    }
 
    public void sethargaObat(Double value) {
        hargaObat.set(value);
    }
 
    public DoubleProperty hargaObatProperty() {
        return hargaObat;
    }
    
    public int getStok() {
        return stok.get();
    }
 
    public void setStok(int value) {
        stok.set(value);
    }
 
    public IntegerProperty stokProperty() {
        return stok;
    }
    
    public String getDeskripsi() {
        return deskripsi.get();
    }
 
    public void setDeskripsi(String value) {
        deskripsi.set(value);
    }
 
    public StringProperty deskripsiProperty() {
        return deskripsi;
    }
}
