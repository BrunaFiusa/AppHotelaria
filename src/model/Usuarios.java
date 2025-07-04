package model;

public class Usuarios extends Pessoas {
    private int id;
    private String senha;
    private int cargo_id;

    public Usuarios(String nome, String email, String senha, int cargo_id) {
        super(nome, email);
        this.senha = senha;
        this.cargo_id = cargo_id;
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

    public int getCargo_id() {
        return cargo_id;
    }

    public void setCargo_id(int cargo_id) {
        this.cargo_id = cargo_id;
    }
}