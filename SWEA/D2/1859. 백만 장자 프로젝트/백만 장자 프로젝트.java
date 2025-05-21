import java.util.*;
import java.io.*;
class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T=Integer.parseInt(br.readLine());
        	
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
			int[] nums = new int[N];
            for (int i = 0; i < N; i ++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }
            
            int max = nums[N - 1];
            long result = 0;
            for (int i = N - 2; i >=0; i--) {
            	if (max < nums[i]) max = nums[i];
                else result += max - nums[i];
            }
            System.out.printf("#%d %d", test_case, result);
            System.out.println();
		}
	}
}