/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
//import java.time.Duration;
import java.util.Calendar;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.util.Duration;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 * FXML Controller class
 *
 * @author danie
 */
public class MenuGerenteController implements Initializable {

    @FXML
    private Label lblOla;
    @FXML
    private Label lblRel;
    @FXML
    private JFXButton btnTal;
    @FXML
    private ImageView imgTal;
    @FXML
    private JFXButton btnCoz;
    @FXML
    private JFXButton btnConv;
    @FXML
    private JFXButton btnEst;
    @FXML
    private JFXButton btnRel;
    @FXML
    private JFXButton btnRela;
    @FXML
    private ProgressBar prgTimer;

    private void bindToTime() {
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
                            }
                        }
                ),
                new KeyFrame(Duration.seconds(1))
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bindToTime();

    }

    public void start(Stage stage) throws Exception {

    }

    @FXML
    private void ClickTal(ActionEvent event) throws IOException {
         
    }

    @FXML
    private void ClickCoz(ActionEvent event) {
    }

    @FXML
    private void ClickCov(ActionEvent event) {
    }

    @FXML
    private void ClickEst(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader;
        fxmlLoader = new FXMLLoader(getClass().getResource("/View/EstacionamentoA.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Controle de Estacionamento");

        stage.setResizable(false);
        stage.setScene(new Scene(root1));
        stage.show();
        //-----
        Stage stage2 = (Stage) btnEst.getScene().getWindow();
        // do what you have to do
        stage2.close();
    }

    @FXML
    private void ClickRel(ActionEvent event) {
    }

    @FXML
    private void ClickRela(ActionEvent event) throws IOException, Exception {
        
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("Gerar Relatório");

        stage.setResizable(false);
        
        JasperPrint jasperprint = null;
        try {
            jasperprint = JasperFillManager.fillReport("target/classes/report1.jasper", new HashMap(), new JREmptyDataSource());
        } catch (JRException e) {
           
            e.printStackTrace();
        }
        JRViewerFx jv = new JRViewerFx(jasperprint, JRViewerFxMode.REPORT_VIEW, stage);
        jv.start(stage);
        
        Stage stage2 = (Stage) btnRela.getScene().getWindow();
       
        stage2.close();

    }

}
