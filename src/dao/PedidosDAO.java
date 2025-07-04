package dao;

import model.Pedidos;
import util.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PedidosDAO {
    //Objeto para instanciar classe Conexao paea requisitar acesso ao DB
    private Conexao conexao = new Conexao();

    public boolean inserirPedidos(Pedidos pedido) {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement novoPedido = condb.prepareStatement("INSERT INTO pedidos" + "(usuario_id, cliente_id, pagamento) VALUES (?, ?, ?);");
            //Setar os parâmetros
            novoPedido.setInt(1, pedido.getUsuario_id());
            novoPedido.setInt(2, pedido.getCliente_id());
            novoPedido.setString(3, pedido.getPagamento());

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

    public void pesquisarPedidos(){
        try {
            Connection condb = conexao.conectar();
            PreparedStatement buscarPedido = condb.prepareStatement("SELECT * " + "FROM pedidos where id = ?");
            buscarPedido.setInt(1,7);
            ResultSet resultSet = buscarPedido.executeQuery();

            while (resultSet.next()){
                Date data = resultSet.getDate("data");
                String pagamento = resultSet.getString("pagamento");
                System.out.println("data: " + data + "\npagamento: " + pagamento);
            }
            condb.close();
        } catch (Exception erro) {
            System.out.println("Erro ao pesquisar pedidos: " + erro);
        }
    }
}
