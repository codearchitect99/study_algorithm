import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            String str = String.valueOf(i);
            int count = 0;
            for (char c : str.toCharArray()) {
                if (c == '3' || c == '6' || c == '9') count++;
            }
            if (count == 0) System.out.print(i);
            else {
                for (int k = 0; k < count; k++) System.out.print('-');
            }
            if (i != N) System.out.print(" ");
        }
        System.out.println();
    }
}