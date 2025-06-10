package dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class CargosDAO {
    //Objeto para instanciar classe Conexao paea requisitar acesso ao DB
    private Conexao conexao = new Conexao();

    public boolean inserirCagos() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement novoCargo = condb.prepareStatement("INSERT INTO cargos" + "(nome) VALUES (?);");
            //Setar os parâmetros
            novoCargo.setString(1, "Camareiro");

            int linhaAfetada = novoCargo.executeUpdate();
            condb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir cargo: " + erro);
            return false;
        }
    }

    public boolean deletarCargos() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement deletarCargos = condb.prepareStatement("DELETE FROM cargos WHERE id = ?;");
            //Setar os parâmetros
            deletarCargos.setInt(1, 5);

            int linhaAfetada = deletarCargos.executeUpdate();
            condb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao deletar cargo: " + erro);
            return false;
        }
    }

    public boolean atualizarCargos() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement atualizarCargos = condb.prepareStatement("UPDATE cargos SET nome = ? WHERE id = ?;");
            //Setar os parâmetros
            atualizarCargos.setString(1, "Funcionario");
            atualizarCargos.setInt(2, 4);

            int linhaAfetada = atualizarCargos.executeUpdate();
            condb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao atualizar cargo: " + erro);
            return false;
        }
    }
}
