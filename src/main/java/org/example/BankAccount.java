package org.example;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance = 100;
    private final Lock lock = new ReentrantLock();
    public  void withdraw(int amount){
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw " +
                amount);
        try{
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                if(balance >= amount){
                    System.out.println(Thread.currentThread().getName() + " proceeding to withdraw ");
                    try {
                        Thread.sleep(10000);
                        balance -= amount;
                        System.out.println("Transaction succeful : Balacne remaining = " + balance);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        lock.unlock();
                    }
                }
                else{
                    System.out.println(Thread.currentThread().getName() + " Insufficent funds " + balance);
                }
            }
            else{
                System.out.println(Thread.currentThread().getName() + " could not acquire the lock");
            }
        }catch (Exception e){
            Thread.currentThread().interrupt();
        }
    }
}
