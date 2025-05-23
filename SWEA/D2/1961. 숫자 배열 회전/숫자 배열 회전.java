import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int n = sc.nextInt();
            int[][] board = new int[n][n];
            for (int i = 0; i < n; i++) {
            	for (int j = 0; j < n; j++) {
                	board[i][j] = sc.nextInt();
                }
            }
            
            int result[][][] = new int [3][n][n];
            result[0] = rotate(board);
            result[1] = rotate(result[0]);
            result[2] = rotate(result[1]);
            
            System.out.printf("#%d\n", test_case);
            for (int i = 0; i < n; i++) {
            	for (int j = 0; j < 3; j++) {
                	for (int k = 0; k < n; k++) {
                    	System.out.print(result[j][i][k]);
                    }
                    System.out.print(" ");
                }
                System.out.println();
            }
             
		}
	}
    
    private static int[][] rotate(int[][] board) {
        int[][] result = new int[board.length][board.length];
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                result[j][board.length - 1 - i] = board[i][j];
            }
        }
        return result;
    }
}