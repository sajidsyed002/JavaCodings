package com.testing.lambda;

import java.util.*;
import java.util.Comparator;
import java.util.HashSet;
import java.util.NavigableSet;
import java.util.PriorityQueue;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


class Parent {
    Parent (String s){
        System.out.println("Parent Class Param  "+s);
    }
}

public class Testing2 extends Parent {

	Testing2 (){
		super("n");
        System.out.println("Child Class Default Constructor");
    }

	Testing2 (String s){
		super("n");
        System.out.println("Child Class Param Constructor "+s);
    }

    public static void main(String[] args) {
    	Testing2 obj = new Testing2();
    }

}
/*
class Parent {
    
    static void staticMethod() {
        System.out.println("Static method in Parent");
    }
}


class Child extends Parent {
    static void staticMethod() {
        System.out.println("Static method in Child");
    }
}


public class Testing2 {
    public static void main(String[] args) {
        Parent.staticMethod();
        Child.staticMethod();
        Parent parent = new Child();
        parent.staticMethod();
    }
}*/
/*
import java.util.Set;
import java.util.TreeSet;

public class Testing2 {
    public static void main(String[] args) {
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("Indian");
        treeSet.add("Premier");
        treeSet.add("League");
        treeSet.add("Premier");
        treeSet.add("IndianPremierLeague");
        for (String temp : treeSet)
            System.out.println(temp + " ");
    }
} */
/*
class Movie implements Comparable<Movie>
{
    private double rating;
    private String name;
    private int year;

    public int compareTo(Movie m) { return this.year - m.year; }

    public Movie(String name, double rating, int year)
    {
        this.name = name;
        this.rating = rating;
        this.year = year;
    }

    public double getRating() { return rating; }
    public String getName() {  return name; }
    public int getYear() {  return year; }
}

public class Testing2
{
    public static void main(String[] args)
    {
        NavigableSet<Movie> movieList = new TreeSet<Movie>();
        movieList.add(new Movie("Bahubali", 8.3, 2015));
        movieList.add(new Movie("Janbar", 8.7, 1977));
        movieList.add(new Movie("Mr.India", 8.8, 1980));
        movieList.add(new Movie("Amar Akbar Anthony", 8.4, 1983));
Collections.sort(movieList, new Comparator<Movie>()){
	public int compare( Movie m1, Movie m2) {
		return m1.getName()-m2.getRating();
	}
};
        System.out.println("Movies after sorting: ");
        for (Movie movie: movieList)
        {
            System.out.println(movie.getName() + " " +
                    movie.getRating() + " " +
                    movie.getYear());
        }
    }
} 
/*
public class Testing2
{
    public static void main(String[] args)
    {
        String str1 = new String("Java");

        String str2 = new String("Java");

        String str3 = "Java";

        String str4 = "Java";

        System.out.println(str1 == str2);
		System.out.println(str3 == str4);
        System.out.println(str1 == str3);
    }
} */


/*
abstract class A
{
    protected abstract void firstMethod();

    public void secondMethod()
    {
        System.out.println("SECOND");

        firstMethod();
    }
}
abstract class B extends A
{
    @Override
    void firstMethod()
    {
        System.out.println("FIRST");

        thirdMethod();
    }

     abstract void thirdMethod();
}

class C extends B
{
    @Override
    void thirdMethod()
    {
        System.out.println("THIRD");
    }
}

public class Testing2
{
    public static void main(String[] args)
    {
        C c = new C();

        c.firstMethod();

        c.secondMethod();

        c.thirdMethod();
    }
} 
*/


/*
import java.util.Set;
import java.util.TreeSet;
/*
public class Testing2 {
    public static void main(String[] args) {
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("Indian");
        treeSet.add("Premier");
        treeSet.add("League");
        treeSet.add("Premier");
        treeSet.add("IndianPremierLeague");
        for (String temp : treeSet)
            System.out.println(temp + " ");
    }
}*/
/*
public class Testing2 {
    public static void main(String args[]) {
        PriorityQueue<String> queue = new PriorityQueue<String>();
        System.out.println("add Operation in Queue: " + queue.add("Kumar"));
        System.out.println("add Operation in Queue: " + queue.add("Hitesh"));
        System.out.println("Elements in Queue: " + queue);

        System.out.println("element Operation in Queue: " + queue.element());
        System.out.println("Elements in Queue: " + queue);

        System.out.println("peek Operation in Queue: " + queue.peek());
        System.out.println("Elements in Queue: " + queue);

        System.out.println("offer Operation in Queue: " + queue.offer("Manoj"));
        System.out.println("Elements in Queue: " + queue);

        System.out.println("remove Operation in Queue: " + queue.remove());
        System.out.println("Elements in Queue: " + queue);

        System.out.println("poll Operation in Queue: " + queue.poll());
        System.out.println("Elements in Queue: " + queue);
    }
} */
/*
class Parent {

    Parent (){
        this("Constructor");
        System.out.println("Parent class Default Constructor");
    }

    Parent (String s){
        System.out.println("Parent Class Param  "+s);
    }
}

public class Testing2 extends Parent {

	Testing2 (){
        super("Constructor");
        System.out.println("Child Class Default Constructor");
    }

	Testing2 (String s){
        System.out.println("Child Class Param Constructor "+s);
    }

    public static void main(String[] args) {
    	Testing2 obj = new Testing2();
    }

} 
*/
/*
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

public class Testing2 {
    public static void main(String[] args) {
        Resource resource =  new Resource();
        ExecutorService executor = Executors.newFixedThreadPool(10);

        Thread t1 = new Thread(new Task1(resource));
        Thread t2 = new Thread(new Task2(resource));
        t1.start();
        t2.start();
    }
} *//*
public class Testing2 {

    public static void main(String[] args) {
        int[][] trainTimings = new int[][]{{600,700},{630,820},{1200,1500}};
        int minPlatformsRequired = calculateMinPlatforms(trainTimings);
        System.out.println(minPlatformsRequired);
    }

    static int calculateMinPlatforms(int[][] trainTimings){
    	System.out.println(Arrays.deepToString(trainTimings));
        Arrays.sort(trainTimings, (a,b)->a[0] == b[0] ? a[1] - b[1] : a[0]-b[0]);
        System.out.println(Arrays.deepToString(trainTimings));
        PriorityQueue<int[]> priorityDepartures = new PriorityQueue<>((a, b)->(a[1]-b[1]));
        System.out.println(priorityDepartures);
        int currentCountOfTrainsAtStation = 0;
        int maxCountOfTrainsAtStation = 0;
        for(int[] trainTime : trainTimings){
            while(priorityDepartures.isEmpty() == false && priorityDepartures.peek()[1] <= trainTime[0]){
                priorityDepartures.poll();
            }
            priorityDepartures.add(trainTime);
            currentCountOfTrainsAtStation = priorityDepartures.size();
            maxCountOfTrainsAtStation = Math.max(maxCountOfTrainsAtStation, currentCountOfTrainsAtStation);
        }
        return maxCountOfTrainsAtStation;
    }
}
/*
class SuperClass
{
    void anyMethod() throws CarException
    {
        System.out.println("Super Class Method");
    }
}
public class Testing2 extends SuperClass
{
    @Override
    void anyMethod() throws VehicleException
    {
        System.out.println("Sub CLass Method");
    }

    public static void main(String[] args) {
    	Testing2 testException = new Testing2();
        try
        {
            testException.anyMethod();
            System.out.println("Inside Try");
            return;
        }
        catch (Exception e)
        {
            System.out.println("Inside Catch");
            return;
        }
        finally
        {
            System.out.println("Inside Finaly");
        }
    }
}

class VehicleException extends Exception {
    public VehicleException (String str)
    {
        System.out.println("Thrown Vehicle Exception For : "+str);
    }
}

class CarException extends VehicleException {
    public CarException (String str)
    {
        System.out.println("Thrown Car Exception For : "+str);
    }
} */
/*
public class Testing2 {
    public static void main(String[] args)
    {
    	List<Integer> al = new ArrayList<>();
        //List<Integer> al = new CopyOnWriteArrayList<>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);

        System.out.println(al);

        Iterator<Integer> itr = al.iterator();
       
        while (itr.hasNext()) {
            if (itr.next() == 3) {
                al.remove(3);
            	//itr.remove();
            }
        }

        System.out.println(al);
    }
} */
/*
abstract class A
{
    protected abstract void firstMethod();

    public void secondMethod()
    {
        System.out.println("SECOND");

        firstMethod();
    }
}
abstract class B extends A
{
    @Override
    protected void firstMethod()
    {
        System.out.println("FIRST");

        thirdMethod();
    }

     abstract void thirdMethod();
}

class C extends B
{
    @Override
    void thirdMethod()
    {
        System.out.println("THIRD");
    }
}

public class Testing2
{
    public static void main(String[] args)
    {
        C c = new C();

        c.firstMethod();

        c.secondMethod();

        c.thirdMethod();
    }
} */
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

public class Testing2 {
    public static void main(String[] args) {
        final String resource1 = "Test1";
        final String resource2 = "Test2";

        Thread t1 = new Thread(new RunnableTask1(resource1, resource2));
        Thread t2 = new Thread(new RunnableTask2(resource1, resource2));

       // t1.start();
        t2.start();
    }
} */
/*
class Parent1 {
    static int x=10;
    static void staticMethod() {
        x++;
        System.out.println("Value of X in Parent : " + x);
    }
}

class Child1 extends Parent1 {
    static void staticMethod() {
        x++;
        System.out.println("Value of X in Child : " + x);
    }
}

public class Testing2 {
    public static void main(String[] args) {
        Parent1.staticMethod();
        Child1.staticMethod();
        Parent1 parent = new Child1();
        parent.staticMethod();
    }
} 
//Explanation: 
//Both Parent and Child classes have a static method named staticMethod.
//Static methods are resolved at compile-time, not runtime (unlike instance methods).
//Static variables are declared in stack memory and created only once for a class
*/
/*
class VehicleException extends Exception {
    public VehicleException (String str)
    {
        System.out.println("Thrown Vehicle Exception For : "+str);
    }
}

class CarException extends VehicleException {
    public CarException (String str)
    {
        super(str);
        System.out.println("Thrown Car Exception For : "+str);
    }
}

class HatchbackException extends CarException {
    public HatchbackException ()
    {
        super("Hatchback");
    }
}

class SUVException extends CarException {
    public SUVException ()
    {
        super("SUV");
    }
}

public class Testing2
{
    public void testCar() throws VehicleException {
        testHatchback();
        testSUV();
    }

    public void testHatchback() throws VehicleException {
        throw new VehicleException("Hatchback");
    }

    public void testSUV() throws SUVException {
        throw new SUVException();
    }

    public static void main(String[] args) throws VehicleException{
    	Testing2 testException = new Testing2();
        testException.testCar();
    }
} 
/*
import java.util.*;
public class Testing2
{
	public static void main(String[] args) {
	    int[][] input = new int[][]
	       { {1,    2,   3,  4,    5},
             {6,    7,   8,  9,   10},
             {11,  12,  13,  14,  15},
             {16,  17,  18,  19,  20} };
        //expected ans : {1, 2, 3, 4, 5, 10, 15, 20, 19, 18, 17, 16, 11, 6, 7, 8, 9, 14, 13, 12}   
        int[] linearArray = spiralTraversal(input);
		System.out.println(Arrays.toString(linearArray));
	}
	
	static int[] spiralTraversal(int[][] input){
	    int fr = 0, fc = 0;
	    int row = input.length;
	    int col = input[0].length;
	    int[] arr = new int[row * col];
	    int lr = row-1;
	    int lc = col-1;
	    
	    
	    
	    return new int[]{};
	}
}
*//*
class Parent1 {
    static int x=10;
    static void staticMethod() {
        x++;
        System.out.println("Value of X in Parent : " + x);
    }
}

class Child1 extends Parent1 {
    static void staticMethod() {
        x++;
        System.out.println("Value of X in Child : " + x);
    }
}

public class Testing2 {
    public static void main(String[] args) {
        Parent1.staticMethod();
        Child1.staticMethod();
        Parent1 parent = new Child1();
        parent.staticMethod();
    }
}*/
/*
class Bird {
    int count = 90;
    void fly() {
        System.out.println(count +" Bird are flying");
    }

    void eat() {
        System.out.println(count +" Bird are Eating");
    }
}

class Penguin extends Bird {
    int count = 70;
    void swim() {
        System.out.println(count +" Penguins are swimming");
    }

    void eat() {
        System.out.println(count +" Penguins are Eating");
    }
}

public class Testing2 {
    public static void main(String[] args) {
        Bird bird = new Penguin();
        //bird.swim();
        bird.eat();
        System.out.println(bird.count +" Birds are There");
    }
} */

/*
public class Testing2 {
    public static void main(String[] args)
    {
        Map<String, String> cityCode = new HashMap<String, String>();
        cityCode.put("India", "Kolkata");
        cityCode.put("Russia", "Moscow");
        cityCode.put("USA", "New York");

        Iterator<String> iterator = cityCode.keySet().iterator();

        while (iterator.hasNext()) {
            String country = iterator.next();
            if ("India".equals(country)) {
                cityCode.put("India", "Delhi");
                //cityCode.put("Pakisthan", "Lahore");
            }
            System.out.println("Country : " + country + ", Capitol : " + cityCode.get(country));
        }
    }
} */
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
    public static synchronized void test2() {
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

public class Testing2 {
    public static void main(String args[]) {
        MultiThreadHandle obj =  new MultiThreadHandle();
        ExecutorService executor = Executors.newFixedThreadPool(10);

        Runnable runnableTask1 = () -> { obj.test1(); };
        Runnable runnableTask2 = () -> { obj.test2(); };

        executor.execute(runnableTask1);
        executor.execute(runnableTask2);
    }
} */