package service.impl;

import utils.Input;

import java.util.Scanner;

public class MenuSeletor {
    private MenuSeletor() {
    }
    public static int execute() {
        System.out.println();
        System.out.println("----------Menu----------");
        System.out.println("0 - Sair.");
        System.out.println("1 - Cadastrar cliente.");
        System.out.println("2 - Cadastrar veículo.");
        System.out.println("3 - Alugar Veiculo.");
        System.out.println("4 - Listar clientes.");
        System.out.println("5 - Listar veículos.");
        System.out.println("6 - Listar alugueis.");
        System.out.println();

        return Input.lerInt("Opção desejada: ");
    }

    public static void tryAgain() {
        System.out.println("Opção inválida. Tente novamente.");
    }
}
