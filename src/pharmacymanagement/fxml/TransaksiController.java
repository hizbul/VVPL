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
public class TransaksiController implements Initializable {
    @FXML
    private TableView<?> tableTransaksi;
    @FXML
    private TableColumn<?, ?> columnKodeResep;
    @FXML
    private TableColumn<?, ?> columnDokter;
    @FXML
    private TableColumn<?, ?> columnSpesialis;
    @FXML
    private TableColumn<?, ?> columnStatus;
    @FXML
    private TextField inSearchTransaksi;
    @FXML
    private Button btnLayani;
    @FXML
    private TextField inIDPasien;
    @FXML
    private TextField inNamaPasien;
    @FXML
    private TextField inUmur;
    @FXML
    private TextField inNamaDokter;
    @FXML
    private TextField inSpesialis;
    @FXML
    private TextField inKodeResep;
    @FXML
    private TableView<?> tableObat;
    @FXML
    private TableColumn<?, ?> columnNamaObat;
    @FXML
    private TableColumn<?, ?> columnHarga;
    @FXML
    private TableColumn<?, ?> columnQty;
    @FXML
    private TableColumn<?, ?> columnTotal;
    @FXML
    private Button btnBayar;
    @FXML
    private Button tbnBatal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnLayaniAction(ActionEvent event) {
    }

    @FXML
    private void btnBayarAction(ActionEvent event) {
    }

    @FXML
    private void btnBatalAction(ActionEvent event) {
    }
    
}
