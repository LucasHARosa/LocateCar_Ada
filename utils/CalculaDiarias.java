package utils;

import java.time.Duration;
import java.time.LocalDateTime;

public class CalculaDiarias {

    private CalculaDiarias() {
    }

    public static long execute(LocalDateTime dataInicial, LocalDateTime dataFinal) {
        Duration duracao = Duration.between(dataInicial, dataFinal);
        long dias = duracao.toHours() / 24;
        if(duracao.toHours() % 24 > 0) {
            dias++;
        }
        return dias;
    }
}
