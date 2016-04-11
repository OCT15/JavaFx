package Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import io.datafx.controller.flow.FlowException;
import io.datafx.controller.util.VetoException;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class EstacionamentoDController implements Initializable {
// <editor-fold defaultstate="collapsed" desc="Declaração de objetos">

    @FXML
    private JFXToggleButton btn1;
    @FXML
    private JFXToggleButton btn2;
    @FXML
    private JFXToggleButton btn3;
    @FXML
    private JFXToggleButton btn4;
    @FXML
    private JFXToggleButton btn5;
    @FXML
    private JFXToggleButton btn6;
    @FXML
    private JFXToggleButton btn7;
    @FXML
    private JFXToggleButton btn8;
    @FXML
    private JFXToggleButton btn9;
    @FXML
    private JFXToggleButton btn10;
    @FXML
    private JFXToggleButton btn11;
    @FXML
    private JFXToggleButton btn12;
    @FXML
    private JFXToggleButton btn13;
    @FXML
    private JFXToggleButton btn14;
    @FXML
    private JFXToggleButton btn15;
    @FXML
    private JFXToggleButton btn16;
    @FXML
    private JFXToggleButton btn17;
    @FXML
    private JFXToggleButton btn18;
    @FXML
    private JFXToggleButton btn19;
    @FXML
    private JFXToggleButton btn20;
    @FXML
    private JFXToggleButton btn21;
    @FXML
    private JFXToggleButton btn22;
    @FXML
    private JFXToggleButton btn23;
    @FXML
    private JFXToggleButton btn24;

    @FXML
    private Pane root;

    Placa p = new Placa();

    @FXML
    private Label lbl1;
    @FXML
    private Label lbl4;
    @FXML
    private Label lbl2;
    @FXML
    private Label lbl3;
    @FXML
    private Label lbl5;
    @FXML
    private Label lbl6;
    @FXML
    private Label lbl18;
    @FXML
    private Label lbl17;
    @FXML
    private Label lbl13;
    @FXML
    private Label lbl15;
    @FXML
    private Label lbl14;
    @FXML
    private Label lbl16;

    private Label lbla = new Label("Ala A");
    private Label lblb = new Label("Ala B");
    private Label lblc = new Label("Ala C");
    private Label lbld = new Label("Ala D");

    @FXML
    private JFXComboBox<Label> cmbAla;
    @FXML
    private JFXButton btnVoltar;
    @FXML
    private JFXTextField txtSearch;
    @FXML
    private JFXButton btnSearch;

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Metodos da Classe">
    private void placosa(JFXToggleButton btn){
        TextInputDialog dialog = new TextInputDialog();
        if (btn.isSelected()) {

            dialog.setTitle("Estacionamento");
            dialog.setHeaderText("Insira o número da placa");
            dialog.setContentText("Número da placa:");

            Optional<String> result = dialog.showAndWait();
            if (result.isPresent()) {
                if (btn == btn1) {
                    p.setPlaca(0, result.get());
                } else if (btn == btn2) {
                    p.setPlaca(1, result.get());
                } else if (btn == btn3) {
                    p.setPlaca(2, result.get());
                } else if (btn == btn4) {
                    p.setPlaca(3, result.get());
                } else if (btn == btn5) {
                    p.setPlaca(4, result.get());
                } else if (btn == btn6) {
                    p.setPlaca(5, result.get());
                } else if (btn == btn7) {
                    p.setPlaca(6, result.get());
                } else if (btn == btn8) {
                    p.setPlaca(7, result.get());
                } else if (btn == btn9) {
                    p.setPlaca(8, result.get());
                } else if (btn == btn10) {
                    p.setPlaca(9, result.get());
                } else if (btn == btn11) {
                    p.setPlaca(10, result.get());
                } else if (btn == btn12) {
                    p.setPlaca(11, result.get());
                } else if (btn == btn13) {
                    p.setPlaca(12, result.get());
                } else if (btn == btn14) {
                    p.setPlaca(13, result.get());
                } else if (btn == btn15) {
                    p.setPlaca(14, result.get());
                } else if (btn == btn16) {
                    p.setPlaca(15, result.get());
                } else if (btn == btn17) {
                    p.setPlaca(16, result.get());
                } else if (btn == btn18) {
                    p.setPlaca(17, result.get());
                } else if (btn == btn19) {
                    p.setPlaca(18, result.get());
                } else if (btn == btn20) {
                    p.setPlaca(19, result.get());
                } else if (btn == btn21) {
                    p.setPlaca(20, result.get());
                } else if (btn == btn22) {
                    p.setPlaca(21, result.get());
                } else if (btn == btn23) {
                    p.setPlaca(22, result.get());
                } else if (btn == btn24) {
                    p.setPlaca(23, result.get());
                }

            }

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb
    ) {
        cmbAla.getItems().add(lbla);
        cmbAla.getItems().add(lblb);
        cmbAla.getItems().add(lblc);
        cmbAla.getItems().add(lbld);

    }
// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Action Methods">

    @FXML
    private void Tog1(ActionEvent event) throws FlowException, VetoException {
        placosa(btn1);

    }

    @FXML
    private void Tog2(ActionEvent event
    ) {
        placosa(btn2);
    }

    @FXML
    private void Tog3(ActionEvent event
    ) {
        placosa(btn3);
    }

    @FXML
    private void Tog4(ActionEvent event
    ) {
        placosa(btn4);
    }

    @FXML
    private void Tog5(ActionEvent event
    ) {
        placosa(btn5);
    }

    @FXML
    private void Tog6(ActionEvent event
    ) {
        placosa(btn6);
    }

    @FXML
    private void Tog7(ActionEvent event
    ) {
        placosa(btn7);
    }

    @FXML
    private void Tog8(ActionEvent event
    ) {
        placosa(btn8);
    }

    @FXML
    private void Tog9(ActionEvent event
    ) {
        placosa(btn9);
    }

    @FXML
    private void Tog10(ActionEvent event
    ) {
        placosa(btn10);
    }

    @FXML
    private void Tog11(ActionEvent event
    ) {
        placosa(btn11);
    }

    @FXML
    private void Tog12(ActionEvent event
    ) {
        placosa(btn12);
    }

    @FXML
    private void Tog13(ActionEvent event
    ) {
        placosa(btn13);
    }

    @FXML
    private void Tog14(ActionEvent event
    ) {
        placosa(btn14);
    }

    @FXML
    private void Tog15(ActionEvent event
    ) {
        placosa(btn15);
    }

    @FXML
    private void Tog16(ActionEvent event
    ) {
        placosa(btn16);
    }

    @FXML
    private void Tog17(ActionEvent event
    ) {
        placosa(btn17);
    }

    @FXML
    private void Tog18(ActionEvent event
    ) {
        placosa(btn18);
    }

    @FXML
    private void Tog19(ActionEvent event
    ) {
        placosa(btn19);
    }

    @FXML
    private void Tog20(ActionEvent event
    ) {
        placosa(btn20);
    }

    @FXML
    private void Tog21(ActionEvent event
    ) {
        placosa(btn21);
    }

    @FXML
    private void Tog22(ActionEvent event
    ) {
        placosa(btn22);
    }

    @FXML
    private void Tog23(ActionEvent event
    ) {
        placosa(btn23);
    }

    @FXML
    private void Tog24(ActionEvent event
    ) {
        placosa(btn24);
    }

    @FXML
    private void Mex1(MouseEvent event) {
        lbl1.setText("");
    }

    @FXML
    private void Me1(MouseEvent event) {
        if (btn1.isSelected()) {
            lbl1.setText(p.getPlaca(0));
        }
    }

    @FXML
    private void Mex2(MouseEvent event) {
        lbl2.setText("");
    }

    @FXML
    private void Me2(MouseEvent event) {
        if (btn2.isSelected()) {
            lbl2.setText(p.getPlaca(1));
        }
    }

    @FXML
    private void Mex3(MouseEvent event) {
        lbl3.setText("");
    }

    @FXML
    private void Me3(MouseEvent event) {
        if (btn3.isSelected()) {
            lbl3.setText(p.getPlaca(2));
        }
    }

    @FXML
    private void Mex4(MouseEvent event) {
        lbl4.setText("");
    }

    @FXML
    private void Me4(MouseEvent event) {
        if (btn4.isSelected()) {
            lbl4.setText(p.getPlaca(3));
        }
    }

    @FXML
    private void Mex6(MouseEvent event) {
        lbl6.setText("");
    }

    @FXML
    private void Me6(MouseEvent event) {
        if (btn6.isSelected()) {
            lbl6.setText(p.getPlaca(5));
        }
    }

    @FXML
    private void Mex7(MouseEvent event) {
        lbl1.setText("");
    }

    @FXML
    private void Me7(MouseEvent event) {
        if (btn7.isSelected()) {
            lbl1.setText(p.getPlaca(6));
        }
    }

    @FXML
    private void Mex8(MouseEvent event) {
        lbl2.setText("");
    }

    @FXML
    private void Me8(MouseEvent event) {
        if (btn8.isSelected()) {
            lbl2.setText(p.getPlaca(7));
        }
    }

    @FXML
    private void Mex9(MouseEvent event) {
        lbl3.setText("");
    }

    @FXML
    private void Me9(MouseEvent event) {
        if (btn9.isSelected()) {
            lbl3.setText(p.getPlaca(8));
        }
    }

    @FXML
    private void Mex10(MouseEvent event) {
        lbl4.setText("");
    }

    @FXML
    private void Me10(MouseEvent event) {
        if (btn10.isSelected()) {
            lbl4.setText(p.getPlaca(9));
        }
    }

    @FXML
    private void Mex11(MouseEvent event) {
        lbl5.setText("");
    }

    @FXML
    private void Me11(MouseEvent event) {
        if (btn11.isSelected()) {
            lbl5.setText(p.getPlaca(10));
        }
    }

    @FXML
    private void Mex12(MouseEvent event) {
        lbl6.setText("");
    }

    @FXML
    private void Me12(MouseEvent event) {
        if (btn12.isSelected()) {
            lbl6.setText(p.getPlaca(11));
        }
    }

    @FXML
    private void Mex13(MouseEvent event) {
        lbl13.setText("");
    }

    @FXML
    private void Me13(MouseEvent event) {
        if (btn13.isSelected()) {
            lbl13.setText(p.getPlaca(12));
        }
    }

    @FXML
    private void Mex14(MouseEvent event) {
        lbl14.setText("");
    }

    @FXML
    private void Me14(MouseEvent event) {
        if (btn14.isSelected()) {
            lbl14.setText(p.getPlaca(13));
        }
    }

    @FXML
    private void Mex15(MouseEvent event) {
        lbl15.setText("");
    }

    @FXML
    private void Me15(MouseEvent event) {
        if (btn15.isSelected()) {
            lbl15.setText(p.getPlaca(14));
        }
    }

    @FXML
    private void Mex16(MouseEvent event) {
        lbl16.setText("");
    }

    @FXML
    private void Me16(MouseEvent event) {
        if (btn16.isSelected()) {
            lbl16.setText(p.getPlaca(15));
        }
    }

    @FXML
    private void Mex17(MouseEvent event) {
        lbl17.setText("");
    }

    @FXML
    private void Me17(MouseEvent event) {
        if (btn17.isSelected()) {
            lbl17.setText(p.getPlaca(16));
        }
    }

    @FXML
    private void Mex18(MouseEvent event) {
        lbl18.setText("");
    }

    @FXML
    private void Me18(MouseEvent event) {
        if (btn18.isSelected()) {
            lbl18.setText(p.getPlaca(17));
        }
    }

    @FXML
    private void Mex19(MouseEvent event) {
        lbl13.setText("");
    }

    @FXML
    private void Me19(MouseEvent event) {
        if (btn19.isSelected()) {
            lbl13.setText(p.getPlaca(18));
        }
    }

    @FXML
    private void Mex20(MouseEvent event) {
        lbl14.setText("");
    }

    @FXML
    private void Me20(MouseEvent event) {
        if (btn20.isSelected()) {
            lbl14.setText(p.getPlaca(19));
        }
    }

    @FXML
    private void Mex21(MouseEvent event) {
        lbl15.setText("");
    }

    @FXML
    private void Me21(MouseEvent event) {
        if (btn21.isSelected()) {
            lbl15.setText(p.getPlaca(20));
        }
    }

    @FXML
    private void Mex22(MouseEvent event) {
        lbl16.setText("");
    }

    @FXML
    private void Me22(MouseEvent event) {
        if (btn22.isSelected()) {
            lbl16.setText(p.getPlaca(21));
        }
    }

    @FXML
    private void Mex23(MouseEvent event) {
        lbl17.setText("");
    }

    @FXML
    private void Me23(MouseEvent event) {
        if (btn23.isSelected()) {
            lbl17.setText(p.getPlaca(22));
        }
    }

    @FXML
    private void Mex24(MouseEvent event) {
        lbl18.setText("");
    }

    @FXML
    private void Me24(MouseEvent event) {
        if (btn24.isSelected()) {
            lbl18.setText(p.getPlaca(23));
        }
    }

    @FXML
    private void Mex5(MouseEvent event) {
        lbl5.setText("");
    }

    @FXML
    private void Me5(MouseEvent event) {
        if (btn5.isSelected()) {
            lbl5.setText(p.getPlaca(4));
        }
    }

    @FXML
    private void SelAla(ActionEvent event) throws IOException {

        if (cmbAla.getSelectionModel().isSelected(0)) {
            FXMLLoader fxmlLoader;

            fxmlLoader = new FXMLLoader(getClass().getResource("/View/EstacionamentoA.fxml"));
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

        } else if (cmbAla.getSelectionModel().isSelected(1)) {
            FXMLLoader fxmlLoader;

            fxmlLoader = new FXMLLoader(getClass().getResource("/View/EstacionamentoB.fxml"));
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
        } else if (cmbAla.getSelectionModel().isSelected(2)) {
            FXMLLoader fxmlLoader;

            fxmlLoader = new FXMLLoader(getClass().getResource("/View/EstacionamentoC.fxml"));
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
        } else if (cmbAla.getSelectionModel().isSelected(3)) {
            FXMLLoader fxmlLoader;

            fxmlLoader = new FXMLLoader(getClass().getResource("/View/EstacionamentoD.fxml"));
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

    private void criarDialog(String vaga, int x) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Resultado de Pesquisa");
        alert.setHeaderText("O carro com a placa "+p.getPlaca(x)+" está na vaga "+vaga);
        alert.setContentText("Quer liberar a vaga?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {                       
            if(btn1.isSelected() && x==0)
                    btn1.setSelected(false);
                else if(btn2.isSelected() && x==1)
                    btn2.setSelected(false);
            else if(btn3.isSelected() && x==2)
                    btn3.setSelected(false); 
            else if(btn4.isSelected() && x==3)
                    btn4.setSelected(false); 
            else if(btn5.isSelected() && x==4)
                    btn5.setSelected(false); 
            else if(btn6.isSelected() && x==5)
                    btn6.setSelected(false); 
            else if(btn7.isSelected() && x==6)
                    btn7.setSelected(false); 
            else if(btn8.isSelected() && x==7)
                    btn8.setSelected(false); 
            else if(btn9.isSelected() && x==8)
                    btn9.setSelected(false); 
            else if(btn10.isSelected() && x==9)
                    btn10.setSelected(false); 
            else if(btn11.isSelected() && x==10)
                    btn11.setSelected(false);
                else if(btn12.isSelected() && x==11)
                    btn12.setSelected(false);
            else if(btn13.isSelected() && x==12)
                    btn13.setSelected(false); 
            else if(btn14.isSelected() && x==13)
                    btn14.setSelected(false); 
            else if(btn15.isSelected() && x==14)
                    btn15.setSelected(false); 
            else if(btn16.isSelected() && x==15)
                    btn16.setSelected(false); 
            else if(btn17.isSelected() && x==16)
                    btn17.setSelected(false); 
            else if(btn18.isSelected() && x==17)
                    btn18.setSelected(false); 
            else if(btn19.isSelected() && x==18)
                    btn19.setSelected(false); 
            else if(btn20.isSelected() && x==19)
                    btn20.setSelected(false); 
            else if(btn21.isSelected() && x==20)
                    btn21.setSelected(false); 
            else if(btn22.isSelected() && x==21)
                    btn22.setSelected(false); 
            else if(btn23.isSelected() && x==22)
                    btn23.setSelected(false); 
            else if(btn24.isSelected() && x==23)
                    btn24.setSelected(false); 
            txtSearch.setText("Pesquisar Placa");
            p.setPlaca(x, "");
        } else {
            alert.close();
        }
    }

    @FXML
    private void ClickPesquisar(ActionEvent event) {
        int i;
        for (i = 0; i <= 24; i++) {
            if (i < 24) {
                String placa = p.getPlaca(i);
                if (placa != null && placa.equals(txtSearch.getText())) {
                    String vaga = String.valueOf(i + 1);
                    this.criarDialog(vaga, i);
                    return;
                }
            } else {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Placa não encontrada");
                    alert.setHeaderText(null);
                    alert.setContentText("Nenhuma placa encontrada com o registro de: " + txtSearch.getText());
                    alert.showAndWait();
                }
        }

    }
// </editor-fold>
}
