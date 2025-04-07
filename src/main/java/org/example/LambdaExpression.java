package org.example;

public class LambdaExpression {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("Hello");
        };
        Thread t1 = new Thread(runnable);
        t1.start();

        Student student = new Student() {
            @Override
            public void getBio(String name) {
                System.out.println( name + " is a engineering student");
            }
        };

        Student student1 = (name)->{
            System.out.println( name + " is lambda learner");
        };

        student.getBio("John");
        student1.getBio("Smith");
    }
}
