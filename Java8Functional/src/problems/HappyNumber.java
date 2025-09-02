package problems;
import java.util.*;

public class HappyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isHappy(7));

	}
	public static boolean isHappy(int num) {
        Set<Integer> set = new HashSet<>();
        
        set.add(num);
        while(num != 1){
            num = sumSquares(num);
            if(!set.add(num))
              return false;
        }
        return true;
    }
    public static int sumSquares(int b){
        int t=0,sum=0;
        while(b>0){
            t=b%10;
            sum += t*t;
            b=b/10;
        }
        return sum;
    }

}
/*//using slow pointer fast pointer
class Solution {
    public boolean isHappy(int n) {
        int slow = getNextNumber(n);
        int fast = getNextNumber(getNextNumber(n));

        while (slow != fast) {
            if (fast == 1) return true;
            slow = getNextNumber(slow);
            fast = getNextNumber(getNextNumber(fast));
        }

        return slow == 1;
    }

    private int getNextNumber(int n) {
        int output = 0;
        
        while (n > 0) {
            int digit = n % 10;
            output += digit * digit;
            n = n / 10;
        }
        
        return output;
    }
}
*/