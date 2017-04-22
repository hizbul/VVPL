/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagement.interfaces;

import javafx.collections.ObservableList;
import pharmacymanagement.models.PemusnahanObat_M;

/**
 *
 * @author drag me to hell
 */
public interface PemusnahanInter {
    void insert(PemusnahanObat_M po);
    ObservableList<PemusnahanObat_M> tampilPemusnahan();
    ObservableList<PemusnahanObat_M> tampilPemusnahanByNamaObat(String namaObat);
}
