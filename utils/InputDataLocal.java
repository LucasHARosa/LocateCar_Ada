package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class InputDataLocal {
    private InputDataLocal() {
    }

    public static LocalDateTime lerDataHora(String mensagem) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        try{
            LocalDateTime dataEntrada = LocalDateTime.parse(Input.lerString(mensagem), formatter);
            return dataEntrada;
        } catch (Exception e){
            System.out.println("Data inválida.");
            return lerDataHora(mensagem);
        }
    }
}
