/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagement.fxml;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import pharmacymanagement.PharmacyManagement;
import pharmacymanagement.implement.DokterSpesialis;
import pharmacymanagement.implement.ObatImpl;
import pharmacymanagement.implement.PasienImpl;
import pharmacymanagement.implement.ResepImpl;
import pharmacymanagement.implement.ResepObatImpl;
import pharmacymanagement.implement.TransaksiImpl;
import pharmacymanagement.interfaces.ObatInter;
import pharmacymanagement.interfaces.PasienInter;
import pharmacymanagement.interfaces.ResepInter;
import pharmacymanagement.interfaces.ResepObatInter;
import pharmacymanagement.interfaces.TransaksiInter;
import pharmacymanagement.models.Obat_M;
import pharmacymanagement.models.Pasien_M;
import pharmacymanagement.models.ResepObat_M;
import pharmacymanagement.models.Resep_M;
import pharmacymanagement.models.Transaksi_M;

/**
 * FXML Controller class
 *
 * @author drag me to hell
 */
public class ListResepController implements Initializable {
    @FXML
    private TabPane tab;
    @FXML
    private Tab tabResep;
    @FXML
    private TableView<Resep_M> tableListResep;
    @FXML
    private TableColumn<Resep_M, String> columnKodeResep;
    @FXML
    private TableColumn<Resep_M, String> columnNamaDokter;
    @FXML
    private TableColumn<Resep_M, String> columnSpesialis;
    @FXML
    private TableColumn<Resep_M, String> columnStatusResep;
    @FXML
    private Button btnLayani;
    @FXML
    private TextField inSearchResep;
    @FXML
    private Tab tabAddResep;
    @FXML
    private ChoiceBox<String> inIdPasien;
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
    private TableView<ResepObat_M> tablePilihanObat;
    @FXML
    private TableColumn<ResepObat_M, String> columnNamaObat;
    @FXML
    private TableColumn<ResepObat_M, Number> columnHarga;
    @FXML
    private TableColumn<ResepObat_M, Number> columnQty;
    @FXML
    private TableColumn<ResepObat_M, Number> columnTotalHarga;
    @FXML
    private Button btnPilihObat;
    @FXML
    private Button btnAddTransaksi;
    @FXML
    private Button btnCancelTransaksi;
    @FXML
    private Button btnLihatResep;
    @FXML
    private Tab tabPilihObat;
    @FXML
    private TableView<Obat_M> tablePilihObat;
    @FXML
    private TableColumn<Obat_M, String> columnKodeObat;
    @FXML
    private TableColumn<Obat_M, String> columnNama;
    @FXML
    private TableColumn<Obat_M, String> columnKategori;
    @FXML
    private TableColumn<Obat_M, String> columnSub;
    @FXML
    private TableColumn<Obat_M, String> columnKemasan;
    @FXML
    private TableColumn<Obat_M, Number> columnHargaObat;
    @FXML
    private TableColumn<Obat_M, Number> columnStok;
    @FXML
    private TableColumn<Obat_M, String> columnKeterangan;
    @FXML
    private Button btnAddObat;
    @FXML
    private Button btnSelesai;
    @FXML
    private TextField inSearchObat;
    @FXML
    private TextField inQty;

    /**
     * Initializes the controller class.
     */
    
    private PharmacyManagement mainApp;
    ResepInter crudData = new ResepImpl();
    ObservableList<Resep_M> listResep;
    ObservableList<Resep_M> listResepPasien;
    PasienInter crudPasien = new PasienImpl();
    ObservableList<Pasien_M> listGetPasien;
    ObatInter crudObat = new ObatImpl();
    ObservableList<Obat_M> listObat;
    ResepObatInter crudResepObat = new ResepObatImpl();
    ObservableList<ResepObat_M> listResepObat;
    TransaksiInter crudTransaksi = new TransaksiImpl();
    ObservableList<Transaksi_M> listTransaksi;
    String kodeResep;
    String kodeObat;
    double hargaObat;
    int pilihResep = 0;
    double totalPembayaran = 0;
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date date = new Date();
    String tanggalPembayaran = dateFormat.format(date);
    String path = null;
    
    public void setMainApp(PharmacyManagement mainApp) {
       this.mainApp = mainApp;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         columnKodeResep.setCellValueFactory((TableColumn.CellDataFeatures<Resep_M, String> cellData) ->
                        cellData.getValue().kodeResepProperty());
         columnNamaDokter.setCellValueFactory((TableColumn.CellDataFeatures<Resep_M, String> cellData) ->
                        cellData.getValue().namaDokterProperty());
         columnSpesialis.setCellValueFactory((TableColumn.CellDataFeatures<Resep_M, String> cellData) ->
                        cellData.getValue().spesialisProperty());
         columnStatusResep.setCellValueFactory((TableColumn.CellDataFeatures<Resep_M, String> cellData) ->
                        cellData.getValue().statusProperty());
         listResep = FXCollections.observableArrayList();
         listResep = crudData.tampilResep();
         tableListResep.setItems(listResep);
         tabResep.setDisable(false);
         tabPilihObat.setDisable(true);
         tabAddResep.setDisable(true);
         pilihResep = 0;
         initChoiceBox();
         initViewObat();
         initTabelObat();
         reset();
    }    
    
    
    public void reset(){
        //tabAddResep.setDisable(true);
        //tabPilihObat.setDisable(true);
        inKodeResep.setDisable(true);
        inNamaDokter.setDisable(true);
        inSpesialis.setDisable(true);
        inNamaPasien.setDisable(true);
        inUmur.setDisable(true);
    }
    
    public void initChoiceBox(){
        listGetPasien = FXCollections.observableArrayList();
        listGetPasien = crudPasien.getPasien();
        ObservableList<String> idPasien = FXCollections.observableArrayList();
        for (int i = 0; i < listGetPasien.size(); i++) {
            idPasien.add(listGetPasien.get(i).getIdPasien());
        }
        inIdPasien.setItems(idPasien);
        inIdPasien.getSelectionModel().selectFirst();
        inIdPasien.getSelectionModel().selectedIndexProperty().addListener(
                new ChangeListener<Number>(){
                    @Override
                    public void changed(ObservableValue ov, Number oldValue, Number newValue) {
                        inNamaPasien.setText(listGetPasien.get(newValue.intValue()).getNamaPasien());
                        inUmur.setText(String.valueOf(listGetPasien.get(newValue.intValue()).getUmur()));
                    }
                });
    }
    
    public void initViewObat(){
         columnKodeObat.setCellValueFactory((TableColumn.CellDataFeatures<Obat_M, String> cellData) ->
                        cellData.getValue().kodeObatProperty());
         columnNama.setCellValueFactory((TableColumn.CellDataFeatures<Obat_M, String> cellData) ->
                        cellData.getValue().namaObatProperty());
         columnKategori.setCellValueFactory((TableColumn.CellDataFeatures<Obat_M, String> cellData) ->
                        cellData.getValue().kategoriObatProperty());
         columnSub.setCellValueFactory((TableColumn.CellDataFeatures<Obat_M, String> cellData) ->
                        cellData.getValue().subObatProperty());
         columnKemasan.setCellValueFactory((TableColumn.CellDataFeatures<Obat_M, String> cellData) ->
                        cellData.getValue().kemasanProperty());
         columnHargaObat.setCellValueFactory((TableColumn.CellDataFeatures<Obat_M, Number> cellData) ->
                        cellData.getValue().hargaObatProperty());
         columnStok.setCellValueFactory((TableColumn.CellDataFeatures<Obat_M, Number> cellData) ->
                        cellData.getValue().stokProperty());
         columnKeterangan.setCellValueFactory((TableColumn.CellDataFeatures<Obat_M, String> cellData) ->
                        cellData.getValue().subObatProperty());
         listObat = FXCollections.observableArrayList();
         listObat = crudObat.getAllObat();
         tablePilihObat.setItems(listObat);
    }
    
    public void initTabelObat(){
        columnNamaObat.setCellValueFactory((TableColumn.CellDataFeatures<ResepObat_M, String> cellData) ->
                        cellData.getValue().namaObatProperty());
        columnQty.setCellValueFactory((TableColumn.CellDataFeatures<ResepObat_M, Number> cellData) ->
                        cellData.getValue().qtyProperty());
        columnHarga.setCellValueFactory((TableColumn.CellDataFeatures<ResepObat_M, Number> cellData) ->
                        cellData.getValue().hargaProperty());
        columnTotalHarga.setCellValueFactory((TableColumn.CellDataFeatures<ResepObat_M, Number> cellData) ->
                        cellData.getValue().totalHargaProperty());
        listResepObat = FXCollections.observableArrayList();
        listResepObat = crudResepObat.getAllResepObat(DokterSpesialis.getKodeResep());
        tablePilihanObat.setItems(listResepObat);
    }

    @FXML
    private void pilihResepAction(MouseEvent event) {
        totalPembayaran = 0;
        path = null;
        try {
            int klik = tableListResep.getSelectionModel().getSelectedIndex();
            String status = listResep.get(klik).getStatus();
            String kr  = listResep.get(klik).getKodeResep();
            if (status.equalsIgnoreCase("Sudah dilayani")) {
                listResepPasien = FXCollections.observableArrayList();
                listResepPasien = crudData.tampilResepPasien(kr);
                inIdPasien.getSelectionModel().select(listResepPasien.get(0).getIdPasien());
                inNamaPasien.setText(listResepPasien.get(0).getNamaPasien());
                inUmur.setText(String.valueOf(listResepPasien.get(0).getUmur()));
                inNamaDokter.setText(listResepPasien.get(0).getNamaDokter());
                inSpesialis.setText(listResepPasien.get(0).getSpesialis());
                inKodeResep.setText(listResepPasien.get(0).getKodeResep());
                path = listResepPasien.get(0).getPathResep();
                columnNamaObat.setCellValueFactory((TableColumn.CellDataFeatures<ResepObat_M, String> cellData) ->
                            cellData.getValue().namaObatProperty());
                columnQty.setCellValueFactory((TableColumn.CellDataFeatures<ResepObat_M, Number> cellData) ->
                                cellData.getValue().qtyProperty());
                columnHarga.setCellValueFactory((TableColumn.CellDataFeatures<ResepObat_M, Number> cellData) ->
                                cellData.getValue().hargaProperty());
                columnTotalHarga.setCellValueFactory((TableColumn.CellDataFeatures<ResepObat_M, Number> cellData) ->
                                cellData.getValue().totalHargaProperty());
                listResepObat = FXCollections.observableArrayList();
                listResepObat = crudResepObat.getAllResepObat(listResepPasien.get(0).getKodeResep());
                tablePilihanObat.setItems(listResepObat);
                for (int i = 0; i < listResepObat.size(); i++) {
                    //System.out.println(listResepObat.get(i).getTotalHarga());
                    totalPembayaran = totalPembayaran + listResepObat.get(i).getTotalHarga();
                }
                System.out.println(totalPembayaran);
                btnPilihObat.setDisable(true);
                inIdPasien.setDisable(true);
                btnAddTransaksi.setDisable(true);
            } else if(status.equalsIgnoreCase("Belum dilayani")){
                listResep = FXCollections.observableArrayList();
                listResep = crudData.tampilResep();
                inNamaDokter.setText(listResep.get(klik).getNamaDokter());
                inSpesialis.setText(listResep.get(klik).getSpesialis());
                inKodeResep.setText(listResep.get(klik).getKodeResep());
                DokterSpesialis.setKodeResep(listResep.get(klik).getKodeResep());
                kodeResep = listResep.get(klik).getKodeResep();
                path = listResep.get(klik).getPathResep();
                columnNamaObat.setCellValueFactory((TableColumn.CellDataFeatures<ResepObat_M, String> cellData) ->
                            cellData.getValue().namaObatProperty());
                columnQty.setCellValueFactory((TableColumn.CellDataFeatures<ResepObat_M, Number> cellData) ->
                                cellData.getValue().qtyProperty());
                columnHarga.setCellValueFactory((TableColumn.CellDataFeatures<ResepObat_M, Number> cellData) ->
                                cellData.getValue().hargaProperty());
                columnTotalHarga.setCellValueFactory((TableColumn.CellDataFeatures<ResepObat_M, Number> cellData) ->
                                cellData.getValue().totalHargaProperty());
                listResepObat = FXCollections.observableArrayList();
                listResepObat = crudResepObat.getAllResepObat(listResep.get(klik).getKodeResep());
                tablePilihanObat.setItems(listResepObat);
            }
            
            pilihResep = 1;
            //System.out.println(kodeResep);
//            btnLayani.setDisable(false);
        } catch (Exception e) {
        }
    }

    @FXML
    private void btnLayaniAction(ActionEvent event) {
        if (pilihResep == 0) {
            showAlert("Warning", "Input Value", "Pilih resep yang akan dilayanai!!!", Alert.AlertType.ERROR);
        } else {
            tabResep.setDisable(true);
            tabAddResep.setDisable(false);
            tab.getSelectionModel().select(tabAddResep);
            
        }
    }

    @FXML
    private void inSearchResepAction(KeyEvent event) {
        listResep = crudData.tampilResepByNamaPasien(inSearchResep.getText());
        tableListResep.setItems(listResep);
    }

    @FXML
    private void btnPilihObatAction(ActionEvent event) {
        tabResep.setDisable(true);
        tabAddResep.setDisable(false);
        tabPilihObat.setDisable(false);
        
        tab.getSelectionModel().select(tabPilihObat);
        System.out.println(kodeResep);
    }

    @FXML
    private void btnAddTransaksiAction(ActionEvent event) {
        //String status = "Sudah dilayani";
        Resep_M r = new Resep_M();
        //r.setStatus(status);
        r.setIdPasien(inIdPasien.getSelectionModel().getSelectedItem());
        r.setKodeResep(inKodeResep.getText());
        crudData.update(r,inIdPasien.getSelectionModel().getSelectedItem(),inKodeResep.getText());
        listResep = crudData.tampilResep();
        tableListResep.setItems(listResep);
        //##########################################################
        totalPembayaran = 0;
        listResepObat = FXCollections.observableArrayList();
        listResepObat = crudResepObat.getAllResepObat(inKodeResep.getText());
        for (int i = 0; i < listResepObat.size(); i++) {
            //System.out.println(listResepObat.get(i).getTotalHarga());
            totalPembayaran = totalPembayaran + listResepObat.get(i).getTotalHarga();
        }
        Transaksi_M t = new Transaksi_M();
        t.setIdPasien(inIdPasien.getSelectionModel().getSelectedItem());
        t.setKodeResep(inKodeResep.getText());
        t.setTanggalTransaksi(tanggalPembayaran);
        t.setTotalPembayaran(totalPembayaran);
        t.setStatus("Belum dilayani");
        //r.setIdPasien("pas001");
        crudTransaksi.insert(t);
        tabAddResep.setDisable(true);
        tabPilihObat.setDisable(true);
        tabResep.setDisable(false);
        tab.getSelectionModel().select(tabResep);
    }

    @FXML
    private void btnCancelTransaksiAction(ActionEvent event) {
        tabAddResep.setDisable(true);
        tabPilihObat.setDisable(true);
        tabResep.setDisable(false);
        tab.getSelectionModel().select(tabResep);
        inIdPasien.getSelectionModel().selectFirst();
        inNamaPasien.setText(null);
        inUmur.setText(null);
        btnPilihObat.setDisable(false);
        inIdPasien.setDisable(false);
        btnAddTransaksi.setDisable(false);
    }

    @FXML
    private void btnLihatResepAction(ActionEvent event) throws IOException {
        File f = new File("C:\\Users\\drag me to hell\\Documents\\NetBeansProjects\\PharmacyManagement\\Resep\\"+path);
        Desktop dt = Desktop.getDesktop();
        dt.open(f);
    }

    @FXML
    private void pilihObatAction(MouseEvent event) {
        try {
            int klik = tablePilihObat.getSelectionModel().getSelectedIndex();
            //System.out.println(klik);
            kodeObat = listObat.get(klik).getKodeObat();
            hargaObat = listObat.get(klik).getHargaObat();
            //System.out.println(kodeResep);
//            btnLayani.setDisable(false);
        } catch (Exception e) {
        }
    }

    @FXML
    private void btnAddObatAction(ActionEvent event) {
        double total;
        ResepObat_M ro = new ResepObat_M();
        ro.setQty(Integer.valueOf(inQty.getText()));
        total = hargaObat * Double.valueOf(inQty.getText());
        ro.setTotalHarga(total);
        ro.setKodeResep(kodeResep);
        ro.setKodeObat(kodeObat);
//        r.setKodeDokter(DokterSpesialis.getKodeDokter());
//        r.setPathResep(lblFile.getText());
//        r.setStatus("Belum dilayani");
//        //r.setIdPasien("pas001");
        crudResepObat.insert(ro, kodeObat, kodeResep, total);
        //        tabResep.setDisable(true);
//        tabAddResep.setDisable(false);
        tab.getSelectionModel().select(tabAddResep);
        columnNamaObat.setCellValueFactory((TableColumn.CellDataFeatures<ResepObat_M, String> cellData) ->
                        cellData.getValue().namaObatProperty());
        columnQty.setCellValueFactory((TableColumn.CellDataFeatures<ResepObat_M, Number> cellData) ->
                        cellData.getValue().hargaProperty());
        columnHarga.setCellValueFactory((TableColumn.CellDataFeatures<ResepObat_M, Number> cellData) ->
                        cellData.getValue().qtyProperty());
        columnTotalHarga.setCellValueFactory((TableColumn.CellDataFeatures<ResepObat_M, Number> cellData) ->
                        cellData.getValue().totalHargaProperty());
        listResepObat = FXCollections.observableArrayList();
        listResepObat = crudResepObat.getAllResepObat(DokterSpesialis.getKodeResep());
        tablePilihanObat.setItems(listResepObat);
    }

    @FXML
    private void btnSelesaiAction(ActionEvent event) {
        tabResep.setDisable(true);
        tabPilihObat.setDisable(true);
        tabAddResep.setDisable(false);
        tab.getSelectionModel().select(tabAddResep);
    }

    @FXML
    private void inSearchObatAction(KeyEvent event) {
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
