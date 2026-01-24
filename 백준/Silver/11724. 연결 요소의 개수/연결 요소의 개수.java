import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Integer>[] list;
    private static boolean[] visit;
    public static void main(String[] args) throws Exception { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        visit = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }
        
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                dfs(i);
                result++;
            }
        }

        System.out.println(result);
    }

    private static void dfs(int node) {
        visit[node] = true;
        for (int item : list[node]) {
            if (!visit[item]) {
                dfs(item);
            }
        }
    }
}