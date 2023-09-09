package model;

public class Aluguel {
    private Veiculo veiculo;
    private Cliente cliente;
    private String data;
    private int horasAlugadas;
    private String local;

    public Aluguel(Veiculo veiculo, Cliente cliente, String data, int horasAlugadas, String local) {
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.data = data;
        this.horasAlugadas = horasAlugadas;
        this.local = local;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getData() {
        return data;
    }

    public int getHorasAlugadas() {
        return horasAlugadas;
    }

    public String getLocal() {
        return local;
    }
}