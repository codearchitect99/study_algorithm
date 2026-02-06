import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static int[] arr; // 노드 배열

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // n: 노드 수, m: 연산 수
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        
        // 초기화: 각 노드는 자기 자신이 대표
        arr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = i;
        }

      	// 연산
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int check = Integer.parseInt(input[0]);
            int a = Integer.parseInt(input[1]);
            int b = Integer.parseInt(input[2]);

            if (check == 0) {
                union(a, b);    // 두 집합 합치기
            }

            if (check == 1) {    // 같은 집합인지 확인
                if (find(a) == find(b)) sb.append("yes\n");
                else sb.append("no\n");
            }
        }
        System.out.print(sb);
    }

    // 대표 노드 찾기 (경로 압축)
    public static int find(int node) {
        if (node == arr[node]) return node;
        arr[node] = find(arr[node]);
        return arr[node];
    }
    
    // 두 집합 합치기
    public static void union(int a, int b) {
				a = find(a);
        b = find(b);
        if (a == b) return; // 이미 같은 집합
        // 대표 노드 번호가 작은 쪽을 대표로 사용
        if (a < b) arr[b] = a;
        else arr[a] = b;
    }
}