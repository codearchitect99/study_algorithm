import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int A;
        int B;
		A=sc.nextInt();
        B=sc.nextInt();
        int n = A - B;
        if ( n*n== 4) {
        	if (A > B) System.out.println('B');
            else System.out.println('A');
        }
        if (A > B) System.out.println('A'); 
        else System.out.println('B');
	}
}