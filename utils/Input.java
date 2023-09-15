package utils;

import java.util.Scanner;

public class Input {
    private Input() {
    }

    public static String lerString(String mensagem) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(mensagem);
        String input = scanner.nextLine();
        return input;
    }

    public static int lerInt(String mensagem) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(mensagem);
        int input = scanner.nextInt();
        return input;
    }
}
