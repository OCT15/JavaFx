/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author danie
 */
public class Evento {
  

    public void setIdEvento(String idEvento) {
       this.idEvento.set(idEvento);
    }
    
    public void setIdCli(String idCli) {
        this.idCli.set(idCli);
    }

    public void setData(String data) {
        this.data.set(data);
    }
    
    public void setHora(String hora) {
        this.hora.set(hora);
    }


    public void setLugar(String lugar) {
        this.lugar.set(lugar);
    }

    public String getIdEvento() {
        return idEvento.get();
    }

    public String getIdCli() {
        return idCli.get();
    }

    public String getData() {
        return data.get();
    }

    public String getHora() {
        return hora.get();
    }

    public String getLugar() {
        return lugar.get();
    }
   
    private SimpleStringProperty idEvento = new SimpleStringProperty();
    private SimpleStringProperty idCli = new SimpleStringProperty();
    private SimpleStringProperty data = new SimpleStringProperty();
    private SimpleStringProperty hora = new SimpleStringProperty();
    private SimpleStringProperty lugar = new SimpleStringProperty();
       }
