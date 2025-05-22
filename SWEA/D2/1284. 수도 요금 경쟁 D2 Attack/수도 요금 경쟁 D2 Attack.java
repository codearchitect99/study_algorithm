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
            int p = sc.nextInt();
            int q = sc.nextInt();
            int r = sc.nextInt();
            int s = sc.nextInt();
            int w = sc.nextInt();
            
            int a = w * p;
           	int b = (w <= r) ? q : q + (w - r) * s;
            
            System.out.printf("#%d %d\n", test_case, (a > b) ? b : a);
		}
	}
}