package wissenProblems;

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

public class SudokoVal {
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
			return checkRows(inputSudoku) && checkColumns(inputSudoku) && checkSub(inputSudoku);
		    //return false;
		}
		static boolean checkRows(char[][] arr) {
			HashSet<Character> hs = new HashSet<>();
			 int len = arr.length;
			 for(int i=0; i <len; i++) {
				 for(int j=0;j<len;j++) {
					 if(arr[i][j] != '.') {
						 if(!hs.add(arr[i][j]))
							 return false;
					 }
				 }
				 hs.clear();
			 }
			return true;
		}
	static boolean checkColumns(char[][] arr) {
		HashSet<Character> hs = new HashSet<>();
		 int len = arr.length;
		 for(int i=0; i <len; i++) {
			 for(int j=0;j<len;j++) {
				 if(arr[j][i] != '.') {
					 if(!hs.add(arr[j][i]))
						 return false;
				 }
			 }
			 hs.clear();
		 }
			return true;
		}
	static boolean checkSub(char[][] arr) {
		HashSet<Character> hs = new HashSet<>();
		 int len = arr.length;int a=0,b=0,m=0,n=0;
		 while(m < len/3) {
			 while(n<len/3) {
		 for(int i=a; i <a+3; i++) {
			 for(int j=b;j<b+3;j++) {
				 if(arr[i][j] != '.') {
					 if(!hs.add(arr[i][j]))
						 return false;
				 }
			 }
		 }
		 hs.clear();
		 a+=3;
		 n++;
		 }
			 m++;
			 n=0;a=0;b+=3;
		 }
		return true;
	}
	static boolean checkSub2(char[][] arr) {
	    HashSet<Character> hs = new HashSet<>();
	    for (int row = 0; row < 9; row += 3) {
	        for (int col = 0; col < 9; col += 3) {
	            hs.clear();
	            for (int i = row; i < row + 3; i++) {
	                for (int j = col; j < col + 3; j++) {
	                    if (arr[i][j] != '.') {
	                        if (!hs.add(arr[i][j]))
	                            return false;
	                    }
	                }
	            }
	        }
	    }
	    return true;
	}

	}
