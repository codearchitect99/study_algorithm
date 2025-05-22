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
            int count = 0;
            
            boolean[] isCalled = new boolean[10];
            
            long currentNumber = N;

            while (!isAll(isCalled)) {
                count++;
            	currentNumber = N * count;
                String str = String.valueOf(currentNumber);
                for (char c : str.toCharArray()) {
                	isCalled[Character.getNumericValue(c)] = true;
                }
            }
            System.out.printf("#%d %d", test_case, currentNumber);
            System.out.println();
           
		}
	}
    
    private static boolean isAll(boolean[] isCalled) {
        for (boolean b : isCalled) {
        	if (!b) return false;
        }
        return true;
    }
}