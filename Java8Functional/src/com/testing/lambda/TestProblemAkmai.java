package com.testing.lambda;

import java.util.HashMap;
import java.util.Map;

public class TestProblemAkmai {

	public static void main(String[] args) {
		
		int arr[] = new int[] {4,4,13,2,3};
		findLargestScoreBand(arr);
		
	/*	def findLargestScoreBand(modelScores):
		    if not modelScores:
		        return 0

		    freq = {}
		    for score in modelScores:
		        freq[score] = freq.get(score, 0) + 1

		    max_band = 0
		    for score in freq:
		        # Consider band of current score and next score
		        current_band = freq[score] + freq.get(score + 1, 0)
		        max_band = max(max_band, current_band)

		    return max_band
*/
	}
	public static void findLargestScoreBand(int[] modelScores) {
		
		Map<Integer,Integer> map = new HashMap<>();
		for(int key : modelScores)
			map.put(key, map.getOrDefault(key, 0)+1);
		
			
		System.out.println(map);
		int max = 0;
		for(int k : map.keySet()) {
			int curr = map.get(k)+map.getOrDefault(k+1, 0);
			int curr2 = map.get(k)+map.getOrDefault(k-1, 0);
			max = Math.max(max, Math.max(curr, curr2));
		}
		System.out.println(max);
		
	}

}
