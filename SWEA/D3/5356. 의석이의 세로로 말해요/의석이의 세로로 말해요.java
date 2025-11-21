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
            char[][] board = new char[5][15];
            int max = 0;
            for (int i = 0; i < 5; i++) {
                String input = sc.next();
                max = max < input.length() ? input.length() : max;
                for (int j = 0; j < input.length(); j++) {
                	board[i][j] = input.charAt(j);
                }
            }
            String result = "";
            for (int i = 0; i < max; i++) {
            	for (int j = 0; j < 5; j++) {
                    if (board[j][i] != 0) result += board[j][i];
                }
            }
            System.out.printf("#%d %s\n", test_case, result);
		}
	}
}