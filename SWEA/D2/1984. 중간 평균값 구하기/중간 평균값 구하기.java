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
            int[] nums = new int[10];
            long sum = 0;
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < 10; i++) {
            	nums[i] = sc.nextInt();
				sum += nums[i];
                if (max < nums[i]) max = nums[i];
                if (min > nums[i]) min = nums[i];
            }
			sum = sum - max - min;
            int avg = (int) Math.round(sum / 8.0);
            System.out.printf("#%d %d", test_case, avg);
            System.out.println();
		}
	}
}