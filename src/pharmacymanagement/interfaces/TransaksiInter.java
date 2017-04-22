/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagement.interfaces;

import javafx.collections.ObservableList;
import pharmacymanagement.models.ResepObat_M;
import pharmacymanagement.models.Transaksi_M;

/**
 *
 * @author drag me to hell
 */
public interface TransaksiInter {
    ObservableList<Transaksi_M> tampilTransaksi();
    ObservableList<Transaksi_M> transaksi(String kodeResep);
    ObservableList<ResepObat_M> getTransaksiResepObat(String resepObat);
    void insert(Transaksi_M transaksi);
    void update(Transaksi_M transaksi, int kodeTransaksi);
    ObservableList<Transaksi_M> transaksiByNama(String namaPasien);
}
