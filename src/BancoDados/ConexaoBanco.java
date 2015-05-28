/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BancoDados;

import Classes.Login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author professor
 */
public class ConexaoBanco 
{
    String driver = "com.mysql.jdbc.Driver"; // Driver para conexão Java/MySQL
    public String caminho = "jdbc:mysql://localhost:3306/ceet"; // Caminho para o banco de dados
    public String usuario = "root"; // Usuário
    public String senha = "root"; 
  
    Statement stm; // Statement para envio e recebimento de dados da base
  
    Connection con; // Objeto que gera a conexão entre o java e a base
    String sql;
    
    
    
    // Método para se conectar ao banco
    public void conectarBanco()
    {
        try
        {
            con = DriverManager.getConnection(caminho, usuario, senha); // Conectando-se a base de dados
        }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "<html><b>Erro de conexão com a base!</b><br><br>Verifique se o MySQL está instalado e, caso positivo,<br>certifique-se de que as tabelas necessárias para<br>o programa sejam criadas<br>(use o conteúdo do arquivo SQL.txt no pacote 'bancodados' do programa!).</html> "+e.getMessage(),"Erro",0);  // Mostra uma mensagem de erro caso a conexão não seja bem sucedida
                e.printStackTrace();
            }
    }
    
    // Método para se desconectar do banco
    public void desconectarBanco()
    {
        try
        {
           con.close(); // Desconectando-se da base de dados
        }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Erro de desconexão com a base! \nContate o administrador do sistema!\n\n"+e.getMessage(),"Erro",0);  // Mostra uma mensagem de erro caso a conexão não seja bem sucedida
                e.printStackTrace();
            }
    }
   public ArrayList <Login> contasCadastradas ()
    {
        ArrayList <Login> contasCadastradas = new ArrayList();
        Login test;
        try
        {
            conectarBanco();
            String sql = "select * from login;";
            stm = con.createStatement();
            ResultSet tabelaretorno = stm.executeQuery(sql);
            while (tabelaretorno.next())
            {
                test = new Login();
                
                test.setLogin(tabelaretorno.getString("login"));
                test.setSenha(tabelaretorno.getString("senha"));
                
                contasCadastradas.add(test);
                
            }
        } 
        catch (Exception e)
        {
        }
        finally
        {
            desconectarBanco();
             return contasCadastradas;
        }
        
       
    }
}
