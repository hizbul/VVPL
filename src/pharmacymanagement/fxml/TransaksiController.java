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
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import pharmacymanagement.PharmacyManagement;
import pharmacymanagement.implement.ObatImpl;
import pharmacymanagement.implement.TransaksiImpl;
import pharmacymanagement.interfaces.ObatInter;
import pharmacymanagement.interfaces.TransaksiInter;
import pharmacymanagement.models.Obat_M;
import pharmacymanagement.models.ResepObat_M;
import pharmacymanagement.models.Transaksi_M;

/**
 * FXML Controller class
 *
 * @author drag me to hell
 */
public class TransaksiController implements Initializable {
    @FXML
    private TabPane tab;
    @FXML
    private Tab tabList;
    @FXML
    private TableView<Transaksi_M> tableTransaksi;
    @FXML
    private TableColumn<Transaksi_M, String> columnKodeResep;
    @FXML
    private TableColumn<Transaksi_M, String> columnDokter;
    @FXML
    private TableColumn<Transaksi_M, String> columnSpesialis;
    @FXML
    private TableColumn<Transaksi_M, String> columnStatus;
    @FXML
    private TextField inSearchTransaksi;
    @FXML
    private Button btnLayani;
    @FXML
    private Tab tabLayani;
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
    private TableView<ResepObat_M> tableObat;
    @FXML
    private TableColumn<ResepObat_M, String> columnNamaObat;
    @FXML
    private TableColumn<ResepObat_M, Number> columnHarga;
    @FXML
    private TableColumn<ResepObat_M, Number> columnQty;
    @FXML
    private TableColumn<ResepObat_M, Number> columnTotal;
    @FXML
    private Button btnBayar;
    @FXML
    private Button tbnBatal;
    @FXML
    private TextField inJumlah;

    /**
     * Initializes the controller class.
     */
    TransaksiInter crudData = new TransaksiImpl();
    ObservableList<Transaksi_M> listTransaksi;
    ObservableList<Transaksi_M> listLayani;
    ObservableList<ResepObat_M> listResepObat;
    ObatInter crudObat = new ObatImpl();
    ObservableList<Obat_M> listTransaksiObat;
    ObservableList<Obat_M> listUpdateObat;
    String kt;
    String ko ;
    int kodeTransaksi;
    int newStok;
    
    private PharmacyManagement mainApp;

    public void setMainApp(PharmacyManagement mainApp) {
       this.mainApp = mainApp;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            columnKodeResep.setCellValueFactory((TableColumn.CellDataFeatures<Transaksi_M, String> cellData) ->
                        cellData.getValue().kodeResepProperty());
            columnDokter.setCellValueFactory((TableColumn.CellDataFeatures<Transaksi_M, String> cellData) ->
                            cellData.getValue().namaDokterProperty());
            columnSpesialis.setCellValueFactory((TableColumn.CellDataFeatures<Transaksi_M, String> cellData) ->
                            cellData.getValue().spesialisProperty());
            columnStatus.setCellValueFactory((TableColumn.CellDataFeatures<Transaksi_M, String> cellData) ->
                            cellData.getValue().statusProperty());

            listTransaksi = FXCollections.observableArrayList();
            listTransaksi = crudData.tampilTransaksi();
            tableTransaksi.setItems(listTransaksi);

            tabLayani.setDisable(true);
            tabList.setDisable(false);
    }    

    @FXML
    private void pilihItem(MouseEvent event) {
        try {
            String status;
            int klik = tableTransaksi.getSelectionModel().getSelectedIndex();
            //System.out.println(klik);
            kt = listTransaksi.get(klik).getKodeResep();
            //System.out.println(kt);
            listLayani = FXCollections.observableArrayList();
            listLayani = crudData.transaksi(kt);
            status = listLayani.get(0).getStatus();
            kodeTransaksi = listLayani.get(0).getKodeTransaksi();
            inIDPasien.setText(listLayani.get(0).getIdPasien());
            inNamaPasien.setText(listLayani.get(0).getNamaPasien());
            inUmur.setText(String.valueOf(listLayani.get(0).getUmur()));
            inNamaDokter.setText(listLayani.get(0).getNamaDokter());
            inSpesialis.setText(listLayani.get(0).getSpesialis());
            inKodeResep.setText(listLayani.get(0).getKodeResep());
            inJumlah.setText(String.valueOf(listLayani.get(0).getTotalPembayaran()));
//#################################################################################
            
//#################################################################################
            columnNamaObat.setCellValueFactory((TableColumn.CellDataFeatures<ResepObat_M, String> cellData) ->
                            cellData.getValue().namaObatProperty());
            columnQty.setCellValueFactory((TableColumn.CellDataFeatures<ResepObat_M, Number> cellData) ->
                            cellData.getValue().qtyProperty());
            columnHarga.setCellValueFactory((TableColumn.CellDataFeatures<ResepObat_M, Number> cellData) ->
                            cellData.getValue().hargaProperty());
            columnTotal.setCellValueFactory((TableColumn.CellDataFeatures<ResepObat_M, Number> cellData) ->
                            cellData.getValue().totalHargaProperty());
            listResepObat = FXCollections.observableArrayList();
            listResepObat = crudData.getTransaksiResepObat(listLayani.get(0).getKodeResep());
            tableObat.setItems(listResepObat);
            if (status.equalsIgnoreCase("Sudah dilayani")) {
                btnBayar.setDisable(true);
            } else {
                btnBayar.setDisable(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void inSearchAction(KeyEvent event) {
            listTransaksi = crudData.transaksiByNama(inSearchTransaksi.getText());
            tableTransaksi.setItems(listTransaksi);
    }

    @FXML
    private void btnLayaniAction(ActionEvent event) {
        tabList.setDisable(true);
        tabLayani.setDisable(false);
        tab.getSelectionModel().select(tabLayani);
    }

    @FXML
    private void btnBayarAction(ActionEvent event) {
        newStok = 0;
        
        int quantity;
        listResepObat = FXCollections.observableArrayList();
        listResepObat = crudData.getTransaksiResepObat(listLayani.get(0).getKodeResep());
        
        for (int i = 0; i < listResepObat.size(); i++) {
            ko = listResepObat.get(i).getKodeObat();
            System.out.println(ko);
            listTransaksiObat = FXCollections.observableArrayList();
            listTransaksiObat = crudObat.getTransaksiObat(kt,ko);
            for (int j = 0; j < listTransaksiObat.size(); j++) {
                
                newStok = listTransaksiObat.get(j).getStok() - listResepObat.get(i).getQty();
                listUpdateObat = FXCollections.observableArrayList();
                Obat_M o = new Obat_M();
                crudObat.updateStok(o, newStok, ko);
            }
        }
        //System.out.println(kodeTransaksi);
        Transaksi_M t = new Transaksi_M();
        crudData.update(t,kodeTransaksi);
        listTransaksi = crudData.tampilTransaksi();
        tableTransaksi.setItems(listTransaksi);
        //####################################################
        
        //#####################################################
        inIDPasien.setText(null);
        inNamaPasien.setText(null);
        inUmur.setText(null);
        //btnPilihObat.setDisable(false);
        inNamaDokter.setText(null);
        inSpesialis.setText(null);
        inKodeResep.setText(null);
        inJumlah.setText(null);
        tabList.setDisable(false);
        tab.getSelectionModel().select(tabList);
        tabLayani.setDisable(true);
    }

    @FXML
    private void btnBatalAction(ActionEvent event) {
         //tab.getSelectionModel().select(tabResep);
        inIDPasien.setText(null);
        inNamaPasien.setText(null);
        inUmur.setText(null);
        //btnPilihObat.setDisable(false);
        inNamaDokter.setText(null);
        inSpesialis.setText(null);
        inKodeResep.setText(null);
        inJumlah.setText(null);
        tabList.setDisable(false);
        tab.getSelectionModel().select(tabList);
        tabLayani.setDisable(true);
    }
    
}
