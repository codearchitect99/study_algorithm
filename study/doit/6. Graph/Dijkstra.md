## Dijkstra

최단 거리를 구하는 알고리즘

- 출발 노드와 모든 노드 간의 최단 거리 탐색
- 에지(가중치)는 모두 양수

시간복잡도: O(ElogV) (E: 엣지 수, V: 노드 수)

1. 거리 배열 dist[] 초기화
   - dist[start] = 0
   - dist[i] = Max (start를 제외한 노드)
   - visited[i] = false
2. 최소 거리 노드 선택
   - visited[i] == false && dist[i] 값이 가장 작은 current 노드 선택
3. 선택 노드 거리 확정
   - visited[current] = true
4. 노드 거리 갱신
   - current와 연결된 next 노드에 대해 거리(가중치) 값 갱신
5. 모든 노드가 확정될 때까지 반복

```java
// GPT
import java.util.*;
import java.io.*;

public class Main {

    // 인접 리스트에 저장할 간선 정보
    static class Edge {
        int to;       // 도착 노드
        int weight;   // 가중치(비용)

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    // 아직 도달 못한 상태를 의미하는 충분히 큰 값
    // dist[i]가 MAX라면 "start에서 i로 가는 경로를 아직 못 찾았다"는 뜻
    static final int MAX = Integer.MAX_VALUE;

    static ArrayList<Edge>[] graph; // graph[u] = u에서 나가는 간선들 목록
    static int[] dist;              // dist[i] = start -> i 최소 비용(현재까지 알려진 값)
    static boolean[] visited;       // visited[i] = i의 최단거리 확정 여부

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력 예시 형식(예):
        // N M
        // start
        // from to weight
        // ...
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());

        // 인접 리스트 초기화
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        // 간선 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[from].add(new Edge(to, weight));
        }

        // dist, visited 초기화
        dist = new int[N + 1];
        visited = new boolean[N + 1];

        // dist는 전부 MAX로 초기화 = 아직 경로 모름
        Arrays.fill(dist, MAX);

        // 시작 노드는 거리 0으로 확정 후보가 됨
        dist[start] = 0;

        // 다익스트라 실행
        dijkstra(start);

        // 결과 출력
        for (int i = 1; i <= N; i++) {
            if (dist[i] == MAX) System.out.println("INF");
            else System.out.println(dist[i]);
        }
    }

    private static void dijkstra(int start) {
        /*
          우선순위 큐에 넣는 값: {노드, 그 노드까지의 거리}
          여기서 핵심은 "거리(dist)가 더 작은 노드를 먼저 꺼내겠다"는 것.
          
          다익스트라는 항상 다음 노드를 이렇게 정한다:
          - 아직 확정(visited=false)되지 않은 노드들 중에서
          - dist가 가장 작은 노드를 골라서 확정한다.
          
          우선순위 큐는 그 '가장 작은 dist 노드'를 빨리 뽑기 위한 도구다.
        */
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[1] - b[1] // a[1]=거리, b[1]=거리 -> 오름차순(작은 거리 먼저)
        );

        // 시작 노드를 큐에 넣는다.
        // dist[start]=0 이니까 {start, 0}
        pq.offer(new int[]{start, 0});

        // 큐가 빌 때까지 진행
        while (!pq.isEmpty()) {

            /*
              1) 현재 큐에서 "거리 값이 가장 작은 후보"를 꺼낸다.
                 current = {node, distance}

              여기서 중요한 점:
              - pq에는 같은 node가 여러 번 들어갈 수 있다.
                예) dist[node]가 10이었다가, 나중에 5로 갱신되면 {node,5}도 들어감.
              - 그래서 "가장 최신/최선의 node"만 확정해야 한다.
            */
            int[] current = pq.poll();
            int node = current[0];
            int distance = current[1];

            /*
              2) visited[node]가 true면 이미 최단거리 확정된 노드다.
                 그럼 이 node는 더 볼 필요가 없다.
                 
                 왜 "더 볼 필요가 없나"?
                 - 다익스트라 전제(가중치 음수 없음) 때문에
                   visited로 확정된 node는 dist가 최단거리로 보장된다.
                 - 이미 확정된 뒤에 더 짧은 경로가 나올 수 없다.
                 
                 따라서 중복 후보(예: {node,10} vs {node,5}) 중
                 먼저 확정된(더 작은 거리로 확정된) 이후에 나오는 것들은 skip한다.
            */
            if (visited[node]) continue;

            /*
              3) 이제 이 node를 확정한다.
                 "현재 pq에서 뽑힌 node는 아직 확정되지 않았고,
                  그 중 가장 작은 distance를 가진 후보"이므로
                  dist[node]는 최단거리로 확정된다.
            */
            visited[node] = true;

            /*
              4) 확정된 node에서 나가는 간선을 이용해
                 이웃 노드들의 dist를 갱신(완화, relax)한다.
                 
                 핵심 갱신식:
                 dist[next] > dist[node] + weight  이면
                 dist[next] = dist[node] + weight
                 
                 이때 주의:
                 - dist[node]가 MAX이면 더하면 오버플로우 위험이 있지만,
                   다익스트라는 start에서 시작했고 pq에서 뽑힌 node는
                   실제로 도달 가능한 노드이므로 dist[node]는 MAX가 아니다.
            */
            for (Edge edge : graph[node]) {
                int next = edge.to;

                /*
                  dist[node]는 지금 확정된 최단거리.
                  next로 가는 새로운 후보 거리(newDist)를 계산한다.
                */
                int newDist = dist[node] + edge.weight;

                /*
                  5) 기존 dist[next]보다 더 짧은 경로를 찾았으면 갱신한다.
                     그리고 pq에 "next로 가는 더 좋은 후보"를 넣는다.
                     
                     여기서 pq에 넣는 이유:
                     - dist[next]가 갱신되었으니,
                       next가 "앞으로 확정될 후보" 목록에 올라가야 한다.
                     - pq는 후보들 중 dist가 가장 작은 것을 다음에 꺼내준다.
                */
                if (dist[next] > newDist) {
                    dist[next] = newDist;

                    // pq에는 갱신된 후보를 넣는다.
                    // 나중에 pq에서 next가 뽑히면, 그때 visited[next]를 확정한다.
                    pq.offer(new int[]{next, dist[next]});
                }
            }
        }
    }
}
```

