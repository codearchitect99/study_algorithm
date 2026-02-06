import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long m = sc.nextLong();

        long[] nums = new long[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextLong();
        }
        
        Arrays.sort(nums);

        int start = 0;
        int end = n-1;

        long result = 0;
        while (start < end) {
            long sum = nums[start] + nums[end];
            if (sum < m) start++;
            else if (sum == m) {
                result++;
                start++;
                end--;
            }
            else if (sum > m) end--; 
        }
        System.out.println(result);
    }
}