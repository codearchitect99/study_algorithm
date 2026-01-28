## DFS

그래프 완전 탐색 기법 중 하나

그래프의 시작 노드에서 출발하여 탐색할 한 쪽 분기를 정하여 최대 깊이까지 탐색을 마친 후 다른 쪽 분기로 이동하여 다시 탐색

- 그래프 완전 탐색
- 재귀함수로 구현 -> 스택오버플로 유의
- 스택 자료구조 이용 -> 스택 성질을 갖는 재귀함수로 주로 구현

시간복잡도: O(V + E) (V: 노드 수, E: 에지 수)

---

11724 - 연결 요소의 개수

방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. (1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.

출력
첫째 줄에 연결 요소의 개수를 출력한다.

```java
// doit
// * 각 노드 번호별 연결 노드 번호 값들이 들어갈 수 있는 ArrayList 배열 사용
// * 각 노드 방문 여부를 확인하기 위해 boolean 배열 사용
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Integer>[] list;    // 노드 번호 별 연결 노드 번호 값들 저장
    private static boolean[] visit;    // 노드 번호 별 방문 여부 확인 용도
    public static void main(String[] args) throws Exception { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

      	// n, m 값 입력 받기
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
				
      	// ArrayList 배열 초기화 -> 안하면 오류 발생
        list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
      	
      	// 노드 번호 별 방문 여부 확인 boolean 배열 선언 및 초기화
        visit = new boolean[n + 1];
      
      	// u, v 값 입력받고 ArrayList 배열에 값 추가
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
          	// 방향이 없는 Graph(즉, 양방향 그래프) -> 각각 서로 추가
            list[u].add(v);
            list[v].add(u);
        }
      
        int result = 0;    // 결과값 변수 선언 및 초기화  
      
      	// dfs 실행
        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                dfs(i);
                result++;
            }
        }
        System.out.println(result);    // 결과 출력
    }

  	// dfs 함수 선언
    private static void dfs(int node) {
        visit[node] = true;
        for (int item : list[node]) {
            if (!visit[item]) {
                dfs(item);
            }
        }
    }
}
```

Q: dfs가 dfs를 계속 무한 반복으로 실행될 수도 있지 않을까??
A: visit[item]이 true인 경우 dfs 실행 멈춤