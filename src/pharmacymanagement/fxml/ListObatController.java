/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagement.fxml;

import java.awt.Color;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import static net.sf.dynamicreports.report.builder.DynamicReports.cmp;
import static net.sf.dynamicreports.report.builder.DynamicReports.col;
import static net.sf.dynamicreports.report.builder.DynamicReports.report;
import static net.sf.dynamicreports.report.builder.DynamicReports.stl;
import static net.sf.dynamicreports.report.builder.DynamicReports.type;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import pharmacymanagement.PharmacyManagement;
import pharmacymanagement.implement.ObatImpl;
import pharmacymanagement.interfaces.ObatInter;
import pharmacymanagement.models.Obat_M;
import net.sf.dynamicreports.report.builder.column.PercentageColumnBuilder;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.style.StyleBuilder;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * FXML Controller class
 *
 * @author drag me to hell
 */
public class ListObatController implements Initializable {
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
    private Button btnCetakObat;

    /**
     * Initializes the controller class.
     */
    private PharmacyManagement mainApp;
    ObatInter crudObat = new ObatImpl();
    ObservableList<Obat_M> listObat;
    ObservableList<Obat_M> getPengadaanObat;
    ObservableList<Obat_M> listByNama;

    public void setMainApp(PharmacyManagement mainApp) {
       this.mainApp = mainApp;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
                        cellData.getValue().subObatProperty());
         listObat = FXCollections.observableArrayList();
         listObat = crudObat.getAllObat();
         for (int i = 0; i < listObat.size(); i++) {
             int stok = listObat.get(i).getStok();
             String namaObat = listObat.get(i).getNamaObat();
             if (stok < 20) {
                 showAlert("Warning", "Stok Menipis", "Stok obat "+namaObat+" sudah menipis, harap segera melakukan pengadaan", Alert.AlertType.WARNING);
             }
         }
         tableObat.setItems(listObat);
    }    

    @FXML
    private void inSearchAction(KeyEvent event) {
        listByNama = crudObat.getObatByNama(inSearch.getText());
        tableObat.setItems(listByNama);
    }

    @FXML
    private void btnCetakObatAction(ActionEvent event) {
        ObservableList<Obat_M> pengadaan = crudObat.getPengadaanObat();
        JRBeanCollectionDataSource src = new JRBeanCollectionDataSource(pengadaan);
        StyleBuilder boldStyle         = stl.style().bold();
        StyleBuilder boldCenteredStyle = stl.style(boldStyle).setHorizontalAlignment(HorizontalAlignment.CENTER);
        StyleBuilder columnTitleStyle  = stl.style(boldCenteredStyle)
                                            .setBorder(stl.pen1Point())
                                            .setBackgroundColor(Color.LIGHT_GRAY);
        //                                                           title,     field name     data type
        TextColumnBuilder<String>     namaObat      = col.column("Nama Obat", "namaObat", String.class).setStyle(boldStyle);
        TextColumnBuilder<String>     kategoriObat      = col.column("Kategori Obat", "kategoriObat", String.class).setStyle(boldStyle);
        TextColumnBuilder<String>     subObat      = col.column("Sub Kategori Obat", "subObat", String.class).setStyle(boldStyle);
        TextColumnBuilder<String>     kemasan     = col.column("Kemasan", "kemasan", String.class).setStyle(boldStyle);
        TextColumnBuilder<Double>     hargaObat      = col.column("Harga Obat", "hargaObat", Double.class).setStyle(boldStyle);
        TextColumnBuilder<Integer>     stok      = col.column("Stok", "stok", Integer.class).setStyle(boldStyle);
        TextColumnBuilder<String>     keterangan      = col.column("Keterangan", "deskripsi", String.class).setStyle(boldStyle);
        TextColumnBuilder<Integer>    rowNumberColumn = col.reportRowNumberColumn("No.")
                                                    //sets the fixed width of a column, width = 2 * character width
                                                   .setFixedColumns(2)
                                                   .setHorizontalAlignment(HorizontalAlignment.CENTER);
        try {
           report()//create new report design
             .setColumnTitleStyle(columnTitleStyle)
             .setSubtotalStyle(boldStyle)
             .highlightDetailEvenRows()
             .columns(//add columns
              rowNumberColumn, namaObat, kategoriObat, subObat, kemasan, hargaObat, stok, keterangan)
             .groupBy(kategoriObat)
             .title(cmp.text("List Pengadaan Obat").setStyle(boldCenteredStyle))//shows report title
             .pageFooter(cmp.pageXofY().setStyle(boldCenteredStyle))//shows number of page at page footer
             .setDataSource(src)//set datasource
             .show();//create and show report
        } catch (DRException e) {
           e.printStackTrace();
        }
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
