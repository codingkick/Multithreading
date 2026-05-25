package multithreading.producerConsumer;

public class Main {
    public static void main(String[] args) {
        ProducerConsumer producerConsumer = new ProducerConsumer(2);
        Thread producer = new Thread(()->{
            while (true) {
                for(int i=0;i<4;i++){
                    producerConsumer.addItem(i);
                }
                try{
                    Thread.sleep(2000);
                }catch(Exception e){
                    System.err.println("err");
                }
            }
        });

        Thread consumer1 = new Thread(()->{
            while (true) {
                producerConsumer.consumeItem();
                try{
                    Thread.sleep(5000);
                }catch(Exception e){
                    System.err.println("err");
                }
            }
        });

        Thread consumer2 = new Thread(()->{
            while (true) {
                producerConsumer.consumeItem();
                try{
                    Thread.sleep(1000);
                }catch(Exception e){
                    System.err.println("err");
                }
            }
        });

        producer.start();
        consumer1.start();
        consumer2.start();

    }
}
