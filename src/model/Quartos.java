package model;

public class Quartos {
    private int id,qtd_cama_casal, qtd_cama_solteiro;
    private String nome;
    private String numero;
    private double preco;
    private boolean disponivel;

    public Quartos(String nome, String numero, int qtd_cama_casal, int qtd_cama_solteiro, double preco, boolean disponivel) {
        this.nome = nome;
        this.numero = numero;
        this.qtd_cama_casal = qtd_cama_casal;
        this.qtd_cama_solteiro = qtd_cama_solteiro;
        this.preco = preco;
        this.disponivel = disponivel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getQtd_cama_casal() {
        return qtd_cama_casal;
    }

    public void setQtd_cama_casal(int qtd_cama_casal) {
        this.qtd_cama_casal = qtd_cama_casal;
    }

    public int getQtd_cama_solteiro() {
        return qtd_cama_solteiro;
    }

    public void setQtd_cama_solteiro(int qtd_cama_solteiro) {
        this.qtd_cama_solteiro = qtd_cama_solteiro;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}