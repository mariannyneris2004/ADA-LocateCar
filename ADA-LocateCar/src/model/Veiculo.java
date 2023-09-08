package model;

public class Veiculo {
    private String placa;
    private String nome;
    private String tipo;
    private boolean disponivel = true;

    public Veiculo(String var1, String var2, String var3) {
        this.placa = var1;
        this.nome = var2;
        this.tipo = var3;
    }

    public String getPlaca() {
        return this.placa;
    }

    public String getNome() {
        return this.nome;
    }

    public String getTipo() {
        return this.tipo;
    }

    public boolean isDisponivel() {
        return this.disponivel;
    }

    public void setDisponivel(boolean var1) {
        this.disponivel = var1;
    }
}
