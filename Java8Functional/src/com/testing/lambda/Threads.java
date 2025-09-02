
package com.testing.lambda;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Modify var from int to AtomicInteger "static int var = 5;" ->  static AtomicInteger var = new AtomicInteger(5); and ask for the output. 
/*
class MultiThreadHandle {
    static int var = 5;
    public synchronized void test1() {
        var++;
        System.out.println("Inside Test1 Method : " + var);
        while (true) {
            try {
                Thread.sleep(Long.MAX_VALUE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static synchronized void test2() {
        var++;
        System.out.println("Inside Test2 Method : " + var);
        while (true) {
            try {
                Thread.sleep(Long.MAX_VALUE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Threads {
    public static void main(String args[]) {
        MultiThreadHandle obj =  new MultiThreadHandle();
        ExecutorService executor = Executors.newFixedThreadPool(10);

        Runnable runnableTask1 = () -> { obj.test1(); };
        Runnable runnableTask2 = () -> { obj.test2(); };

        executor.execute(runnableTask1);
        executor.execute(runnableTask2);
    }
} 
*/

/***

There is no gurarantee what value of var will be printed, because the  var  has been shared by multiple threads and there is no locking on it. The Output could be any of the below.

Inside Test1 Method : 6
Inside Test2 Method : 7
//or//
Inside Test1 Method : 7
Inside Test2 Method : 6
or
Inside Test1 Method : 7
Inside Test2 Method : 7
or
Inside Test2 Method : 6
Inside Test1 Method : 7
or
Inside Test2 Method : 7
Inside Test1 Method : 7
or
Inside Test2 Method : 6
Inside Test1 Method : 6

After Modify var from int to AtomicInteger the Output will be always
Inside Test1 Method : 7
Inside Test2 Method : 7


**/






/*
class MultiThreadHandle {
    public synchronized void test1() {
        System.out.println("Inside Test1 Method");
        while (true) {
            try {
                Thread.sleep(Long.MAX_VALUE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized void test2() {
        System.out.println("Inside Test2 Method");
        while (true) {
            try {
                Thread.sleep(Long.MAX_VALUE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Threads {
    public static void main(String args[]) {
        MultiThreadHandle obj =  new MultiThreadHandle();
        ExecutorService executor = Executors.newFixedThreadPool(10);

        Runnable runnableTask1 = () -> { obj.test1(); };
        Runnable runnableTask2 = () -> { obj.test2(); };

        executor.execute(runnableTask1);
        executor.execute(runnableTask2);
    }
} 
*/
/**
 * 
 It Can Either Print "Inside Test1 Method" or "Inside Test2 Method" based on which thread aquires the lock first. Both Thread can't access simultaneously as the synchronized method is a non static method and it aquires the object level lock.
 */

/*

class RunnableTask1 implements Runnable {
    private String resource1, resource2;

    public RunnableTask1(String resource1, String resource2) {
        this.resource1 = resource1;
        this.resource2 = resource2;
    }

    @Override
    public void run() {
        synchronized (resource1) {
            System.out.println("Task 1: Printing : " + resource1);

            try { Thread.sleep(100);} catch (Exception e) {}

            synchronized (resource2) {
                System.out.println("Task 1: Printing : " + resource2);
            }
        }
    }
}
class RunnableTask2 implements Runnable {
    private String resource1, resource2;

    public RunnableTask2(String resource1, String resource2) {
        this.resource1 = resource1;
        this.resource2 = resource2;
    }

    @Override
    public void run() {
        synchronized (resource2) {
            System.out.println("Task 2: Printing : " + resource2);

            try { Thread.sleep(100);} catch (Exception e) {}

            synchronized (resource1) {
                System.out.println("Task 2: Printing : " + resource1);
            }
        }
    }
}

public class Threads {
    public static void main(String[] args) {
        final String resource1 = "Test1";
        final String resource2 = "Test2";

        Thread t1 = new Thread(new RunnableTask1(resource1, resource2));
        Thread t2 = new Thread(new RunnableTask2(resource1, resource2));

        t1.start();
        t2.start();
    }
} 






/**
It will always printeither one of the combination. Both the thread won't move further as the will be waiting on each other and will go into deadlock situation.
-------------
Task 1: Printing : Test1
Task 2: Printing : Test2
///////or/////////
Task 2: Printing : Test2
Task 1: Printing : Test1
----------------
 */

class Resource {
    public synchronized void test1() {
        System.out.println("Inside Test1 Method");
        try {
            Thread.sleep(Long.MAX_VALUE);;

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static synchronized void test2() {
        System.out.println("Inside Test2 Method");
        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Task1 implements Runnable {
    private Resource resource;

    public Task1(Resource resource) { this.resource = resource; }

    @Override
    public void run() {
        resource.test1();
        resource.test2();
        System.out.println("Invoked Test2 Method from Task1");
    }
}

class Task2 implements Runnable {
    private Resource resource;

    public Task2(Resource resource) { this.resource = resource; }

    @Override
    public void run() {
        resource.test2();
        resource.test1();
        System.out.println("Invoked Test1 Method from Task2");
    }
}

public class Threads {
    public static void main(String[] args) {
        Resource resource =  new Resource();
        ExecutorService executor = Executors.newFixedThreadPool(10);

        Thread t1 = new Thread(new Task1(resource));
        Thread t2 = new Thread(new Task2(resource));
        t1.start();
        t2.start();
    }
} //t will always printeither one of the combination. 
//Inside Test1 Method
//Inside Test2 Method
//Despite each thread aquire different lock one on Object another one on Class, both the thread won't move further as they will be waiting on each other and will go into deadlock situation.
//Because you’re mixing two different locks (this and Resource.class) and acquiring them in different orders in different threads:
//Task1: object → class
//Task2: class → object
//This is the recipe for deadlock.