## Floyd-Warshall

최단 거리를 구하는 알고리즘

A에서 B까지 가는 경로 사이에 K가 있다에서 나온 알고리즘

- 모든 노드 간에 최단 경로 탐색
- 음수 가중치가 있어도 수행 가능
- 동적 계획법의 원리를 이용하여 알고리즘에 접근
- 인접 행렬 이용

시간복잡도: O(V³) (V: 노드 수)

1. 거리 배열 `dist[i][j]` 초기화
   - i == j → 0
   - 간선 있으면 가중치
   - 없으면 MAX
2. 중간 노드 k를 1부터 N까지 선택
3. 모든 (i, j)에 대해: `dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])`

```java
// GPT
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int MAX = Integer.MAX; // 충분히 큰 값 (무한대 역할)
    static int N, M;
    static int[][] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 노드 수
        M = Integer.parseInt(st.nextToken()); // 간선 수

        dist = new int[N + 1][N + 1];

        // 거리 배열 초기화
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) dist[i][j] = 0;   // 자기 자신 → 0
                else dist[i][j] = MAX;       // 아직 경로 없음
            }
        }

        // 간선 입력 (여러 간선이 있을 수 있으므로 min 처리)
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            dist[from][to] = Math.min(dist[from][to], weight);
        }

        // Floyd–Warshall 핵심 로직
        // k: 중간 노드
        // i: 출발 노드
        // j: 도착 노드
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (dist[i][k] == MAX || dist[k][j] == MAX) continue;
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // 결과 출력
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (dist[i][j] == MAX) System.out.print("INF ");
                else System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
}
```

