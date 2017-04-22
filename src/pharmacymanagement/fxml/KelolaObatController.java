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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import pharmacymanagement.PharmacyManagement;
import pharmacymanagement.implement.ObatImpl;
import pharmacymanagement.interfaces.ObatInter;
import pharmacymanagement.models.Obat_M;

/**
 * FXML Controller class
 *
 * @author drag me to hell
 */
public class KelolaObatController implements Initializable {
    @FXML
    private TabPane tab;
    @FXML
    private Tab tabListObat;
    @FXML
    private TableView<Obat_M> tableObat;
    @FXML
    private TableColumn<Obat_M, String> columnKodeObat;
    @FXML
    private TableColumn<Obat_M, String> columnNamaObat;
    @FXML
    private TableColumn<Obat_M, String> columnKategori;
    @FXML
    private TableColumn<Obat_M, String> columnSubKategori;
    @FXML
    private TableColumn<Obat_M, String> columnKemasan;
    @FXML
    private TableColumn<Obat_M, Number> columnHarga;
    @FXML
    private TableColumn<Obat_M, Number> columnStok;
    @FXML
    private TableColumn<Obat_M, String> columnKeterangan;
    @FXML
    private TextField inSearch;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnEdit;
    @FXML
    private Button btnDelete;
    @FXML
    private Tab tabForm;
    @FXML
    private TextField inKode;
    @FXML
    private TextField inNama;
    @FXML
    private ChoiceBox<String> inKategori;
    @FXML
    private TextField inSub;
    @FXML
    private ChoiceBox<String> inKemasan;
    @FXML
    private TextField inHarga;
    @FXML
    private TextField inStok;
    @FXML
    private TextArea inKeterangan;
    @FXML
    private Button inSave;
    @FXML
    private Button inCancel;

    /**
     * Initializes the controller class.
     */
    private PharmacyManagement mainApp;
    ObatInter crudObat = new ObatImpl();
    ObservableList<Obat_M> listObat;
    String status = "0";
    
    public void setMainApp(PharmacyManagement mainApp) {
       this.mainApp = mainApp;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        columnKodeObat.setCellValueFactory((TableColumn.CellDataFeatures<Obat_M, String> cellData) ->
                        cellData.getValue().kodeObatProperty());
         columnNamaObat.setCellValueFactory((TableColumn.CellDataFeatures<Obat_M, String> cellData) ->
                        cellData.getValue().namaObatProperty());
         columnKategori.setCellValueFactory((TableColumn.CellDataFeatures<Obat_M, String> cellData) ->
                        cellData.getValue().kategoriObatProperty());
         columnSubKategori.setCellValueFactory((TableColumn.CellDataFeatures<Obat_M, String> cellData) ->
                        cellData.getValue().subObatProperty());
         columnKemasan.setCellValueFactory((TableColumn.CellDataFeatures<Obat_M, String> cellData) ->
                        cellData.getValue().kemasanProperty());
         columnHarga.setCellValueFactory((TableColumn.CellDataFeatures<Obat_M, Number> cellData) ->
                        cellData.getValue().hargaObatProperty());
         columnStok.setCellValueFactory((TableColumn.CellDataFeatures<Obat_M, Number> cellData) ->
                        cellData.getValue().stokProperty());
         columnKeterangan.setCellValueFactory((TableColumn.CellDataFeatures<Obat_M, String> cellData) ->
                        cellData.getValue().deskripsiProperty());
         listObat = FXCollections.observableArrayList();
         listObat = crudObat.getAllObat();
         tableObat.setItems(listObat);
         tabForm.setDisable(true);
         btnEdit.setDisable(true);
         btnDelete.setDisable(true);
         initChoiceBoxKategoriObat();
         initChoiceBoxKemasan();
    }    
    
    private void initChoiceBoxKategoriObat(){
        ObservableList<String> kategoriObat = FXCollections.observableArrayList();
        kategoriObat.add("Pilih kategori Obat");
        kategoriObat.add("Bebas");
        kategoriObat.add("Bebas Terbatas");
        kategoriObat.add("Keras");
        inKategori.setItems(kategoriObat);
        inKategori.getSelectionModel().selectFirst();
    }
    
    private void initChoiceBoxKemasan(){
        ObservableList<String> kemasan = FXCollections.observableArrayList();
        kemasan.add("Pilih Jenis Kemasan");
        kemasan.add("Strip");
        kemasan.add("Botol");
        kemasan.add("Tablet");
        kemasan.add("Kapsul");
        kemasan.add("Serbuk");
        inKemasan.setItems(kemasan);
        inKemasan.getSelectionModel().selectFirst();
    }
    
    private void clear(){
        inKode.clear();
        inNama.clear();
        inKategori.getSelectionModel().selectFirst();
        inSub.clear();
        inKemasan.getSelectionModel().selectFirst();
        inHarga.clear();
        inStok.clear();
        inKeterangan.clear();
        status = "0";
    }

    @FXML
    private void pilihObatAction(MouseEvent event) {
        btnEdit.setDisable(false);
        btnDelete.setDisable(false);
        status = "1";
        try {
            Obat_M klik = tableObat.getSelectionModel().getSelectedItems().get(0);
            inKode.setText(klik.getKodeObat());
            inNama.setText(klik.getNamaObat());
            inKategori.getSelectionModel().select(klik.getKategoriObat());
            inSub.setText(klik.getSubObat());
            inKemasan.getSelectionModel().select(klik.getKemasan());
            inHarga.setText(String.valueOf(klik.getHargaObat()));
            inStok.setText(String.valueOf(klik.getStok()));
            inKeterangan.setText(klik.getDeskripsi());
        } catch (Exception e) {
        }
    }

    @FXML
    private void inSearchAction(KeyEvent event) {
        listObat = crudObat.getObatByNama(inSearch.getText());
        tableObat.setItems(listObat);
    }

    @FXML
    private void btnAddAction(ActionEvent event) {
        clear();
        status = "0";
        inKode.setDisable(false);
        tabListObat.setDisable(true);
        tabForm.setDisable(false);
        tab.getSelectionModel().select(tabForm);
    }

    @FXML
    private void btnEditAction(ActionEvent event) {
        inKode.setDisable(true);
        tabListObat.setDisable(true);
        tabForm.setDisable(false);
        tab.getSelectionModel().select(tabForm);
        status = "1";
    }

    @FXML
    private void btnDeleteAction(ActionEvent event) {
        Obat_M o = new Obat_M();
        o.setKodeObat(inKode.getText());
        crudObat.delete(o);
        listObat = crudObat.getAllObat();
        tableObat.setItems(listObat);
        clear();
        btnDelete.setDisable(true);
        btnEdit.setDisable(true);
    }

    @FXML
    private void inSaveAction(ActionEvent event) {
        Obat_M o = new Obat_M();
        o.setKodeObat(inKode.getText());
        o.setNamaObat(inNama.getText());
        o.setKategoriObat(inKategori.getSelectionModel().getSelectedItem());
        o.setSubObat(inSub.getText());
        o.setKemasan(inKemasan.getSelectionModel().getSelectedItem());
        o.sethargaObat(Double.valueOf(inHarga.getText()));
        o.setStok(Integer.valueOf(inStok.getText()));
        o.setDeskripsi(inKeterangan.getText());
        if (status.equals("0")) {
            crudObat.insert(o);
        }else{
            crudObat.update(o);
        }
        //dialog(Alert.AlertType.INFORMATION, "Data Telah Tersimpan");
        listObat = crudObat.getAllObat();
        tableObat.setItems(listObat);
        inKode.setDisable(false);
        clear();
        tabListObat.setDisable(false);
        tabForm.setDisable(true);
        tab.getSelectionModel().select(tabListObat);
        btnDelete.setDisable(true);
        btnEdit.setDisable(true);
        status = "0";
    }

    @FXML
    private void inCancelAction(ActionEvent event) {
        tabListObat.setDisable(false);
        tabForm.setDisable(true);
        tab.getSelectionModel().select(tabListObat);
        clear();
        btnDelete.setDisable(true);
        btnEdit.setDisable(true);
        status = "0";
    }
    
}
