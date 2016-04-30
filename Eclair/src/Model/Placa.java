/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.EstacionamentoAController;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danie
 */
public class Placa implements Serializable {

    private String[] placa = new String[24];

    public void setPlaca(int x, String placa) {
        this.placa[x] = placa;
    }

    public String getPlaca(int x) {
        return placa[x];
    }

    public void lerVagas() {
        try {
            
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("data.bin"));
            Placa pa = (Placa) is.readObject();           
            for (int x = 0; x < 24; x++) {                
                   placa[x]=pa.getPlaca(x);                
            }
        } catch (IOException ex) {
            System.out.println("Arquivo não encontrado");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EstacionamentoAController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
