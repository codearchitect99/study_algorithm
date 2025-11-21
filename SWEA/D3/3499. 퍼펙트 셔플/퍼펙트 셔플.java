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
            
            int leftLength = n % 2 == 0 ? n / 2  : n / 2 + 1;

            String[] leftCards = new String[leftLength];
            String[] rightCards = new String[n - leftLength];

            String[] deck = new String[n];
            
            for (int i = 0; i < leftLength; i++) {
            	leftCards[i] = sc.next();
            }
            for (int i = 0; i < n - leftLength; i++) {
            	rightCards[i] = sc.next();
            }
            
            // left(even)
            int evenIdx = 0;
            for (String card : leftCards) {
            	deck[evenIdx] = card;
                evenIdx += 2;
            }
            
            // right(odd)
            int oddIdx = 1;
            for (String card : rightCards) {
            	deck[oddIdx] = card;
                oddIdx += 2;
            }
         
            System.out.printf("#%d", test_case);
            for (String card : deck) {
            	System.out.printf(" %s", card);
            }
            System.out.println();
		}
	}
}