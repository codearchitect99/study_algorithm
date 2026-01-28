import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    private static boolean result;
    private static int[] visited;
    private static ArrayList<Integer>[] nodes;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            String[] input = br.readLine().split(" ");
            int v = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            nodes = new ArrayList[v + 1];
            visited = new int[v + 1];
            for (int j = 1; j <= v; j++) {
                nodes[j] = new ArrayList<>();
            }
            for (int j = 0; j < e; j++) {
                input = br.readLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                nodes[start].add(end);
                nodes[end].add(start);
            }
            result = true;
            for (int j = 1; j <= v; j++) {
                dfs(j);
            }
            if (result) System.out.println("YES");
            else System.out.println("NO");
        }
    }
    
    public static void dfs(int node) {
        if (visited[node] == 0) visited[node] = 1;
        for (int i : nodes[node]) {
            if (visited[i] == 0) {
                visited[i] = visited[node] == 1 ? 2 : 1;
                dfs(i);
            }
            else if (visited[i] == visited[node]) {
                result = false;
                return;
            } 
        }
    }
}