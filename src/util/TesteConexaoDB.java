package util;
/* Classe para testar a conexão do banco com as
requisições; se os parametros como IP, nome de usuario, senha
e nome do banco de dados estão corretos, utilizando-se o driver JDBC para MYSQL
 */

import dao.*;
import model.Cargos;
import model.Clientes;
import model.Usuarios;
import java.sql.Connection;

public class TesteConexaoDB {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();

        Usuarios usuario = new Usuarios("Osana", "osanaam@gmail.com", "121274", 1);

        Connection condb = conexao.conectar();

        if (condb != null) {
            System.out.println("Conexão estabelecida com sucesso!");
            try {
                UsuariosDAO usuariosDAO = new UsuariosDAO();
                usuariosDAO.autenticarUsuario(usuario);
//
//                ClientesDAO clientesDAO = new ClientesDAO();
//                clientesDAO.pesquisarCientes();
//                QuartosDAO quartosDAO = new QuartosDAO();
//                quartosDAO.pesquisarQuarto();
//                AdicionaisDAO adicionaisDAO = new AdicionaisDAO();
//                adicionaisDAO.atualizarAdicionais();
//                PedidosDAO pedidosDAO = new PedidosDAO();
//                pedidosDAO.pesquisarPedidos();
//                ReservasDAO reservasDAO = new ReservasDAO();
//                reservasDAO.pesquisarReservas();
//                CargosDAO cargosDAO = new CargosDAO();
//                cargosDAO.pesquisarCargos();

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