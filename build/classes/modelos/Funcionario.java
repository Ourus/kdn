package modelos;

public class Funcionario
{
    private String nome;
    private String turno;
    private boolean cProduto;
    private boolean eProduto;
    private boolean aProdutos;
    private boolean cCliente;
    private boolean eClente;
    private boolean aCliente;
    private boolean venda;
    private int codFuncioario;
    private String senha;
    
    public String getsenha (){
        return senha;
    }
    public void setsenha(String senha){
        this.senha= senha;
    }    
    
    public int getcodFuncionario(){
        return codFuncioario;
    } 
    public void setcodFuncionario(int codFuncionario){
        this.codFuncioario = codFuncionario;        
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    

    /**
     * @return the turno
     */
    public String getTurno() {
        return turno;
    }

    /**
     * @param turno the turno to set
     */
    public void setTurno(String turno) {
        this.turno = turno;
    }

    /**
     * @return the cProduto
     */
    public boolean iscProduto() {
        return cProduto;
    }

    /**
     * @param cProduto the cProduto to set
     */
    public void setcProduto(boolean cProduto) {
        this.cProduto = cProduto;
    }

    /**
     * @return the eProduto
     */
    public boolean iseProduto() {
        return eProduto;
    }

    /**
     * @param eProduto the eProduto to set
     */
    public void seteProduto(boolean eProduto) {
        this.eProduto = eProduto;
    }

    /**
     * @return the aProdutos
     */
    public boolean isaProdutos() {
        return aProdutos;
    }

    /**
     * @param aProdutos the aProdutos to set
     */
    public void setaProdutos(boolean aProdutos) {
        this.aProdutos = aProdutos;
    }

    /**
     * @return the cCliente
     */
    public boolean iscCliente() {
        return cCliente;
    }

    /**
     * @param cCliente the cCliente to set
     */
    public void setcCliente(boolean cCliente) {
        this.cCliente = cCliente;
    }

    /**
     * @return the eClente
     */
    public boolean iseClente() {
        return eClente;
    }

    /**
     * @param eClente the eClente to set
     */
    public void seteClente(boolean eClente) {
        this.eClente = eClente;
    }

    /**
     * @return the aCliente
     */
    public boolean isaCliente() {
        return aCliente;
    }

    /**
     * @param aCliente the aCliente to set
     */
    public void setaCliente(boolean aCliente) {
        this.aCliente = aCliente;
    }

    /**
     * @return the venda
     */
    public boolean isVenda() {
        return venda;
    }

    /**
     * @param venda the venda to set
     */
    public void setVenda(boolean venda) {
        this.venda = venda;
    }
          
    
}
