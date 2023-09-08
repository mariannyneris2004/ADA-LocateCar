package model;

public class Cliente {
    private String id;
    private String nome;

    public Cliente(String var1, String var2) {
        this.id = var1;
        this.nome = var2;
    }

    public String getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }
}
