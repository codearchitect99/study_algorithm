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
            int k = sc.nextInt();
            
            boolean[][] board = new boolean[n][n];
            
            int result = 0;
            for (int i = 0; i < n; i++) {
                int count = 0;
            	for (int j = 0; j < n; j++) {
                	board[i][j] = (sc.nextInt() == 1) ? true : false;
                    if (board[i][j]) count++;
                    else {
                    	if (count == k && !board[i][j]) {
                    		result++;
                        	count = 0;
                    	} else count = 0;
                    }                 
                }
                if (count == k) result++;
            }
            
            for (int i = 0; i < n; i++) {
                int count = 0;
            	for (int j = 0; j < n; j++) {
                	if (board[j][i]) count++;
                    else {
                    	if (count == k && !board[j][i]) {
                    		result++;
                        	count = 0;
                    	} else count = 0;
                    }            
                }
                if (count == k) result++;
            }
            System.out.printf("#%d %d\n", test_case, result);
		}
	}
}