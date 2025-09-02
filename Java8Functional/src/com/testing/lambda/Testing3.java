package com.testing.lambda;

import java.util.*;

/*
public class Testing3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		int a  = Integer.MAX_VALUE +10;
		int b = Integer.MIN_VALUE -2 ;
		System.out.println(a);
		System.out.println(b);

	}

}
*/
/*

class Parent {

    Parent (String s){
        System.out.println("Parent Class Param  "+s);
    }
}

public class Testing3 extends Parent {

	Testing3 (){
		this("Constructor");
		//super("w");
        
        System.out.println("Child Class Default Constructor");
    }

	Testing3 (String s){
		super(s);
        System.out.println("Child Class Param "+s);
    }

    public static void main(String[] args) {
    	Testing3 obj = new Testing3();
    }

}

*/

class Movie //implements Comparable<Movie>
{
    private double rating;
    private String name;
    private int year;

    //public int compareTo(Movie m) { return this.year - m.year; }

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

public class Testing3
{
    public static void main(String[] args)
    {
       /* NavigableSet<Movie> movieList = new TreeSet<Movie>();
        movieList.add(new Movie("Bahubali", 8.3, 2015));
        movieList.add(new Movie("Janbar", 8.7, 1977));
        movieList.add(new Movie("Mr.India", 8.8, 1980));
        movieList.add(new Movie("Amar Akbar Anthony", 8.4, 1983));

        System.out.println("Movies after sorting: ");
        for (Movie movie: movieList)
        {
            System.out.println(movie.getName() + " " +
                    movie.getRating() + " " +
                    movie.getYear());
        }*/
        NavigableSet<Movie> movieList1 = new TreeSet<Movie>(Comparator.comparing(Movie::getRating).reversed());
        //NavigableSet<Movie> movieList1 = new TreeSet<Movie>();
        movieList1.add(new Movie("Bahubali", 8.3, 2015));
 
        movieList1.add(new Movie("Janbar", 8.7, 1977));
 
        movieList1.add(new Movie("Mr.India", 8.8, 1980));
 
        movieList1.add(new Movie("Amar Akbar Anthony", 8.4, 1983));
        System.out.println("Movies after sorting: 2");
        for (Movie movie: movieList1)
        {
            System.out.println(movie.getName() + " " +
                    movie.getRating() + " " +
                    movie.getYear());
        }
    }
}