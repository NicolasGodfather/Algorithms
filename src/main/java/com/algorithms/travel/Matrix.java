package com.algorithms.travel;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * консольное приложение, которое:
 * a. получает на входе матрицу чисел M на N
 * b. удаляет все столбцы с минимальным числом
 * c. выводит результат на экран
 * d. ввод M, N - с консоли либо в качестве параметра, матрица - из консоли
 */

public class Matrix {

    private static int min = Integer.MAX_VALUE;;
    private static int m;
    private static int n;
    private static int[][] matrix = new int[m][n];
    private static Set<Integer> set;

    public static void main(String[] args) {
        if (args.length == 0) {
            try (Scanner scanner = new Scanner(System.in)) {
                m = scanner.nextInt();
                n = scanner.nextInt();
                fillArray(m, n);
                findMin(m, n);
                fillNewMatrix(m, n);
            }
        } else {
            m = Integer.parseInt(args[0]);
            n = Integer.parseInt(args[1]);
            fillArray(m, n);
            findMin(m, n);
            fillNewMatrix(m, n);
        }
    }

    private static void fillArray(int m, int n) {
        try (Scanner scanner = new Scanner(System.in);) {
            matrix = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
//                    matrix[i][j] = scanner.nextInt(); // это нужно для условия задачи, пока закоментим
                    matrix[i][j] = (int) (Math.random() * 9); // это чтобы вручную не вводить, for fast check
                    System.out.print(matrix[i][j] + "\t"); // for check
                }
                System.out.println();
            }
        }
    }

    private static int findMin(int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                }
            }
        }
        System.out.println("Min number = " + min);
        return min;
    }

    private static Set<Integer> fillList(int m, int n, int[][] matrix) {
        set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == min) {
                    set.add(j);
                }
            }
        }
        System.out.println("Count columns with minimum number = " + set.size()); // for check
        return set;
    }

    private static void fillNewMatrix(int m, int n) {
        fillList(m, n, matrix);
        int l = n - set.size();
        int[][] newMatrix = new int[m][l];

        for (int i = 0; i < m; i++) {
            int k = 0;
            for (int j = 0; j < n; j++) {
                if (set.contains(j)) {
                    continue;
                }
                newMatrix[i][k] = matrix[i][j];
                System.out.print(newMatrix[i][k] + "\t");
                k++;
            }
            System.out.println();
        }
    }
}
