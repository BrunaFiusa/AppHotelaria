package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ReservasDAO {
    //Objeto para instanciar classe Conexao paea requisitar acesso ao DB
    private Conexao conexao = new Conexao();

    public boolean deletarReservas() {
        try {
            Connection condb = conexao.conectar();
            PreparedStatement deletarReserva = condb.prepareStatement("DELETE FROM reservas WHERE id = ?;");
            //Setar os parâmetros
            deletarReserva.setInt(1, 3);

            int linhaAfetada = deletarReserva.executeUpdate();
            condb.close();
            return linhaAfetada > 0;
        } catch (Exception erro) {
            System.out.println("Erro ao deletar reserva: " + erro);
            return false;
        }
    }
}
