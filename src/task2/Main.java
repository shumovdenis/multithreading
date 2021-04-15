package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final ExecutorService es = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<Future<Integer>> tasks = new ArrayList<>();
        List<Callable<Integer>> listIntegerCallable = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Callable<Integer> myCallable = new MyCallable(String.valueOf(i));
            listIntegerCallable.add(myCallable);
            Future<Integer> task = es.submit(myCallable);
            tasks.add(task);
            Thread.sleep(1500);
        }

        for (int i = 0; i < tasks.size(); i++) {
            Future<Integer> el = tasks.get(i);
            System.out.println(el.get());
        }

        es.shutdown();
    }
}
