/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author ETESP
 */
public class RelatorioMaster {

    public final String getNome() {
        return nome.get();
    }

    public final Integer getId() {
        return id.get();
    }

    public final String getSenha() {
        return senha.get();
    }

    public void setNome(String nomes) {
        nome.set(nomes);
    }

    public void setId(Integer ids) {
        id.set(ids);
    }

    public void setSenha(String senhas) {
        senha.set(senhas);
    }

    private StringProperty nome = new SimpleStringProperty();
    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty senha = new SimpleStringProperty();

}
