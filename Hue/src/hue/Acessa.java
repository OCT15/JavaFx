/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class Acessa {

    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String caminho = "jdbc:sqlserver://localhost\\MSSQLSERVER:1433; DataBaseName=teste";
    private static String usuario = "sa";
    private static String senha = "123";
    public Statement st;
    public ResultSet rs;
    private Connection conn;

    public void conectar() {
        try {
            Class.forName(driver);

            this.setConn(DriverManager.getConnection(this.caminho, this.usuario, this.senha));

            //JOptionPane.showMessageDialog(null, "Conexão realizada com sucesso.");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Acessa.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Classe não realizada.");
        } catch (SQLException ex) {
            Logger.getLogger(Acessa.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro de conexão: " + ex.getMessage());
        }
    }

    public void desconectar() {
        try {
            this.getConn().close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao desconectar");
        }
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public void executarSQL(String sql) {
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException err) {
            System.out.println(err);
        }
    }
}
