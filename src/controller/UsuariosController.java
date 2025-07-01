package controller;

import dao.UsuariosDAO;
import model.Usuarios;

public class UsuariosController {
    private final UsuariosDAO usuariosDAO;

    /*Construtor para inicializar objeto UsuariosController(). Ao inicializá-lo, o construtor de
    UsuariosDAO9 será executado, significa que a camada de Controle estará verificando se os parâmetros
    necessários foram informados para que sejam enviados às requisições (package DAO)*/

    public UsuariosController() {
        this.usuariosDAO = new UsuariosDAO();
    }

    /*Metodo para verificar se os parãmetros necessários para autenticação estão presentes, ou seja,
    não podem ser vazios ou nulos; se estiverem presentes, um novo objeto de Usuario é inicializado*/

    public boolean verificarCredenciais(String email, String senha) {
        if (email == null || email.isEmpty() || senha == null || senha.isEmpty()) {
            return false;
        }
        Usuarios usuario = new Usuarios("", email, senha, 0);
        return usuariosDAO.autenticarUsuario(usuario);
    }
}