import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
            int n = sc.nextInt();
            int[][] ladder = new int[100][100];
            
            int X = 0;
            for (int y = 0; y < 100; y++) {
            	for (int x = 0; x < 100; x++) {
                    int input = sc.nextInt();
                    if (input == 2) X = x;
                	ladder[x][y] = input;
                }
            }
            
            for (int i = 99; i >= 0; i--) {
                if (X >= 1 && ladder[X - 1][i] == 1) {
                	while (X >= 1 && ladder[X - 1][i] == 1) {
                    	X--;
	                }
                    continue;
                }
                if (X <= 98 && ladder[X + 1][i] == 1) {
                	while (X <= 98 && ladder[X + 1][i] == 1) {
                    	X++;
	                }
                    continue;
                }
            }
            
            /////
            System.out.printf("#%d %d\n", n, X);
		}
	}
}