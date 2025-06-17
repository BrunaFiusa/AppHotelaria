package model;

public class Usuarios extends Pessoas {
    private int id;
    private String senha;
    private int role_id;

    public Usuarios(String nome, String email, String senha, int cargo_id) {
        super(nome, email);
        this.senha = senha;
        this.role_id = cargo_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }
}