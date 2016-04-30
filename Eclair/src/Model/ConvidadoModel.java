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
 * @author ETESP
 */
public class ConvidadoModel {

    private Acessa c = new Acessa();
    private ObservableList<Convidado> data = FXCollections.observableArrayList();

    private Persist p = new Persist();

    public void selecionarConvidados(TableView tbl, String txt) throws SQLException {

        c.executarSQL("select id_convidado, nome_convidado, compareceu from convidados");
        Convidado co;
        while (c.rs.next()) {
            co = new Convidado();
            co.setNome(c.rs.getString("nome_convidado"));
            co.setCompareceu(c.rs.getBoolean("compareceu"));
            co.setId(c.rs.getInt("id_convidado"));
            data.add(co);

        }
        p.setData(data);
        //tbl.setItems(data);

    }

    public void updateCompareceu(int id, boolean btnBool) {
        String sql = "update convidados set compareceu='" + btnBool + "' where id_convidado='" + id + "'";
        c.insert_updateSQL(sql);
    }

    public void addConvidado(String nome, TableView tbl) {
        Convidado ci = new Convidado();
        int id = data.size() + 1;
        c.insert_updateSQL("insert into convidados(id_convidado,id_evento,nome_convidado, compareceu)"
                + " VALUES (" + id + "," + p.getId_evento() + ",'" + nome + "','false')");
        ci.setNome(nome);
        ci.setCompareceu(false);
        ci.setId(id);
        data.add(ci);

    }

    public Integer getId(String nome) throws SQLException {                
        int id = 0;
        c.executarSQL("select id_convidado from convidados where nome_convidado='" + nome + "' and id_evento=" + p.getId_evento());
        while (c.rs.next()) {
            id = c.rs.getInt("id_convidado");
            return id;
        }
        return null;
    }

    public boolean getCompareceu(String nome) throws SQLException {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getNome().equals(nome) && data.get(i).isCompareceu()==true) {
                return true;
            }            
        }
        return false;
    }
    
}
