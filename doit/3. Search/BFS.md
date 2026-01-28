## BFS

그래프 완전 탐색 기법 중 하나

시작 노드에서 출발 해 시작 노드를 기준으로 가까운 노드를 먼저 방문하면서 탐색
-> 목표 노드에 도착하는 경로가 여러개 일 때, 최단 경로 보장

- 그래프 완전 탐색
- FIFO 탐색
- Queue 자료구조 이용

시간복잡도: O(V + E) (V: 노드 수, E: 에지 수)

---

2178 - 미로 탐색

N×M크기의 배열로 표현되는 미로가 있다.

| 1    | 0    | 1    | 1    | 1    | 1    |
| ---- | ---- | ---- | ---- | ---- | ---- |
| 1    | 0    | 1    | 0    | 1    | 0    |
| 1    | 0    | 1    | 0    | 1    | 1    |
| 1    | 1    | 1    | 0    | 1    | 1    |

미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오. 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.
위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.

입력
첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 **붙어서** 입력으로 주어진다.

출력
첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayDeque;

public class Main {
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static boolean[][] visited;
    private static int[][] board;
    private static int n, m;
  
    public static void main(String[] args) throws Exception {
      	// 값 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = input.charAt(j) - '0';
            }
        }

        visited = new boolean[n][m];    // 이마 방문한 노드인지 확인 용도
        
      	bfs(0, 0);

        System.out.println(board[n - 1][m - 1]);
    }

    private static void bfs(int r, int c) {
      	// (0, 0) 시작
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c});
        visited[r][c] = true;
				
        while(!q.isEmpty()) {
          	// q에서 꺼낸 현재 값
            int[] current = q.poll();
            int currentR = current[0];
            int currentC = current[1];
						
          	// 현재 값에서 (상, 하, 좌, 우) 확인 후 가능한 위치에 값 더하기
            for (int d = 0; d < 4; d++) {
              	// 다음 위치 값
                int nextR = currentR + dr[d];
                int nextC = currentC + dc[d];

              	// (상, 하, 좌, 우) 에서 갈 수 없는 값인 경우 다음 진행
                if (nextR >= n || nextC >= m || nextR < 0 || nextC < 0) continue;
                if (visited[nextR][nextC]) continue;
                if (board[nextR][nextC] == 0) continue;

              	// 다음 값에 현재 값에 1을 더한 값 추가
                board[nextR][nextC] = board[currentR][currentC] + 1;
                visited[nextR][nextC] = true;    // 다음 값에 값을 추가했으니 방문했다고 표현
                q.offer(new int[]{nextR, nextC});    // 다음 값을 큐에 추가

            }
        }

    }
}
```

