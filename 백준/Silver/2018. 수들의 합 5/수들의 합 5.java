import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        
        long start = 1;
        long end = 1;
        long sum = 1;
        int result = 0;
        
        while (start <= n) {
            if (sum < n) {
                end++;
                sum += end;
            }
            else if (sum == n) {
                result++;
                sum -= start;
                start++;
            }
            else if (sum > n) {
                sum -= start;
                start++;
            }
        }
        System.out.println(result);
    }
}