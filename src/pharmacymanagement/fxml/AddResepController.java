/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagement.fxml;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import pharmacymanagement.PharmacyManagement;
import pharmacymanagement.implement.DokterSpesialis;
import pharmacymanagement.implement.ResepImpl;
import pharmacymanagement.interfaces.ResepInter;
import pharmacymanagement.models.Resep_M;

/**
 * FXML Controller class
 *
 * @author drag me to hell
 */
public class AddResepController implements Initializable {
    @FXML
    private TextField inKodeResep;
    @FXML
    private Label lblNamaDokter;
    @FXML
    private Label lblSpesialis;
    @FXML
    private Label lblFile;
    @FXML
    private Button btnImport;
    @FXML
    private Button btnAddResep;

    /**
     * Initializes the controller class.
     */
    private PharmacyManagement mainApp;
    ResepInter crudData = new ResepImpl();
    ObservableList<Resep_M> listData;
    File file;
    //JFileC

    public void setMainApp(PharmacyManagement mainApp) {
       this.mainApp = mainApp;
    }
    //String namaDokter = "Fajar Shidiq Ramadhani";
    //String spesialis = "THT";
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblNamaDokter.setText(DokterSpesialis.getDokter());
        lblSpesialis.setText(DokterSpesialis.getSpesialis());
    }    

    @FXML
    private void btnImportAction(ActionEvent event) {
      file = new FileChooser().showOpenDialog(mainApp.getPrimaryStage());
      if (file != null) {
         //lblFile.setText(file.getName());
         String[] text = mainApp.trimDocument(file.getName());
         lblFile.setText(file.getName());
      }
    }

    @FXML
    private void btnAddResepAction(ActionEvent event) throws IOException {
        //Path copyFile = Files.copy(FileSystems.getDefault().getPath(file.getPath()), FileSystems.getDefault().getPath("Resep/" + file.getName()), StandardCopyOption.REPLACE_EXISTING);
        String[] tmpDoc = mainApp.trimDocument(file.getName());
        Resep_M r = new Resep_M();
        r.setKodeResep(inKodeResep.getText());
        r.setKodeDokter(DokterSpesialis.getKodeDokter());
        r.setPathResep(lblFile.getText());
        r.setStatus("Belum dilayani");
        //r.setIdPasien("pas001");
        crudData.insert(r);
        try {
            Path copyFile = Files.copy(FileSystems.getDefault().getPath(file.getPath()), FileSystems.getDefault().getPath("Resep/" + file.getName()), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            Logger.getLogger(AddResepController.class.getName()).log(Level.SEVERE, null, ex);
        }
        clear();
        //       DocumentFilling pd = new DocumentFilling(inDate.getValue(), lblDocumentName.getText(), null, inDateReceived.getValue(), new Document(tmpDoc[0], tmpDoc[1], file.getName()));
    }
    
    private void clear(){
        inKodeResep.clear();
        lblFile.setText(null);
    }
    
}
