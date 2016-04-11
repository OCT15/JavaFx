/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.LoginModel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
    
    private String usuario, senha;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    
    @FXML
    private void Click(ActionEvent e) throws IOException, SQLException {
        usuario = txtUsuario.getText();
        senha = txtSenha.getText();
        LoginModel lm = new LoginModel();
        lm.connect(usuario, senha);
        
        if(lm.isOk()==true)
        {
        
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
                Stage stage2 = (Stage) btnLogin.getScene().getWindow();
                // do what you have to do
                stage2.close();
        }
        
    }

    @FXML
    private void ClickSair(ActionEvent event) {
        System.exit(0);
    }


    @FXML
    private void onEnter(KeyEvent event) throws IOException, SQLException {
        if(event.getCode().equals(KeyCode.ENTER))
        {
           this.Click(null); 
        }
        
    }
    
}
