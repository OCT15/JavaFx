/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hue;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ETESP
 */
public class LoginController implements Initializable {

    @FXML
    private JFXTextField txtUsuario;
    @FXML
    private JFXPasswordField txtSenha;
    @FXML
    private JFXButton btnLogin;
    @FXML
    private JFXButton btnSair;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void Click(ActionEvent event) throws IOException {
        
        Acessa c = new Acessa();
        c.conectar();
        String a = txtUsuario.getText();
        String b = txtSenha.getText();
        c.executarSQL("select * from funcionario where name='" + a
                + "' and id='" + b + "'");
        try {
            if (c.rs.next()) {
                int cont = c.rs.getRow();
                if (cont != 0) {

                    FXMLLoader fxmlLoader;
                    fxmlLoader = new FXMLLoader(getClass().getResource("Menu.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.initModality(Modality.APPLICATION_MODAL);
                    // stage.initStyle(StageStyle.UNDECORATED);
                    stage.setTitle("Menu");
                    stage.setFullScreen(true);
                    stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
                    stage.setResizable(false);
                    stage.setScene(new Scene(root1));
                    stage.show();
                    //-----
                    Stage stage2 = (Stage) btnLogin.getScene().getWindow();
                    // do what you have to do
                    stage2.close();

                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos");
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        c.desconectar();
    }

    @FXML
    private void ClickSair(ActionEvent event) {
        System.exit(0);
    }


    @FXML
    private void onEnter(KeyEvent event) throws IOException {
        if(event.getCode().equals(KeyCode.ENTER))
        {
           this.Click(null); 
        }
        
    }
    
}
