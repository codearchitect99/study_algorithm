import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
//		sc.nexLine();

		for(int test_case = 1; test_case <= 10; test_case++)
		{
            int n = sc.nextInt();
            int[] buildings = new int[n];
            
            for (int i =0; i < n; i++) {
            	buildings[i] = sc.nextInt();
            }
            
            int result = 0;
            for (int i = 2; i < n - 2; i++) {
                int leftMax = Math.max(buildings[i - 1], buildings[i - 2]);
                int rightMax = Math.max(buildings[i + 1], buildings[i + 2]);
                int minView = Math.max(leftMax, rightMax);
				if (buildings[i] > minView) result += (buildings[i] - minView);
            }
            System.out.printf("#%d %d\n", test_case, result);
            

		}
	}
}