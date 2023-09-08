package service;

import model.Cliente;
import model.Veiculo;

class Aluguel {
    private Veiculo veiculo;
    private Cliente cliente;
    private String data;
    private int horasAlugadas;

    public Aluguel(Veiculo veiculo, Cliente cliente, String data, int horasAlugadas) {
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.data = data;
        this.horasAlugadas = horasAlugadas;
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
}