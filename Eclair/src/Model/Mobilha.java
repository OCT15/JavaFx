/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author aluno
 */
public class Mobilha {

    public String getNome() {
        return nome.get();
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public double getPreco() {
        return preco.get();
    }

    public void setPreco(double preco) {
        this.preco.set(preco);
    }

    public String getQtd() {
        return qtd.get();
    }

    public void setQtd(String qtd) {
        this.qtd.set(qtd);
    }   
    private final SimpleStringProperty nome;
    private final SimpleDoubleProperty preco;
    private final SimpleStringProperty qtd;
    
    
    public Mobilha(String nome, double preco, String qtd){
    this.nome = new SimpleStringProperty(nome);
    this.preco = new SimpleDoubleProperty(preco);
    this.qtd = new SimpleStringProperty(qtd);
}
}
