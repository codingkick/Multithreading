package multithreading.customsemaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        CustomSemaphore customSemaphore = new CustomSemaphore(2);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(()->{
            customSemaphore.acquire();
            System.out.println("Work being done by "+Thread.currentThread().getName());
            try{
                Thread.sleep(2000);
            }catch(Exception e){
                System.err.println("err");
            }
            customSemaphore.release();
        });

        executorService.submit(()->{
            customSemaphore.acquire();
            System.out.println("Work being done by "+Thread.currentThread().getName());
            try{
                Thread.sleep(2000);
            }catch(Exception e){
                System.err.println("err");
            }
            customSemaphore.release();
        });

        executorService.shutdown();

    }
}
