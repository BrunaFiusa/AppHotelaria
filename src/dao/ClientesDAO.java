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
            novoCliente.setString(1, "Pamela");
            novoCliente.setString(2, "53901248598");
            novoCliente.setString(3, "(15)99898-9888");
            novoCliente.setString(4, "pamela.pereto@gmail.com");

            int linhaAfetada = novoCliente.executeUpdate();
            condb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir cliente: " + erro);
            return false;
        }
    }

    public boolean deletarClientes() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement deletarClientes = condb.prepareStatement("DELETE FROM clientes WHERE id = ?;");
            //Setar os parâmetros
            deletarClientes.setInt(1, 2);

            int linhaAfetada = deletarClientes.executeUpdate();
            condb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao deletar usuario: " + erro);
            return false;
        }
    }

    public boolean atualizarClientes() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement atualizarClientes = condb.prepareStatement("UPDATE clientes SET nome = ?, cpf = ?, telefone = ?, email = ? WHERE id = ?;");
            //Setar os parâmetros
            atualizarClientes.setString(1, "Bruna");
            atualizarClientes.setString(2, "53901145829");
            atualizarClientes.setString(3, "(15)99797-9377");
            atualizarClientes.setString(4, "bruna.fiusa@gmail.com");
            atualizarClientes.setInt(5, 4);

            int linhaAfetada = atualizarClientes.executeUpdate();
            condb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao deletar usuario: " + erro);
            return false;
        }
    }

}