package problems;
import java.util.*;

public class LastStone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {2,7,4,1,8,1};
		System.out.println(lastStoneWeight(arr));
	}
	
	    public static int lastStoneWeight(int[] stones) {
	        PriorityQueue<Integer> qu = new PriorityQueue<>(Collections.reverseOrder());
	        for(int n : stones){
	            qu.add(n);
	        }
	        System.out.println(qu);
	        while(qu.size() > 1) {
	        	int diff = qu.poll();
	        	int diff2 = qu.poll();
	        	qu.offer(diff-diff2);
	        }
	        return qu.isEmpty() ? 0 : qu.peek();
	    }
	
}
