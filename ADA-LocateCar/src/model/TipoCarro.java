package model;

public enum TipoCarro {
    PEQUENO("Pequeno"),
    MEDIO("Médio"),
    SUV("SUV");

    private String tipo;

    TipoCarro(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
