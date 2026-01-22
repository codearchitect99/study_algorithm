import java.util.Scanner;
import java.util.ArrayDeque;

public class Main {
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

       int n = sc.nextInt();

       ArrayDeque<Integer> q = new ArrayDeque<>();

       for (int i = 1; i <= n; i++) q.offer(i);

       boolean isTrash = true;
       while (q.size() > 1) {
           if (isTrash) {
               q.poll();
           } else {
               q.offer(q.poll());
           }
           isTrash = !isTrash;
       }
       System.out.println(q.poll());
    }
}