package kurs;

public class Main {

    public static void main(String[] args) {

        //1.
        invertArray();

        //2.
        fillArray();

        //3.
        changeArray();

        //4.
        fillDiagonal();

        //5.
        findMinMax();

        //6.
        System.out.println("6.");
        System.out.println(checkBalance(new int[]{2, 2, 2, 1, 2, 2, 10, 1}));
        System.out.println(checkBalance(new int[]{1, 1, 1, 2, 1}));
        System.out.println(checkBalance(new int[]{2, 2, 2, 3, 2, 2, 10, 1}));
        System.out.println(checkBalance(new int[]{1, 2, 1, 2, 1}));

        //7.
        System.out.println("7.");
        shiftArray(new int[]{1, 2, 3}, 1);
        shiftArray(new int[]{1, 2, 3}, 2);
        shiftArray(new int[]{3, 5, 6, 1}, -2);

    }

    //0. Пусть будет функция вывода массива целых в одну строку
    public static void outArray(String msg, int[] a) {
        System.out.print(msg + ": ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    //и для двумерных тоже пусть будет
    public static void outArray(String msg, int[][] a) {
        System.out.println(msg + ":");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    //1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например:
    //[ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия
    //заменить 0 на 1, 1 на 0
    public static void invertArray() {
        System.out.println("1.");
        int[] a = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        outArray("original", a);
        for (int i = 0; i < a.length; i++) {
            a[i] = 1 - a[i];
        }
        outArray("inverted", a);
    }

    //2.Задать пустой целочисленный массив размером 8. С помощью цикла
    //заполнить его значениями 0 3 6 9 12 15 18 21
    public static void fillArray() {
        System.out.println("2.");
        int[] a = new int[8];
        for (int i = 0; i < a.length; i++) {
            a[i] = i * 3;
        }
        outArray("filled", a);
    }

    //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти
    //по нему циклом, и числа меньшие 6 умножить на 2
    public static void changeArray() {
        System.out.println("3.");
        int[] a = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        outArray("original", a);
        for (int i = 0; i < a.length; i++) {
            if (a[i] >= 6) continue;
            a[i] *= 2;
        }
        outArray("changed", a);
    }

    //4. Создать квадратный двумерный целочисленный массив (количество строк
    //и столбцов одинаковое), и с помощью цикла(-ов) заполнить его
    //диагональные элементы единицами;
    public static void fillDiagonal() {
        System.out.println("4.");
        int[][] a = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 8, 7, 6}, {5, 4, 3, 2}};
        outArray("original", a);
        for (int i = 0; i < a.length; i++) {
            a[i][i] = 1;
            a[i][a.length - 1 - i] = 1;
        }
        outArray("changed", a);
    }

    //5. Задать одномерный массив и найти в нем минимальный и максимальный
    //элементы (без помощи интернета)
    public static void findMinMax() {
        System.out.println("5.");
        int[] a = {7, 5, 3, 2, 11, 4, 1, 2, 4, 8, 9, 6};
        outArray("array", a);
        System.out.println("min = " + minInArray(a));
        System.out.println("max = " + maxInArray(a));
    }
    public static int minInArray(int[] a) {
        int res = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] >= res) continue;
            res = a[i];
        }
        return res;
    }
    public static int maxInArray(int[] a) {
        int res = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] <= res) continue;
            res = a[i];
        }
        return res;
    }

    //6. Написать метод, в который передается не пустой одномерный целочисленный
    //массив, метод должен вернуть true, если в массиве есть место, в котором сумма
    //левой и правой части массива равны.
    //Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
    //checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||,
    //эти символы в массив не входят
    public static boolean checkBalance(int[] a) {
        outArray("array", a);
        for (int i = 1; i < a.length; i++) {
            if (leftSum(a, i) == rightSum(a, i)) return true;
        }
        return false;
    }
    public static int leftSum(int[] a, int to) {
        int sum = 0;
        for (int i = 0; i < to; i++) {
            sum += a[i];
        }
        return sum;
    }
    public static int rightSum(int[] a, int from) {
        int sum = 0;
        for (int i = from; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }

    //7. Написать метод, которому на вход подается одномерный массив и число n
    //(может быть положительным, или отрицательным), при этом метод должен сместить
    //все элементы массива на n позиций. Элементы смещаются циклично. Для усложнения
    //задачи нельзя пользоваться вспомогательными массивами. Примеры: [ 1, 2, 3 ]
    //при n = 1 (на один вправо) -> [ 3, 1, 2 ];
    //[ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
    //При каком n в какую сторону сдвиг можете выбирать сами
    public static void shiftArray(int[] a, int n) {
        outArray("original", a);
        if (n < 0) {
            for (int i = 0; i > n; i--) {
                int first = a[0];
                for (int j = 1; j < a.length; j++) {
                    a[j - 1] = a[j];
                }
                a[a.length - 1] = first;
            }
        } else {
            for (int i = 0; i < n; i++) {
                int last = a[a.length - 1];
                for (int j = a.length - 1; j > 0; j--) {
                    a[j] = a[j - 1];
                }
                a[0] = last;
            }
        }
        outArray("shifted, n = " + n, a);
    }

}
