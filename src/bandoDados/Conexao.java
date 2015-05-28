
package bandoDados;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.*;
import javax.swing.JOptionPane;

public class Conexao
{
    protected String driver="com.mysql.jdbc.Driver";
    protected String usuario = "root";
    protected String caminho = "jdbc:mysql://localhost:3306/ceet";
    protected String senha = "root";
    protected Connection con;
    protected Statement stm;
    
    protected void conectarBanco()
    {
        try
        {
           // Class.forName(driver);
            con = DriverManager.getConnection(this.caminho,this.usuario,this.senha);
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    protected void desconectarBanco()
    {
        try
        {
            con.close();
            
        } 
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    
}
