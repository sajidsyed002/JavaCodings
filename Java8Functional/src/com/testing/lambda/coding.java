package com.testing.lambda;

import java.util.*;

public class coding {
	public static void main(String args[]) {
		int[] arr = new int[]{1,2,2,5,5};
		System.out.println(Arrays.toString(arr));
		System.out.println(findKings(arr));
	}
	
	public static int findKings(int[] arr) {
		int n = arr.length;
		int sum=0;
		int count=0;
		List<Integer> l = new LinkedList<>();
		for(int i =0; i< n; i++) {
			sum += arr[i];
			l.add(arr[i]);
		}
		System.out.println("sum = "+sum);
		for(int i =0; i< n; i++) {
			int remsum = sum - arr[i];
			System.out.print("remsum = "+remsum);
			int div =0;
			if(remsum%2 == 0) {
				div = remsum/2;
				System.out.print("  div = "+div+"\n");
				if(l.contains(div)) {
					if(l.get(i)== div) {
						int freq=0;
						for(int a : arr) {
							if(a==div)
								freq++;
						}
						if(freq>1)
							count++;
					}
					else
						count++;
				}
			}
		}
		return count;
	}
}
