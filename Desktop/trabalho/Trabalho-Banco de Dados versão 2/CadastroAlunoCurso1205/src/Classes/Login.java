
package Classes;

import java.util.Calendar;


public class Login 
{
    private int id;
    private String login;
    private String senha;
    private String setor;
    private boolean estado_login;
    private Calendar dt_cadastro;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the setor
     */
    public String getSetor() {
        return setor;
    }

    /**
     * @param setor the setor to set
     */
    public void setSetor(String setor) {
        this.setor = setor;
    }

    /**
     * @return the estado_login
     */
    public boolean isEstado_login() {
        return estado_login;
    }

    /**
     * @param estado_login the estado_login to set
     */
    public void setEstado_login(boolean estado_login) {
        this.estado_login = estado_login;
    }

    /**
     * @return the dt_cadastro
     */
    public Calendar getDt_cadastro() {
        return dt_cadastro;
    }

    /**
     * @param dt_cadastro the dt_cadastro to set
     */
    public void setDt_cadastro(Calendar dt_cadastro) {
        this.dt_cadastro = dt_cadastro;
    }
    
}
