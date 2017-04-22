/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagement.interfaces;

import javafx.collections.ObservableList;
import pharmacymanagement.models.Dokter_M;
import pharmacymanagement.models.Login_M;

/**
 *
 * @author drag me to hell
 */
public interface LoginInter {
    ObservableList<Login_M> login(String username, String password);
    ObservableList<Dokter_M> getDokter(String kodeAccount);
}
