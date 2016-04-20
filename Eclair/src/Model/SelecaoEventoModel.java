/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

/**
 *
 * @author danie
 */
public class SelecaoEventoModel {

    Acessa c = new Acessa();

    private ObservableList<Evento> data;
   

    public void selecionarEventos(TableView tbl) throws SQLException {
        try {
            c.executarSQL("SET DATEFORMAT dmy "
                    + "select id_evento, id_cliente, dt_evento, hr_inicio, id_lugar from evento");
            data = FXCollections.observableArrayList();   
            while (c.rs.next()) {                       
                Evento e = new Evento();
                e.setIdEvento(c.rs.getString("id_evento"));
                e.setData(c.rs.getDate("dt_evento").toString());
                e.setHora((c.rs.getTime("hr_inicio").toString()));
                e.setLugar(c.rs.getString("id_lugar"));
                e.setIdCli(c.rs.getString("id_cliente"));               
                data.add(e);                
            }

            tbl.setItems(data);
        } catch (Exception e) {
            System.out.println("Error on building data");
        }
    }
}
