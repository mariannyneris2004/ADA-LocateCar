package model;

public class Cliente<T> {
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

    public void setNome(String novoNome) {
        this.nome = novoNome;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setId(int id) {
        this.id = id;
    }
}
