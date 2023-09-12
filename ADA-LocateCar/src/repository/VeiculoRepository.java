package repository;

import model.Veiculo;

import java.util.HashMap;
import java.util.Map;

public class VeiculoRepository {
    private Map<String, Veiculo> veiculos = new HashMap<>();

    public Veiculo cadastrar(Veiculo veiculo) {
        this.veiculos.put(veiculo.getPlaca(), veiculo);
        return veiculo;
    }

    public Veiculo alterar(Veiculo veiculo) {
        if(buscar(veiculo.getPlaca()) != null){
            veiculos.replace(veiculo.getPlaca(), veiculo);
        }
        return null;
    }

    public Map<String, Veiculo> buscarLista() {
        return this.veiculos;
    }

    public Veiculo buscar(String placa) {
        if(veiculos.get(placa) != null){
            return veiculos.get(placa);
        }
        return null;
    }
}
