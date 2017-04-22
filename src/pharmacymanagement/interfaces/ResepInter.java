/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagement.interfaces;

import javafx.collections.ObservableList;
import pharmacymanagement.models.Resep_M;

/**
 *
 * @author drag me to hell
 */
public interface ResepInter {
    void insert(Resep_M resep);
    ObservableList<Resep_M> tampilResep();
    ObservableList<Resep_M> tampilResepPasien(String kodeResep);
    void update(Resep_M resep, String kodePasien, String kodeResep);
    ObservableList<Resep_M> tampilResepByNamaPasien(String namaPasien);
}
