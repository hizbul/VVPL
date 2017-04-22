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
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import pharmacymanagement.PharmacyManagement;
import pharmacymanagement.implement.AccountImpl;
import pharmacymanagement.implement.DokterImpl;
import pharmacymanagement.interfaces.AccountInter;
import pharmacymanagement.interfaces.DokterInter;
import pharmacymanagement.models.Account_M;
import pharmacymanagement.models.Dokter_M;

/**
 * FXML Controller class
 *
 * @author drag me to hell
 */
public class KelolaAccountController implements Initializable {
    @FXML
    private TextField inKodeAkun;
    @FXML
    private TextField inUsername;
    @FXML
    private TextField inPassword;
    @FXML
    private TextField inJabaran;
    @FXML
    private ChoiceBox<String> inDokter;
    @FXML
    private Button btnNew;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnEdit;
    @FXML
    private Button btnDelete;
    @FXML
    private TableView<Account_M> tableAccount;
    @FXML
    private TableColumn<Account_M, String> columnKode;
    @FXML
    private TableColumn<Account_M, String> columnUsername;
    @FXML
    private TableColumn<Account_M, String> columnPassword;
    @FXML
    private TableColumn<Account_M, String> columnJabatan;
    @FXML
    private TextField inSearch;
    @FXML
    private Button btnSimpanAkun;
    @FXML
    private Button btnUpdateAkun;
    

    /**
     * Initializes the controller class.
     */
    private PharmacyManagement mainApp;
    AccountInter crudAccount = new AccountImpl();
    ObservableList<Account_M> listAccount;
    DokterInter getDokter = new DokterImpl();
    ObservableList<Dokter_M> listDokter;
    String statusKode ;
    
    public void setMainApp(PharmacyManagement mainApp) {
       this.mainApp = mainApp;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         columnKode.setCellValueFactory((TableColumn.CellDataFeatures<Account_M, String> cellData) ->
                        cellData.getValue().kodeAccountProperty());
        columnUsername.setCellValueFactory((TableColumn.CellDataFeatures<Account_M, String> cellData) ->
                        cellData.getValue().usernameProperty());
        columnPassword.setCellValueFactory((TableColumn.CellDataFeatures<Account_M, String> cellData) ->
                        cellData.getValue().passwordProperty());
        columnJabatan.setCellValueFactory((TableColumn.CellDataFeatures<Account_M, String> cellData) ->
                        cellData.getValue().jabatanProperty());
        listAccount = FXCollections.observableArrayList();
        listAccount = crudAccount.getAll();
        tableAccount.setItems(listAccount);
        initChoiceBoxJenisKelamin();
        statusKode = "0";
        btnEdit.setDisable(true);
        btnDelete.setDisable(true);
        btnSave.setDisable(true);
        inDokter.setDisable(true);
        btnSimpanAkun.setDisable(true);
        btnUpdateAkun.setDisable(true);
        setFormAccess(false);
    }    
    
    private void setFormAccess(boolean access) {
      inKodeAkun.setDisable(!access);
      inUsername.setEditable(access);
      inPassword.setEditable(access);
      inJabaran.setEditable(access);
//      inDokter.setDisable(!access);
      tableAccount.setDisable(access);
   }
    
    public void clear(){
        inKodeAkun.setText(null);
        inUsername.setText(null);
        inPassword.setText(null);
        inJabaran.setText(null);
        inDokter.getSelectionModel().selectFirst();
    }
    
    private void initChoiceBoxJenisKelamin(){
        listDokter = FXCollections.observableArrayList();
        listDokter = getDokter.getDokter();
        ObservableList<String> dokter = FXCollections.observableArrayList();
        for (int i = 0; i < listDokter.size(); i++) {
            dokter.add(listDokter.get(i).getKodeDokter());
        }
        inDokter.setItems(dokter);
        inDokter.getSelectionModel().selectFirst();
    }

    @FXML
    private void inDokterTextChanged(InputMethodEvent event) {
        
    }

    @FXML
    private void inDokterActionRelease(KeyEvent event) {
        
    }

    @FXML
    private void btnNewAction(ActionEvent event) {
        btnDelete.setDisable(true);
        btnEdit.setDisable(true);
        if (btnNew.getText().equals("Baru")) {
         btnNew.setText("Batal");
         clear();
         setFormAccess(true);
         btnSave.setDisable(false);
         //setStyle("new");
      } else {
         btnNew.setText("Baru");
         clear();
         setFormAccess(false);
         btnSave.setDisable(true);
         //setStyle("");
      }
    }

    @FXML
    private void btnSaveAction(ActionEvent event) {
        Account_M a = new Account_M();
        a.setKodeAccount(inKodeAkun.getText());
        a.setUsername(inUsername.getText());
        a.setPassword(inPassword.getText());
        a.setJabatan(inJabaran.getText());
        if (statusKode.equals("0")) {
            crudAccount.insert(a);
        }else{
            crudAccount.update(a);
        }
        //dialog(Alert.AlertType.INFORMATION, "Data Telah Tersimpan");
        listAccount = crudAccount.getAll();
        tableAccount.setItems(listAccount);
        clear();
        setFormAccess(false);
        btnNew.setText("Baru");
        btnSave.setDisable(true);
        btnEdit.setText("Ubah");
        btnEdit.setDisable(true);
        btnUpdateAkun.setDisable(true);
        statusKode = "0";
    }

    @FXML
    private void btnEditAction(ActionEvent event) {
        statusKode = "1";
        if (btnEdit.getText().equals("Ubah")) {
         if (tableAccount.getSelectionModel().getSelectedItem() != null) {
            btnEdit.setText("Batal");
           // setStyle("edit");
            btnEdit.setDisable(false);
            btnDelete.setDisable(true);
            setFormAccess(true);
            inKodeAkun.setDisable(true);
            btnSave.setDisable(false);
            //showDetail(pemasukan);
            
         } else {
            mainApp.showAlert("Warning", "Invalid Action", "Please select first", Alert.AlertType.ERROR);
         }
      } else {
        // setStyle("");
         btnEdit.setText("Ubah");
         setFormAccess(false);
         btnEdit.setDisable(true);
         btnSave.setDisable(true);
         clear();
      }
    }

    @FXML
    private void btnDeleteAction(ActionEvent event) {
        Account_M dk = new Account_M();
        dk.setKodeAccount(inKodeAkun.getText());
        crudAccount.delete(dk);
        listAccount = crudAccount.getAll();
        tableAccount.setItems(listAccount);
        clear();
        setFormAccess(false);
        btnUpdateAkun.setDisable(true);
        btnDelete.setDisable(true);
        btnEdit.setDisable(true);
    }

    @FXML
    private void tableAccountAction(MouseEvent event) {
        btnEdit.setDisable(false);
        btnDelete.setDisable(false);
        btnSave.setDisable(true);
        statusKode = "1";
        try {
            Account_M klik = tableAccount.getSelectionModel().getSelectedItems().get(0);
            inKodeAkun.setText(klik.getKodeAccount());
            inUsername.setText(klik.getUsername());
            inPassword.setText(klik.getPassword());
            inJabaran.setText(klik.getJabatan());
            if (klik.getJabatan().equalsIgnoreCase("dokter")) {
                inDokter.setDisable(false);
                btnUpdateAkun.setDisable(false);
            } else {
                inDokter.setDisable(true);
                btnUpdateAkun.setDisable(true);
            }
        } catch (Exception e) {
        }
    }

    @FXML
    private void inSearchAction(KeyEvent event) {
    }
    
    @FXML
    private void jabatanAction(KeyEvent event) {
        
    }
    
    @FXML
    private void btnSimpanAkunAction(ActionEvent event) {
        getDokter.updateAkunDokter(inDokter.getSelectionModel().getSelectedItem(), inKodeAkun.getText());
        btnSimpanAkun.setDisable(true);
        clear();
        btnDelete.setDisable(true);
        btnEdit.setDisable(true);
        listDokter = FXCollections.observableArrayList();
        listDokter = getDokter.getDokter();
        ObservableList<String> dokter = FXCollections.observableArrayList();
        for (int i = 0; i < listDokter.size(); i++) {
            dokter.add(listDokter.get(i).getKodeDokter());
        }
        inDokter.setItems(dokter);
        inDokter.getSelectionModel().selectFirst();
    }
    
    @FXML
    private void btnUpdateAkunAction(ActionEvent event) {
        btnSimpanAkun.setDisable(false);
        btnUpdateAkun.setDisable(true);
        setFormAccess(false);
    }
    
}
