/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagement;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import pharmacymanagement.fxml.AddResepController;
import pharmacymanagement.fxml.AdminLayoutController;
import pharmacymanagement.fxml.ApotekerLayoutController;
import pharmacymanagement.fxml.DokterLayoutController;
import pharmacymanagement.fxml.KasirLayoutController;
import pharmacymanagement.fxml.KelolaAccountController;
import pharmacymanagement.fxml.KelolaDokterController;
import pharmacymanagement.fxml.KelolaObatController;
import pharmacymanagement.fxml.ListObatController;
import pharmacymanagement.fxml.ListResepController;
import pharmacymanagement.fxml.LoginController;
import pharmacymanagement.fxml.PemusnahanObatController;
import pharmacymanagement.fxml.TransaksiController;

/**
 *
 * @author drag me to hell
 */
public class PharmacyManagement extends Application {
    
    private Stage primaryStage;
    private BorderPane rootLayout;
    private AnchorPane rootLogin;
    String namaDokter;
    String spesialis;
    
    @Override
    public void start(Stage primaryStage) {
      this.primaryStage = primaryStage;
      this.primaryStage.setTitle("Pharmacy Management");
      this.primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("images/icon/PMS-ICON.png")));

      try {
         initLoginLayout();
      } catch (IOException ex) {
         Logger.getLogger(PharmacyManagement.class.getName()).log(Level.SEVERE, null, ex);
      }
//        Button btn = new Button();
//        btn.setText("Say 'Hello World'");
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Hello World!");
//            }
//        });
//        
//        StackPane root = new StackPane();
//        root.getChildren().add(btn);
//        
//        Scene scene = new Scene(root, 300, 250);
//        
//        primaryStage.setTitle("Hello World!");
//        primaryStage.setScene(scene);
//        primaryStage.show();
    }
    
     public Stage getPrimaryStage() {
      return primaryStage;
   }
     
     public String[] trimDocument(String text) {
      String[] tmpDoc = text.split("\\.");
      return tmpDoc;
   }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public void showAlert(String title, String headerText, String contentText, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.initOwner(primaryStage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();
   }
    //---------------------------------------------------------------------
    
    public void initLoginLayout() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(PharmacyManagement.class.getResource("fxml/Login.fxml"));
        AnchorPane ap = (AnchorPane) loader.load();
        //rootLogin = (AnchorPane) anchor.getChildren().get(0);
        LoginController controller = loader.getController();
        controller.setMainApp(this);
        Scene scene = new Scene(ap);
        primaryStage.setScene(scene);
        primaryStage.show();
   }
    
   public void initApotekerLayout() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(PharmacyManagement.class.getResource("fxml/ApotekerLayout.fxml"));
        AnchorPane anchor = (AnchorPane) loader.load();
        rootLayout = (BorderPane) anchor.getChildren().get(0);
        ApotekerLayoutController controller = loader.getController();
        controller.setMainApp(this);
        Scene scene = new Scene(anchor);
        primaryStage.setScene(scene);
        primaryStage.setX(0);
        primaryStage.setY(0);
        primaryStage.show();
   }
   
   public void initDokterLayout() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(PharmacyManagement.class.getResource("fxml/DokterLayout.fxml"));
        AnchorPane anchor = (AnchorPane) loader.load();
        rootLayout = (BorderPane) anchor.getChildren().get(0);
        DokterLayoutController controller = loader.getController();
        controller.setMainApp(this);
        Scene scene = new Scene(anchor);
        primaryStage.setScene(scene);
        primaryStage.show();
   }
   
   public void initAdminLayout() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(PharmacyManagement.class.getResource("fxml/AdminLayout.fxml"));
        AnchorPane anchor = (AnchorPane) loader.load();
        rootLayout = (BorderPane) anchor.getChildren().get(0);
        AdminLayoutController controller = loader.getController();
        controller.setMainApp(this);
        Scene scene = new Scene(anchor);
        primaryStage.setScene(scene);
        primaryStage.setX(0);
        primaryStage.setY(0);
        primaryStage.show();
   }
   
   public void setDokter(String nd, String s){
       this.namaDokter = nd;
       this.spesialis = s;
   }
   
   public String getNamaDokter(){
       return namaDokter;
   }
   
   public String getSpesialis(){
       return spesialis;
   }
   
   public void initKasirLayout() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(PharmacyManagement.class.getResource("fxml/KasirLayout.fxml"));
        AnchorPane anchor = (AnchorPane) loader.load();
        rootLayout = (BorderPane) anchor.getChildren().get(0);
        KasirLayoutController controller = loader.getController();
        controller.setMainApp(this);
        Scene scene = new Scene(anchor);
        primaryStage.setScene(scene);
        primaryStage.setX(0);
        primaryStage.setY(0);
        primaryStage.show();
   }
   
   //########################################################################
   public void showResepMasuk() throws IOException {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(PharmacyManagement.class.getResource("fxml/ListResep.fxml"));
      AnchorPane ap = (AnchorPane) loader.load();
      rootLayout.setCenter(ap);
      ListResepController controller = loader.getController();
      controller.setMainApp(this);
   }
   
   public void showListObat() throws IOException {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(PharmacyManagement.class.getResource("fxml/ListObat.fxml"));
      AnchorPane ap = (AnchorPane) loader.load();
      rootLayout.setCenter(ap);
      ListObatController controller = loader.getController();
      controller.setMainApp(this);
   }
   
   public void showCatatPemusnahan() throws IOException {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(PharmacyManagement.class.getResource("fxml/PemusnahanObat.fxml"));
      AnchorPane ap = (AnchorPane) loader.load();
      rootLayout.setCenter(ap);
      PemusnahanObatController controller = loader.getController();
      controller.setMainApp(this);
   }
   
   public void showAddResep() throws IOException {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(PharmacyManagement.class.getResource("fxml/AddResep.fxml"));
      AnchorPane ap = (AnchorPane) loader.load();
      rootLayout.setCenter(ap);
      AddResepController controller = loader.getController();
      controller.setMainApp(this);
   }
   
   public void showTransaksi() throws IOException {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(PharmacyManagement.class.getResource("fxml/Transaksi.fxml"));
      AnchorPane ap = (AnchorPane) loader.load();
      rootLayout.setCenter(ap);
      TransaksiController controller = loader.getController();
      controller.setMainApp(this);
   }
   
   public void showKelolaObat() throws IOException{
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(PharmacyManagement.class.getResource("fxml/KelolaObat.fxml"));
      AnchorPane ap = (AnchorPane) loader.load();
      rootLayout.setCenter(ap);
      KelolaObatController controller = loader.getController();
      controller.setMainApp(this);
   }
   
   public void showKelolaAkun() throws IOException{
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(PharmacyManagement.class.getResource("fxml/KelolaAccount.fxml"));
      AnchorPane ap = (AnchorPane) loader.load();
      rootLayout.setCenter(ap);
      KelolaAccountController controller = loader.getController();
      controller.setMainApp(this);
   }
   
   public void showKelolaDokter() throws IOException{
       FXMLLoader loader = new FXMLLoader();
      loader.setLocation(PharmacyManagement.class.getResource("fxml/KelolaDokter.fxml"));
      AnchorPane ap = (AnchorPane) loader.load();
      rootLayout.setCenter(ap);
      KelolaDokterController controller = loader.getController();
      controller.setMainApp(this);
   }
}
