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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author drag me to hell
 */
public class ListResepController implements Initializable {
    @FXML
    private Tab tabResep;
    @FXML
    private TableView<?> tableListResep;
    @FXML
    private TableColumn<?, ?> columnKodeResep;
    @FXML
    private TableColumn<?, ?> columnNamaResep;
    @FXML
    private TableColumn<?, ?> columnSpesialis;
    @FXML
    private TableColumn<?, ?> columnStatus;
    @FXML
    private Button btnLayani;
    @FXML
    private TextField inSearchResep;
    @FXML
    private Tab tabAddResep;
    @FXML
    private ChoiceBox<?> inIdPasien;
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
    private TableView<?> tablePilihanObat;
    @FXML
    private TableColumn<?, ?> columnNamaObat;
    @FXML
    private TableColumn<?, ?> columnHarga;
    @FXML
    private TableColumn<?, ?> columnQty;
    @FXML
    private Button btnPilihObat;
    @FXML
    private Button btnAddTransaksi;
    @FXML
    private Button btnCancelTransaksi;
    @FXML
    private Tab tabPilihObat;
    @FXML
    private TableView<?> tablePilihObat;
    @FXML
    private TableColumn<?, ?> columnKodeObat;
    @FXML
    private TableColumn<?, ?> columnNama;
    @FXML
    private TableColumn<?, ?> columnKategori;
    @FXML
    private TableColumn<?, ?> columnSub;
    @FXML
    private TableColumn<?, ?> columnKemasan;
    @FXML
    private TableColumn<?, ?> columnHargaObat;
    @FXML
    private TableColumn<?, ?> columnStok;
    @FXML
    private TableColumn<?, ?> columnKeterangan;
    @FXML
    private Button btnAddObat;
    @FXML
    private Button btnSelesai;
    @FXML
    private TextField inSearchObat;

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
    private void inSearchResepAction(KeyEvent event) {
    }

    @FXML
    private void btnPilihObatAction(ActionEvent event) {
    }

    @FXML
    private void btnAddTransaksiAction(ActionEvent event) {
    }

    @FXML
    private void btnCancelTransaksiAction(ActionEvent event) {
    }

    @FXML
    private void btnAddObatAction(ActionEvent event) {
    }

    @FXML
    private void btnSelesaiAction(ActionEvent event) {
    }

    @FXML
    private void inSearchObatAction(KeyEvent event) {
    }
    
}
