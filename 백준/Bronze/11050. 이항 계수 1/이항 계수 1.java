import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int p = factorial(n - k) * factorial(k);
        int c = factorial(n);
        System.out.println(c/p);
    }

    public static int factorial(int n) {
        if (n == 0) return 1;
        for (int i = n - 1; i >= 1; i--) {
            n *= i;
        }
        return n;
    }
}