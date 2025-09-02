package problems;

public class LongPalindromeSubstring {

	public static void main(String[] args) {
		String ss = "babad";
		//System.out.println(isValidPalindrome(ss));
		System.out.println(longestPalindrome(ss));

	}
	 static String longestPalindrome(String s) {
	        int len=0, maxlen=0, startpos=0;
	        if(s.length()<2)
	        	return s;
	        for(int last=s.length()-1; last>=0;last--) {
	        	for(int start =0;start<last;start++) {
	        		if(isValidPalindrome(s,start,last)) {
	        			len = last-start+1;
	        			if(len > maxlen) {
	        				maxlen = len;
	        				startpos=start;
	        			}
	        			maxlen = Math.max(len, maxlen);
	        		}
	        	}
	        }
	        if(maxlen > 0)
	        	return s.substring(startpos,startpos+maxlen);
	        
	    	return s.substring(0,1);
	    }
	 static boolean isValidPalindrome(String s,int l, int r) {
	
		 int len = r-l+1;
		 for(int i=0;i<len/2;i++) {
			 if(i==r)
				 break;
			 if(s.charAt(l) != s.charAt(r))
				 return false;
			 l++;
			 r--;
		 }
		 
		 return true;
	 }

	 /*
	  *class Solution {
    public String longestPalindrome(String s) {
        for (int length = s.length(); length > 0; length--) {
            for (int start = 0; start <= s.length() - length; start++) {
                if (check(start, start + length, s)) {
                    return s.substring(start, start + length);
                }
            }
        }

        return "";
    }

    private boolean check(int i, int j, String s) {
        int left = i;
        int right = j - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
	  */
}
