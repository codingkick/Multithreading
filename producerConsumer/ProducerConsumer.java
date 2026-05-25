package multithreading.producerConsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer {
    private int capacity;
    Queue<Integer> queue;
    ReentrantLock queueLock;
    Semaphore filled;
    Semaphore available;
    ProducerConsumer(int capacity){
        this.capacity = capacity;
        this.queue = new LinkedList<>();
        queueLock = new ReentrantLock();
        filled = new Semaphore(0);
        available = new Semaphore(capacity);
        
    } 

    public void addItem(Integer inp){
        try{
            available.acquire();
            queueLock.lock();
            queue.add(inp);
            queueLock.unlock();
            filled.release();
        }catch(Exception e){
            System.err.println("error");
        }

    }

        public void consumeItem(){
        try{
            filled.acquire();
            queueLock.lock();
            System.out.println("element is "+queue.peek() + "consumed by "+Thread.currentThread().getName());
            queue.poll();
            queueLock.unlock();
            available.release();
        }catch(Exception e){
            System.err.println("error");
        }

    }
}
