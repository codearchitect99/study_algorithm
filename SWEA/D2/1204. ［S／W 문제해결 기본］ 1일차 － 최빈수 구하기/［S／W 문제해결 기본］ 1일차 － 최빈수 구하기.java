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
            int N = sc.nextInt();
            int[] count = new int[101];
            for (int i = 0; i < 1000; i++) {
            	int score = sc.nextInt();
                count[score]++;
            }
            int result = 0;
            for (int temp = 0; temp < 101; temp++) {
                if (count[temp] >= count[result]) result = temp;
            }
            System.out.printf("#%d %d\n",N, result);
		}
	}
}