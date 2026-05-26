package multithreading.diningPhilosopher;

public class Main {
    public static void main(String[] args) {
        DiningPhilosopher diningPhilosopher = new DiningPhilosopher(5);
        diningPhilosopher.start();
    }
}
