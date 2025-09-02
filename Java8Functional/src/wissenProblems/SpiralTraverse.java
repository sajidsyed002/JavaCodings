package wissenProblems;

import java.util.Arrays;
/***
Given a 2-dimensional array, traverse it spirally and copy the elements into 1-dimensional array.

input:  inputMatrix  = [ [1,    2,   3,  4,    5],
                                       [6,    7,   8,  9,   10],
                                     [11,  12,  13,  14,  15],
                                     [16,  17,  18,  19,  20] ]

output: [1, 2, 3, 4, 5, 10, 15, 20, 19, 18, 17, 16, 11, 6, 7, 8, 9, 14, 13, 12]
Explaination :       [1 -2 -3 -  4 -   5]
                                                                   |
			       [6 - 7- 8-  9   10]
		               |		|     |
			     [11 12-13-14  15]
			       |         	        |
			      [16 -17-18-19-20]
				  
Logic - Traverse first row, last column, last row in reverse order, first column in reverse order; 
For the next iteration, perform the same logic but increase the first row, decrease the last column, decrease the last row and increase the first column and so on...
**/


public class SpiralTraverse {
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

		static int[] spiralTraversal(int[][] arr){
			int fr=0, lr = arr.length-1, fc = 0, lc = arr[0].length-1,k=0;
			int[] ret = new int[arr.length * arr[0].length];
			
			while(fr<lr && fc<lc) {
			for(int i=fr;i<lc;i++) {
				ret[k] = arr[fr][i];
				k++;
			}
			for(int i=fr;i<=lr;i++) {
				ret[k] = arr[i][lc];
				k++;
			}
			for(int i=lr;i>fc;i--) {
				ret[k] = arr[lr][i];
				k++;
			}
			for(int i=lr;i>fr;i--) {
				ret[k] = arr[i][fc];
				k++;
			}
			fr++;lr--;fc++;lc--;
			}	
			return ret;
		}

		/*
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
		 */
		 
}
