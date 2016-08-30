package com.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Realization class that receipt 2 numbers of rows and columns matrix,
 * further fill matrix and output sorted numbers in matrix.
 *
 * @author Nicolas Asinovich.
 */
public class SpiralPrint {

    private static int rows;
    private static int columns;
    private static int [][] matrixGlob = new int[rows][columns];

    public static void main(String[] args) {
        if (args.length == 0) {
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("Your parameters in the argument is empty. \nPlease input numbers of rows and columns: ");
                rows = scanner.nextInt();
                columns = scanner.nextInt();
                fillArray(rows, columns);
                getSpiralPrint(matrixGlob);
            }
        } else {
            rows = Integer.parseInt(args[0]);
            columns = Integer.parseInt(args[1]);
            fillArray(rows, columns);
            getSpiralPrint(matrixGlob);
        }
    }

    private static void fillArray(int m, int n) {
        matrixGlob = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrixGlob[i][j] = (int) (Math.random() * 9);
                System.out.print(matrixGlob[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("Your matrix is filled =)");
    }

    private static void getSpiralPrint(int [][] matrixLoc) {
        matrixGlob = matrixLoc;
        ArrayList<Integer> spiralList = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                spiralList.add(matrixGlob[i][j]);
            }
        }

        Collections.sort(spiralList);
        for (Integer number : spiralList) {
            System.out.print(number);
        }
    }
}
