package dao;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class PedidosDAO {
    //Objeto para instanciar classe Conexao paea requisitar acesso ao DB
    private Conexao conexao = new Conexao();

    public boolean inserirPedidos() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement novoPedido = condb.prepareStatement("INSERT INTO pedidos" + "(usuario_id, cliente_id, pagamento) VALUES (?, ?, ?);");
            //Setar os parâmetros
            novoPedido.setInt(1, 3);
            novoPedido.setInt(2, 3);
            novoPedido.setString(3, "Cartão");

            int linhaAfetada = novoPedido.executeUpdate();
            condb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao inserir pedidos: " + erro);
            return false;
        }
    }

    public boolean deletarPedidos() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement deletarPedidos = condb.prepareStatement("DELETE FROM pedidos WHERE id = ?;");
            //Setar os parâmetros
            deletarPedidos.setInt(1, 4);

            int linhaAfetada = deletarPedidos.executeUpdate();
            condb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao deletar pedido: " + erro);
            return false;
        }
    }

    public boolean atualizarPedidos() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement atualizarPedidos = condb.prepareStatement("UPDATE pedidos SET usuario_id = ?, cliente_id = ?, pagamento = ? WHERE id = ?;");
            //Setar os parâmetros
            atualizarPedidos.setInt(1, 3);
            atualizarPedidos.setInt(2, 3);
            atualizarPedidos.setString(3, "Cartão");
            atualizarPedidos.setInt(4, 5);

            int linhaAfetada = atualizarPedidos.executeUpdate();
            condb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao atualizar: " + erro);
            return false;
        }
    }
}
