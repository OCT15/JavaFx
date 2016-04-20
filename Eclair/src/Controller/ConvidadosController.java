/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Evento;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTabPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author aluno
 */
public class ConvidadosController implements Initializable {

    @FXML
    private JFXTabPane root;
    @FXML
    private JFXButton btnPesq;
    @FXML
    private JFXButton btnSair;
    @FXML
    private TableView<Evento> tblConv;
    @FXML
    private TableColumn<Evento, String> colNome;
    @FXML
    private TableColumn<Evento,String> colPres;

   /* private final ObservableList<Evento> data = FXCollections.observableArrayList(
            new Evento("2", "2", "22", "2323", "3232"),
            new Evento("243", "2", "22", "2323", "3232")
    );*/

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

       /* tblConv.setEditable(false);
        colNome.setCellValueFactory(
                new PropertyValueFactory<>("idEvento"));

        colPres.setCellValueFactory( new PropertyValueFactory<>( "DUMMY" ));
        Callback<TableColumn<Evento, String>, TableCell<Evento, String>> cellFactory = //
                new Callback<TableColumn<Evento, String>, TableCell<Evento, String>>()
                {
                    @Override
                    public TableCell call( final TableColumn<Evento, String> param )
                    {
                        final TableCell<Evento, String> cell = new TableCell<Evento, String>()
                        {

                            final JFXCheckBox btn = new JFXCheckBox( "Just Do It" );

                            @Override
                            public void updateItem( String item, boolean empty )
                            {
                                super.updateItem( item, empty );
                                if ( empty )
                                {
                                    setGraphic( null );
                                    setText( null );
                                }
                                else
                                {
                                    btn.setOnAction( ( ActionEvent event ) ->
                                            {
                                                Evento person = getTableView().getItems().get( getIndex() );
                                                System.out.println( person.getIdEvento()+ "   " + person.getIdCli());
                                    } );
                                    setGraphic( btn );
                                    setText( null );
                                }
                            }
                        };
                        return cell;
                    }
                };
        colPres.setCellFactory(cellFactory);
        tblConv.setItems(data);*/
    }

    @FXML

    private void Pesquisar(ActionEvent event) {
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
        Stage stage2 = (Stage) btnSair.getScene().getWindow();
        // do what you have to do
        stage2.close();
    }

}
