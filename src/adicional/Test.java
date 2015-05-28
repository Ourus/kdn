
package adicional;

import bandoDados.AlunoBD;
import modelos.Aluno;
import modelos.Contato;
import modelos.Endereco;


public class Test 
{
    public static void main(String[] args) {
    Aluno alunoN = new Aluno();
    Endereco enderecoN = new Endereco();
    Contato contatoN = new Contato();
    AlunoBD alunob = new AlunoBD();
    
    
    
    alunoN.setCertidaoNascimento("true");
    alunoN.setComprovanteEscolarida("true");
    alunoN.setCorRaca("Preta");
    alunoN.setCpf("111.111.111-88");
   
           
    }
    
}
