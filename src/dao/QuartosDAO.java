package dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class QuartosDAO {
    //Objeto para instanciar classe Conexao paea requisitar acesso ao DB
    private Conexao conexao = new Conexao();

    public boolean inserirQuartos() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement novoQuarto = condb.prepareStatement("INSERT INTO quartos" + "(nome, numero, qtd_cama_casal, qtd_cama_solteiro, preco, disponivel) VALUES (?, ?, ?, ?, ?, ?);");
            //Setar os parâmetros
            novoQuarto.setString(1, "Quarto casal");
            novoQuarto.setString(2, "33");
            novoQuarto.setInt(3, 1);
            novoQuarto.setInt(4, 1);
            novoQuarto.setDouble(5, 800);
            novoQuarto.setBoolean(6, true);

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
            PreparedStatement atualizarQuartos = condb.prepareStatement("UPDATE quartos SET nome = ?, numero = ?, qtd_cama_casal = ?, qtd_cama_solteiro = ?, preco = ?, disponivel = ?  WHERE id = ?;");
            //Setar os parâmetros
            atualizarQuartos.setString(1, "Quarto casal");
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
}