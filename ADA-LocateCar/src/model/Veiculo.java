package model;

public class Veiculo {
    private String placa;
    private String marca;
    private String modelo;
    private TipoCarro tipo;
    private boolean disponivel = true;

    public Veiculo(String placa, String marca, String modelo, TipoCarro tipo) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.tipo = tipo;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public TipoCarro getTipo() {
        return tipo;
    }

    public boolean isDisponivel() {
        return this.disponivel;
    }

    public void setDisponivel(boolean var1) {
        this.disponivel = var1;
    }
}
