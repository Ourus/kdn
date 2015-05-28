package bandoDados;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelos.*;

public class AlunoBD extends PessoaBD {
    // cadastros 

    public void cadastro(Aluno aluno, Endereco endereco, Contato contato) {
        int key = 0;
        try {
            key = super.cadastro(aluno, endereco, contato);

            conectarBanco();
            stm = con.createStatement();
            JOptionPane.showMessageDialog(null, key);

            String sql = "insert into aluno (codAluno,matricula,certidaoNascimento,compEscolaridade,status,observacao)"
                    + "value(" + key + ",'" + aluno.getMatricula() + "','" + aluno.getCertidaoNascimento() + "',"
                    + "'" + aluno.getComprovanteEscolarida() + "','" + aluno.getStatus() + "','" + aluno.getObservacao() + "');";

            JOptionPane.showMessageDialog(null, "Aluno: " + aluno.getNome() + "\n \t Cadastrado com sucesso");

            stm.executeUpdate(sql);

            System.out.println(key);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            desconectarBanco();

        }

    }

    public void cadastro(Aluno aluno, Endereco endereco, ArrayList<Contato> contato) {
        int key = 0;
        try {
            key = super.cadastro(aluno, endereco, contato);

            conectarBanco();
            stm = con.createStatement();
            JOptionPane.showMessageDialog(null, key);

            String sql = "insert into aluno (codAluno,matricula,certidaoNascimento,compEscolaridade,status,observacao)"
                    + "value(" + key + ",'" + aluno.getMatricula() + "','" + aluno.getCertidaoNascimento() + "',"
                    + "'" + aluno.getComprovanteEscolarida() + "','" + aluno.getStatus() + "','" + aluno.getObservacao() + "');";

            JOptionPane.showMessageDialog(null, "Aluno: " + aluno.getNome() + "\n \t Cadastrado com sucesso");

            stm.executeUpdate(sql);

            System.out.println(key);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            desconectarBanco();

        }

    }

    public void cadastro(Aluno aluno, ArrayList<Endereco> endereco, Contato contato) {
        int key = 0;
        try {
            key = super.cadastro(aluno, endereco, contato);

            conectarBanco();
            stm = con.createStatement();
            JOptionPane.showMessageDialog(null, key);

            String sql = "insert into aluno (codAluno,matricula,certidaoNascimento,compEscolaridade,status,observacao)"
                    + "value(" + key + ",'" + aluno.getMatricula() + "','" + aluno.getCertidaoNascimento() + "',"
                    + "'" + aluno.getComprovanteEscolarida() + "','" + aluno.getStatus() + "','" + aluno.getObservacao() + "');";

            JOptionPane.showMessageDialog(null, "Aluno: " + aluno.getNome() + "\n \t Cadastrado com sucesso");

            stm.executeUpdate(sql);

            System.out.println(key);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            desconectarBanco();

        }

    }

    public void cadastro(Aluno aluno, ArrayList<Endereco> endereco, ArrayList<Contato> contato) {
        int key = 0;
        try {
            key = super.cadastro(aluno, endereco, contato);

            conectarBanco();
            stm = con.createStatement();
            JOptionPane.showMessageDialog(null, key);

            String sql = "insert into aluno (codAluno,matricula,certidaoNascimento,compEscolaridade,status,observacao)"
                    + "value(" + key + ",'" + aluno.getMatricula() + "','" + aluno.getCertidaoNascimento() + "',"
                    + "'" + aluno.getComprovanteEscolarida() + "','" + aluno.getStatus() + "','" + aluno.getObservacao() + "');";

            stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Aluno: " + aluno.getNome() + "\n \t Cadastrado com sucesso");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            desconectarBanco();

        }

    }

    public void cadastroDesempenho(Aluno aluno, Desempenho despenho) {
        try {
            conectarBanco();
            stm = con.createStatement();
            String sql = "insert into desempenho (codAluno,desempenho,numeroFaltas,trimestre)"
                    + " values(" + aluno.getCodPessoa() + ",'" + despenho.getDesempenho() + "',"
                    + "" + despenho.getNumeroFaltas() + ",'" + despenho.getTrimestre() + "';";
            stm.executeUpdate(sql);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            desconectarBanco();
        }

    }

    public void cadastroDesempenho(Aluno aluno, ArrayList<Desempenho> desp) {
        try {
            conectarBanco();
            stm = con.createStatement();
            for (Desempenho desempenho : desp) {
                String sql = "insert into desempenho (codAluno,desempenho,numeroFaltas,trimestre)"
                        + " values(" + aluno.getCodPessoa() + ",'" + desempenho.getDesempenho() + "',"
                        + "" + desempenho.getNumeroFaltas() + ",'" + desempenho.getTrimestre() + "';";
                stm.executeUpdate(sql);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            desconectarBanco();
        }

    }

    public void cadastroDesempenho(int aluno, Desempenho despenho) {
        try {
            conectarBanco();
            stm = con.createStatement();
            String sql = "insert into desempenho (codAluno,desempenho,numeroFaltas,trimestre)"
                    + " values(" + aluno + ",'" + despenho.getDesempenho() + "',"
                    + "" + despenho.getNumeroFaltas() + ",'" + despenho.getTrimestre() + "';";
            stm.executeUpdate(sql);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            desconectarBanco();
        }

    }

    public void cadastroDesempenho(int aluno, ArrayList<Desempenho> desp) {
        try {
            conectarBanco();
            stm = con.createStatement();
            for (Desempenho desempenho : desp) {
                String sql = "insert into desempenho (codAluno,desempenho,numeroFaltas,trimestre)"
                        + " values(" + aluno + ",'" + desempenho.getDesempenho() + "',"
                        + "" + desempenho.getNumeroFaltas() + ",'" + desempenho.getTrimestre() + "';";
                stm.executeUpdate(sql);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            desconectarBanco();
        }

    }

    public void cadastroEscolaridade(Aluno aluno, Escolaridade escolaridade) {
        try {
            conectarBanco();
            stm = con.createStatement();
            String sql = "insert into escolaridade (codAluno,serie,nomeEscola,"
                    + "municipio,dependenciaAdministrativa,anoLetivo,eja)"
                    + " values(" + aluno.getCodPessoa() + ",'" + escolaridade.getSerie() + "',";

        } catch (Exception e) {
        } finally {

        }
    }

// pesquisas 
    // desempenho Aluno 
    public ArrayList<Desempenho> listaDesempenhoAluno(Aluno aluno) {

        ArrayList<Desempenho> desempenho = new ArrayList();

        try {
            conectarBanco();
            Desempenho pesquisa;
            stm = con.createStatement();
            String comando = "select desempenho,numeroFaltas,trimestre"
                    + " from desempenho where codAluno=" + aluno.getCodPessoa() + ";";

            ResultSet tabelaDesempenhoAluno = stm.executeQuery(comando);
            while (tabelaDesempenhoAluno.next()) {
                pesquisa = new Desempenho();

                pesquisa.setDesempenho(tabelaDesempenhoAluno.getString("desempenho"));
                pesquisa.setNumeroFaltas(tabelaDesempenhoAluno.getInt("numeroFaltas"));
                pesquisa.setTrimestre(tabelaDesempenhoAluno.getString("trimestre"));

                desempenho.add(pesquisa);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally {
            desconectarBanco();
            return desempenho;
        }

    }

    // Pesquisar escolaridade do aluno 
    public ArrayList<Escolaridade> listaEscolaridadeAluno(Aluno aluno) {
        ArrayList<Escolaridade> escolaridade = new ArrayList();
        try {
            conectarBanco();
            stm = con.createStatement();
            String comando = "select * from escolaridade"
                    + " where codAluno=" + aluno.getCodPessoa() + ";";
            ResultSet tabelaEsolaridadeAluno = stm.executeQuery(comando);
            Escolaridade pesquisa;

            while (tabelaEsolaridadeAluno.next()) {
                pesquisa = new Escolaridade();
                pesquisa.setNomeEscola(tabelaEsolaridadeAluno.getString("nomeEscola"));
                pesquisa.setMunicipioEscola(tabelaEsolaridadeAluno.getString("municipio"));
                pesquisa.setSerie(tabelaEsolaridadeAluno.getString("serie"));
                pesquisa.setAnoLetivo(tabelaEsolaridadeAluno.getString("anoLetivo"));
                pesquisa.setEja(tabelaEsolaridadeAluno.getString("eja"));
                pesquisa.setDependenciasAdministrativa(tabelaEsolaridadeAluno.getString("dependenciaAdministrativa"));

                escolaridade.add(pesquisa);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        } finally {
            desconectarBanco();
            return escolaridade;

        }
    }

    // Atualizar dados  do Aluno 
}
