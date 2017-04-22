/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagement.interfaces;

import javafx.collections.ObservableList;
import pharmacymanagement.models.Account_M;

/**
 *
 * @author drag me to hell
 */
public interface AccountInter {
    void insert(Account_M akun);
    void delete(Account_M akun);
    void update(Account_M akun);
    ObservableList<Account_M> getAll();
    ObservableList<Account_M> likeByUsername(String a);
    
}
