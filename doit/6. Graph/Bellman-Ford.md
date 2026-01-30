## Bellman-Ford

최단 거리를 구하는 알고리즘

- 특정 출발 노드에서 다른 모든 노드까지의 최단 경로 탐색
- 음수 가중치 에지가 있어도 수행 가능
- 전체 그래프에서 음수 사이클의 존재 여부 판단 가능
- 에지를 중심으로 동작
- 업데이트 반복 횟수 = 노드 개수 - 1
  - 출발점에서 도착점까지 가는 최단 거리를 위한 최대 에지 수를 의미

- 다익스트라보다 효율이 좋지 않아서 음수 사이클 존재 확인 용도로 주로 사용

시간복잡도: O(VE) (V: 노드 수, E: 에지 수)

1. 초기화
   - dist[start] = 0, dist[나머지 노드] = Max
2. 거리 갱신(N - 1회)
   - 전체 간선 확인을 N - 1회 반복
   - dist[u] + w < dist[v] -> dist[v] = dist[u] + w
3. N 번째 확인은 음수 사이클 확인
   - dist[] 값이 하나라도 줄어들 수 있으면 음수사이클

```java
// java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {

    // 간선 정보 저장용 클래스
    static class Edge {
        int from;    // 출발 노드
        int to;      // 도착 노드
        int weight;  // 가중치

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    static final int MAX = Integer.MAX_VALUE; // 무한대 역할
    static int N, M;                          // 노드 수, 간선 수
    static ArrayList<Edge> edges = new ArrayList<>();
    static long[] dist;                       // 각 노드까지의 최단 거리

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 노드 수
        M = Integer.parseInt(st.nextToken()); // 간선 수

        dist = new long[N + 1];

        // 거리 배열 초기화
        // 시작 노드를 제외한 모든 노드는 아직 도달 불가 상태
        for (int i = 1; i <= N; i++) {
            dist[i] = MAX;
        }
        dist[1] = 0; // 시작 노드의 거리는 0 (아무 것도 안 간 상태)

        // 간선 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges.add(new Edge(from, to, weight));
        }

        // 거리 갱신 단계 (N-1회)
        // 의미: 간선 1개 → 2개 → ... → N-1개까지 사용하는 모든 경로 고려
        for (int i = 1; i <= N - 1; i++) {
            for (Edge e : edges) {

                // 출발 노드에 아직 도달하지 못했다면 건너뜀
                if (dist[e.from] == MAX) continue;

                // 현재 경로가 더 짧다면 거리 갱신
                if (dist[e.from] + e.weight < dist[e.to]) {
                    dist[e.to] = dist[e.from] + e.weight;
                }
            }
        }

        // 음수 사이클 확인
        // N번째에도 거리가 줄어든다면 음수 사이클 존재
        boolean hasNegativeCycle = false;
        for (Edge e : edges) {
            if (dist[e.from] == MAX) continue;

            if (dist[e.from] + e.weight < dist[e.to]) {
                hasNegativeCycle = true;
                break;
            }
        }

        // 결과 출력
        if (hasNegativeCycle) {
            System.out.println("Negative Cycle Exists");
        } else {
            for (int i = 1; i <= N; i++) {
                if (dist[i] == MAX) {
                    System.out.println("INF"); // 도달 불가
                } else {
                    System.out.println(dist[i]);
                }
            }
        }
    }
}
```

