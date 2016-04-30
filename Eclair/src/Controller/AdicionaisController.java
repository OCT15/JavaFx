/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Mobilha;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author aluno
 */
public class AdicionaisController implements Initializable {

    @FXML
    private Label lblTotal;
    @FXML
    private TableView<Mobilha> tblMob;
    @FXML
    private TableColumn<Mobilha, String> colMob;
    @FXML
    private TableColumn<Mobilha, Double> colPrec;
    @FXML
    private TableColumn<Mobilha, String> colQuant;

    

    private int[] qtds = new int[9];

    private final ObservableList<Mobilha> list = FXCollections.observableArrayList(
            new Mobilha("Garfos", 90.00, "0"),
            new Mobilha("Facas", 90.00, "0"),
            new Mobilha("Pratos", 15.00, "0"),
            new Mobilha("Colheres", 90.00, "0"),
            new Mobilha("Mesas", 1500.00, "0"),
            new Mobilha("Cadeiras", 500.00, "0"),
            new Mobilha("Copos", 120.00, "0"),
            new Mobilha("Taças", 150.00, "0"),
            new Mobilha("Adornos", 700.00, "0")
    );
    @FXML
    private JFXButton btnVoltar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        assert tblMob != null : "fx:id=\"tblMob\" was not injected: check your FXML file 'Adicionais.fxml'.";
        tblMob.setEditable(true);
        lblTotal.setText("0.0");
        colQuant.setEditable(true);

        colMob.setCellValueFactory(
                new PropertyValueFactory<Mobilha, String>("nome"));

        colPrec.setCellValueFactory(
                new PropertyValueFactory<Mobilha, Double>("preco"));

        colQuant.setCellValueFactory(
                new PropertyValueFactory<Mobilha, String>("qtd"));

        colQuant.setCellFactory(TextFieldTableCell.forTableColumn());

        colQuant.setOnEditCommit(
                new EventHandler<CellEditEvent<Mobilha, String>>() {
            @Override
            public void handle(CellEditEvent<Mobilha, String> t) {
                ((Mobilha) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setQtd(t.getNewValue());
                double prec[] = new double[9];
                double qtd[] = new double[9];
                double total = 0.0d;
                for (int i = 0; i < 9; i++) {
                    prec[i] = colPrec.getCellData(i);
                    qtd[i] = Double.parseDouble(colQuant.getCellData(i));                    
                    total += prec[i] * qtd[i];
                }
                lblTotal.setText(String.valueOf(total));
            }
        }
        );
        tblMob.setItems(list);
    }

    @FXML
    private void btnAdd(ActionEvent event) {

    }

    @FXML
    private void Sair(ActionEvent event) throws IOException {
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
        Stage stage2 = (Stage) btnVoltar.getScene().getWindow();
        // do what you have to do
        stage2.close();
    }

}
