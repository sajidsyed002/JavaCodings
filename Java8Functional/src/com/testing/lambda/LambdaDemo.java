package com.testing.lambda;

import java.util.*;
import java.util.stream.*;

interface Sample{
	public void f1();
}
public class LambdaDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x=100;
		
		List<Integer> integerList = Arrays.asList(1,2,3,4,4,4,3,5,7,6,8,6,9);
		// Imperative Style
		List<Integer> uniqueList = new ArrayList<>();
		for(Integer i : integerList)
			if(!uniqueList.contains(i)) {
				uniqueList.add(i);
			}
		System.out.println("Unique List elements : "+uniqueList);
		// Declarative Style
		List<Integer> uniqueList1 = integerList.stream()
				.distinct()
				.collect(Collectors.toList());
		System.out.println("Unique List elements : "+uniqueList1);

	}

}
