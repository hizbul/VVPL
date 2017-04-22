/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagement.fxml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import pharmacymanagement.PharmacyManagement;

/**
 * FXML Controller class
 *
 * @author drag me to hell
 */
public class DokterLayoutController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private PharmacyManagement mainApp;
    String namaDokter;
    String spesialis;

    public void setMainApp(PharmacyManagement mainApp) {
       this.mainApp = mainApp;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }    

    @FXML
    private void gotoLogout(ActionEvent event) throws IOException {
        mainApp.initLoginLayout();
    }

    @FXML
    private void gotoAddResep(ActionEvent event) throws IOException {
        mainApp.showAddResep();
    }
    
}
