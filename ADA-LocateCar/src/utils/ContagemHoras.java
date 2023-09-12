package utils;

import exceptions.ArgumentoInvalidoException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ContagemHoras {
    public static int contagemHoras(String dataInicial, String dataFinal, String horaAluguel, String horaDevolucao){
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoHorario = new SimpleDateFormat("HH:mm");

        try {
            Date dataHoraInicio = formatoData.parse(dataInicial + " " + horaAluguel);
            Date dataHoraFinal = formatoData.parse(dataFinal + " " + horaDevolucao);

            long diferenca = Math.abs(dataHoraFinal.getTime() - dataHoraInicio.getTime());
            long diferencaEmHoras = diferenca / (1000 * 60 * 60);

            return (int) diferencaEmHoras;
        } catch (Exception e) {
            throw new ArgumentoInvalidoException("Erro ao passar o formato da data!");
        }
    }
}
