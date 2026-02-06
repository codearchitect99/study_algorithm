import java.util.Scanner;

public class Main {
    private static int n, m;
    private static boolean[] visited;
    private static int[] picked;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        visited = new boolean[n + 1];
        picked = new int[m];

        dfs(0);

        System.out.print(sb);
    }

    private static void dfs(int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(picked[i]).append(" ");
            }
            sb.append("\n");
            return;
        } 
        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            picked[depth] = i;
            dfs(depth + 1);
            visited[i] = false;
        }
    }
}