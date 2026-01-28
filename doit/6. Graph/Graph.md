## Graph

그래프는 노드와 엣지로 구성된 집합

트리도 그래프의 일종이다.

그래프 구현 방법

- Edge List - 에지 리스트: 에지를 중심으로 그래프 표현
  - 가중치가 없는 에지 리스트
    - 배열에 [1, 2] 추가 -> 1에서 2로 가는 간선 추가
    - 출발 노드와 도착 노드로만 표현
  - 가중치가 있는 에지 리스트
    - 배열에 [1, 2, 3] 추가 -> 1에서 2로 가는 가중치 값이 3인 간선 추가
    - 출발 노드, 도착 노드, 가중치로 표현
- Adjacency Matrix - 인접 행렬: 2차원 배열을 자료구조로 이용하여 노드 중심으로 그래프 표현
  - 2차원 배열을 이용하여 표현하며 배열 값에 가중치가 들어감
    - `A[startNode][endNode]` = weight
    - 가중치가 없으면 1로 저장
  - 노드에 비해 에지 수가 적을 때, 공간 효율성이 떨어짐
  - 노드 개수가 많은 경우 2차원 배열 선언 자체를 할 수 없음
    - ex) 노드가 30,000개 이상이면 Java Heap Space 에러 발생
- Adjacency List - 인접 리스트: ArrayList로 노드 갯수만큼 그래프를 표현
  - 가중치가 없는 인접 리스트
    - ArrayList[1]에 [2, 3] 입력 -> 1번 노드를 2번, 3번 노드에 연결
  - 가중치가 있는 인접 리스트
    - ArrayList[1]에 Node{e: 2, v: 3}, Node{e: 3, v: 4}를 입력 -> 1번 노드를 가중치를 가진 2번, 3번 노드에 연결
  - 그래프 구현은 복잡하지만 에지 탐색 시간은 빠름
  - 노드 갯수가 커져도 공간 효율 좋음

이분 그래프

- 이분 그래프는 정점들을 두 그룹으로 나눌 수 있는 그래프이다.
- 모든 간선은 서로 다른 두 그룹의 정점을 연결해야 한다.
- 즉, 같은 그룹에 속한 정점끼리는 간선이 존재하지 않는다.
- ex) 그래프의 정점들을 두 가지 색으로 칠할 수 있으면 이분 그래프이다.

---

1707 - 이분 그래프

그래프의 정점의 집합을 둘로 분할하여, 각 집합에 속한 정점끼리는 서로 인접하지 않도록 분할할 수 있을 때, 그러한 그래프를 특별히 이분 그래프 (Bipartite Graph) 라 부른다.
그래프가 입력으로 주어졌을 때, 이 그래프가 이분 그래프인지 아닌지 판별하는 프로그램을 작성하시오.

입력
입력은 여러 개의 테스트 케이스로 구성되어 있는데, 첫째 줄에 테스트 케이스의 개수 K가 주어진다. 각 테스트 케이스의 첫째 줄에는 그래프의 정점의 개수 V와 간선의 개수 E가 빈 칸을 사이에 두고 순서대로 주어진다. 각 정점에는 1부터 V까지 차례로 번호가 붙어 있다. 이어서 둘째 줄부터 E개의 줄에 걸쳐 간선에 대한 정보가 주어지는데, 각 줄에 인접한 두 정점의 번호 u, v (u ≠ v)가 빈 칸을 사이에 두고 주어진다. 

출력
K개의 줄에 걸쳐 입력으로 주어진 그래프가 이분 그래프이면 YES, 아니면 NO를 순서대로 출력한다.

```java
// doit + me
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    private static boolean result;    // 이분 그래프 여부 결과 (true면 YES, false면 NO)

    // 방문 + 그룹(색) 정보
    // 0 : 미방문
    // 1, 2 : 서로 다른 두 그룹(색)
    private static int[] visited;    
  
    // 인접 리스트
    // nodes[x]에는 x와 연결된 모든 정점 번호가 저장됨
    private static ArrayList<Integer>[] nodes;    
  
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int i = 0; i < k; i++) {
            String[] input = br.readLine().split(" ");
            int v = Integer.parseInt(input[0]);    // 정점(노드) 개수
            int e = Integer.parseInt(input[1]);    // 간선(엣지) 개수

            nodes = new ArrayList[v + 1];          // 인접 리스트 초기화
            visited = new int[v + 1];              // 방문/색 배열 초기화

            for (int j = 1; j <= v; j++) {
                nodes[j] = new ArrayList<>();
            }

            // 간선 입력 (무방향 그래프이므로 양쪽에 모두 추가)
            for (int j = 0; j < e; j++) {
                input = br.readLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                nodes[start].add(end);
                nodes[end].add(start);
            }
          
            result = true; // 처음에는 이분 그래프라고 가정

            // 그래프가 여러 컴포넌트로 나뉠 수 있으므로
            // 모든 정점에 대해 DFS를 시작(미방문 정점에서만)
            for (int j = 1; j <= v; j++) {
                if (!result) break;           // 하나라도 틀리면 더 진행할 필요 없음
                if (visited[j] == 0) dfs(j);  // 미방문 정점에서만 DFS 시작
            }

            System.out.println(result ? "YES" : "NO");
        }
    }
    
    // DFS로 그래프를 탐색하면서 정점을 1/2 두 그룹(색)으로 나눔
    public static void dfs(int node) {
        // DFS 시작 정점이 미방문이면 1번 그룹(색)으로 지정
        if (visited[node] == 0) visited[node] = 1;
      
        // 현재 node와 연결된 모든 인접 정점 검사
        for (int next : nodes[node]) {
            // 인접 정점이 미방문이면: 현재와 반대 그룹(색)으로 지정 후 DFS 진행
            if (visited[next] == 0) {
                visited[next] = (visited[node] == 1) ? 2 : 1;
                dfs(next);
            }
            // 인접 정점이 이미 방문되었는데 같은 그룹(색)이라면 이분 그래프 불가능
            else if (visited[next] == visited[node]) {
                result = false;
                return;
            }
        }
    }
}
```