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

        int base64[] = new int[128];
        for (int i = 0; i < 26; i++) base64['A' + i] = i;
        for (int i = 0; i < 26; i++) base64['a' + i] = i + 26;
        for (int i = 0; i < 10; i++) base64['0' + i] = i + 52;
        base64['+'] = 62;
        base64['/'] = 63;
        
		for(int test_case = 1; test_case <= T; test_case++)
		{          
            String encoded = sc.nextLine();
            String result = "";
            for (int i = 0; i < encoded.length(); i += 4) {
                int a = base64[encoded.charAt(i)];
                int b = base64[encoded.charAt(i + 1)];
                int c = base64[encoded.charAt(i + 2)];
                int d = base64[encoded.charAt(i + 3)];
				
				int num = a << 18 | b << 12 | c << 6 | d;
    
				int first = num >> 16 & 0xff;
                int second = num >> 8 & 0xff;
                int third = num & 0xff;

				result += (char) first;
				result += (char) second;
				result += (char) third;               
             }
            System.out.printf("#%d %s", test_case, result);
            System.out.println();
		}
	}
}