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
public class Resep_M {
    private StringProperty kodeDokter = new SimpleStringProperty();
    private StringProperty kodeResep = new SimpleStringProperty();
    private StringProperty pathResep = new SimpleStringProperty();
    private StringProperty status = new SimpleStringProperty();
    private StringProperty idPasien = new SimpleStringProperty();
    
    private StringProperty namaDokter = new SimpleStringProperty();
    private StringProperty spesialis = new SimpleStringProperty();
    private StringProperty namapasien = new SimpleStringProperty();
    private IntegerProperty umur = new SimpleIntegerProperty();
    
    public Resep_M(){}

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

    public String getPathResep() {
        return pathResep.get();
    }

    public void setPathResep(String value) {
       pathResep.set(value);
    }
    
    public StringProperty pathresepProperty() {
        return pathResep;
    }

    public String getStatus() {
        return status.get();
    }

    public void setStatus(String value) {
        status.set(value);
    }
    
    public StringProperty statusProperty() {
        return status;
    }

    public String getIdPasien() {
        return idPasien.get();
    }

    public void setIdPasien(String value) {
        idPasien.set(value);
    }
    
    public StringProperty idPasienProperty() {
        return idPasien;
    }
    
    //############################################################
    
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
    
    public String getNamaPasien() {
        return namapasien.get();
    }

    public void setNamaPasien(String value) {
        namapasien.set(value);
    }
    
    public StringProperty namaPasienProperty() {
        return namapasien;
    }
    
    public int getUmur() {
        return umur.get();
    }

    public void setumur(int value) {
        umur.set(value);
    }
    
    public IntegerProperty umurProperty() {
        return umur;
    }
    
}
