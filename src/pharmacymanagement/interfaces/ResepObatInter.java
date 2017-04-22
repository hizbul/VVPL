/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagement.interfaces;

import javafx.collections.ObservableList;
import pharmacymanagement.models.ResepObat_M;

/**
 *
 * @author drag me to hell
 */
public interface ResepObatInter {
    ObservableList<ResepObat_M> getAllResepObat(String resepObat);
    void insert(ResepObat_M resepObat, String kodeObat, String kodeResep, double jumlahHarga);
}
