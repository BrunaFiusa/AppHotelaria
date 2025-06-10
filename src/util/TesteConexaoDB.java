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
        Connection condb = conexao.conectar();

        if (condb != null) {
            System.out.println("Conexão estabelecida com sucesso!");
            try {
//                UsuariosDAO usuariosDAO = new UsuariosDAO();
//                usuariosDAO.atualizarUsuario();
//
                ClientesDAO clientesDAO = new ClientesDAO();
                clientesDAO.atualizarClientes();

//                QuartosDAO quartosDAO = new QuartosDAO();
//                quartosDAO.atualizarQuartos();
//
//                AdicionaisDAO adicionaisDAO = new AdicionaisDAO();
//                adicionaisDAO.atualizarAdicionais();
//
//                PedidosDAO pedidosDAO = new PedidosDAO();
//                pedidosDAO.atualizarPedidos();
//
//                ReservasDAO reservasDAO = new ReservasDAO();
//                reservasDAO.atualizarReservas();

//                CargosDAO cargosDAO = new CargosDAO();
//                cargosDAO.atualizarCargos();

                System.out.println("Informações deletadas com sucesso!");

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
