import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;

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
            
            int[] scores = new int[n];
            
            for (int i = 0; i < n; i++) {
            	scores[i] = sc.nextInt();
            }
            Arrays.sort(scores);

            int result = 0;
            for (int i = 0; i < k; i++) {
                result += scores[n - 1 - i];
            }
            System.out.printf("#%d %d\n", test_case, result);
		
		}
	}
}