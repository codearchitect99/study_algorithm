import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        boolean[] arr = new boolean[n + 1];
        arr[0] = arr[1] = true;
        for (int i = 2; i * i <= n; i++) {
            if (arr[i]) continue;
            int num = i * 2;
            while (num <= n) {
                arr[num] = true;
                num += i;
            }
        }
        for (int i = m; i <= n; i++) {
            if (!arr[i]) System.out.println(i);
        }

    }
}