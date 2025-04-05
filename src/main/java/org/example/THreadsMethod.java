package org.example;

public class THreadsMethod extends  Thread{
    public THreadsMethod(String name){
        super(name);
    }
    @Override
    public void run() {
//        System.out.println("Thread is running");
//        for (int i = 1; i < 5; i++) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println(i);
//        }
        for(int i =0; i < 5; i++){
            System.out.println(Thread.currentThread().getName() + " Priority " + Thread.currentThread().getPriority() + " -count: " + i);
            try{
                Thread.sleep(100);
            }catch (Exception e){

            }
        }

    }

    public static void main(String[] args) {
        THreadsMethod t1 = new THreadsMethod("LowThread");
        THreadsMethod t2 = new THreadsMethod("NormalThread");
        THreadsMethod t3 = new THreadsMethod("HighThread");
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
    }
}
