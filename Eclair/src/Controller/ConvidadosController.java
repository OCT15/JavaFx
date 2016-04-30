package Controller;

import Model.Convidado;
import Model.ConvidadoModel;
import Model.Persist;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

public class ConvidadosController implements Initializable {

    @FXML
    private JFXTabPane root;
    @FXML
    private JFXButton btnSair;
    @FXML
    private TableView<Convidado> tblConv;
    @FXML
    private TableColumn<Convidado, String> colNome;
    @FXML
    private TableColumn<Convidado, String> colPres;

    private ConvidadoModel cm = new ConvidadoModel();

    @FXML
    private JFXTextField txtPesquisar;
    @FXML
    private JFXTextField txtNome;
    Persist p = new Persist();

    private ObservableList<Convidado> masterData = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //tblConv.setItems(masterData);
        tblConv.setEditable(false);
        //Inicializa as colunas
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colPres.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));

        //Adiciona os dados à tabela
        try {
            cm.selecionarConvidados(tblConv, "");
            masterData = p.getData();

        } catch (SQLException ex) {
            Logger.getLogger(ConvidadosController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        // Liga FilteredList aos dados mandados para persistência
        FilteredList<Convidado> filteredData = new FilteredList<>(masterData, p -> true);

        // Muda o predicado do filtro toda vez que o filtro muda
        txtPesquisar.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(convidado -> {
                // se o filtro está vazio, mostra todos os dados
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                //compara o nome de cada convidado com o filtro
                String lowerCaseFilter = newValue.toLowerCase();

                if (convidado.getNome().toLowerCase().contains(lowerCaseFilter)) {

                    return true;//filtra o nome
                }
                return false;//nada encontrado

            });
        }
        );
        // Liga filteredList na SortedList
        SortedList<Convidado> sortedData = new SortedList<>(filteredData);

        //Liga o comparador da SortedList com o comparador da tabela 
        sortedData.comparatorProperty().bind(tblConv.comparatorProperty());

        //adiciona os dados da SortedList (e filtered) na tabela 
        tblConv.setItems(sortedData);

        //Adiciona as CheckBoxes à coluna de comparecidos
        Callback<TableColumn<Convidado, String>, TableCell<Convidado, String>> cellFactory
                = //
                new Callback<TableColumn<Convidado, String>, TableCell<Convidado, String>>() {
                    @Override
                    public TableCell call(final TableColumn<Convidado, String> param) {
                        final TableCell<Convidado, String> cell = new TableCell<Convidado, String>() {
                            final JFXCheckBox btn = new JFXCheckBox();

                            @Override
                            public void updateItem(String item, boolean empty) {
                                super.updateItem(item, empty);

                                if (empty) {
                                    setGraphic(null);
                                    setText(null);
                                } else {
                                    try {
                                        for (int i = 0; i < sortedData.size(); i++) {
                                            if (i == this.getTableRow().getIndex()) {
                                                btn.setSelected(cm.getCompareceu(sortedData.get(i).getNome()));
                                            }
                                        }

                                    } catch (SQLException ex) {
                                        Logger.getLogger(ConvidadosController.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    //Action Event do CheckBox
                                    btn.setOnAction((ActionEvent event) -> {
                                        Convidado person = getTableView().getItems().get(getIndex());
                                        person.setCompareceu(btn.isSelected());
                                        try {
                                            int ind = this.getTableRow().getIndex();
                                            String nome = sortedData.get(ind).getNome();
                                            int id = cm.getId(nome);
                                            cm.updateCompareceu(id, btn.isSelected());
                                        } catch (SQLException ex) {
                                            Logger.getLogger(ConvidadosController.class.getName()).log(Level.SEVERE, null, ex);
                                        }

                                    });
                                    setGraphic(btn);

                                    setText(null);
                                }
                            }
                        };
                        return cell;
                    }
                };

        colPres.setCellFactory(cellFactory);

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

    @FXML
    private void AddConvidado(ActionEvent event) {
        cm.addConvidado(txtNome.getText(), tblConv);
        txtNome.setText("");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alerta");
        alert.setHeaderText(null);
        alert.setContentText("Convidado adicionado com sucesso!");
        alert.showAndWait();
    }

}
