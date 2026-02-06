import java.util.Scanner;

public class Main {

    private static int n;
    private static int result = 0;
    private static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n];

        backtracking(0);

        System.out.println(result);
    }

    private static void backtracking(int row) {
        if (row == n) {
            result++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (check(row, col)) {
                arr[row] = col;
                backtracking(row + 1);
            }
        }
    }

    private static boolean check(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (arr[i] == col) return false;
            if (Math.abs(row - i) == Math.abs(col - arr[i])) return false;
        }
        return true;
    }
}