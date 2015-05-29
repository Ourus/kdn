package bandoDados;

/**
 *
 * @author jonathan
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import modelos.BasesTecnologicas;
import modelos.Competencias;
import modelos.Disciplina;
import modelos.Ementa;
import modelos.Habilidades;
import modelos.Pessoa;
import modelos.Curso;

public class DisiplinaBD extends Conexao {
    
    
    // ==============================| Cadastros Principais de Disciplina |===================
    
    
    
    
    
    
    
    
    
    

    private int cadastroDisciplinaKey(Curso curso, Disciplina disciplina) {
        int key = 0;

        try {
            conectarBanco();
            String sql = "insert into disciplina (codCurso,nome, cargaHoraria)"
                    + " values(?,?,?);";
            PreparedStatement stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setInt(1, curso.getCodCurso());
            stm.setString(2, disciplina.getNome());
            stm.setInt(3, disciplina.getCargaHoraria());

            stm.executeUpdate();

            ResultSet codDisciplina = stm.getGeneratedKeys();
            while (codDisciplina.next()) {
                key = codDisciplina.getInt(1);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {

            desconectarBanco();
            return key;
        }
    }

    private int cadastroDisciplinaKey(int curso, Disciplina disciplina) {
        int key = 0;

        try {
            conectarBanco();
            String sql = "insert into disciplina (codCurso,nome, cargaHoraria)"
                    + " values(?,?,?);";
            PreparedStatement stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setInt(1, curso);
            stm.setString(2, disciplina.getNome());
            stm.setInt(3, disciplina.getCargaHoraria());

            stm.executeUpdate();

            ResultSet codDisciplina = stm.getGeneratedKeys();
            while (codDisciplina.next()) {
                key = codDisciplina.getInt(1);
            }
            JOptionPane.showMessageDialog(null, key);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {

            desconectarBanco();
            return key;
        }
    }

    private int cadastroDisciplinaKey(int curso, ArrayList<Disciplina> disci) {
        int key = 0;

        try {
            conectarBanco();
            for (Disciplina disciplina : disci) {

                String sql = "insert into disciplina (codCurso,nome, cargaHoraria)"
                        + " values(?,?,?);";
                PreparedStatement stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stm.setInt(1, curso);
                stm.setString(2, disciplina.getNome());
                stm.setInt(3, disciplina.getCargaHoraria());

                stm.executeUpdate();

                ResultSet codDisciplina = stm.getGeneratedKeys();
                while (codDisciplina.next()) {
                    key = codDisciplina.getInt(1);
                }
                JOptionPane.showMessageDialog(null, key);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {

            desconectarBanco();
            return key;
        }
    }

    private int cadastroDisciplinaKey(Curso curso, ArrayList<Disciplina> disci) {
        int key = 0;

        try {
            conectarBanco();
            for (Disciplina disciplina : disci) {

                String sql = "insert into disciplina (codCurso,nome, cargaHoraria)"
                        + " values(?,?,?);";
                PreparedStatement stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stm.setInt(1, curso.getCodCurso());
                stm.setString(2, disciplina.getNome());
                stm.setInt(3, disciplina.getCargaHoraria());

                stm.executeUpdate();

                ResultSet codDisciplina = stm.getGeneratedKeys();
                while (codDisciplina.next()) {
                    key = codDisciplina.getInt(1);
                }
                JOptionPane.showMessageDialog(null, key);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {

            desconectarBanco();
            return key;
        }
    }

    
// Cadastro Ementa 
    public void casdastroEmentaDisciplina(Disciplina disciplina, Ementa ementa) {
        try {
            conectarBanco();
            stm = con.createStatement();
            String sql = "insert into ementa (codEmenta,periodoLetivo) values (" + disciplina.getCodDisciplina() + ","
                    + "'" + ementa.getPeriodoLetivo() + "');";
            stm.executeUpdate(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            desconectarBanco();
        }
    }

    public void casdastroEmentaDisciplina(int disciplina, Ementa ementa) {
        try {
            conectarBanco();
            stm = con.createStatement();
            String sql = "insert into ementa (codEmenta,periodoLetivo) values (" + disciplina + ","
                    + "'" + ementa.getPeriodoLetivo() + "');";
            stm.executeUpdate(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            desconectarBanco();
        }
    }
    
    
    // Cadastro Competencias
    
    public void casdastroCompetenciasDisciplina(Ementa ementa, Competencias compentencias)
    {
        try 
        {
            conectarBanco();
          
            stm = con.createStatement();
            String sql= "insert into ceet.competencia(codEmenta,Compentencia ) values ("+ementa.getCodDisciplina()+""
                    + ",'"+compentencias.getCompetencia()+"');";
            stm.executeUpdate(sql);
           
            
        } 
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally
        {
            desconectarBanco();
        }
    }
    
    public void casdastroCompetenciasDisciplina(Ementa ementa, ArrayList<Competencias> comp)
    {
        try 
        {
            conectarBanco();
            for(Competencias compentencias:comp)
            {
            stm = con.createStatement();
           String sql= "insert into ceet.competencia(codEmenta,Compentencia ) values ("+ementa.getCodDisciplina()+""
                    + ",'"+compentencias.getCompetencia()+"');";
            stm.executeUpdate(sql);
            
        } 
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally
        {
            desconectarBanco();
        }
    }
    public void casdastroCompetenciasDisciplina(int ementa, Competencias compentencias)
    {
        try 
        {
            conectarBanco();
            stm = con.createStatement();
          String sql= "insert into ceet.competencia(codEmenta,Compentencia ) values ("+ementa+""
                    + ",'"+compentencias.getCompetencia()+"');";
            stm.executeUpdate(sql);
            
        } 
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally
        {
            desconectarBanco();
        }
    }
    
    public void casdastroCompetenciasDisciplina(int ementa, ArrayList<Competencias> comp)
    {
        try 
        {
            conectarBanco();
            for(Competencias compentencias:comp)
            {
            stm = con.createStatement();
           String sql= "insert into ceet.competencia(codEmenta,Compentencia ) values ("+ementa+""
                    + ",'"+compentencias.getCompetencia()+"');";
            stm.executeUpdate(sql);
            
        } 
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally
        {
            desconectarBanco();
        }
    }

    
   // Cadastro Habilidades 
    
    public void casdastroHabilidadesDisciplina(Ementa ementa, Habilidades  habilidade)
    {
        try 
        {
            conectarBanco();
          
            stm = con.createStatement();
            String sql= "insert into ceet.habilidade(codEmenta,habilidade) values ("+ementa.getCodDisciplina()+""
                    + ",'"+habilidade.getHabilidades()+"');";
            stm.executeUpdate(sql);
           
            
        } 
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally
        {
            desconectarBanco();
        }
    }
    
    public void casdastroHabilidadesDisciplina(Ementa ementa, ArrayList <Habilidades > comp)
    {
        try 
        {
            conectarBanco();
            for(Habilidades habilidade:comp)
            {
            stm = con.createStatement();
           String sql= "insert into ceet.habilidade(codEmenta,habilidade) values ("+ementa.getCodDisciplina()+""
                    + ",'"+habilidade.getHabilidades()+"');";
            stm.executeUpdate(sql);
            
        } 
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally
        {
            desconectarBanco();
        }
    }
    public void casdastroHabilidadesDisciplina(int ementa, Habilidades  habilidade)
    {
        try 
        {
            conectarBanco();
            stm = con.createStatement();
          String sql= "insert into ceet.habilidade(codEmenta,habilidade) values ("+ementa+""
                    + ",'"+habilidade.getHabilidades()+"');";
            stm.executeUpdate(sql);
            
        } 
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally
        {
            desconectarBanco();
        }
    }
    
    public void casdastroHabilidadesDisciplina(int ementa, ArrayList<Habilidades > comp)
    {
        try 
        {
            conectarBanco();
            for(Habilidades habilidade:comp)
            {
            stm = con.createStatement();
           String sql= "insert into ceet.habilidade(codEmenta,habilidade ) values ("+ementa+""
                    + ",'"+habilidade.getHabilidades()+"');";
            stm.executeUpdate(sql);
            
        } 
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally
        {
            desconectarBanco();
        }
    }
    
    // Bases tecnologicas
    
    
     public void casdastroBasesTecnologicasDisciplina(Ementa ementa, BasesTecnologicas  base)
    {
        try 
        {
            conectarBanco();
          
            stm = con.createStatement();
            String sql= "insert into ceet.basesTecnologicas(codEmenta,bases) values ("+ementa.getCodDisciplina()+""
                    + ",'"+base.getBases()+"');";
            stm.executeUpdate(sql);
           
            
        } 
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally
        {
            desconectarBanco();
        }
    }
    
    public void casdastroBasesTecnologicasDisciplina(Ementa ementa, ArrayList <BasesTecnologicas > comp)
    {
        try 
        {
            conectarBanco();
            for(BasesTecnologicas base:comp)
            {
            stm = con.createStatement();
           String sql= "insert into ceet.basesTecnologicas(codEmenta,bases ) values ("+ementa.getCodDisciplina()+""
                    + ",'"+base.getBases()+"');";
            stm.executeUpdate(sql);
            
        } 
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally
        {
            desconectarBanco();
        }
    }
    public void casdastroBasesTecnologicasDisciplina(int ementa, BasesTecnologicas  base)
    {
        try 
        {
            conectarBanco();
            stm = con.createStatement();
          String sql= "insert into ceet.basesTecnologicas(codEmenta,bases) values ("+ementa+""
                    + ",'"+base.getBases()+"');";
            stm.executeUpdate(sql);
            
        } 
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally
        {
            desconectarBanco();
        }
    }
    
    public void casdastroBasesTecnologicasDisciplina(int ementa, ArrayList<BasesTecnologicas > comp)
    {
        try 
        {
            conectarBanco();
            for(BasesTecnologicas base:comp)
            {
            stm = con.createStatement();
           String sql= "insert into ceet.basesTecnologicas(codEmenta,bases) values ("+ementa+""
                    + ",'"+base.getBases()+"');";
            stm.executeUpdate(sql);
            
        } 
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally
        {
            desconectarBanco();
        }
    }
    

}
