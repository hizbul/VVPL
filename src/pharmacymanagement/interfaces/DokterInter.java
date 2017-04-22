/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagement.interfaces;

import javafx.collections.ObservableList;
import pharmacymanagement.models.Dokter_M;

/**
 *
 * @author drag me to hell
 */
public interface DokterInter {
    void insert(Dokter_M dokter);
    void delete(Dokter_M dokter);
    void update(Dokter_M dokter);
    void updateAkunDokter(String kodeDokter, String kodeAkun);
    ObservableList<Dokter_M> getAll();
    ObservableList<Dokter_M> getDokter();
    ObservableList<Dokter_M> getAccount(String a);
    ObservableList<Dokter_M> likeByNama(String a);
}
