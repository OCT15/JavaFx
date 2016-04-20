package Controller;

import Model.PlacaC;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import io.datafx.controller.flow.FlowException;
import io.datafx.controller.util.VetoException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.stage.WindowEvent;
import javafx.util.Duration;

public class EstacionamentoController implements Initializable {
// <editor-fold defaultstate="collapsed" desc="Declaração de objetos">

    List<JFXToggleButton> btn;

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

    PlacaC p = new PlacaC();

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

    private final Label lbla = new Label("Ala A");
    private final Label lblb = new Label("Ala B");
    private final Label lblc = new Label("Ala C");
    private Label lbld = new Label("Ala D");

    private boolean add = true;
    @FXML
    private JFXComboBox<Label> cmbAla;
    @FXML
    private JFXButton btnVoltar;
    @FXML
    private JFXTextField txtSearch;
    @FXML
    private JFXButton btnSearch;
    @FXML
    private Label lblRel;

    private boolean[] fire = new boolean[24];
    private boolean start = true;

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Metodos da Classe">
    public void addItem() {
        if (add) {
            btn = new ArrayList<>();
            btn.add(btn1);
            btn.add(btn2);
            btn.add(btn3);
            btn.add(btn4);
            btn.add(btn5);
            btn.add(btn6);
            btn.add(btn7);
            btn.add(btn8);
            btn.add(btn9);
            btn.add(btn10);
            btn.add(btn11);
            btn.add(btn12);
            btn.add(btn13);
            btn.add(btn14);
            btn.add(btn15);
            btn.add(btn16);
            btn.add(btn17);
            btn.add(btn18);
            btn.add(btn19);
            btn.add(btn20);
            btn.add(btn21);
            btn.add(btn22);
            btn.add(btn23);
            btn.add(btn24);
            add = false;
        }

    }

    private void bindToTime() {
        addItem();
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0),
                        new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {

                                Calendar time = Calendar.getInstance();
                                String hourString = StringUtilities.pad(2, ' ', time.get(Calendar.HOUR) == 0 ? "12" : time.get(Calendar.HOUR) + "");
                                String minuteString = StringUtilities.pad(2, '0', time.get(Calendar.MINUTE) + "");
                                String secondString = StringUtilities.pad(2, '0', time.get(Calendar.SECOND) + "");
                                String ampmString = time.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";
                                lblRel.setText(hourString + ":" + minuteString + ":" + secondString + " " + ampmString);
                                if (start == true) {
                                    for (int i = 0; i < 24; i++) {
                                        if (p.getPlaca(i) != null && fire[i] == false) {
                                            btn.get(i).setSelected(true);
                                            fire[i] = true;
                                        }
                                    }
                                    start = false;
                                }
                            }
                        }
                ),
                new KeyFrame(Duration.seconds(1))
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

    }

    private void addPlaca(JFXToggleButton btn) {
        TextInputDialog dialog = new TextInputDialog();
        if (btn.isSelected()) {
            dialog.setTitle("Estacionamento");
            dialog.setHeaderText("Insira o número da placa");
            dialog.setContentText("Número da placa:");

            Optional<String> result = dialog.showAndWait();

            if (result.isPresent()) {
                for (int i = 0; i < 24; i++) {
                    String btnName = "btn" + String.valueOf(i + 1);
                    if (btn.getId().equals(btnName)) {
                        p.setPlaca(i, result.get());
                    }
                }
            } else {
                btn.setSelected(false);
            }
        } else {
            for (int i = 0; i < 24; i++) {
                if (btn.getId().equals("btn" + String.valueOf(i + 1))) {
                    p.setPlaca(i, null);
                }
            }
        }
    }

    private void pesquisarPlaca(String vaga, int x, List<JFXToggleButton> btn) {

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Resultado de Pesquisa");
        alert.setHeaderText("O carro com a placa " + p.getPlaca(x) + " está na vaga " + vaga);
        alert.setContentText("Quer liberar a vaga?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            for (int i = 0; i < 24; i++) {
                if (btn.get(i).isSelected() && x == i) {
                    btn.get(i).setSelected(false);
                }
            }
            txtSearch.setText("Pesquisar Placa");
            p.setPlaca(x, null);
        } else {
            alert.close();
        }
    }

    public void salvarVagas() {
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("dataC.bin"));
            os.writeObject(p);//write object
            os.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EstacionamentoAController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EstacionamentoAController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Done wirting");

    }

    @Override
    public void initialize(URL url, ResourceBundle rb
    ) {

        cmbAla.getItems().add(lbla);
        cmbAla.getItems().add(lblb);
        cmbAla.getItems().add(lblc);
        cmbAla.getItems().add(lbld);
        try {
            p.lerVagas();
        } catch (Exception e) {

            System.out.println("Classe não inicializada");
        }

        bindToTime();

    }

// </editor-fold>
// <editor-fold defaultstate="collapsed" desc="Action Methods">
    @FXML
    private void Tog1(ActionEvent event) throws FlowException, VetoException {

        addPlaca(btn1);

    }

    @FXML
    private void Tog2(ActionEvent event
    ) {
        addPlaca(btn2);
    }

    @FXML
    private void Tog3(ActionEvent event
    ) {
        addPlaca(btn3);
    }

    @FXML
    private void Tog4(ActionEvent event
    ) {
        addPlaca(btn4);
    }

    @FXML
    private void Tog5(ActionEvent event
    ) {
        addPlaca(btn5);
    }

    @FXML
    private void Tog6(ActionEvent event
    ) {
        addPlaca(btn6);
    }

    @FXML
    private void Tog7(ActionEvent event
    ) {
        addPlaca(btn7);
    }

    @FXML
    private void Tog8(ActionEvent event
    ) {
        addPlaca(btn8);
    }

    @FXML
    private void Tog9(ActionEvent event
    ) {
        addPlaca(btn9);
    }

    @FXML
    private void Tog10(ActionEvent event
    ) {
        addPlaca(btn10);
    }

    @FXML
    private void Tog11(ActionEvent event
    ) {
        addPlaca(btn11);
    }

    @FXML
    private void Tog12(ActionEvent event
    ) {
        addPlaca(btn12);
    }

    @FXML
    private void Tog13(ActionEvent event
    ) {
        addPlaca(btn13);
    }

    @FXML
    private void Tog14(ActionEvent event
    ) {
        addPlaca(btn14);
    }

    @FXML
    private void Tog15(ActionEvent event
    ) {
        addPlaca(btn15);
    }

    @FXML
    private void Tog16(ActionEvent event
    ) {
        addPlaca(btn16);
    }

    @FXML
    private void Tog17(ActionEvent event
    ) {
        addPlaca(btn17);
    }

    @FXML
    private void Tog18(ActionEvent event
    ) {
        addPlaca(btn18);
    }

    @FXML
    private void Tog19(ActionEvent event
    ) {
        addPlaca(btn19);
    }

    @FXML
    private void Tog20(ActionEvent event
    ) {
        addPlaca(btn20);
    }

    @FXML
    private void Tog21(ActionEvent event
    ) {
        addPlaca(btn21);
    }

    @FXML
    private void Tog22(ActionEvent event
    ) {
        addPlaca(btn22);
    }

    @FXML
    private void Tog23(ActionEvent event
    ) {
        addPlaca(btn23);
    }

    @FXML
    private void Tog24(ActionEvent event
    ) {
        addPlaca(btn24);
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
            salvarVagas();
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
            salvarVagas();
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
            salvarVagas();
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
            salvarVagas();
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
        salvarVagas();
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

    @FXML
    private void ClickPesquisar(ActionEvent event) {
        int i;
        for (i = 0; i <= 24; i++) {
            if (i < 24) {
                String placa = p.getPlaca(i);
                if (placa != null && placa.equals(txtSearch.getText())) {
                    String vaga = String.valueOf(i + 1);
                    pesquisarPlaca(vaga, i, btn);
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
