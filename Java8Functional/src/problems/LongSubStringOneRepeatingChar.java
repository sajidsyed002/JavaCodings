package problems;

import java.util.*;

public class LongSubStringOneRepeatingChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "geuqjmt";//babacc
		String qc = "bgemoegklm";//bcb
		int[] arr = new int[] {3,4,2,6,5,6,5,4,3,2};
		System.out.println(Arrays.toString(longestRepeating(s,qc, arr)));

	}
	
  public static int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        Map<Character,Integer> map = new HashMap<>();
        int maxlen=0, len = 0;
        StringBuilder sb = new StringBuilder(s);
        int[] res = new int[queryIndices.length];
        for(int i=0;i<queryIndices.length;i++) {
        	int index = queryIndices[i];
        	maxlen=0;
    		sb.setCharAt(index, queryCharacters.charAt(i));  
        	for(int j=0;j<sb.length();j++) {
        		
        		map.put(sb.charAt(j), map.getOrDefault(sb.charAt(j), 0)+1);
        		if(map.size()>1) {
        			map.remove(sb.charAt(j-1));
        		}else {
        			maxlen = Math.max(maxlen,map.get(sb.charAt(j)));
        		}
        	}
        	map.clear();
        	res[i] = maxlen;
        }
	  return res;
    }
  
  /*
   *class Solution {
    class Node {
        char leftChar, rightChar; // Characters at segment boundaries
        int leftCount, rightCount, max, length; // Repeating substring counts and segment length
        Node() {} // Default constructor for empty/padding nodes
        Node(char c) { // Constructor for leaf nodes, representing single characters
            leftChar = c; rightChar = c; // Left and right chars are the char itself
            leftCount = 1; rightCount = 1; // Initially, repeating counts are 1
            max = 1;        // Max repeating length in segment is 1 (itself)
            length = 1;     // Segment length is 1
        }
    }
    Node[] tree; int size; // Segment tree array and its size (power of 2)

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length(), q = queryIndices.length; // n: string length, q: number of queries
        size = 1; while(size < n) size *= 2; // Calculate segment tree size to be power of 2 >= n
        tree = new Node[2 * size]; // Initialize segment tree array with size 2*size
        for(int i = 0; i < size; i++) // Initialize leaf nodes and padding nodes
            tree[size + i] = (i < n) ? new Node(s.charAt(i)) : new Node(); // Assign Node with char if in string range, else empty Node
        for(int i = size - 1; i >= 1; i--) // Build segment tree from leaf nodes up to the root
            tree[i] = merge(tree[2 * i], tree[2 * i + 1]); // Merge children to create parent node

        int[] ans = new int[q]; // Array to store results for each query
        for(int i = 0; i < q; i++) { // Process each query
            update(queryIndices[i], queryCharacters.charAt(i)); // Update the character in segment tree
            ans[i] = tree[1].max; // After update, the max value at root (index 1) is the longest repeating substring
        }
        return ans; // Return array of longest repeating substring lengths after each query
    }

    private void update(int pos, char c) {
        int idx = pos + size; // Calculate index of leaf node corresponding to position pos
        tree[idx] = new Node(c); // Update leaf node with the new character
        for(idx /= 2; idx >= 1; idx /= 2) // Traverse up from leaf to root (segment tree update process)
            tree[idx] = merge(tree[2 * idx], tree[2 * idx + 1]); // Re-calculate current node's info by merging its children
    }

    private Node merge(Node left, Node right) {
        if(left.length == 0) return right; // If left child represents empty segment, return right child
        if(right.length == 0) return left; // If right child represents empty segment, return left child
        Node res = new Node(); // Create a new Node to store merged segment info
        res.length = left.length + right.length; // Merged segment length is sum of children's lengths
        res.leftChar = left.leftChar;   // Leftmost char of merged segment is from left child
        res.rightChar = right.rightChar; // Rightmost char of merged segment is from right child

        res.leftCount = left.leftCount; // Initialize left repeating count from left child
        // Extend leftCount if the entire left segment is of same char and matches the start of right segment
        if(left.leftCount == left.length && left.rightChar == right.leftChar)
            res.leftCount = left.length + right.leftCount;

        res.rightCount = right.rightCount; // Initialize right repeating count from right child
        // Extend rightCount if the entire right segment is of same char and matches the end of left segment
        if(right.rightCount == right.length && left.rightChar == right.leftChar)
            res.rightCount = right.length + left.rightCount;

        res.max = Math.max(left.max, right.max); // Max repeating length is at least the max of children
        // Check if merging creates a larger repeating substring across the segment boundary
        if(left.rightChar == right.leftChar)
            res.max = Math.max(res.max, left.rightCount + right.leftCount); // Update max if merging extends the repeating substring
        return res; // Return the merged Node
    }
}
   * */
   
  
  /*
   *class Node{
    int max;
    int prefSt,prefEnd;
    int suffSt,suffEnd;
    Node(int max,int prefSt,int prefEnd,int suffSt,int suffEnd){
        this.max=max;
        this.prefSt=prefSt;
        this.prefEnd=prefEnd;
        this.suffSt=suffSt;
        this.suffEnd=suffEnd;
    }
}

class SegmentTree{
    Node [] tree;
    StringBuilder s;
    SegmentTree(String s){
        this.s=new StringBuilder();
        this.s.append(s);
        tree=new Node[4*s.length()];
        build(0,0,s.length()-1);
    }
    
    Node merge(Node left,Node right,int tl,int tm,int tr){
        int max=Integer.max(left.max,right.max);
        int prefSt=left.prefSt;
        int prefEnd=left.prefEnd;
        int suffSt=right.suffSt;
        int suffEnd=right.suffEnd;
        
        if(s.charAt(tm)==s.charAt(tm+1)){
            max=Integer.max(max,right.prefEnd-left.suffSt+1);
            if(left.prefEnd-left.prefSt+1==tm-tl+1)
                prefEnd=right.prefEnd;
            if(right.suffEnd-right.suffSt+1==tr-tm)
                suffSt=left.suffSt;
        }
        
        return new Node(max,prefSt,prefEnd,suffSt,suffEnd);
    }
    
    void build(int pos,int tl,int tr){
        if(tl==tr){
            tree[pos]=new Node(1,tl,tl,tr,tr);
        }else{
            int tm=tl+(tr-tl)/2;
            build(2*pos+1,tl,tm);
            build(2*pos+2,tm+1,tr);
            
            tree[pos]=merge(tree[2*pos+1],tree[2*pos+2],tl,tm,tr);
        }
    }
    
    void update(int pos,int tl,int tr,int idx,char ch){
        if(tl==tr){
            tree[pos]=new Node(1,tl,tl,tr,tr);
            s.setCharAt(idx,ch);
            // System.out.println(pos);
        }
        else{
            int tm=tl+(tr-tl)/2;
            if(idx<=tm)
                update(2*pos+1,tl,tm,idx,ch);
            else
                update(2*pos+2,tm+1,tr,idx,ch);
            tree[pos]=merge(tree[2*pos+1],tree[2*pos+2],tl,tm,tr);
        }
    }
}

class Solution {
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int k=queryIndices.length;
        SegmentTree tree=new SegmentTree(s);
        for(int i=0;i<k;i++){
            tree.update(0,0,s.length()-1,queryIndices[i],queryCharacters.charAt(i));
            queryIndices[i]=tree.tree[0].max;
        }
        return queryIndices;
    }
}
   * */
   
  
  
  
  /*
   class Solution {
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        char[] arr = s.toCharArray();
        int m = arr.length, n = queryIndices.length;
        int[] output = new int[n];
        TreeMap<Integer, Integer> lengths = new TreeMap<>(), spans = new TreeMap<>();
        // Stores spans of each letter in the TreeMap
        for (int i = 0, j = 1; j <= m; j++) if (j == m || arr[i] != arr[j]) {
            lengths.put(j - i, lengths.getOrDefault(j - i, 0) + 1);
            spans.put(i, j - 1);
            i = j;
        }
        // Update spans on each query and find the max length
        for (int i = 0; i < queryIndices.length; i++) {
            int j = queryIndices[i];
            if (arr[j] != queryCharacters.charAt(i)) {
                // Remove the spans that has the character to be updated
                int l = spans.floorKey(j), r = spans.remove(l), length = r - l + 1;
                if (lengths.get(length) == 1) lengths.remove(length);
                else lengths.put(length, lengths.get(length) - 1);
                // if the character is going to be different from its neighbors, break the span
                if (l < j) {
                    spans.put(l, j - 1);
                    lengths.put(j - l, lengths.getOrDefault(j - l, 0) + 1);
                }
                if (r > j) {
                    spans.put(j + 1, r);
                    lengths.put(r - j, lengths.getOrDefault(r - j, 0) + 1);
                }
                arr[j] = queryCharacters.charAt(i);
                l = j;
                r = j;
                // if the character is going to be same as its neighbors, merge the spans
                if (j > 0 && arr[j] == arr[j - 1]) {
                    l = spans.floorKey(j);
                    length = spans.remove(l) - l + 1;
                    if (lengths.get(length) == 1) lengths.remove(length);
                    else lengths.put(length, lengths.get(length) - 1);
                }
                if (j < m - 1 && arr[j] == arr[j + 1]) {
                    int key = spans.ceilingKey(j);
                    r = spans.remove(key);
                    length = r - key + 1;
                    if (lengths.get(length) == 1) lengths.remove(length);
                    else lengths.put(length, lengths.get(length) - 1);
                }
                spans.put(l, r);
                lengths.put(r - l + 1, lengths.getOrDefault(r - l + 1, 0) + 1);
            }
            output[i] = lengths.lastKey();
        }
        return output;
    }
}
   */

}
