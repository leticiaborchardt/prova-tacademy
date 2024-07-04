package org.example.utilitarios;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public final class ValidadorInput {
    private static final Scanner scanner = new Scanner(System.in);

    public static String obterString(String mensagem) {
        System.out.println(mensagem);
        scanner.useDelimiter("\n");

        return scanner.next();
    }

    public static int obterInteiro(String mensagem) {
        System.out.println(mensagem);

        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Insira somente valores inteiros.");
                scanner.next();
            }
        }
    }

    public static LocalDateTime obterDataHora(String mensagem) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        while (true) {
            try {
                String entrada = obterString(mensagem);

                return LocalDateTime.parse(entrada, formatter);
            } catch (Exception e) {
                System.out.println("Formato inválido. Tente novamente.");
            }
        }
    }
}
