package task3;

import java.util.Date;
import java.util.concurrent.ForkJoinPool;

import static java.util.concurrent.ForkJoinTask.invokeAll;

public class Main {
    static final int ARRAY_SIZE = 1_000_000;
    static int numOfThreads = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        int[] array = new int[ARRAY_SIZE];

        fillArray(array);
        System.out.println(new Date());
        sumArray(array);
        System.out.println(new Date());
        System.out.println("||||||||||||||||||||||||||||||||||");

        ForkJoinPool pool = new ForkJoinPool(numOfThreads);

        System.out.println(new Date());
        System.out.println(pool.invoke(new ArraySumTask(array, 0, ARRAY_SIZE)));
        System.out.println(new Date());
    }

    public static void fillArray (int[] arr) {
        int MAX = 100;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * ++MAX);
        }
    }

    public static void sumArray (int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println(sum);
    }
}
