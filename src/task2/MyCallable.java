package task2;

import java.util.Random;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    private static int count;

    @Override
    public String call() throws Exception {
        count++;
        StringBuilder sb = new StringBuilder();
        sb.append("Msg: ");
        sb.append(Math.random());
        return sb.toString();
    }

    public static int getCount() {
        return count;
    }
}
