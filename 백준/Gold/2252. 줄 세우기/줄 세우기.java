import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.ArrayDeque;

public class Main {
    private static ArrayDeque<Integer> q = new ArrayDeque<>();
    private static StringBuilder sb = new StringBuilder();
    private static int n;
    private static int m;
    private static ArrayList<Integer>[] edges;
    private static int[] counts;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        edges = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }
        counts = new int[n + 1];
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int front = Integer.parseInt(input[0]);
            int back = Integer.parseInt(input[1]);
            edges[front].add(back);
            counts[back]++;
        }

        for (int i = 1; i <= n; i++) {
            if (counts[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int current = q.poll();
            sb.append(current).append(" ");
            for (int i : edges[current]) {
                counts[i]--;
                if (counts[i] == 0) q.offer(i);
            }
        }

        System.out.println(sb);
    }
}