package com.algorithms;

import java.util.Random;

/**
 * Realization algorithm quick sort
 *
 * @author Nicolas Asinovich.
 */
public class QuickSort {

    public static int ARRAY_LENGTH = 10000;
    private static byte[] array = new byte[ARRAY_LENGTH];
    private static Random generator = new Random();
    private static int counter = 0;

    public static void init () {
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            array[i] = (byte) generator.nextInt(255);
        }
    }

    public static void printArray () {
        for (int i = 0; i < ARRAY_LENGTH - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[ARRAY_LENGTH - 1]);
    }

    public static void sort () {
        int first = 0;
        int last = ARRAY_LENGTH - 1;
        quickSorting(first, last);
    }

    private static void swap (int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = (byte) temp;
    }

    private static void quickSorting (int start, int end) {
        if (start >= end)
            return;
        int i = start, j = end;
        int mid = (i + j) / 2;
        while (i < j) {
            while ((i < mid) && (array[i] <= array[mid])) i++;
            while ((j > mid) && (array[mid] <= array[j])) j--;
            if (i < j) {
                swap(i, j);
                if (i == mid)
                    mid = j;
                else if (j == mid)
                    mid = i;
            }
        }
        counter++;
        quickSorting(start, mid);
        quickSorting(mid + 1, end);
    }

    public static void main (String[] args) {
        init();
        printArray();
        sort();
        printArray();
        System.out.println(counter);
    }
}
