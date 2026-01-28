import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        
        arr = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int check = Integer.parseInt(input[0]);
            int a = Integer.parseInt(input[1]);
            int b = Integer.parseInt(input[2]);
            if (check == 0) union(a, b); 
            if (check == 1) {
                if (find(a) == find(b)) sb.append("yes\n");
                else sb.append("no\n");
            }
        }
        System.out.print(sb);
    }

    public static int find(int node) {
        if (node == arr[node]) return node;
        arr[node] = find(arr[node]);
        return arr[node];
    }
    
    public static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot) return;
        if (aRoot < bRoot) arr[bRoot] = aRoot;
        else arr[aRoot] = bRoot;
        return;
    }
}