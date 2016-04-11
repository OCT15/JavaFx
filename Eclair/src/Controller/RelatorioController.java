/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Acessa;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author ETESP
 */
public class RelatorioController implements Initializable {

    @FXML
    private TableView<RelatorioMaster> tbl1;
    @FXML
    private TableColumn<RelatorioMaster, String> nomeCol;
    @FXML
    private TableColumn<RelatorioMaster, String> senhaCol;
    @FXML
    private TableColumn<RelatorioMaster, Integer> idCol;
    

    Acessa c = new Acessa();

    /**
     * Initializes the controller class.
     */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        assert tbl1 != null :"fx:id=\\\"tbl1\\\" was not injected: check your FXML file 'Relatorio.fxml'.";
       
        nomeCol.setCellValueFactory(
        new PropertyValueFactory<RelatorioMaster,String>("nome"));
        senhaCol.setCellValueFactory(
        new PropertyValueFactory<RelatorioMaster,String>("senha"));
        idCol.setCellValueFactory(
        new PropertyValueFactory<RelatorioMaster,Integer>("id"));
        try {
            buildData();
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private ObservableList<RelatorioMaster> data;

    public void buildData() throws SQLException {
        data = FXCollections.observableArrayList();
        try{
            c.conectar();
            c.executarSQL("select * from funcionario");
            while(c.rs.next())
            {
                
                RelatorioMaster rm = new RelatorioMaster();
                rm.setId(c.rs.getInt("id"));
                rm.setNome(c.rs.getString("nome"));
                rm.setSenha(c.rs.getString("senha"));
                data.add(rm);
            }
            tbl1.setItems(data);
            
        }catch(Exception e )
        {
            e.printStackTrace();
            System.out.println("Error on building Data");
        }
    }

}
