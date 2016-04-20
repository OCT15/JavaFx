/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
    
}
