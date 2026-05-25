package multithreading.summation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        final int[] s1 = new int[]{0};
        final int[] s2 = new int[]{0};
        Thread t1 = new Thread(()->{
            for(int i=1;i<((n+1)/2);i++)
                s1[0] += i;
        });

        Thread t2 = new Thread(()->{
            for(int i=((n+1)/2);i<=n;i++)
                s2[0] += i;
        });

        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        }catch(Exception e){
            System.err.println("error occurred h");
        }
        
        System.out.println(s1[0]+s2[0]);

    }
}
