package model;

public class Aluguel {
    private int id;
    private Veiculo veiculo;
    private Cliente cliente;
    private String dataAluguel;
    private String dataDevolucao;
    private String horaAluguel;
    private String horaDevolucao;
    private String local;

    public Aluguel(Veiculo veiculo, Cliente cliente, String dataAluguel, String horaAluguel) {
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.dataAluguel = dataAluguel;
        this.horaAluguel = horaAluguel;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getData() {
        return dataAluguel;
    }

    public int getId() {
        return id;
    }

    public String getHoraAluguel() {
        return horaAluguel;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public void setHoraDevolucao(String horaDevolucao) {
        this.horaDevolucao = horaDevolucao;
    }

    public void setId(int id) {
        this.id = id;
    }
}