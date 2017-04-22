/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagement.models;

import java.time.LocalDate;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author drag me to hell
 */
public class Transaksi_M {
    private StringProperty kodeDokter = new SimpleStringProperty();
    private StringProperty kodeResep = new SimpleStringProperty();
    private StringProperty pathResep = new SimpleStringProperty();
    private StringProperty status = new SimpleStringProperty();
    private StringProperty idPasien = new SimpleStringProperty();
    
    private StringProperty namaDokter = new SimpleStringProperty();
    private StringProperty spesialis = new SimpleStringProperty();
    private StringProperty namapasien = new SimpleStringProperty();
    private IntegerProperty umur = new SimpleIntegerProperty();
    
    private IntegerProperty kodeTransaksi = new SimpleIntegerProperty();
    
    private StringProperty tanggalTransaksi = new SimpleStringProperty();
    private DoubleProperty totalPembayaran = new SimpleDoubleProperty();
    
    public Transaksi_M(){}

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
    
    public int getKodeTransaksi() {
        return kodeTransaksi.get();
    }

    public void setKodeTransaksi(int value) {
        kodeTransaksi.set(value);
    }
    
    public IntegerProperty kodeTransaksiProperty() {
        return kodeTransaksi;
    }
    
    public String getTanggalTransaksi() {
        return tanggalTransaksi.get();
    }

    public void setTanggalTransaksi(String value) {
        tanggalTransaksi.set(value);
    }
    
    public StringProperty tanggalTransaksiProperty() {
        return tanggalTransaksi;
    }
    
    public double getTotalPembayaran() {
        return totalPembayaran.get();
    }

    public void setTotalPembayaran(double value) {
        totalPembayaran.set(value);
    }
    
    public DoubleProperty totalPembayaranProperty() {
        return totalPembayaran;
    }
}
