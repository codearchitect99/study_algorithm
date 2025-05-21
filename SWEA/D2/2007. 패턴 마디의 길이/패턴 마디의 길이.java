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
            int count = 0;
            for (int len = 1; len <= 10; len++) {
            	String pattern = str.substring(0, len);
                boolean isRepeat = true;
                for (int i = 0; i + len < str.length(); i += len) {
                	if (!pattern.equals(str.substring(i, i + len))) {
                    	isRepeat = false;
                        break;
                    }
                }
                if (isRepeat) {
                	count = len;
                    break;
                }
            }
            System.out.printf("#%d %d", test_case, count);
            System.out.println();
		}
	}
}