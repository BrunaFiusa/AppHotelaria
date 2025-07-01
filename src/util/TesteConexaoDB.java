package util;
/* Classe para testar a conexão do banco com as
requisições; se os parametros como IP, nome de usuario, senha
e nome do banco de dados estão corretos, utilizando-se o driver JDBC para MYSQL
 */

import controller.UsuariosController;
import dao.*;
import model.Cargos;
import model.Clientes;
import model.Usuarios;
import java.sql.Connection;

public class TesteConexaoDB {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        UsuariosController usuariosController = new UsuariosController();
        Connection condb = conexao.conectar();

        if (condb != null) {
            System.out.println("Conexão estabelecida com sucesso!");
            try {
                //Testando a autenticação de um usuário
                usuariosController.verificarCredenciais("bruna.fiusa2006@gmail.com", "251173");
                condb.close();
                System.out.println("Conexão encerrada!");
            } catch (Exception erro) {
                System.out.println("Erro ao encerrar a conexão: " + erro.getMessage());
            }
        } else {
            System.out.println("Falha ao conectar ao banco de dados!");
        }
    }
}