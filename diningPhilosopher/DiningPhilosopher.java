package multithreading.diningPhilosopher;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class DiningPhilosopher {
    private int philosopher;
    Semaphore[] forks;





    DiningPhilosopher(int philosopher){
        this.philosopher = philosopher;
        this.forks = new Semaphore[philosopher];
        for(int i=0;i<philosopher;i++)
            forks[i] = new Semaphore(1);
    }

    private void think(String p){
        System.out.println(p +" thinking");
        try{
            Thread.sleep(2000);
        }catch(Exception e){
            System.err.println("error");
        }
    }
    private void eat(String p){
        System.out.println(p +" eating");
        try{
            Thread.sleep(2000);
        }catch(Exception e){
            System.err.println("error");
        }
    }

    public void start(){
        final List<Thread> threads = new ArrayList<>();
        threads.add(new Thread(()->{
                while (true) {
                    think("P0");
                    try{
                        forks[0].acquire();
                        forks[4].acquire();
                        eat("P0");
                    }catch(Exception e){
                        System.err.println("error");
                    }
                    forks[0].release();
                    forks[4].release();
                }
            }));
        threads.add(new Thread(()->{
            while(true){
                think("P1");
                try{
                    forks[0].acquire();
                    forks[1].acquire();
                    eat("P1");
                }catch(Exception e){
                    System.err.println("error");
                }
                forks[0].release();
                forks[1].release();
            }
        }));
        threads.add(new Thread(()->{
            while(true){
                think("P2");
                try{
                    forks[2].acquire();
                    forks[1].acquire();
                    eat("P2");
                }catch(Exception e){
                    System.err.println("error");
                }
                forks[2].release();
                forks[1].release();
            }
        }));
        threads.add(new Thread(()->{
            while(true){
                think("P3");
                try{
                    forks[2].acquire();
                    forks[3].acquire();
                    eat("P3");
                }catch(Exception e){
                    System.err.println("error");
                }
                forks[2].release();
                forks[3].release();
            }
        }));
        threads.add(new Thread(()->{
            while(true){
                think("P4");
                try{
                    forks[3].acquire();
                    forks[4].acquire();
                    eat("P4");
                }catch(Exception e){
                    System.err.println("error");
                }
                forks[3].release();
                forks[4].release();
            }
        }));
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        threads.forEach(thread -> executorService.submit(thread));

    }
}
