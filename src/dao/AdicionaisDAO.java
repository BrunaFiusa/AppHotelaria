package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AdicionaisDAO {

    //Objeto para instanciar classe Conexao paea requisitar acesso ao DB
    private Conexao conexao = new Conexao();

    public boolean inserirAdicionais() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement novoAdicional = condb.prepareStatement("INSERT INTO adicionais" + "(nome, preco) VALUES (?, ?);");
            //Setar os parâmetros
            novoAdicional.setString(1, "banheira");
            novoAdicional.setDouble(2, 300);

            int linhaAfetada = novoAdicional.executeUpdate();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir adicionais: " + erro);
            return false;
        }
    }
}
