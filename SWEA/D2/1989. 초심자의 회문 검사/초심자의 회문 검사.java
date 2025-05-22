import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        sc.nextLine();

		for(int test_case = 1; test_case <= T; test_case++)
		{
        	String str = sc.nextLine();
            boolean result = true;
            for (int i = 0; i < str.length() / 2; i++) {
            	if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                	result = false;
                    break;
                }
            }
            System.out.printf("#%d %d \n", test_case, result ? 1 : 0);
        }
	}
}