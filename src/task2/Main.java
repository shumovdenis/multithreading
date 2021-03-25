package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        final ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<Future<String>> tasks = new ArrayList<>();
        List<Callable<String>> listStringCallable = new ArrayList<>();

        Thread thread1 = new MyThread("1");
        Thread thread2 = new MyThread("2");
        Thread thread3 = new MyThread("3");
        Thread thread4 = new MyThread("4");

        for (int i = 0; i < 10; i++) {
            Callable<String> myCallable = new MyCallable();
            listStringCallable.add(myCallable);
            Future<String> task = service.submit(myCallable);
            tasks.add(task);
            Thread.sleep(1500);
        }

        for (Future<String> el : tasks) {
            try {
                System.out.println(el.get());
                Thread.sleep(100);
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(MyCallable.getCount());
        System.out.println(service.invokeAny(listStringCallable));

        service.shutdown();

        System.out.println();





    }
}
