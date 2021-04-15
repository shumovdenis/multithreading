package task3;

import java.util.concurrent.RecursiveTask;

public class ArraySumTask extends RecursiveTask<Integer> {
    private int[] array;
    private int start;
    private int end;


    public ArraySumTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int middle = Main.ARRAY_SIZE / 2;
        ArraySumTask task1 = new ArraySumTask(array, start, middle);
        ArraySumTask task2 = new ArraySumTask(array, middle + 1, end);
        invokeAll(task1, task2);
        return task1.join() + task2.join();
    }

}
