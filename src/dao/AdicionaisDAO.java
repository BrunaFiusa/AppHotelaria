package dao;

import model.Adicionais;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AdicionaisDAO {

    //Objeto para instanciar classe Conexao paea requisitar acesso ao DB
    private Conexao conexao = new Conexao();

    public boolean inserirAdicionais(Adicionais adicionais) {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement novoAdicional = condb.prepareStatement("INSERT INTO adicionais" + "(nome, preco) VALUES (?, ?);");
            //Setar os parâmetros
            novoAdicional.setString(1, adicionais.getNome());
            novoAdicional.setDouble(2, adicionais.getPreco());

            int linhaAfetada = novoAdicional.executeUpdate();
            condb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir adicional: " + erro);
            return false;
        }
    }

    public boolean deletarAdicionais() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement deletarAdicionais = condb.prepareStatement("DELETE FROM adicionais WHERE id = ?;");
            //Setar os parâmetros
            deletarAdicionais.setInt(1, 2);

            int linhaAfetada = deletarAdicionais.executeUpdate();
            condb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao deletar adicional: " + erro);
            return false;
        }
    }

    public boolean atualizarAdicionais() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement atualizarAdicionais = condb.prepareStatement("UPDATE adicionais SET nome = ?, preco = ? WHERE id = ?;");
            //Setar os parâmetros
            atualizarAdicionais.setString(1, "banheira");
            atualizarAdicionais.setDouble(2, 300);
            atualizarAdicionais.setInt(3, 3);

            int linhaAfetada = atualizarAdicionais.executeUpdate();
            condb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao atualizar adicional: " + erro);
            return false;
        }
    }

}
