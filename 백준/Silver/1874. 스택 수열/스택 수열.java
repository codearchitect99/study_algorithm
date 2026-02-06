import java.util.Scanner;
import java.util.Stack;

public class Main {
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        
        StringBuilder sb = new StringBuilder();

        int num = 1;

        for (int i = 0; i < n; i++) {
            while (nums[i] >= num) {
                stack.push(num++);
                sb.append("+\n");
            }
            if (!stack.isEmpty() && stack.peek() == nums[i]) {
                stack.pop();
                sb.append("-\n");
            }
            else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb);
    }
}