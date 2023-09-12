package repository;

import exceptions.ArgumentoInvalidoException;
import model.Aluguel;
import model.Cliente;
import model.Veiculo;

import java.util.HashMap;
import java.util.Map;

public class AluguelRepository {
    private Map<Integer, Aluguel> alugueis = new HashMap<>();
    private int ultimoId = 0;

    public Aluguel alugar(Aluguel aluguel) {
        ultimoId++;
        aluguel.setId(ultimoId);
        this.alugueis.put(ultimoId, aluguel);
        aluguel.getVeiculo().setDisponivel(false);
        return aluguel;
    }

    public Map<Integer, Aluguel> buscarLista() {
        return this.alugueis;
    }

    public Aluguel buscarPorClienteEVeiculo(Cliente cliente, Veiculo veiculo, String dataAluguel) {
        for (Aluguel aluguel:buscarLista().values()) {
            if (aluguel.getVeiculo().equals(veiculo) && aluguel.getCliente().equals(cliente) &&
            aluguel.getData().equals(dataAluguel)){
                return aluguel;
            }
        }
        return null;
    }

    public Aluguel devolver(Aluguel aluguel) {
        if(buscarPorClienteEVeiculo(aluguel.getCliente(), aluguel.getVeiculo(), aluguel.getData()) != null){
            alugueis.replace(aluguel.getId(), aluguel);
            aluguel.getVeiculo().setDisponivel(true);
            return aluguel;
        }
        throw new ArgumentoInvalidoException("Não foi possível realizar a devolução! Tente novamente mais tarde...");
    }
}
