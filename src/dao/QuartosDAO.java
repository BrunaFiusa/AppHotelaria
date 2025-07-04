package dao;

import model.Quartos;
import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class QuartosDAO {
    //Objeto para instanciar classe Conexao paea requisitar acesso ao DB
    private Conexao conexao = new Conexao();

    public boolean inserirQuartos(Quartos quarto) {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement novoQuarto = condb.prepareStatement("INSERT INTO quartos" + "(nome, numero, qtd_cama_casal, qtd_cama_solteiro, preco, disponivel) VALUES (?, ?, ?, ?, ?, ?);");
            //Setar os parâmetros
            novoQuarto.setString(1, quarto.getNome());
            novoQuarto.setString(2, quarto.getNumero());
            novoQuarto.setInt(3, quarto.getQtd_cama_casal());
            novoQuarto.setInt(4, quarto.getQtd_cama_solteiro());
            novoQuarto.setDouble(5, quarto.getPreco());
            novoQuarto.setBoolean(6, quarto.isDisponivel());

            int linhaAfetada = novoQuarto.executeUpdate();
            condb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir quarto: " + erro);
            return false;
        }
    }

    public boolean deletarQuartos() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement deletarQuarto = condb.prepareStatement("DELETE FROM quartos WHERE id = ?;");
            //Setar os parâmetros
            deletarQuarto.setInt(1, 2);

            int linhaAfetada = deletarQuarto.executeUpdate();
            condb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao deletar quarto: " + erro);
            return false;
        }
    }

    public boolean atualizarQuartos() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement atualizarQuartos = condb.prepareStatement("UPDATE quartos SET nome = ?, numero = ?, qtd_cama_casal = ?, " +
                    "qtd_cama_solteiro = ?, preco = ?, disponivel = ?  WHERE id = ?;");
            //Setar os parâmetros
            atualizarQuartos.setString(1, "Quarto Casal");
            atualizarQuartos.setString(2, "100");
            atualizarQuartos.setInt(3, 1);
            atualizarQuartos.setInt(4, 1);
            atualizarQuartos.setDouble(5, 800);
            atualizarQuartos.setBoolean(6, true);
            atualizarQuartos.setInt(7, 3);

            int linhaAfetada = atualizarQuartos.executeUpdate();
            condb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao atualizar quarto: " + erro);
            return false;
        }
    }

    public void pesquisarQuarto(){
        try {
            Connection condb = conexao.conectar();
            PreparedStatement buscarQuarto = condb.prepareStatement("SELECT * " + "FROM quartos where id = ?");
            buscarQuarto.setInt(1,3);
            ResultSet resultSet = buscarQuarto.executeQuery();

            while (resultSet.next()){
                String nome = resultSet.getString("nome");
                String numero = resultSet.getString("numero");
                int qtd_cama_casal = resultSet.getInt("qtd_cama_casal");
                int qtd_cama_solteiro = resultSet.getInt("qtd_cama_solteiro");
                double preco = resultSet.getDouble("preco");
                boolean disponivel = resultSet.getBoolean("disponivel");
                System.out.println("nome: " + nome + "\nnumero: " + numero + "\nqtd_cama_casal: " + qtd_cama_casal + "\nqtd_cama_solteiro: " + qtd_cama_solteiro + "\npreco: " + preco + "\ndisponivel: " + disponivel);
            }
            condb.close();
        } catch (Exception erro) {
            System.out.println("Erro ao pesquisar quarto: " + erro);
        }
    }
}