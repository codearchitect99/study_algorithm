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
            String input = sc.next();
            int result = 0;
            for (int i = 0; i < input.length() - 1; i++) {
                if (input.charAt(i) == '.') continue;
                if (input.charAt(i) == '(') {
                    if( input.charAt(i + 1) == '|' || input.charAt(i + 1) == ')') {
                        result++;
                        continue;
                    }
                }
                if (input.charAt(i) == '|' && input.charAt(i + 1) == ')') {
                    result ++;
                    continue;
                }
            }
            System.out.printf("#%d %d\n", test_case, result);
        }
    }
}