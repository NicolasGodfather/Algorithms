package com.algorithms;

import java.util.Scanner;

/**
 * консольное приложение, которое:
 * a. получает на входе десятичное число
 * b. преобразует число в двоичный вид (написать собственный метод преобразования) и выводит результат
 * c. предусмотреть два варианта запуска - с вводом числа из консоли и в качестве параметра запуска
 */

public class DecimalToBinary {

    private static String temp;

    public static void main(String[] args) {

        int decimal;

        if (args.length == 0) {
            System.out.println("Please enter any decimal number: ");

            try (Scanner scanner = new Scanner(System.in);) {
                decimal = scanner.nextInt();
            }
        } else {
            decimal = Integer.parseInt(args[0]);
        }
        convertDecimalToBinary(decimal);
        outputResult(temp, decimal);
    }

    private static String convertDecimalToBinary(int number) {
        int quotient;
        temp = "";
        while (number != 0) {
            quotient = number % 2;
            temp = quotient + temp;
            number = number / 2;
        }
        return temp;
    }

    private static void outputResult(String temp, int number) {
        DecimalToBinary.temp = temp;
        System.out.println("Number '" + number + "' was converted to the binary number of: '" + DecimalToBinary.temp + "'");
    }
}
