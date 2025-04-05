package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        World world = new World();
//        world.start();
//        for (; ; ) {
//            System.out.println("Hello ----- ");
//        }
//        SyncCounter counter = new SyncCounter();
//        ThreadSync t1 = new ThreadSync(counter);
//        ThreadSync t2 = new ThreadSync(counter);
//        t1.start();
//        t2.start();
//        try {
//            t1.join();
//            t2.join();
//        }catch (Exception e){
//
//        }
//        System.out.println(counter.getCount());

        BankAccount bankAccount= new BankAccount();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                bankAccount.withdraw(50);
            }
        };
        Thread t1 = new Thread(task,"thread 1");
        Thread t2 = new Thread(task, "thread 2");
        t1.start();
        t2.start();


    }
}