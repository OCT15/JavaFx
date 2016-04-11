/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author aluno
 */
import Controller.LoginController;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
      
public class LoginModel {

    public static boolean isOk() {
        return ok;
    }

    public static void setOk(boolean ok) {
        LoginModel.ok = ok;
    }

    private static boolean ok;

    public void connect(String usuario, String senha) throws SQLException, IOException {        
        LoginController lc = new LoginController();       
        Acessa c = new Acessa();
        //c.conectar();
        c.executarSQL("select * from funcionario where nome='" + usuario + "' and senha='" + senha + "'");
        try {
            if (c.rs.next()) {
                int cont = c.rs.getRow();
                if (cont != 0) {
                    ok = true;
                    
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos");
                ok = false;
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
            
        }
        c.desconectar();
        LoginModel.setOk(ok);
    }
}

