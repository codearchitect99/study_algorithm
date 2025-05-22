import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

         int[] lastDays = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int preMonth = sc.nextInt();
            int preDate = sc.nextInt();
            int postMonth = sc.nextInt();
            int postDate = sc.nextInt();
            
            int result = 1;
            while (preMonth != postMonth || preDate != postDate) {
            	preDate++;
                if (preDate > lastDays[preMonth]) {
                    preMonth ++;
                    if (preMonth == 13) preMonth = 1;
                    preDate = 1;
                }
                result++;
            } 
            System.out.printf("#%d %d\n", test_case, result);
		}
	}
}