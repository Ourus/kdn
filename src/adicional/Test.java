
package adicional;

import bandoDados.AlunoBD;
import bandoDados.DisiplinaBD;
import modelos.Aluno;
import modelos.Contato;
import modelos.Endereco;
import modelos.Ementa;
import modelos.Endereco;
import modelos.Competencias;
import modelos.Habilidades;
import modelos.BasesTecnologicas;



public class Test 
{
    public static void main(String[] args) {
    Aluno alunoN = new Aluno();
    Endereco enderecoN = new Endereco();
    Contato contatoN = new Contato();
    AlunoBD alunob = new AlunoBD();
     Ementa disiplinaN = new  Ementa();
     DisiplinaBD desBD = new DisiplinaBD();
     Competencias comp = new Competencias();
     BasesTecnologicas btN =  new BasesTecnologicas();
     Habilidades habilN = new Habilidades();
     
     
    /* e necessario lembra que o curso ele deve ser existir antes para que possa cadastrar as
     disciplnas */
     disiplinaN.setCargaHoraria(40);
     disiplinaN.setNome("Matematica");
     disiplinaN.setPeriodoLetivo("2009");
     comp.setCompetencia("calculos arimeticos");
     btN.setBases("na real nao sei o que colocar aqui");
     habilN.setHabilidades("saber oque e calculo")
             ;
         
     
     //desBD.casdastroEmentaDisciplina(2,disiplinaN);
     //desBD.casdastroCompetenciasDisciplina(2, comp);
     //desBD.casdastroBasesTecnologicasDisciplina(2, btN);
     desBD.casdastroHabilidadesDisciplina(2, habilN);
     
    
    /*
    
    alunoN.setCertidaoNascimento("true");
    alunoN.setComprovanteEscolarida("true");
    alunoN.setCorRaca("Preta");
    alunoN.setCpf("111.111.111-88");
    
    
    
    
    
   
      */     
    }
    
}
