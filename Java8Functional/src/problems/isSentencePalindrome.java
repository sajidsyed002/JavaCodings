package problems;

public class isSentencePalindrome {
	public static void main(String args[]) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
	}	
	
	public static boolean isPalindrome(String s) {
	        s= s.toLowerCase().replaceAll("[^a-z0-9]", "");
	        System.out.println(s);
	        int l =0, r = s.length()-1;
	        while(l <r) {
	        	if(s.charAt(l) != s.charAt(r)) {
	        		return false;
	        	}
	        	l++;r--;
	        }
	        
	        return true;
	    }

	    public static boolean isPalindrome2(String s) {
	        int start = 0;
	        int last = s.length() - 1;
	        while(start <= last) {
	        	char currFirst = s.charAt(start);
	        	char currLast = s.charAt(last);
	        	if (!Character.isLetterOrDigit(currFirst )) {
	        		start++;
	        	} else if(!Character.isLetterOrDigit(currLast)) {
	        		last--;
	        	} else {
	        		if (Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)) {
	        			return false;
	        		}
	        		start++;
	        		last--;
	        	}
	        }
	        return true;
	    }
	    
	    public static boolean isPalindrome3(String s) {
	    	StringBuilder sb = new StringBuilder();
	        for(char ch : s.toCharArray()){
	            if(Character.isLetterOrDigit(ch)){
	                sb.append(Character.toLowerCase(ch));
	            }
	        }
	        if(sb.toString().equals(sb.reverse().toString())){
	        return true;
	        }
	        return false;
	    }
	    
	    public static boolean isPalindrome4(String s) {
		    String str="";
	
		    for(int i=0;i<s.length();i++)
		    {
		        if(Character.isLetterOrDigit(s.charAt(i))) str+=s.charAt(i);
		    }
	
		    str=str.toLowerCase();
	
		    int j=str.length()-1;
	
		    for(int i=0;i<str.length()/2;i++)
		    {
		        if(str.charAt(i)!=str.charAt(j)){
		            return false;
		        } 
		        
		        j--;
		    }
	
		    return true;
	    }
}
