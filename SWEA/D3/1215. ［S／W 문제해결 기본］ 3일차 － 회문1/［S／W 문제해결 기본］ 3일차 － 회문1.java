import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static char[][] board = new char[8][8];
    static int n;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		for(int test_case = 1; test_case <= 10; test_case++)
		{
            n = sc.nextInt();
            
            for (int i = 0; i < 8; i++) {
                String input = sc.next();
            	for (int j = 0; j < 8; j++) {
                	board[i][j] = input.charAt(j);
                }
            }
            
            int result = 0;
            for (int i = 0; i < 8; i++) {
            	for (int j = 0; j < 8; j++) {
                	if (i < 8 - n + 1) {
                    	if (checkColumn(i, j)) result++;
                    }
                    if (j < 8 - n + 1) {
                    	if (checkRow(i, j)) result ++;
                    }
                }
            }
            System.out.printf("#%d %d\n", test_case, result);
		}
	}
    
    static boolean checkRow(int i, int j) {
        int leftIdx = j;
        int rightIdx = j + n - 1;
        while (leftIdx < rightIdx) {
        	if (board[i][leftIdx] != board[i][rightIdx]) return false;
            leftIdx++;
            rightIdx--;
        }
        return true;
    }
    
    static boolean checkColumn(int i, int j) {
        int topIdx = i;
        int bottomIdx = i + n - 1;
        while (topIdx < bottomIdx) {
        	if (board[topIdx][j] != board[bottomIdx][j]) return false;
            topIdx++;
            bottomIdx--;
        }
        return true;
    }
}