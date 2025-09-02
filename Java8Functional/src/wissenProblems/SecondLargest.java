package wissenProblems;

public class SecondLargest {



public static void main(String[] args)
{
    Integer arr[] = { 12, 35, 1, 10, 33, 1,-1 };
    int n = arr.length;
	Integer i = getSecondlargest(arr, n);

	if (i == null) {
		System.out.printf("There is no second largest element\n");
	} else {
		System.out.printf("The second largest element is %d\n", i);
	}
    
}

private static Integer getSecondlargest(Integer[] arr, int n) {
	int max = arr[0], max2 = arr[1], temp =0;
	if(max < max2) {
		temp = max;
		max = max2;
		max2 = temp;
	}
	for(int i=1; i < n;i++) {
		if(arr[i] > max && arr[i] > max2) {
			temp = max;
			max = arr[i];
			max2 = temp;
		}
		
		else if(arr[i] < max && arr[i] > max2) {
			max2 = arr[i];
		}	
	}
	
	return max2;
}
}
