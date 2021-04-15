package task2;

import java.util.Random;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    public String threadName;

    public MyCallable(String threadName) {
        this.threadName = threadName;
    }

    public String getThreadName() {
        return threadName;
    }

    @Override
    public Integer call() {
        Random rnd = new Random();
        int countMsg = 0;
        try {
            for (int i = 0; i < rnd.nextInt(3); i++) {
                System.out.printf("Я поток номер %s\n", threadName);
                countMsg++;
                Thread.sleep(2000);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        return countMsg;
    }
}
