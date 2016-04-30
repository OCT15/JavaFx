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
        String sql = "SET DATEFORMAT dmy "
                + "select id_evento from evento where dt_evento=CAST(GETDATE() AS DATE) AND DATEPART(HOUR,hr_inicio)=DATEPART(HOUR, GETDATE())+1";
        c.executarSQL(sql);
        if (c.rs.next()) {
            p.setId_evento(c.rs.getString("id_evento"));
        }              
        
    }

}
