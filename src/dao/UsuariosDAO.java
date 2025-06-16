package dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
            System.out.println("Erro ao atualizar usuario: " + erro);
            return false;
        }
    }

    public void pesquisarUsuario(){
        try {
            Connection condb = conexao.conectar();
            PreparedStatement buscarUsuario = condb.prepareStatement("SELECT \n" +
                    "\tusuarios.nome,\n" +
                    "    usuarios.email,\n" +
                    "    cargos.nome\n" +
                    "FROM \n" +
                    "\tusuarios\n" +
                    "INNER JOIN\n" +
                    "\tcargos\n" +
                    "ON\n" +
                    "\tusuarios.cargo_id = cargos.id\n" +
                    "WHERE usuarios.id = ?");
            buscarUsuario.setInt(1,3);
            ResultSet resultSet = buscarUsuario.executeQuery();

            while (resultSet.next()){
                String nome = resultSet.getString("nome");
                String email = resultSet.getString("email");
                String cargo = resultSet.getString("cargos.nome");
                System.out.println("nome: " + nome + "\nemail: " + email + "\ncargo: " + cargo);
            }
            condb.close();
        } catch (Exception erro) {
            System.out.println("Erro ao pesquisar usuario: " + erro);
        }
    }
}
