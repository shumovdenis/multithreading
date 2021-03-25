package task1;

public class Main {
    public static void main(String[] args) {
        ThreadGroup group = new ThreadGroup("group");

        Thread thread1 = new MyThread("1", group);
        Thread thread2 = new MyThread("2", group);
        Thread thread3 = new MyThread("3", group);
        Thread thread4 = new MyThread("4", group);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            Thread.sleep(15000);
            group.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();        }


    }
}
