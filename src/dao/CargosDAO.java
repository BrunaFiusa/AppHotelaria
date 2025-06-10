package dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class CargosDAO {
    //Objeto para instanciar classe Conexao paea requisitar acesso ao DB
    private Conexao conexao = new Conexao();

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
            System.out.println("Erro ao deletar usuario: " + erro);
            return false;
        }
    }
}
