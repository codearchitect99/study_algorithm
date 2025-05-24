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
            
            int len = n;
            
            int[] di = {0, 1, 0, -1};
            int[] dj = {1, 0, -1, 0};
            int d = 0;
            
            int I = 0;
            int J = -1;
            
            int k = 1;
            for (int i = 0; i < n; i++) {
                I += di[d];
                J += dj[d];
                board[I][J] = k;
                k++;
            }
            d++;
            len--;
            
            while (len > 0) {
                for (int j = 0; j < 2; j++) {
	                for (int i = 0; i < len; i++) {
                        I += di[d];
                        J += dj[d];
    	            	board[I][J] = k;
                        k++;
        	        }
            	    d++;
                	if (d >= 4) d = 0;
                }
                len--;
            }
            
            System.out.printf("#%d\n", test_case);
            for (int i = 0; i < n; i++) {
            	for (int j = 0; j < n; j++) {
                	System.out.printf("%d ", board[i][j]);
                }
                System.out.println();
            }
		}
	}
}