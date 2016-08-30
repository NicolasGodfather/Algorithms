package com.algorithms.expertsoft;
import java.util.ArrayList;

/**
 Функция принимает два ArrayList одинакового размера [a1, a2, ..., an], [b1, b2, ..., bn].
 В результате выполнения функции в первом (!) ArrayList (в данном случае это А) должны содержаться элементы обоих ArrayList,
 которые чередуются последовательно, а именно [a1, b1, a2, b2, ..., an, bn]

 * @author Nikolay
 * Решая эту интересную задачку, стоит задуматься на сколько будет эффективным алгоритм решения.
 * Вот что у меня получилось:
 * 1 способ - простой и трудозатратный для памяти, но всё же он имеет место быть
 * 2 способ - намного лучше, т.к. избавились от создания временного объекта и сортировки методом 3 стаканов,
 *            вместо этого мы меняем значения командой set(), внутри которого командой get() получаем нужный нам элемент
 * 3 способ - логически сложнее, по эффективности чуть лучше чем второй, например команда addAll() быстрее добавит
 *            элементы 2-го списка в 1-ый, а далее принцип схож.
*/

public class Merge2List {

    static volatile ArrayList<String> A = new ArrayList<>();
    static volatile ArrayList<String> B = new ArrayList<>();

    public static void main(String[] args) {
        long startTimeList = System.nanoTime();
        mergeLists(A, B);
        double finishTime = System.nanoTime() - startTimeList;
        System.out.println("Первый алгоритм занял " + finishTime + " наносекунд процессорного времени");
        System.out.println();

        long startTimeList2 = System.nanoTime();
        mergeLists2(A, B);
        double finishTime2 = System.nanoTime() - startTimeList2;
        System.out.println("Второй алгоритм занял " + finishTime2 + " наносекунд процессорного времени");
        System.out.println();

        long startTimeList3 = System.nanoTime();
        mergeLists3(A, B);
        double finishTime3 = System.nanoTime() - startTimeList3;
        System.out.println("Третий алгоритм занял " + finishTime3 + " наносекунд процессорного времени");
        System.out.println();

        if (finishTime < finishTime2 && finishTime < finishTime3) {
            System.out.println("Быстреее оказался 1-ый алгоритм");
        } else if (finishTime2 < finishTime && finishTime2 < finishTime3) {
            System.out.println("Быстреее оказался 2-ой алгоритм");
        } else {
            System.out.println("Быстреее оказался 3-ий алгоритм");
        }
    }

    static ArrayList addA() {
        for (int i = 0; i < 10000; i++) {
            A.add("a" + (i+1));
        }
        return A;
    }
    static ArrayList addB() {
        for (int i = 0; i < 10000; i++) {
            B.add("b" + (i+1));
        }
        return B;
    }

    public static void mergeLists(ArrayList a, ArrayList b) {
        a = addA();
        b = addB();
        for (int i = 0; i < b.size(); i++) {
            a.add(b.get(i));
        }
        System.out.println(a);

        for (int i1 = 0, i2 = 0; i1 < a.size(); i1 += 2, i2++) {
            Object temp = a.get(a.size() / 2 + i2);
            a.remove(a.size() / 2 + i2);
            a.add(i1 + 1, temp);
        }
        System.out.println(a);
        a.clear();
        b.clear();
    }

    public static void mergeLists2(ArrayList a, ArrayList b) {
        a = addA();
        b = addB();
        for (int i = 0; i < b.size(); i++) {
            a.add(a.get(i));
        }
        System.out.println(a);

        for (int i1 = 0, i2 = 0; i1 < a.size(); i1 += 2, i2++) {
            a.set(i1, a.get(a.size() / 2 + i2));
            a.set(i1 + 1, b.get(i2));
        }
        System.out.println(a);
        a.clear();
        b.clear();
    }

    public static void mergeLists3(ArrayList a, ArrayList b) {
        a = addA();
        b = addB();
        a.addAll(b);
        System.out.println(a);
        for (int i = a.size() - 1; i > 0; i--) {
            int index = i / 2;
            if (i % 2 == 0) {
                a.set(i, a.get(index));
            } else {
                a.set(i, b.get(index));
            }
        }
        System.out.println(a);
        a.clear();
        b.clear();
    }
}





