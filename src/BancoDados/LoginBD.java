package BancoDados;

import Classes.Login;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class LoginBD extends ConexaoBanco
{
    public void inserirLoginBanco(Login loginRecebido)
    {
        try
        {
            // Conectar ao banco
            conectarBanco();
            
            // Criando o SQL
            String sql = "INSERT INTO login (login, senha, nivel) "
                       + "VALUES ('"+loginRecebido.getLogin()+"', '"+loginRecebido.getSenha()+"', "+loginRecebido.getNivel()+"); ";
            
            stm = con.createStatement(); // Criando o botão de execuções de códigos SQL
            
            stm.executeUpdate(sql); 
            
            JOptionPane.showMessageDialog(null, "Login "+loginRecebido.getLogin()+" cadastrado com sucesso!");
            
        }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage()); 
            }finally
                {
                    desconectarBanco();
                }       
    }
    
    public ArrayList<Login> retornarLoginsCadastrados()
    {
        ArrayList<Login> listaRecebida = new ArrayList();
        Login login;
        
        try
        {
            // Conectar ao banco
            conectarBanco();
            
            // Criando o SQL
            String sql = "SELECT * FROM ceet.login ";
            
            stm = con.createStatement(); // Criando o botão de execuções de códigos SQL
            
            ResultSet tabela = stm.executeQuery(sql); // Buscando a tabela de logins do sistema e armazenando no objeto 'tabela'
            
            while(tabela.next()) // Enquanto houverem linhas para serem lidas na tabela...
            {
                login = new Login(); // Criando um login VAZIO
                
                // Preenchendo o login com os dados de cada linha da tabela
                login.setId(tabela.getInt("id"));
                login.setLogin(tabela.getString("login"));
                login.setSenha(tabela.getString("senha"));
                login.setNivel(tabela.getInt("nivel")); 
                
                // adicionando o login preenchido na lista de logins
                listaRecebida.add(login);
            }
            
        }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage()); 
            }finally
                {
                    desconectarBanco();
                    System.out.println(listaRecebida.size());
                    return listaRecebida;
                }       
    }
    
    public void removerLoginBanco(int id)
    {
        try
        {
            // Conectar ao banco
            conectarBanco();
            
            // Criando o SQL
            String sql = "DELETE "
                        + "FROM login "
                        + "WHERE id = "+id;
            
            stm = con.createStatement(); // Criando o botão de execuções de códigos SQL
            
            stm.executeUpdate(sql); 
            
            JOptionPane.showMessageDialog(null, "Login excluído com sucesso!");
            
        }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage()); 
            }finally
                {
                    desconectarBanco();
                }       
    }
    
    
}
