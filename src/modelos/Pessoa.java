
package modelos;

import java.util.ArrayList;
import bandoDados.PessoaBD;
import com.mysql.jdbc.Blob;
import java.sql.Date;
import java.util.Calendar;

public class Pessoa
{
  
    private int codPessoa;
    private Blob foto;
    private String nome;
    private String sexo;
    private String corRaca;
    private String cpf;
    private Calendar dataNacimento;
    private String naturalidade;
    private String uf;
    private String nomeMae;
    private String nomePai;
    private String RG;
    private String orgaoEmissor;
    private Calendar dataExpedicao;
    private ArrayList <Endereco> enderecos = new ArrayList ();
    private ArrayList <Contato> contatos = new ArrayList();

    
   
    
    
    
    // Comandos para Buscar em outras tabelas 

    public ArrayList <Endereco> getEnderecos()
    {
        return this.enderecos;
    }

    public void setEnderecos(ArrayList<Endereco> endereco)
    {
        this.enderecos = endereco;
    }
    public void setEnderecos(Endereco endereco)
    {
        this.enderecos.add(endereco);
    }

    public ArrayList <Contato> getContato(Pessoa pessoa) {
       
       return this.contatos;
    }

    public void setContato(Contato contato) {
        this.contatos.add(contato);
    }
    public void setContato (ArrayList <Contato> contato)
    {
        this.contatos = contato;
    }
   
/*=====================================================================*/

    public int getCodPessoa() {
        return codPessoa;
    }

    public void setCodPessoa(int codPessoa) {
        this.codPessoa = codPessoa;
    }

    public Blob getFoto() {
        return foto;
    }

    public void setFoto(Blob foto) {
        this.foto = foto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCorRaca() {
        return corRaca;
    }

    public void setCorRaca(String corRaca) {
        this.corRaca = corRaca;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Calendar getDataNacimento() {
        return dataNacimento;
    }

    public void setDataNacimento(Calendar dataNacimento) {
        this.dataNacimento = dataNacimento;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getOrgaoEmissor() {
        return orgaoEmissor;
    }

    public void setOrgaoEmissor(String orgaoEmissor) {
        this.orgaoEmissor = orgaoEmissor;
    }

    public Calendar getDataExpedicao() {
        return dataExpedicao;
    }

    public void setDataExpedicao(Calendar dataExpedicao) {
        this.dataExpedicao = dataExpedicao;
    }
  
    
}
