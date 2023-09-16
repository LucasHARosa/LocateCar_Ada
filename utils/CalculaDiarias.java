package utils;

import java.time.Duration;
import java.time.LocalDateTime;

public class CalculaDiarias {

    private CalculaDiarias() {
    }

    public static double execute(LocalDateTime dataInicial, LocalDateTime dataFinal) {
        Duration duracao = Duration.between(dataInicial, dataFinal);
        long dias = duracao.toMinutes() / (24*60);
        System.out.println(dias);
        if(duracao.toMinutes() % (dias*24*60) > 0) {
            dias++;
        }
        return dias;
    }
}
