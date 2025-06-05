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
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir quarto: " + erro);
            return false;
        }
    }
}