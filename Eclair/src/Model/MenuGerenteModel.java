/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.joda.time.DateTime;

/**
 *
 * @author danie
 */
public class MenuGerenteModel {

    Acessa c = new Acessa();
    Persist p = new Persist();

    public void selecionarEvento() throws SQLException {

        String pattern = "dd-MM-yyyy";
        String dateInString = new SimpleDateFormat(pattern).format(new Date());
        DateTime dt = new DateTime();
        int hour = dt.getHourOfDay() + 1;
        String sql = "SET DATEFORMAT dmy "
                + "select id_evento from evento where dt_evento='" + dateInString + "' and hr_inicio='" + String.valueOf(hour)+":00:00" + "'";
        c.executarSQL(sql);
        if (c.rs.next()) {
            p.setId_evento(c.rs.getString("id_evento"));
        }              
        
    }

}
