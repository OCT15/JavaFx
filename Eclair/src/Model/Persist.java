/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.jfoenix.controls.JFXCheckBox;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author danie
 */
public class Persist {

    public static String getNome() {
        return nome;
    }

    public static void setNome(String nome) {
        Persist.nome = nome;
    }
    private static String nome;

    public static String getId_evento() {
        return id_evento;
    }

    public static void setId_evento(String id_evento) {
        Persist.id_evento = id_evento;
    }
    
    private static String id_evento;

    public static int getTam() {
        return tam;
    }

    public static void setTam(int tam) {
        Persist.tam = tam;
    }
    private static int tam;
    
     private static ObservableList<Convidado> data = FXCollections.observableArrayList();

    public static ObservableList<Convidado> getData() {
        return data;
    }

    public static void setData(ObservableList<Convidado> data) {
        Persist.data = data;
    }

    
    private static List<JFXCheckBox> list = new ArrayList<>();

    public static List<JFXCheckBox> getList() {
        return list;
    }

    public static void setList(List<JFXCheckBox> list) {
        Persist.list = list;
    }

}
