package dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ClientesDAO {
    //Objeto para instanciar classe Conexao paea requisitar acesso ao DB
    private Conexao conexao = new Conexao();

    public boolean inserirCliente() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement novoCliente = condb.prepareStatement("INSERT INTO clientes" + "(nome, cpf, telefone, email) VALUES (?, ?, ?, ?);");
            //Setar os parâmetros
            novoCliente.setString(1, "Luana");
            novoCliente.setString(2, "53901248853");
            novoCliente.setString(3, "(15)99898-9588");
            novoCliente.setString(4, "luana.fiusa@gmail.com");

            int linhaAfetada = novoCliente.executeUpdate();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir cliente: " + erro);
            return false;
        }
    }
}