package com.algorithms;

/**
 * Realization
 *
 * @author Nicolas Asinovich.
 */
public class ByteArraySorter {
    private static final int BYTE_MODEL_SIZE = 256;
    private static final int BYTE_MASK = 0xFF;
    private static final int BYTE_SIGNED_MIN_VALUE = -128;
    private static final int BYTE_SIGNED_MAX_VALUE = 127;
    private static final int BYTE_UNSIGNED_MIN_VALUE = 0;
    private static final int BYTE_UNSIGNED_MAX_VALUE = 255;

    public static void sort(byte[] buffer) {
        sort(buffer, BYTE_SIGNED_MIN_VALUE, BYTE_SIGNED_MAX_VALUE);
    }

    public static void sortUnsigned(byte[] buffer) {
        sort(buffer, BYTE_UNSIGNED_MIN_VALUE, BYTE_UNSIGNED_MAX_VALUE);
    }

    private static void sort(byte[] buffer, int fromValue, int toValue) {
        if (buffer == null) { return; }

        int length = buffer.length;
        if (length == 0) { return; }

        int[] model = new int[BYTE_MODEL_SIZE];

        for (int i = 0; i < length; i++) {
            model[buffer[i] & BYTE_MASK]++;
        }

        int index = 0;

        for (int i = fromValue; i <= toValue; i++) {
            int toIndex = index + model[i & BYTE_MASK];

            while (index < toIndex) {
                buffer[index] = (byte)i;
                index++;
            }
        }
    }

   /* public void sort_low_radix(int a[])
    {
        int cnt[][] = new int[4][];
        int b[];
        int i, j;
        int a_len = a.length;

        if (a_len < 2) {
            // массив длиной 1 элемент не нужно сортировать :)
            return;
        }

        // инициализируем счетчик [cnt]
        for (j = 0; j < 4; j++) {
            cnt[j] = new int[257];
            for (i = 0; i < 257; i++) cnt[j][i] = 0;
        }

        // выделяем память под копию сортируемого массива
        b = new int[a_len];

        // подсчитываем количество элементов для каждого значения j-го разряда
        for (i = 0; i < a_len; i++) {
            for (j = 0; j < 4; j++) {
                cnt[j][1 + ((a[i] >>> (8 * j)) & 0xff)]++;
            }
        }

        for (j = 0; j < 4; j++) {
//                вычисляем позиции cnt[i], начиная с которых будут располаться элементы
//                с соответствующим значением j-го разряда
            for (i = 1; i < 256; i++) cnt[j][i] += cnt[j][i - 1];
            // расставляем элементы из массива a в массив b в указанном порядке
            for (i = 0; i < a_len; i++) {
                b[cnt[j][(a[i] >>> (8 * j)) & 0xff]++] = a[i];
            }
            // копируем массив b на место массива a
            for (i = 0; i < a_len; i++) a[i] = b[i];
        }
    }*/
}