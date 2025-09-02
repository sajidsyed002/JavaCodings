package com.testing.lambda;

import java.util.HashSet;

/******************************************************************************
Check validity of sudoku problem:
Determine if a 9 x 9 Sudoku board is valid.
    The rules that need to be checked if the Sudoku grid is valid are :
        1.Each row must contain the digits 1-9 without repetition.
        2.Each column must contain the digits 1-9 without repetition.
        3.Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

     Example 1 :
            {{'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}}
            Output: true

      Example 2 :
            {{'8','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}}
            Output: false

*******************************************************************************/
        /*                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               import java.util.*;
public class TestProb {
	public static void main(String[] args) {
	    char[][] inputSudoku = new char[][]
	       {{'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}};
        //Expected answer is : true
        
        boolean isSudokuValid = checkSudokuValidity(inputSudoku);
		System.out.println("Is given sudoku problem vablid ? : " + isSudokuValid);
	}
	
	static boolean checkSudokuValidity(char[][] inputSudoku){
	    int track[] = new int[9];
	    int i=0,j=0, rows = inputSudoku.length, cols=inputSudoku[0].length;
	    while(i<rows){
	        Set<Character> row_check = new HashSet<Character>();
	        while(j<cols){
	            if(inputSudoku[i][j]!='.'){
	                if(!row_check.add(inputSudoku[i][j])){
	                    //System.out.println(inputSudoku[i][j]);
	                    return false;
	                }
	            }
	            j++;
	        }
	        i++;
	    }
	    while(j<cols){
	        Set<Character> col_check = new HashSet<Character>();
	        while(i<rows){
	            if(inputSudoku[i][j]!='.'){
	                if(!col_check.add(inputSudoku[i][j])){
	                    return false;
	                }
	            }
	            i++;
	        }
	        j++;
	    }
	    while(j<cols){
	        Set<Character> col_check = new HashSet<Character>();
	        while(i<rows){
	            if(inputSudoku[i][j]!='.'){
	                if(!col_check.add(inputSudoku[i][j])){
	                    return false;
	                }
	            }
	            i++;
	        }
	        j++;
	    }
	    return true;
	}
}*/
//original sol --------------
/*
class SudokuSolution{
    boolean checkIfSudokuValid(char[][] sudoKuBoard){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(sudoKuBoard[i][j] != '.'){
                    boolean flag = checkValidity(sudoKuBoard, i, j);
                    if(flag == false){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    boolean checkValidity(char[][] sudokuBoard, int x, int y){
        int i=0;
        int j=0;

        for(i=0; i<9; i++){
            if(sudokuBoard[i][y] == sudokuBoard[x][y] && x!=i){
                return false;
            }
        }
        for(j=0; j<9; j++){
            if(sudokuBoard[x][j] == sudokuBoard[x][y] && y!=j){
                return false;
            }
        }

        int xStart = (x/3)*3;
        int yStart = (y/3)*3;
        for(i=xStart; i<xStart+3; i++){
            for(j=yStart; j<yStart+3; j++){
                if(sudokuBoard[i][j] == sudokuBoard[x][y] && i!=x && j!=y){
                    return false;
                }
            }
        }

        return true;
    }
}		
*/

/*
1. We initialize `maxProfit` to `0` and `minPrice` to the first element of the array `prices`.
2. We iterate through the array `prices` starting from the second element.
3. For each day `i`, we calculate the profit that can be made by selling the stock on that day (`prices[i] - minPrice`), where `minPrice` is the minimum price seen so far.
4. We update `maxProfit` with the maximum of its current value and the profit calculated for the current day.
5. We update `minPrice` with the minimum of its current value and the price of the current day.
6. After iterating through all days, `maxProfit` will hold the maximum profit that can be achieved by buying and selling stocks on consecutive days.

This solution has a time complexity of O(n), where n is the number of elements in the `prices` array, as it iterates through the array only once. It doesn't use a HashMap directly but employs a strategy based on finding the minimum price and calculating the maximum profit accordingly.
*/
/*
import java.util.HashMap;
import java.util.Map;

public class TestProb {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0; // Cannot make a profit with less than two prices
        }

        int maxProfit = 0;
        int minPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            int currentProfit = prices[i] - minPrice;
            maxProfit = Math.max(maxProfit, currentProfit);
            minPrice = Math.min(minPrice, prices[i]);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Maximum Profit: " + maxProfit(prices)); // Output: 5
    }
}
*/

/*
 * import java.util.HashSet;

public class TestProb {
    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestSequence = 0;

        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentSequence = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentSequence++;
                }

                longestSequence = Math.max(longestSequence, currentSequence);
            }
        }

        return longestSequence;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println("Length of the longest consecutive sequence: " + longestConsecutive(nums)); // Output: 4
    }
}
*/

/*
 // convert list to map using java 8.
class Student {
    private Integer id;

    private String name;

    public Student(Integer id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public Integer getId() { return id; }

    public String getName() { return name; }
}

public class TestProb {
    public static void main(String args[]) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "Krisha"));
        studentList.add(new Student(2, "Aarya"));
        studentList.add(new Student(3, "Tisha"));
        studentList.add(new Student(3, "Ishana"));

        Map<Integer, String> studentMap = studentList.stream()
                .collect(
                        Collectors
                                .toMap(
                                        Student::getId,
                                        Student::getName,
                                        (x, y) -> y ,
                                        LinkedHashMap::new));

        studentMap.forEach(
                (x, y) -> System.out.println("Student ID : " + x + ", Student Name : " + y));
    }
}
 */

/*
 // Logic - Traverse first row, last column, last row in reverse order, first column in reverse order; 
//	For the next iteration, perform the same logic but increase the first row, decrease the last column, 
 // decrease the last row and increase the first column and so on...


import java.util.Arrays;

public class TestProb {
    public static void main(String[] args) {

        int[][] matrix = new int[][]{
                {1,    2,   3,  4,    5},
                {6,    7,   8,  9,   10},
                {11,  12,  13,  14,  15},
                {16,  17,  18,  19,  20}
        };

        int[] flattenedOneDimArray = spiralTraversal(matrix);
        System.out.printf(Arrays.toString(flattenedOneDimArray));
    }

    static int[] spiralTraversal(int[][] matrix){
        int firstRow = 0;
        int lastRow = matrix.length-1;
        int firstColumn = 0;
        int lastColumn = matrix[0].length-1;
        int[] ans = new int[matrix.length * matrix[0].length];
        int k = 0;
        while(firstRow < lastRow && firstColumn < lastColumn){
            for(int j=firstColumn; j<lastColumn; j++){
                ans[k] = matrix[firstRow][j];
                k++;
            }

            for(int i=firstRow; i<lastRow; i++){
                ans[k] = matrix[i][lastColumn];
                k++;
            }

            for(int j=lastColumn; j>firstColumn; j--){
                ans[k] = matrix[lastRow][j];
                k++;
            }

            for(int i=lastRow; i>firstRow; i--){
                ans[k] = matrix[i][firstColumn];
                k++;
            }

            firstRow ++;
            lastRow --;
            firstColumn ++;
            lastColumn --;
        }

        return ans;
    }
}
*/
/*
import java.util.HashMap;
import java.util.Map;

public class TestProb {
    public static int minDistance(String word1, String word2) {
        final int m = word1.length();
        final int n = word2.length();
        // dp[i][j] := the minimum number of operations to convert word1[0..i) to
        // word2[0..j)
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; ++i)
            dp[i][0] = i;

        for (int j = 1; j <= n; ++j)
            dp[0][j] = j;

        for (int i = 1; i <= m; ++i)
            for (int j = 1; j <= n; ++j)
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;

        return dp[m][n];
    }


    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";
        System.out.println("Maximum Profit: " + minDistance(word1, word2));
    }
}
 */

