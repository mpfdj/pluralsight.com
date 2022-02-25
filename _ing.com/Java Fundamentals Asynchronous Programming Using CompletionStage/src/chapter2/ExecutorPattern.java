package chapter2;

import java.util.concurrent.*;

public class ExecutorPattern {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newSingleThreadExecutor();

        Runnable task = () -> {
            System.out.println("Hello I'm a Task and I'm sleeping for 3 seconds...");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Future future = service.submit(task);

        future.get();  // block until the task is done

//        future.cancel(true);

        System.out.println("Main");


    }
}
