package com.testing.lambda;

import java.math.BigDecimal;
import java.util.*;
import java.util.HashSet;
/*
class Student { 
    public int id; 
    public String name; 
    BigDecimal b1;
  
    public BigDecimal getB1() {
		return b1;
	}

	public void setB1(BigDecimal b1) {
		this.b1 = b1;
	}

	public Student(String name, int id) { 
        this.name = name;  
        this.id = id; 
        //System.out.println(b1);
    }
  
    public String toString() { 
        return "Student: " + this.name + "@" + Integer.toHexString(hashCode()) ; 
    } 
  
    public boolean equals(Object o) { 
        if (o instanceof Student) { 
           Student s = (Student) o; 
           return s.id == this.id ? true : false; 
        } 
        return false; 
    }
    public int hashCode() { 
        return id; 
    }
   
} 
  
public class Testing {
  
    public static void main(String[] args) { 
    HashSet<Student> studentList = new HashSet<>();
    Map<Student, String> map = new HashMap<>();
  
    Student st1 = new Student("Nimit", 1); 
    Student st2 = new Student("Rahul", 1); 
    Student st3 = new Student("Nimit", 1); 
    
    map.put(st1, "first");
    System.out.println("Map: " + map);
    System.out.println("Before mutation: " + map.get(st1));
    
    boolean a1 = studentList.add(st1); 
    boolean a2 =studentList.add(st2); 
    boolean a3 =studentList.add(st3); 
    boolean a4 =false;
    
    st1.id=3;
     a4 = studentList.add(st1);
    //System.out.println("size====="+studentList.size()); 
    System.out.println(studentList);
    System.out.println(a1+" "+a2+" "+a3+" "+a4);
    
    System.out.println("Map: " + map);
    //System.out.println(st1);
    System.out.println("After mutation: " + map.get(st1)); //returns null after mutation.
    //System.out.println(map.);
   // map.put(st1, "again");
   // System.out.println("Map: " + map);
   // System.out.println("After mutation n adding again: " + map.get(st1));
    
}
}*/
    /***
     *  What happens when you mutate st1.id = 3
If your Student class has overridden hashCode() and equals() based on id:

When you first added st1 with id=1, its hashCode pointed to some bucket.

After mutation → id=3, so now hashCode changes.

But HashSet still has the object sitting in the old bucket (hash for 1).

So now HashSet is “confused”: the object is in a bucket where it no longer belongs.

When you try studentList.add(st1) again:

It checks hashCode (3) → goes to new bucket.

Doesn’t find the same object there → thinks it’s new → adds it again.

Duplicate entry inserted (violation of HashSet’s contract).
     
     =========================================================================================
     for hashmaps
     If your key object is mutable and you change its fields that affect equals or hashCode:

The key is stored in the bucket of its old hashCode.

After mutation, its hashCode changes, but the object remains stuck in the wrong bucket.

Lookup (map.get(key)) will now fail, even if you pass the same key object reference!
     
     
     Even if you can find the key by scanning values, the lookup by mutated key (map.get(s1)) is still broken.
      The object is there, but the hash bucket mismatch prevents direct retrieval.
      you cannot rely on map.get(key) anymore after mutation.
     */


/*
class SuperClass
{
    void anyMethod() throws CarException
    {
        System.out.println("Super Class Method");
    }
}
public class Testing extends SuperClass
{
    @Override
    void anyMethod() throws CarException
    {
        System.out.println("Sub CLass Method");
    }

    public static void main(String[] args) {
    	Testing testException = new Testing();
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
	public VehicleException ()
    {
        System.out.println("Thrown Vehicle Exception For default constructor : ");
    }
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
} 
*/
/*
class Student
{
    String name;
    int id;

    Student(String name, int id)
    {
        this.name = name;
        this.id = id;
    }

    @Override
    public int hashCode()
    {
        return this.id;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj)
            return true;

        if(obj == null || obj.getClass()!= this.getClass())
            return false;

        Student Student = (Student) obj;
        return (Student.name.equals(this.name) && Student.id == this.id);
    }

    @Override
    public String toString() {
        return "Student: " + this.name + "@" + Integer.toHexString(hashCode());
    }
}

public class Testing {
    public static void main(String[] args)
    {

        Student g1 = new Student("aditya", 1);
        Student g2 = new Student("adityaa", 1);

        Map<Student, String> map = new HashMap<Student, String>();
        map.put(g1, "CSE");
        map.put(g2, "IT");

        for(Student student : map.keySet())
        {
            System.out.println("Key : " + student);
            System.out.println("Value : " + map.get(student).toString());
        }
    }
} 
*/
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

public class Testing
{
    public void testCar() throws CarException {
        //testHatchback(); // Comilation error as CarException is subclass of VehicleException, and can't handle VehicleException.
        testSUV();
    }

    public void testHatchback() throws VehicleException {
        throw new VehicleException("Hatchback");
    }

    public void testSUV() throws SUVException {
        throw new SUVException();
    }

    public static void main(String[] args) throws VehicleException   {
    	Testing testException = new Testing();
        
			testException.testCar(); // Compilattion error Unhandled exception: CarException. Either add throws or handle with try catch
    }
}

