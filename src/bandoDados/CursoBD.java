package bandoDados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelos.Curso;

/**
         *
         * @author Jonathan Dutra
         */

public class CursoBD extends Conexao 
{

    public int cadastrarCursoKey(Curso curso) {
        int key = -1;

        try 
        {
            conectarBanco();
            stm = con.createStatement();
            String sql = "insert into disciplina (nome, numeroIdMEC)"
                    + " values(?,?);";
            PreparedStatement stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, curso.getNomeCurso());
            stm.setString(2, curso.getNumeroIdMEC());
            stm.executeUpdate();
            ResultSet codCurso = stm.getGeneratedKeys();
            while (codCurso.next()) {
                key = codCurso.getInt(1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            desconectarBanco();
            return key;
        }
    }

}
