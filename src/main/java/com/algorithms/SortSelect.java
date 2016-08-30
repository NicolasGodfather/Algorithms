package com.algorithms;

/**
 *
 * @author Nicolas Asinovich.
 */
public class SortSelect {

    public static void selectionSort(int[] marks){
        for(int i=0;i<marks.length;i++)
        {
            int m=i;
            for(int j=i;j<marks.length;j++)
            {
                if(marks[m] < marks[j])
                    m = j;
            }
            int t;
            t = marks[m];
            marks[m] = marks[i];
            marks[i] = t;
        }
    }

    /*public static void bubbleSort(int[] arr){
        for(int i = arr.length-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
            if( arr[j] > arr[j+1] ){
                int tmp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = tmp;
            }
        }
    }*/
}
