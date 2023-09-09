package model;

public class Cliente {
    private int id;
    private String nome;
    private String documento;

    public Cliente(String nome, String documento) {
        this.nome = nome;
        this.documento = documento;
    }

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getDocumento() {
        return documento;
    }
}
