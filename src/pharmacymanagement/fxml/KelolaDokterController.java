/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagement.fxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import pharmacymanagement.PharmacyManagement;
import pharmacymanagement.implement.DokterImpl;
import pharmacymanagement.interfaces.DokterInter;
import pharmacymanagement.models.Dokter_M;
import pharmacymanagement.models.Obat_M;

/**
 * FXML Controller class
 *
 * @author drag me to hell
 */
public class KelolaDokterController implements Initializable {
    @FXML
    private TextField inKode;
    @FXML
    private TextField inNama;
    @FXML
    private TextField inSpesialis;
    @FXML
    private TextArea inAlamat;
    @FXML
    private ChoiceBox<String> inJenisKelamin;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnEdit;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnNew;
    @FXML
    private TableView<Dokter_M> tableDokter;
    @FXML
    private TableColumn<Dokter_M, String> columnKode;
    @FXML
    private TableColumn<Dokter_M, String> columnNama;
    @FXML
    private TableColumn<Dokter_M, String> columnSpesialis;
    @FXML
    private TableColumn<Dokter_M, String> columnAlamat;
    @FXML
    private TableColumn<Dokter_M, String> columnJenisKelamin;
    @FXML
    private TextField inSearch;

    /**
     * Initializes the controller class.
     */
    private PharmacyManagement mainApp;
    DokterInter crudDokter = new DokterImpl();
    ObservableList<Dokter_M> listDokter;
    private String StatusKode;
    
    public void setMainApp(PharmacyManagement mainApp) {
       this.mainApp = mainApp;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        columnKode.setCellValueFactory((TableColumn.CellDataFeatures<Dokter_M, String> cellData) ->
                        cellData.getValue().kodeDokterProperty());
        columnNama.setCellValueFactory((TableColumn.CellDataFeatures<Dokter_M, String> cellData) ->
                        cellData.getValue().namaDokterProperty());
        columnSpesialis.setCellValueFactory((TableColumn.CellDataFeatures<Dokter_M, String> cellData) ->
                        cellData.getValue().spesialisProperty());
        columnAlamat.setCellValueFactory((TableColumn.CellDataFeatures<Dokter_M, String> cellData) ->
                        cellData.getValue().alamatProperty());
        columnJenisKelamin.setCellValueFactory((TableColumn.CellDataFeatures<Dokter_M, String> cellData) ->
                        cellData.getValue().jenisKelaminProperty());
        listDokter = FXCollections.observableArrayList();
        listDokter = crudDokter.getAll();
        tableDokter.setItems(listDokter);
        initChoiceBoxJenisKelamin();
        StatusKode = "0";
        btnEdit.setDisable(true);
        btnDelete.setDisable(true);
        btnSave.setDisable(true);
        setFormAccess(false);
    }    
    
    private void setFormAccess(boolean access) {
      inKode.setDisable(!access);
      inNama.setEditable(access);
      inSpesialis.setEditable(access);
      inAlamat.setEditable(access);
      inJenisKelamin.setDisable(!access);
      btnSave.setDisable(!access);
      tableDokter.setDisable(access);
   }
    
    public void clear(){
        inKode.setText(null);
        inNama.setText(null);
        inSpesialis.setText(null);
        inAlamat.setText(null);
        inJenisKelamin.getSelectionModel().selectFirst();
    }
    
    private void initChoiceBoxJenisKelamin(){
        ObservableList<String> jk = FXCollections.observableArrayList();
        jk.add("Pilih Jenis Kelamin");
        jk.add("Laki-laki");
        jk.add("Perempuan");
        inJenisKelamin.setItems(jk);
        inJenisKelamin.getSelectionModel().selectFirst();
    }
    
    @FXML
    private void pilihDokterAction(MouseEvent event) {
        btnEdit.setDisable(false);
        btnDelete.setDisable(false);
        btnSave.setDisable(true);
        StatusKode = "1";
        try {
            Dokter_M klik = tableDokter.getSelectionModel().getSelectedItems().get(0);
            inKode.setText(klik.getKodeDokter());
            inNama.setText(klik.getNamaDokter());
            inSpesialis.setText(klik.getSpesialis());
            inAlamat.setText(klik.getAlamat());
            inJenisKelamin.getSelectionModel().select(klik.getJenisKelamin());
        } catch (Exception e) {
        }
    }

    @FXML
    private void btnSaveAction(ActionEvent event) {
        Dokter_M o = new Dokter_M();
        o.setKodeDokter(inKode.getText());
        o.setNamaDokter(inNama.getText());
        o.setSpesialis(inSpesialis.getText());
        o.setAlamat(inAlamat.getText());
        o.setJenisKelamin(inJenisKelamin.getSelectionModel().getSelectedItem());
        if (StatusKode.equals("0")) {
            crudDokter.insert(o);
        }else{
            crudDokter.update(o);
        }
        //dialog(Alert.AlertType.INFORMATION, "Data Telah Tersimpan");
        listDokter = crudDokter.getAll();
        tableDokter.setItems(listDokter);
        clear();
        setFormAccess(false);
        btnEdit.setText("Ubah");
        btnEdit.setDisable(true);
        StatusKode = "0";
    }

    @FXML
    private void btnEditAction(ActionEvent event) {
        StatusKode = "1";
        if (btnEdit.getText().equals("Ubah")) {
         if (tableDokter.getSelectionModel().getSelectedItem() != null) {
            btnEdit.setText("Batal");
           // setStyle("edit");
            btnEdit.setDisable(false);
            btnDelete.setDisable(true);
            setFormAccess(true);
            //showDetail(pemasukan);
            
         } else {
            mainApp.showAlert("Warning", "Invalid Action", "Please select first", Alert.AlertType.ERROR);
         }
      } else {
        // setStyle("");
         btnEdit.setText("Ubah");
         setFormAccess(false);
         btnEdit.setDisable(true);
         
         clear();
      }
    }

    @FXML
    private void btnDeleteAction(ActionEvent event) {
        Dokter_M dk = new Dokter_M();
        dk.setKodeDokter(inKode.getText());
        crudDokter.delete(dk);
        listDokter = crudDokter.getAll();
        tableDokter.setItems(listDokter);
        clear();
        setFormAccess(false);
        btnDelete.setDisable(true);
        btnEdit.setDisable(true);
    }

    @FXML
    private void btnNewAction(ActionEvent event) {
        btnDelete.setDisable(true);
        btnEdit.setDisable(true);
        if (btnNew.getText().equals("Baru")) {
         btnNew.setText("Batal");
         clear();
         setFormAccess(true);
         //setStyle("new");
      } else {
         btnNew.setText("Baru");
         clear();
         setFormAccess(false);
         //setStyle("");
      }
    }

    @FXML
    private void inSearchAction(KeyEvent event) {
    }
    
}
