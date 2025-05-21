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
            int[] nums = new int[N];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = sc.nextInt();
            }
            
            int max = nums[N - 1];
            long result = 0;
            for (int i = N - 2; i >=0; i--) {
            	if (max < nums[i]) max = nums[i];
                else {
                    result += max - nums[i];
                }
            }
            System.out.printf("#%d %d", test_case, result);
            System.out.println();
		}
	}
}