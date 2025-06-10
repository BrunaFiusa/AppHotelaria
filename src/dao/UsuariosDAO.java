package dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UsuariosDAO {
    //Objeto para instanciar classe Conexao paea requisitar acesso ao DB
    private Conexao conexao = new Conexao();

    public boolean inserirUsuario() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement novoUsuario = condb.prepareStatement("INSERT INTO usuarios" + "(nome, email, senha, cargo_id) VALUES (?, ?, md5(?), ?);");
            //Setar os parâmetros
            novoUsuario.setString(1, "Pamela");
            novoUsuario.setString(2, "pamela.pereto@gmail.com");
            novoUsuario.setString(3, "123");
            novoUsuario.setInt(4, 4);

            int linhaAfetada = novoUsuario.executeUpdate();
            condb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir usuario: " + erro);
            return false;
        }
    }

    public boolean deletarUsuarios() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement deletarUsuario = condb.prepareStatement("DELETE FROM usuarios WHERE id = ?;");
            //Setar os parâmetros
            deletarUsuario.setInt(1, 2);

            int linhaAfetada = deletarUsuario.executeUpdate();
            condb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao deletar usuario: " + erro);
            return false;
        }
    }

    public boolean atualizarUsuario() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement atualizarUsuarios = condb.prepareStatement("UPDATE usuarios SET nome = ?, email = ?, senha = md5(?), cargo_id = ?  WHERE id = ?;");
            //Setar os parâmetros
            atualizarUsuarios.setString(1, "Bruna Fiusa");
            atualizarUsuarios.setString(2, "bruna.fiusa2006@gmail.com");
            atualizarUsuarios.setString(3, "251173");
            atualizarUsuarios.setInt(4, 1);
            atualizarUsuarios.setInt(5, 3);

            int linhaAfetada = atualizarUsuarios.executeUpdate();
            condb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao deletar usuario: " + erro);
            return false;
        }
    }
}
