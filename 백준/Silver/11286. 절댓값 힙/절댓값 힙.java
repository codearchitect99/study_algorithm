import java.util.Scanner;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> {
            int absA = Math.abs(a);
            int absB = Math.abs(b);
            if (absA == absB) return a - b;
            return absA - absB;
        });

        for (int i = 0; i < n; i++) {
            int input = sc.nextInt();
            if (input != 0) {
                q.offer(input);
            }
            else {
                if (q.isEmpty()) System.out.println(0);
                else System.out.println(q.poll());
            }
        }
    }
}