package dao;

import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

    public void pesquisarReservas(){
        try {
            Connection condb = conexao.conectar();
            PreparedStatement buscarReservas = condb.prepareStatement("SELECT * " + "FROM reservas where id = ?");
            buscarReservas.setInt(1,4);
            ResultSet resultSet = buscarReservas.executeQuery();

            while (resultSet.next()){
                String fim = resultSet.getString("fim");
                String inicio = resultSet.getString("inicio");
                System.out.println("Fim: " + fim + "\ninicio: " + inicio);
            }
            condb.close();
        } catch (Exception erro) {
            System.out.println("Erro ao pesquisar reserva: " + erro);
        }
    }
}
