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
public class ResepObat_M {
    private StringProperty kodeDokter = new SimpleStringProperty();
    private StringProperty kodeResep = new SimpleStringProperty();
    private IntegerProperty qty = new SimpleIntegerProperty();
    private DoubleProperty totalHarga = new SimpleDoubleProperty();
    private StringProperty namaObat = new SimpleStringProperty();
    private DoubleProperty harga = new SimpleDoubleProperty();
    private StringProperty kodeObat = new SimpleStringProperty();
    
    public ResepObat_M(){}
    
    public String getKodeDokter() {
        return kodeDokter.get();
    }

    public void setKodeDokter(String value) {
        kodeDokter.set(value);
    }
    
    public StringProperty kodeDokterProperty() {
        return kodeDokter;
    }
    
    public String getKodeResep() {
        return kodeResep.get();
    }

    public void setKodeResep(String value) {
        kodeResep.set(value);
    }
    
    public StringProperty kodeResepProperty() {
        return kodeResep;
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
    
    public double getTotalHarga() {
        return totalHarga.get();
    }

    public void setTotalHarga(double value) {
        totalHarga.set(value);
    }
    
    public DoubleProperty totalHargaProperty() {
        return totalHarga;
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
    
    public double getHarga() {
        return harga.get();
    }

    public void setHarga(double value) {
        harga.set(value);
    }
    
    public DoubleProperty hargaProperty() {
        return harga;
    }
    
    public String getKodeObat() {
        return kodeObat.get();
    }

    public void setKodeObat(String value) {
        kodeObat.set(value);
    }
    
    public StringProperty kodeObatProperty() {
        return kodeObat;
    }
}
