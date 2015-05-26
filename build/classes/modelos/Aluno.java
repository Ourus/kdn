
package modelos;

import java.util.ArrayList;
import bandoDados.AlunoBD;

public class Aluno extends Pessoa 
{
    private String matricula;
    private String certidaoNascimento;
    private String comprovanteEscolarida;
    private String observacao;
    private String status;
    private ArrayList <Desempenho> desempenho = new ArrayList();
    private ArrayList<Escolaridade> escolaridade = new ArrayList ();    

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
 //   public void setMatricula()
 //   {
 //       
 //   }

    public String getCertidaoNascimento() {
        return certidaoNascimento;
    }

    public void setCertidaoNascimento(String certidaoNascimento) {
        this.certidaoNascimento = certidaoNascimento;
    }

    public String getComprovanteEscolarida() {
        return comprovanteEscolarida;
    }

    public void setComprovanteEscolarida(String comprovanteEscolarida) {
        this.comprovanteEscolarida = comprovanteEscolarida;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    public void setDesempenho (Desempenho desempenho)
    {
        this.desempenho.add(desempenho);
    }
    public void setDesempenho (ArrayList<Desempenho> desempenho1)
    {
        this.desempenho = desempenho1;
    }
   public ArrayList<Desempenho> getDesempenho(Aluno aluno)
            
    {        
       return this.desempenho;
        
    }
    
    public void setEscolaridade (Escolaridade escolaridade)
    {
        this.escolaridade.add(escolaridade);
    }
    public void setEscolaridade (ArrayList<Escolaridade> escolar)
    {
        this.escolaridade = escolar;
        
    }
    
  public ArrayList<Escolaridade> getEscolaridade(Aluno aluno)
   {
        return this.escolaridade;
   }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
