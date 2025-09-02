package problems;

import java.util.*;

//longest substring without repeating characters
public class SlidingWindow {

	public static void main(String[] args) {
		String a = "tmmzuxt";
		String b = "aabaab!bb";
		
		System.out.println(lengthOfLongestSubstring(a));
	}

    public static int lengthOfLongestSubstring(String s) {
        int l=0,r=0,len=0,maxlen=0;
        HashMap<Character,Integer> map = new HashMap<>();
        while(r < s.length()){
            if(map.containsKey(s.charAt(r)) && map.get(s.charAt(r))>= l){
                    l = map.get(s.charAt(r))+1;
                }
            map.put(s.charAt(r),r);
            len = r-l+1;
            maxlen = Math.max(len,maxlen);
            r++;
        }
        return maxlen;
    }
}
