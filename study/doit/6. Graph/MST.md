## MST

Minimum Spanning Tree 최소 신장 트리: 그래프에서 모든 노드를 연결할 때, 사용된 에지들의 가중치의 합을 최소로 하는 트리

모든 노드를 사이클이 돌지 않게 하나로 연결하돼 가중치가 최소여야함

- 사이클이 포함되면 가중치의 합이 최소가 될 수 없다.
- N개의 노드가 있으면 MST를 구성하는 에지 개수는 항상 N - 1개

| **구분** | **Kruskal** | **Prim**      |
| -------- | ----------- | ------------- |
| 관점     | 간선 중심   | 노드 중심     |
| 시작     | 전체 간선   | 한 노드       |
| 자료구조 | Union-Find  | PriorityQueue |
| 적합     | 간선 적음   | 간선 많음     |

Kruskal 알고리즘 이용

1. 모든 간선(edges)을 가중치(cost) 오름차순으로 정렬

2. 가중치가 가장 작은 간선(Edge e)부터 하나씩 확인

   - 정렬된 edges를 앞에서부터 순서대로 순회한다.

3. 간선 e(u, v)를 선택했을 때 사이클이 생기지 않으면 선택

   - find(u)와 find(v)를 비교한다.

   1. Union-Find를 이용하여 노드 u와 v를 하나의 집합으로 합친다
      - union(u, v) 실행
      - 이때 parent[] 배열에서 대표 노드가 갱신된다.
   2. 이미 u와 v의 대표 노드가 같다면 `if (find(u) == find(v))`
      - 이미 같은 집합에 속해 있으므로 이 간선을 추가하면 사이클이 발생하여 선택x

4. 선택된 간선 수(edgeCount)가 N - 1개가 되면 종료

   - MST는 노드 수 N일 때 간선 수가 항상 N - 1
   - edgeCount == N - 1이면 알고리즘 종료

```java
// GPT
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    /*
     * 간선 정보를 담는 클래스
     * Kruskal은 "간선 중심" 알고리즘이므로
     * 모든 간선을 객체로 관리하는 것이 자연스럽다.
     */
    static class Edge implements Comparable<Edge> {
        int u;      // 간선의 한쪽 노드
        int v;      // 간선의 다른쪽 노드
        int cost;   // 간선 가중치

        Edge(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }

        /*
         * 간선 정렬 기준
         * 가중치가 작은 간선부터 선택해야 하므로
         * 오름차순 정렬을 정의한다.
         */
        @Override
        public int compareTo(Edge other) {
            return this.cost - other.cost;
        }
    }

    static int N, M;               // 노드 수, 간선 수
    static int[] parent;           // Union-Find 부모 배열
    static ArrayList<Edge> edges = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 전체 노드 수
        M = Integer.parseInt(st.nextToken()); // 전체 간선 수

        /*
         * Union-Find 초기화
         * 처음에는 모든 노드가 자기 자신을 대표로 가진다.
         * 즉, 모든 노드는 서로 다른 집합이다.
         */
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        /*
         * 간선 입력
         * Kruskal은 그래프 구조보다
         * "모든 간선의 목록"이 핵심이므로
         * 인접 리스트가 필요 없다.
         */
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges.add(new Edge(u, v, cost));
        }

        /*
         * 1단계: 간선 정렬
         * 가장 비용이 작은 간선부터 확인하기 위함
         */
        Collections.sort(edges);

        int mstCost = 0;   // MST 전체 비용
        int edgeCount = 0; // 현재까지 선택된 간선 수

        /*
         * 2단계: 간선을 하나씩 확인하며 MST 구성
         */
        for (Edge e : edges) {

            /*
             * 두 노드의 대표가 다르면
             * 현재 간선을 선택해도 사이클이 생기지 않는다.
             */
            if (find(e.u) != find(e.v)) {

                // 두 집합을 하나로 합친다.
                union(e.u, e.v);

                // MST 비용에 현재 간선 비용 추가
                mstCost += e.cost;

                // 선택된 간선 수 증가
                edgeCount++;

                /*
                 * MST는 항상 간선이 N-1개이면 완성된다.
                 * 더 볼 필요 없이 종료한다.
                 */
                if (edgeCount == N - 1) break;
            }
            /*
             * 대표가 같다면 이미 연결된 집합이므로
             * 이 간선을 선택하면 사이클이 발생한다.
             * 따라서 해당 간선은 버린다.
             */
        }

        System.out.println(mstCost);
    }

    /*
     * 대표 노드 찾기 (Find)
     * 경로 압축을 사용하여
     * 이후 탐색을 빠르게 만든다.
     */
    static int find(int x) {
        if (parent[x] == x) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }

    /*
     * 두 집합 합치기 (Union)
     * 두 대표 노드 중 하나를
     * 다른 쪽의 부모로 설정한다.
     */
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
    }
        }
}
```

