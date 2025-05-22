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
            int m = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[m];
            for (int i = 0; i < n; i++)  a[i] = sc.nextInt();
            for (int i = 0; i < m; i++) b[i] = sc.nextInt();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < Math.abs(m - n) + 1; i++) {
                int sum = 0;

                if (m >= n) {
                	for (int j = 0; j < n; j++) {
                		sum += a[j] * b[j + i];
                	}
                } else {
                	for (int j = 0; j < m; j++) {
                		sum += a[j + i] * b[j];
                	}
                }
                max = (max < sum) ? sum : max;
            }
            System.out.printf("#%d %d\n", test_case, max);

		}
	}
}