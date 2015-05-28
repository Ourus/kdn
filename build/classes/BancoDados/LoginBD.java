package BancoDados;

import Classes.Login;
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
            String sql = "INSERT INTO login (login, senha, setor) "
                       + "VALUES ('"+loginRecebido.getLogin()+"', '"+loginRecebido.getSenha()+"', '"+loginRecebido.getSetor()+"'); ";
            
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
}
