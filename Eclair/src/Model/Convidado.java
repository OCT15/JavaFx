/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author ETESP
 */
public class Convidado {

    public String getNome() {
        return nome.get();
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public boolean isCompareceu() {
        return compareceu.get();
    }

    public void setCompareceu(boolean compareceu) {
        this.compareceu.set(compareceu);
    }
    private SimpleStringProperty nome = new SimpleStringProperty();
    private SimpleBooleanProperty compareceu = new SimpleBooleanProperty();

    public Integer getId() {
        return id.get();
    }

    public void setId(Integer id) {
        this.id.set(id);
    }
    private SimpleIntegerProperty id = new SimpleIntegerProperty();
    
}
