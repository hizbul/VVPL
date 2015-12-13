/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagement.fxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author drag me to hell
 */
public class PemusnahanObatController implements Initializable {
    @FXML
    private TableView<?> tableObat;
    @FXML
    private TableColumn<?, ?> columnKodeObat;
    @FXML
    private TableColumn<?, ?> columnNamaObat;
    @FXML
    private TableColumn<?, ?> columnKategori;
    @FXML
    private TableColumn<?, ?> columnSubKategori;
    @FXML
    private TableColumn<?, ?> columnStok;
    @FXML
    private TextField inSearch;
    @FXML
    private TextField inKodeObat;
    @FXML
    private TextField inNamaObat;
    @FXML
    private TextField inKategori;
    @FXML
    private TextField inSubKategori;
    @FXML
    private TextField inJmlPemusnahan;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnCancel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnSaveAction(ActionEvent event) {
    }

    @FXML
    private void btnCancelAction(ActionEvent event) {
    }
    
}
