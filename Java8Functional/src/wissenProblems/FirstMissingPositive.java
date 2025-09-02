package wissenProblems;

import java.util.Arrays;

/******************************************************************************
First Missing Positive:
Given an unsorted integer array numbers, return the smallest missing positive integer.

You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.

Example 1:
Input: nums = [1,2,0]
Output: 3
Explanation: The numbers in the range [1,2] are all in the array.

Example 2:
Input: nums = [3,4,-1,1]
Output: 2
Explanation: 1 is in the array but 2 is missing.

Example 3:
Input: nums = [7,8,9,11,12]
Output: 1
Explanation: The smallest positive integer 1 is missing.
 
Constraints:
1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1

*******************************************************************************/
/*
public class FirstMissingPositive
{
	public static void main(String[] args) {
		int[] input = new int[]{3,4,-1,1};
		//Expected ans : 2
		int firstMissingPositive = getFirstMissingPositive(input);
		
		System.out.println(firstMissingPositive);
	}
	
	static int getFirstMissingPositive(int[] input){
		Arrays.sort(input);
		int i =0;
		for( i=0;i<input.length;i++) {
			if(input[i] > 0) {
				if(input[i] != 1)
					return 1;
				else
					break;
			}	
		}
		if(i == input.length-1)
			return input[i]+1;
		for(int j =i+1;j<input.length;j++) {
			if(input[j]-input[j-1] !=1)
				return input[j-1]+1;
			else if(j == input.length-1)
				return input[j]+1;
		}
	    return 0;
	}
}

*/
//index based swapping
public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {1, 2, -1, 3};
        int res = firstMissingPositive(nums);
        System.out.println(res);  // Output: 2
    }

    static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // Swap nums[i] and nums[nums[i] - 1]
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }
}
