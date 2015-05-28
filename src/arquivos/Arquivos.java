package arquivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class Arquivos 
{
    public void salvarTextoNoArquivo(String texto)
    {
        try
        {
            PrintWriter impressora = new PrintWriter(new File("conteudo.txt"));
            
            impressora.println(texto);
            
            impressora.close();
            
            JOptionPane.showMessageDialog(null, "<html>Aha, tudo salvo! Show de bola! XD<br><br><b>Pode fechar a janela e abrir de novo!</b></html>");
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    
    public String lerTextoArquivo()
    {
        String linha = "", texto = "";
        BufferedReader bf= null;
        try
        {
            FileReader leitor = new FileReader("conteudo.txt"); // Criando um leitor para o arquivo
            bf = new BufferedReader(leitor);    // Armazenando o conteúdo obtido pelo leitor em um buffer
            
            while((linha = bf.readLine())!= null) // Enquanto houverem linhas a serem lidas no buffer...
                {
                   texto+=linha;
                }
        }catch(IOException e)
        {
            e.printStackTrace();
        }finally
            {
                return texto;
            }
    }
}
