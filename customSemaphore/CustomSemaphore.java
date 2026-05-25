package multithreading.customsemaphore;

public class CustomSemaphore {
    private int count;
    CustomSemaphore(int count){
        this.count = count;
    }

    public synchronized void acquire(){
        while(count == 0){
            try{
                this.wait();
            }catch(Exception e){
                System.err.println("Error due to "+e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
        count--;
    }

    public synchronized void release(){
        count++;
        this.notify();
    }
}
