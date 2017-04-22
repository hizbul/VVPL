/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagement.fxml;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import pharmacymanagement.PharmacyManagement;
import pharmacymanagement.implement.ObatImpl;
import pharmacymanagement.implement.PemusnahanImpl;
import pharmacymanagement.interfaces.ObatInter;
import pharmacymanagement.interfaces.PemusnahanInter;
import pharmacymanagement.models.Obat_M;
import pharmacymanagement.models.PemusnahanObat_M;

/**
 * FXML Controller class
 *
 * @author drag me to hell
 */
public class PemusnahanObatController implements Initializable {
    @FXML
    private TabPane tab;
    @FXML
    private Tab tabCatat;
    @FXML
    private TableView<PemusnahanObat_M> tablePemusnahan;
    @FXML
    private TableColumn<PemusnahanObat_M, String> columnKodeObat;
    @FXML
    private TableColumn<PemusnahanObat_M, String> columnNamaObat;
    @FXML
    private TableColumn<PemusnahanObat_M, String> columnKategori;
    @FXML
    private TableColumn<PemusnahanObat_M, String> columnTanggal;
    @FXML
    private TableColumn<PemusnahanObat_M, Number> columnJumlahPemusnahan;
    @FXML
    private TextField inSearchPemusnahan;
    @FXML
    private TextField inKodeObat;
    @FXML
    private TextField inNamaObat;
    @FXML
    private TextField inKategori;
    @FXML
    private TextField inJmlPemusnahan;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnCancel;
    @FXML
    private DatePicker inTanggal;
    @FXML
    private Button btnPilihObat;
    @FXML
    private Tab tabPilih;
    @FXML
    private TableView<Obat_M> tableObat;
    @FXML
    private TableColumn<Obat_M, String> columnObatKode;
    @FXML
    private TableColumn<Obat_M, String> columnObatNama;
    @FXML
    private TableColumn<Obat_M, String> columnObatKategori;
    @FXML
    private TableColumn<Obat_M, String> columnObatSubKategori;
    @FXML
    private TableColumn<Obat_M, String> columnObatKemasan;
    @FXML
    private TableColumn<Obat_M, Number> columnObatHarga;
    @FXML
    private TableColumn<Obat_M, Number> columnObatStok;
    @FXML
    private TableColumn<Obat_M, String> columnObatKeterangan;
    @FXML
    private TextField inSearchObat;
    @FXML
    private Button btnAdd;

    /**
     * Initializes the controller class.
     */
    private PharmacyManagement mainApp;
    ObatInter crudObat = new ObatImpl();
    ObservableList<Obat_M> listObat;
    ObservableList<Obat_M> getObat;
    ObservableList<Obat_M> updateObat;
    ObservableList<Obat_M> getPengadaanObat;
    PemusnahanInter crudPemusnahan = new PemusnahanImpl();
    ObservableList<PemusnahanObat_M> listPemusnahan;
    int newStok;

    public void setMainApp(PharmacyManagement mainApp) {
       this.mainApp = mainApp;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            inKodeObat.setDisable(true);
            inNamaObat.setDisable(true);
            inKategori.setDisable(true);
            tabCatat.setDisable(false);
            tabPilih.setDisable(true);
            btnSave.setDisable(true);
            columnKodeObat.setCellValueFactory((TableColumn.CellDataFeatures<PemusnahanObat_M, String> cellData) ->
                        cellData.getValue().kodeObatProperty());
            columnNamaObat.setCellValueFactory((TableColumn.CellDataFeatures<PemusnahanObat_M, String> cellData) ->
                           cellData.getValue().namaObatProperty());
            columnKategori.setCellValueFactory((TableColumn.CellDataFeatures<PemusnahanObat_M, String> cellData) ->
                           cellData.getValue().kategoriObatProperty());
            columnTanggal.setCellValueFactory((TableColumn.CellDataFeatures<PemusnahanObat_M, String> cellData) ->
                           cellData.getValue().tanggalPemusnahanProperty());
            columnJumlahPemusnahan.setCellValueFactory((TableColumn.CellDataFeatures<PemusnahanObat_M, Number> cellData) ->
                           cellData.getValue().jmlPemusnahanProperty());
            listPemusnahan = FXCollections.observableArrayList();
            listPemusnahan = crudPemusnahan.tampilPemusnahan();
            tablePemusnahan.setItems(listPemusnahan);
            initTabelObat();
    }    
    
    public void initTabelObat(){
        columnObatKode.setCellValueFactory((TableColumn.CellDataFeatures<Obat_M, String> cellData) ->
                        cellData.getValue().kodeObatProperty());
         columnObatNama.setCellValueFactory((TableColumn.CellDataFeatures<Obat_M, String> cellData) ->
                        cellData.getValue().namaObatProperty());
         columnObatKategori.setCellValueFactory((TableColumn.CellDataFeatures<Obat_M, String> cellData) ->
                        cellData.getValue().kategoriObatProperty());
         columnObatSubKategori.setCellValueFactory((TableColumn.CellDataFeatures<Obat_M, String> cellData) ->
                        cellData.getValue().subObatProperty());
         columnObatKemasan.setCellValueFactory((TableColumn.CellDataFeatures<Obat_M, String> cellData) ->
                        cellData.getValue().kemasanProperty());
         columnObatHarga.setCellValueFactory((TableColumn.CellDataFeatures<Obat_M, Number> cellData) ->
                        cellData.getValue().hargaObatProperty());
         columnObatStok.setCellValueFactory((TableColumn.CellDataFeatures<Obat_M, Number> cellData) ->
                        cellData.getValue().stokProperty());
         columnObatKeterangan.setCellValueFactory((TableColumn.CellDataFeatures<Obat_M, String> cellData) ->
                        cellData.getValue().subObatProperty());
         listObat = FXCollections.observableArrayList();
         listObat = crudObat.getAllObat();
         tableObat.setItems(listObat);
         for (int i = 0; i < listObat.size(); i++) {
            
        }
    }

    @FXML
    private void inSearchPemusnahanActon(KeyEvent event) {
        listPemusnahan = crudPemusnahan.tampilPemusnahanByNamaObat(inSearchPemusnahan.getText());
        tablePemusnahan.setItems(listPemusnahan);
    }

    @FXML
    private void btnSaveAction(ActionEvent event) {
        if ( inJmlPemusnahan.getText().isEmpty() || inJmlPemusnahan.getText() == "") {
            showAlert("Warning", "Input Value", "Inputan jumlah pemusnahan masih kosong!!! Harap diisi untuk melanjutkan aksi", Alert.AlertType.ERROR);
            } else if (inTanggal.getValue() == null ) {
                showAlert("Warning", "Input Value", "Inputan tanggal pemusnahan masih kosong!!! Harap diisi untuk melanjutkan aksi", Alert.AlertType.ERROR);
                 } else {
                        newStok = 0;
                       LocalDate tgl = inTanggal.getValue();
                       String t = String.valueOf(tgl);
                       PemusnahanObat_M po = new PemusnahanObat_M();
                       po.setKodeObat(inKodeObat.getText());
                       po.setNamaObat(inNamaObat.getText());
                       po.setKategoriObat(inKategori.getText());
                       po.setTanggalPemusnahan(t);
                       po.setJmlPemusnahan(Integer.valueOf(inJmlPemusnahan.getText()));
                       //r.setIdPasien("pas001");
                       crudPemusnahan.insert(po);
                       getObat = FXCollections.observableArrayList();
                       getObat = crudObat.getObat(inKodeObat.getText());
                       newStok = getObat.get(0).getStok() - Integer.valueOf(inJmlPemusnahan.getText());
                       updateObat = FXCollections.observableArrayList();
                       Obat_M obat = new Obat_M();
                       crudObat.updateStok(obat, newStok, inKodeObat.getText());
               //        System.out.println(newStok);
                       listPemusnahan = crudPemusnahan.tampilPemusnahan();
                       tablePemusnahan.setItems(listPemusnahan);
                       listObat = crudObat.getAllObat();
                       tableObat.setItems(listObat);
               //        System.out.println(t);
                }
            
    }

    @FXML
    private void btnCancelAction(ActionEvent event) {
        inKodeObat.setText(null);
        inNamaObat.setText(null);
        inKategori.setText(null);
        inTanggal.setValue(null);
        inJmlPemusnahan.setText(null);
        btnSave.setDisable(true);
        tabCatat.setDisable(false);
        tabPilih.setDisable(true);
        tab.getSelectionModel().select(tabCatat);
    }

    @FXML
    private void btnPilihObatAction(ActionEvent event) {
        tabCatat.setDisable(true);
        tabPilih.setDisable(false);
        tab.getSelectionModel().select(tabPilih);
    }

    @FXML
    private void pilihObatAction(MouseEvent event) {
         try {
            int klik = tableObat.getSelectionModel().getSelectedIndex();
            //System.out.println(klik);
            inKodeObat.setText(listObat.get(klik).getKodeObat());
            inNamaObat.setText(listObat.get(klik).getNamaObat());
            inKategori.setText(listObat.get(klik).getKategoriObat());
            //System.out.println(kodeResep);
//            btnLayani.setDisable(false);
        } catch (Exception e) {
        }
    }

    @FXML
    private void inSearchObatAction(KeyEvent event) {
         listObat = crudObat.getObatByNama(inSearchObat.getText());
         tableObat.setItems(listObat);
    }

    @FXML
    private void btnAddAction(ActionEvent event) {
        tabCatat.setDisable(false);
        tabPilih.setDisable(true);
        tab.getSelectionModel().select(tabCatat);
        btnSave.setDisable(false);
    }
    
    public void showAlert(String title, String headerText, String contentText, Alert.AlertType alertType) {
      Alert alert = new Alert(alertType);
      //alert.initOwner(primaryStage);
      alert.setTitle(title);
      alert.setHeaderText(headerText);
      alert.setContentText(contentText);
      alert.showAndWait();
   }
    
}
