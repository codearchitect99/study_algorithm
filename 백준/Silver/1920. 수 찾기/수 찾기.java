import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();

        Arrays.sort(a);

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int num = sc.nextInt();
            int result = 0;
            int start = 0;
            int end = n - 1;
            while (start <= end) {
               int mid = (start + end) / 2;
                if (a[mid] == num) {
                    result = 1;
                    break;
                }
                else if (a[mid] > num) {
                    end = mid - 1;
                }
                else if (a[mid] < num) {
                    start = mid + 1;
                }
            }
            System.out.println(result);
        }
    }
}