/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagement.fxml;

import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.GlyphsDude;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pharmacymanagement.PharmacyManagement;
import pharmacymanagement.implement.DokterSpesialis;
import pharmacymanagement.implement.LoginImpl;
import pharmacymanagement.interfaces.LoginInter;
import pharmacymanagement.models.Dokter_M;
import pharmacymanagement.models.Login_M;

/**
 * FXML Controller class
 *
 * @author drag me to hell
 */
public class LoginController implements Initializable {
    @FXML
    private TextField inUsername;
    @FXML
    private TextField inPassword;
    @FXML
    private Button btnLogin;
    @FXML
    private Button btnCancel;

    /**
     * Initializes the controller class.
     */
    private PharmacyManagement mainApp;
    private AddResepController arc;
    private Stage primaryStage;
    private BorderPane rootLayout;
    private AnchorPane rootLogin;
    LoginInter crudData = new LoginImpl();
    ObservableList<Login_M> listData;
    ObservableList<Dokter_M> listDokter;
    

   public void setMainApp(PharmacyManagement mainApp) {
      this.mainApp = mainApp;
   }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        GlyphsDude.setIcon(btnLogin, FontAwesomeIcon.CHECK_SQUARE, "18 px");
        
       
    }    
    
   

    @FXML
    private void btnLoginAction(ActionEvent event) throws IOException {
        listData = crudData.login(inUsername.getText(),inPassword.getText());
        //DokterSpesialis ds = new DokterSpesialis();
        if (listData.isEmpty()) {
            showAlert("Warning", "Input Value", "Pengguna tidak terdaftar!!!", Alert.AlertType.ERROR);
        } else {
            String jabatan = listData.get(0).getJabatan();
            String kode = listData.get(0).getKodeAccount();
            //System.out.println(kode);
            listDokter = crudData.getDokter(kode);
            if (jabatan.contains("dokter")) {
                String kodeDokter = listDokter.get(0).getKodeDokter();
                String namaDokter = listDokter.get(0).getNamaDokter();
                String spesialis = listDokter.get(0).getSpesialis();
                DokterSpesialis.setDokterSpesialis(kodeDokter, namaDokter, spesialis);
                
                mainApp.initDokterLayout();
                //mainApp.setDokter(namaDokter, spesialis);
            } else if (jabatan.contains("apoteker")){
                mainApp.initApotekerLayout();
            } else if (jabatan.contains("kasir")){
                mainApp.initKasirLayout();
            } else if (jabatan.contains("admin")){
                mainApp.initAdminLayout();
            }
        }
    }
    

    @FXML
    private void btnCancelAction(ActionEvent event) {
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
