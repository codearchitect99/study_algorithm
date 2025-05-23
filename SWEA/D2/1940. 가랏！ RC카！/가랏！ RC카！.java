
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
            
            int currentV = 0;
            int d = 0;
            for (int i = 0; i < n; i++) {
				int a = sc.nextInt();
                int b = 0;
                if (a != 0) b = sc.nextInt();
                
                a = (a ==2) ? -1 : a;
                
                currentV += a * b;
                if (currentV < 0) currentV = 0;
                d += currentV;
            }
            System.out.printf("#%d %d\n", test_case, d);

		}
	}
}