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
public class obat_m {
    private final StringProperty kodeObat = new SimpleStringProperty();
    private final StringProperty namaObat = new SimpleStringProperty();
    private final StringProperty jenisObat = new SimpleStringProperty();
    private final DoubleProperty hargaObat = new SimpleDoubleProperty();
    private final IntegerProperty qty = new SimpleIntegerProperty();
    private final StringProperty keterangan = new SimpleStringProperty();
    
    public obat_m (){}
    
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
    
    public String getJenisObat() {
        return jenisObat.get();
    }
 
    public void setJenisObat(String value) {
        jenisObat.set(value);
    }
 
    public StringProperty jenisObatProperty() {
        return jenisObat;
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
    
    public int getQty() {
        return qty.get();
    }
 
    public void setQty(int value) {
        qty.set(value);
    }
 
    public IntegerProperty qtyProperty() {
        return qty;
    }
    
    public String getKeterangan() {
        return keterangan.get();
    }
 
    public void setKeterangan(String value) {
        keterangan.set(value);
    }
 
    public StringProperty keteranganProperty() {
        return keterangan;
    }
}
