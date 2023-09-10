package utils;

import exceptions.ArgumentoInvalidoException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EntradaDeDados {
    public static int getInt() {
        try {
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            return input;
        } catch (InputMismatchException e){
            throw new ArgumentoInvalidoException("Operação inválida!");
        }
    }

    public static String getString() {
        try {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            return input;
        } catch (InputMismatchException e){
            throw new ArgumentoInvalidoException("Operação inválida!");
        }
    }

    public static double getDouble() {
        try {
            Scanner scanner = new Scanner(System.in);
            double input = scanner.nextDouble();
            return input;
        } catch (InputMismatchException e){
            throw new ArgumentoInvalidoException("Operação inválida!");
        }
    }
}
