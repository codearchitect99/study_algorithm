import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[][] c = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            c[i][i] = 1;
            c[i][0] = 1;
        }
        
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                c[i][j] = c[i-1][j-1] + c[i-1][j];
            }
        }
        System.out.println(c[n][k]);

    }
}