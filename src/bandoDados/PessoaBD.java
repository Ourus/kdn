package bandoDados;

import java.sql.Blob;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import javax.swing.JOptionPane;
import modelos.*;

public class PessoaBD extends Conexao {

// ================= Metodos Principais de Pessoas =====================
// Cadastro de Pessoa
    public int cadastro(Pessoa pessoa, Endereco endereco, Contato contato) {
        int i = 0;
        try {
            i = cadastroPessoaKey(pessoa);
            cadastroEndereco(i, endereco);
            cadastroContato(i, contato);
            JOptionPane.showMessageDialog(null, "Cadastro Realizado \n \t com sucesso !!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            desconectarBanco();
            return i;
        }
    }

     // ===================================================================================
    
    public int cadastro(Pessoa pessoa, Endereco endereco, ArrayList<Contato> contato) {
        int i = 0;
        try {
            i = cadastroPessoaKey(pessoa);
            cadastroEndereco(i, endereco);
            cadastroContato(i, contato);
            JOptionPane.showMessageDialog(null, "Cadastro Realizado \n \t com sucesso !!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            desconectarBanco();
            return i;
        }
    }
    
    
    public int cadastro(Pessoa pessoa, ArrayList <Endereco> endereco, Contato contato) {
        int i = 0;
        try {
            i = cadastroPessoaKey(pessoa);
            cadastroEndereco(i, endereco);
            cadastroContato(i, contato);
            JOptionPane.showMessageDialog(null, "Cadastro Realizado \n \t com sucesso !!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            desconectarBanco();
            return i;
        }
    }
    
    
    public int cadastro(Pessoa pessoa, ArrayList <Endereco> endereco, ArrayList <Contato> contato) {
        int i = 0;
        try {
            i = cadastroPessoaKey(pessoa);
            cadastroEndereco(i, endereco);
            cadastroContato(i, contato);
            JOptionPane.showMessageDialog(null, "Cadastro Realizado \n \t com sucesso !!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            desconectarBanco();
            return i;
        }
    }

// Excluir Pessoa
    
    
    
    
    
    public void excluirPessoa(Pessoa pessoa) {
        try {
            conectarBanco();
            stm = con.createStatement();
            String sql = "delete from pessoa where codPessoa=" + pessoa.getCodPessoa() + ";";
            stm.executeUpdate(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            desconectarBanco();
        }
    }

// ================= Metodos de destinada a cadastro ==================
    public void cadastro(Pessoa pessoa) {
        try {
            conectarBanco();
            stm = con.createStatement();
            String sql = "insert into pessoa (nome,rg,cpf,naturalidade,"
                    + "dataNascimento,uf,nomePai,nomeMae,foto,compResidencia,compFoto) value ('"
                    + pessoa.getNome() + "','" + pessoa.getRG() + "','" + pessoa.getCpf() + "',"
                    + "'" + pessoa.getNaturalidade() + "','" + pessoa.getDataNacimento() + "',"
                    + "'" + pessoa.getUf() + "','" + pessoa.getNomePai() + "','" + pessoa.getNomeMae() + "'"
                    + ",'" + pessoa.getFoto() + "','"+pessoa.getCompResidencia()+"',);";
            stm.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

            ResultSet tb = stm.getGeneratedKeys();

            while (tb.next()) {
                JOptionPane.showConfirmDialog(null, tb.getInt("codPessoa"));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            desconectarBanco();
        }
    }

    public void cadastroEndereco(int pessoa, Endereco endereco) {

        try {
            conectarBanco();
            stm = con.createStatement();
            String sql = "insert into endereco (codPessoa,rua,cidade,uf,bairro,cep,complemento)"
                    + "values(" + pessoa + ",'" + endereco.getRua() + "','" + endereco.getCidade() + "'"
                    + ",'" + endereco.getUf() + "','" + endereco.getBairro() + "','" + endereco.getCep() + "',"
                    + "'" + endereco.getComplemento() + "');";
            stm.executeUpdate(sql);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            desconectarBanco();
        }

    }

    private void cadastroEndereco(int pessoa, ArrayList<Endereco> ende) 
    {

        try {
            conectarBanco();
            for (Endereco endereco : ende) {
                stm = con.createStatement();
                String sql = "insert into endereco (codPessoa,endereco,cidade,uf,bairro,cep,complemento)"
                        + "values(" + pessoa + ",'" + endereco.getRua() + "','" + endereco.getCidade() + "'"
                        + ",'" + endereco.getUf() + "','" + endereco.getBairro() + "','" + endereco.getCep() + "',"
                        + "'" + endereco.getComplemento() + "');";
                stm.executeUpdate(sql);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            desconectarBanco();
        }

    }

    public void cadastroContato(int pessoa, Contato contato) {
        try {
            conectarBanco();
            stm = con.createStatement();
            String sql = "insert into contato (codPessoa,tipo,contato) values(" + pessoa + ","
                    + "'" + contato.getTipo() + "','" + contato.getContato() + "');";
            stm.executeUpdate(sql);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        } finally {
            desconectarBanco();
        }

    }

    private void cadastroContato(int pessoa, ArrayList<Contato> cont) {
        try {
            for (Contato contato :cont) {
                conectarBanco();

                stm = con.createStatement();
                String sql = "insert into contato (codPessoa,tipo,contato) values(" + pessoa + ","
                        + "'" + contato.getTipo() + "','" + contato.getContato() + "');";
                stm.executeUpdate(sql);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        } finally {
            desconectarBanco();
        }

    }

    private int cadastroPessoaKey(Pessoa pessoa) {
        int key = 0;

        try {
            conectarBanco();
            String sql = "insert into pessoa (nome,rg,dataExpedicao,orgaoEmissor,cpf,naturalidade,dataNascimento,uf,"
                    + "nomePai,nomeMae,foto,sexo,corRaca,compResidencia,compFoto) values(?,?,?,?,?,?,?,?,?,?,?,?,?.?,?);";
            PreparedStatement stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, pessoa.getNome());
            stm.setString(2, pessoa.getRG());
            stm.setString(3, pessoa.getDataExpedicao().get(Calendar.YEAR)+"-"+ pessoa.getDataExpedicao().get(Calendar.MONTH)+ "-"+ pessoa.getDataExpedicao().get(Calendar.DAY_OF_MONTH));
            stm.setString(4, pessoa.getOrgaoEmissor());
            stm.setString(5, pessoa.getCpf());
            stm.setString(6, pessoa.getNaturalidade());
            // new Date(pessoa.getDataNacimento().get(Calendar.DAY_OF_MONTH), pessoa.getDataNacimento().get(Calendar.MONTH), pessoa.getDataNacimento().get(Calendar.YEAR))
            stm.setString(7, pessoa.getDataNacimento().get(Calendar.YEAR) + "-" + pessoa.getDataNacimento().get(Calendar.MONTH) + "-" + pessoa.getDataNacimento().get(Calendar.DAY_OF_MONTH));
            stm.setString(8, pessoa.getUf());
            stm.setString(9, pessoa.getNomePai());
            stm.setString(10, pessoa.getNomeMae());
            stm.setBlob(11, pessoa.getFoto());
            stm.setString(12, pessoa.getSexo());
            stm.setString(13, pessoa.getCorRaca());
            stm.setString(14, pessoa.getCompResidencia());
            stm.setString(15,pessoa.getCompFoto());
            
            
            
            stm.executeUpdate();

            ResultSet codPessoa = stm.getGeneratedKeys();
            while (codPessoa.next()) {
                key = codPessoa.getInt(1);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {

            desconectarBanco();
            return key;
        }
    }

// ================= Metodos de destinada a excluir ==================
    public void excluirContato(Pessoa pessoa, Contato contato) {
        try {
            conectarBanco();
            stm = con.createStatement();
            String sql = "delete from contato where codContato=" + contato.getCodContato() + "and "
                    + "codPessoa=" + pessoa.getCodPessoa() + ";";
            stm.executeUpdate(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            desconectarBanco();
        }

    }

    public void excluirEndereco(Pessoa pessoa, Endereco endereco) {
        try {
            conectarBanco();
            stm = con.createStatement();
            String sql = "delete from endereco where codEndereco=" + endereco.getCodEndereco() + "and"
                    + "codPessoa=" + pessoa.getCodPessoa() + ";";
            stm.executeUpdate(sql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            desconectarBanco();
        }
    }

// ================= Metodos de destinada a buscar ==================
// Buscar endereco de uma pessoa
    public ArrayList<Endereco> listarEnderecoPessoa(Pessoa pessoa) {
        ArrayList<Endereco> listaEnderecoPessoa = new ArrayList();

        try {

            conectarBanco();
            Endereco endereco;
            stm = con.createStatement();
            String sqlComando = "select * from endereco where codPessoa= " + pessoa.getCodPessoa();
            ResultSet tabelaEnderecosPessoas = stm.executeQuery(sqlComando);
            while (tabelaEnderecosPessoas.next()) {
                endereco = new Endereco();

                endereco.setCidade(tabelaEnderecosPessoas.getString("cidade"));
                endereco.setBairro(tabelaEnderecosPessoas.getString("bairro"));
                endereco.setComplemento(tabelaEnderecosPessoas.getString("complemento"));
                endereco.setCep(tabelaEnderecosPessoas.getString("cep"));
                endereco.setUf(tabelaEnderecosPessoas.getString("uf"));
                endereco.setRua(tabelaEnderecosPessoas.getString("endereco"));
                endereco.setCodEndereco(tabelaEnderecosPessoas.getInt("codEndereco"));

                listaEnderecoPessoa.add(endereco);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            desconectarBanco();
            return listaEnderecoPessoa;
        }
    }

    // Buacar Contatos de uma pessoa
    public ArrayList<Contato> listarContatoPessoa(Pessoa pessoa) {
        ArrayList<Contato> listaContatosPessoa = new ArrayList();

        try {
            conectarBanco();

            Contato novoContato;
            stm = con.createStatement();
            String sql = "select * from contato where  codPessoa=" + pessoa.getCodPessoa();

            ResultSet tabelaResultadoContatos = stm.executeQuery(sql);

            while (tabelaResultadoContatos.next()) {
                novoContato = new Contato();

                novoContato.setContato(tabelaResultadoContatos.getString("contato"));
                novoContato.setTipo(tabelaResultadoContatos.getString("tipo"));
                novoContato.setCodContato(tabelaResultadoContatos.getInt("codContato"));
                listaContatosPessoa.add(novoContato);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            desconectarBanco();
            return listaContatosPessoa;

        }
    }

    public Pessoa localizarPessoa(Pessoa pessoa) {
        Pessoa pessoaCadastrada = new Pessoa();
        try {
            conectarBanco();
            stm = con.createStatement();
            String sql = "select * from aluno where codPessoa=" + pessoa.getCodPessoa() + ";";
            ResultSet tabelaResultante = stm.executeQuery(sql);
            pessoaCadastrada.setCodPessoa(tabelaResultante.getInt("codPessoa"));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            desconectarBanco();
            return pessoaCadastrada;
        }
    }

    public ArrayList<Pessoa> listarPessoasBanco() {
        ArrayList<Pessoa> listaPessoa = new ArrayList();

        try {
            Pessoa novoPessoa;
            conectarBanco();
            String sql = "select * from pessoa;";
            stm = con.createStatement();
            ResultSet listasPessoaCadastradas = stm.executeQuery(sql);
            while (listasPessoaCadastradas.next()) {
                novoPessoa = new Pessoa();

                novoPessoa.setCodPessoa(listasPessoaCadastradas.getInt("codPessoa"));
                novoPessoa.setCpf(listasPessoaCadastradas.getString("cpf"));
                Calendar cal = Calendar.getInstance();
                cal.setTime(listasPessoaCadastradas.getDate("dataNascimento"));
                novoPessoa.setDataNacimento(cal);
                novoPessoa.setFoto((Blob) listasPessoaCadastradas.getBlob("foto"));
                novoPessoa.setNaturalidade(listasPessoaCadastradas.getString("naturalidade"));
                novoPessoa.setNome(listasPessoaCadastradas.getString("nome"));
                novoPessoa.setNomeMae(listasPessoaCadastradas.getString("nomeMae"));
                novoPessoa.setNomePai(listasPessoaCadastradas.getString("nomePai"));
                novoPessoa.setRG(listasPessoaCadastradas.getString("rg"));
                novoPessoa.setUf(listasPessoaCadastradas.getString("uf"));

                listaPessoa.add(novoPessoa);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            desconectarBanco();

            //    novoPessoa.setEnderecos(listarEnderecoPessoa(novoPessoa));
            return listaPessoa;
        }
    }

    public ArrayList<Pessoa> listarPessoasBanco(String nome) {
        ArrayList<Pessoa> nomePessoa = new ArrayList();

        try {
            Pessoa novoPessoa;
            conectarBanco();
            String sql = "select * from pessoa where nome= '" + nome + "';";
            stm = con.createStatement();
            ResultSet listasPessoaCadastradas = stm.executeQuery(sql);
            while (listasPessoaCadastradas.next()) {
                novoPessoa = new Pessoa();

                novoPessoa.setCodPessoa(listasPessoaCadastradas.getInt("codPessoa"));
                novoPessoa.setCpf(listasPessoaCadastradas.getString("cpf"));
                Calendar cal = Calendar.getInstance();
                cal.setTime(listasPessoaCadastradas.getDate("dataNascimento"));
                novoPessoa.setDataNacimento(cal);
                novoPessoa.setFoto((Blob) listasPessoaCadastradas.getBlob("foto"));
                novoPessoa.setNaturalidade(listasPessoaCadastradas.getString("naturalidade"));
                novoPessoa.setNome(listasPessoaCadastradas.getString("nome"));
                novoPessoa.setNomeMae(listasPessoaCadastradas.getString("nomeMae"));
                novoPessoa.setNomePai(listasPessoaCadastradas.getString("nomePai"));
                novoPessoa.setRG(listasPessoaCadastradas.getString("rg"));
                novoPessoa.setUf(listasPessoaCadastradas.getString("uf"));

                nomePessoa.add(novoPessoa);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            desconectarBanco();
            return nomePessoa;
        }

    }

    // ================= Metodos de destinada a Atualizar ==================
    public void atualizarPessoa(Pessoa pessoa) {
        try {
            conectarBanco();
            String sql = "update pessoa set nome = '" + pessoa.getNome() + "',rg='" + pessoa.getRG() + "',"
                    + "cpf='" + pessoa.getCpf() + "',naturalidade='" + pessoa.getNaturalidade() + "',"
                    + "dataNascimento='" + pessoa.getDataNacimento() + "',"
                    + "uf='" + pessoa.getUf() + "',nomePai='" + pessoa.getNomePai() + "',nomeMae='" + pessoa.getNomeMae() + "',"
                    + "foto='" + pessoa.getFoto() + "' compResidencia="+pessoa.getCompResidencia()+"' where codPessoa= " + pessoa.getCodPessoa() + ";";
            stm = con.createStatement();
            stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Cadastro Realizado \n\t com sucesso");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            desconectarBanco();
        }
    }

    public void atualizarContato(Pessoa pessoa, Contato contato) {
        try {
            conectarBanco();
            stm = con.createStatement();
            String sql = "update contato set tipo='" + contato.getTipo() + "', "
                    + "contato='" + contato.getContato() + "' where codPessoa=" + pessoa.getCodPessoa() + ";";
            stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Atualização realizada com sucesso ");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            desconectarBanco();
        }
    }

    public void atualizarEndereco(Pessoa pessoa, Endereco endereco) {
        try {
            conectarBanco();
            stm = con.createStatement();
            String sql = "uptdate";
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        } finally {
            desconectarBanco();
        }
    }

}
