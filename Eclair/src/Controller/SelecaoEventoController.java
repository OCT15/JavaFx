/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Evento;
import Model.Persist;
import Model.SelecaoEventoModel;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import sun.plugin2.jvm.RemoteJVMLauncher;

/**
 * FXML Controller class
 *
 * @author danie
 */
public class SelecaoEventoController implements Initializable {

    private SelecaoEventoModel sem = new SelecaoEventoModel();
    @FXML
    private TableView<Evento> tblEvento;
    @FXML
    private TableColumn<Evento, String> colid;
    @FXML
    private TableColumn<Evento, String> colCli;
    @FXML
    private TableColumn<Evento, String> colData;
    @FXML
    private TableColumn<Evento, String> colHora;
    @FXML
    private TableColumn<Evento, String> colLug;

    Persist p = new Persist();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        assert tblEvento != null : "fx:id=\"tblEvento\" was not injected: check your FXML file 'Evento.fxml'.";
        colid.setCellValueFactory(
                new PropertyValueFactory<Evento, String>("idEvento"));
        colCli.setCellValueFactory(
                new PropertyValueFactory<Evento, String>("idCli"));
        colData.setCellValueFactory(
                new PropertyValueFactory<Evento, String>("data"));
        colHora.setCellValueFactory(
                new PropertyValueFactory<Evento, String>("hora"));
        colLug.setCellValueFactory(
                new PropertyValueFactory<Evento, String>("lugar"));
        try {
            sem.selecionarEventos(tblEvento);
        } catch (SQLException ex) {
            Logger.getLogger(SelecaoEventoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        tblEvento.setRowFactory(tv -> {
            TableRow<Evento> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    try {
                        Evento rowData = row.getItem();
                        //System.out.println(rowData.getIdEvento());
                        p.setId_evento(rowData.getIdEvento());
                        FXMLLoader fxmlLoader;
                        fxmlLoader = new FXMLLoader(getClass().getResource("/View/MenuGerente.fxml"));
                        Parent root1 = (Parent) fxmlLoader.load();
                        Stage stage = new Stage();
                        stage.initModality(Modality.APPLICATION_MODAL);
                        stage.initStyle(StageStyle.UNDECORATED);
                        stage.setTitle("Menu");                        
                        stage.setResizable(false);
                        stage.setScene(new Scene(root1));
                        stage.show();
                        //-----
                        Stage stage2 = (Stage) tblEvento.getScene().getWindow();
                        // do what you have to do
                        stage2.close();
                    } catch (IOException ex) {
                        Logger.getLogger(SelecaoEventoController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            return row;
        });

    }

}
