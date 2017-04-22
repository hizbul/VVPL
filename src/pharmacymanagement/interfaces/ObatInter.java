/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagement.interfaces;

import javafx.collections.ObservableList;
import pharmacymanagement.models.Obat_M;
import pharmacymanagement.models.ResepObat_M;

/**
 *
 * @author drag me to hell
 */
public interface ObatInter {

    public ObservableList<Obat_M> getAllObat();
    public ObservableList<Obat_M> getObat(String kodeObat);
    void updateStok(Obat_M obat, int qty, String kodeObat);
    public ObservableList<Obat_M> getTransaksiObat(String kodeResep, String kodeObat);
    public ObservableList<Obat_M> getPengadaanObat();
    public ObservableList<Obat_M> getObatByNama(String namaObat);
    void insert(Obat_M obat);
    void update(Obat_M obat);
    void delete(Obat_M obat);
}
