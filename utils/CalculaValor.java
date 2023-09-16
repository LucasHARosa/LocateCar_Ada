package utils;

import model.Documento;
import model.Valor;

public class CalculaValor {

        private CalculaValor() {
        }

        public static Valor execute(double dias, String tipoVeiculo, Documento documento) {
            double valorDiaria = valorDiaria(tipoVeiculo);
            double valorTotal = valorDiaria * dias;
            if (documento.getTipo().getDescricao().equals("CNPJ")) {
                if(dias>3){
                    double valorDesconto = valorTotal * 0.1;
                    return new Valor(valorTotal, valorDesconto, valorTotal - valorDesconto);
                }
            }
            else{
                if(dias>5){
                    double valorDesconto = valorTotal * 0.05;
                    return new Valor(valorTotal, valorDesconto, valorTotal - valorDesconto);
                }
            }
            return new Valor(valorTotal, 0, valorTotal);
        }

        private static double valorDiaria(String tipoVeiculo){
            switch (tipoVeiculo){
                case "SUV":
                    return 200;
                case "SEDAN":
                    return 150;
                case "PICKUP":
                    return 200;
                case "HATCH":
                    return 100;
                default:
                    return 0;
            }
        }
}
