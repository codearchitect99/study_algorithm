import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        int[] grades = new int[num];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < num; i++) {
            grades[i] = sc.nextInt();
            max = max < grades[i] ? grades[i] : max;
        }

        double result = 0;
        for (int i = 0; i < num; i++) {
            result += (double) grades[i] / max * 100.0;
        }

        System.out.println(result/num);
    }
}