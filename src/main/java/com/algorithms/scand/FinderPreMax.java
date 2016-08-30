package com.algorithms.scand;

/**
 *
 * @author Nicolas Asinovich.
 */
public class FinderPreMax {

    public static void main (String[] args) {
        int [] arr = {2,5,7,4,8,1,3,7,5};
        getPreMax(arr);
    }

    private static void getPreMax(int [] array) {
        int max = array[0];
        int preMax = array[1];
        for (int i = 0; i < array.length; i++) {
            if (max > array[i]) {
                preMax = max;
                max = array[i];
            }
        }
        System.out.println(preMax);
    }
}
