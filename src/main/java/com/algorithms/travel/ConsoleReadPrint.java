package com.algorithms.travel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * консольное приложение, которое:
 * a. получает на входе строку (латинские буквы и пробелы)
 * b. выводит на экран: i. количество слов в строке (слово - буква/буквы, разделенные пробелами)
 *                      ii. максимальную длину слова
 *                      iii. минимальную длину слова
 * c. предусмотреть два варианта запуска - с вводом строки из консоли и в качестве параметра запуска
 */

public class ConsoleReadPrint {

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Enter any line: ");
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {
                String line = reader.readLine();
                String[] allWords = line.split(" ");
                printResult(allWords);
            }
        } else {
            printResult(args);
        }
    }

    private static void printResult(String[] allWords) {
        int wordNumber = getNumberOfWords(allWords);
        System.out.println("Number of words in line: " + wordNumber);

        int maxLengthWord = getMaxLengthOfWords(allWords);
        System.out.println("Max length of words in line = : " + maxLengthWord);

        int minLengthWord = getMinLengthOfWords(allWords);
        System.out.println("Min length of words in line = : " + minLengthWord);
    }

    private static int getNumberOfWords(String[] allWords) {
        return allWords.length;
    }

    private static int getMinLengthOfWords(String[] allWords) {
        int minLengthWord = allWords[0].length();
        for (String word : allWords) {
            if (word.length() < minLengthWord) {
                minLengthWord = word.length();
            }
        }
        return minLengthWord;
    }

    private static int getMaxLengthOfWords(String[] allWords) {
        int maxLengthWord = 0;
        for (String word : allWords) {
            if (word.length() > maxLengthWord) {
                maxLengthWord = word.length();
            }
        }
        return maxLengthWord;
    }
}
