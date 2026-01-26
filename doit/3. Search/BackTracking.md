## BackTracking

문제를 해결할 수 있는 모든 경로를 탐색하면서 선택한 경로가 유효하지 않거나 조건에 만족하는 해를 찾지 못한 경우, 이전 단계로 되돌아가 다른 경로를 시도

- 문제를 해결할 수 있는 모든 경로 탐색
- 재귀함수로 구현
  - DFS: 노드를 방문 후 true
  - BackTracking: 노드를 방문 후 true, 다시 되돌아오며 false

- 가지치기로 성능 향상
  - 유효하지 않은 경로를 조기에 배제하여 탐색 -> 성능 향상
- DFS 개념과 유사
  - DFS: 모든 노드를 탐색
  - BackTracking: 가지치기로 필요없는 탐색 배제

시간복잡도: O(nᵈ) (n: 분기수, d: 탐색 깊이)

---

15648 - N과 M (1)

자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

- 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열

입력

첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

출력

한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

수열은 사전 순으로 증가하는 순서로 출력해야 한다.

```java
import java.util.Scanner;

public class Main {
    private static int n, m;
    private static boolean[] visited;
    private static int[] picked;
    private static StringBuilder sb = new StringBuilder();
  
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        visited = new boolean[n + 1];    // 숫자 방문 여부 확인 배열
        picked = new int[m];    // m개 수열이 들어갈 배열

      	// picked에 들어갈 0번째 값부터 시작
        dfs(0);

      	// 출력
        System.out.print(sb);
    }

    private static void dfs(int depth) {
        if (depth == m) {    // m 크기만큼 depth가 찼으면 결과값 생성 후 리턴
            for (int i = 0; i < m; i++) {
                sb.append(picked[i]).append(" ");
            }
            sb.append("\n");
            return;
        } 
        for (int i = 1; i <= n; i++) {
            if (visited[i]) continue;    // 이미 사용한 숫자는 중복이 안됨으로 건너뛰기
            visited[i] = true;
            picked[depth] = i;    // depth 인덱스에 값 입력
            dfs(depth + 1);    // 다음 depth에 들어갈 값을 구하기
            visited[i] = false;    // 다시 돌아와서 숫자 미사용 처리
        }
    }
}
```

---

9663 - N-Queen

N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.

N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.

입력

첫째 줄에 N이 주어진다. (1 ≤ N < 15)

출력

첫째 줄에 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력한다.

```java
import java.util.Scanner;

public class Main {

    // 체스판 크기 (N x N)
    private static int n;

    // arr[row] = col
    // row번째 행에 col번째 열에 퀸을 놓았다는 의미
    private static int[] arr;

    // 가능한 경우의 수
    private static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N 입력
        n = sc.nextInt();

        // 각 행의 퀸 위치를 저장할 배열
        arr = new int[n];

        // 0번째 행부터 퀸 배치 시작
        backtracking(0);

        // 결과 출력
        System.out.println(result);
    }

    // row: 현재 퀸을 놓을 행 번호
    private static void backtracking(int row) {

        // 종료 조건:
        // 0 ~ n-1 행까지 모두 퀸을 성공적으로 배치한 경우
        if (row == n) {
            result++;   // 경우의 수 1 증가
            return;
        }

        // 현재 row에 대해 모든 열(col)을 하나씩 시도
        for (int col = 0; col < n; col++) {

          	// doit ------------------------------
            // row행, col열에 퀸을 놓아본다
            // arr[row] = col;
						//
            // 이전에 놓은 퀸들과 충돌하지 않으면 다음 행으로 진행
            // if (check(row)) {
            //     backtracking(row + 1);
            // }
          	// me ------------------------------
          	if (check(row, col)) {
              	arr[row] = col;
              	backtracking(row + 1);
            }
          	// ------------------------------
            // 충돌하면 자동으로 다음 col로 넘어감 (가지치기)
        }
    }

    // doit ------------------------------
  	// row행에 놓은 퀸이 이전 퀸들과 충돌하는지 검사
    // private static boolean check(int row) {
		//
    //     // 0행부터 row-1행까지 검사
    //     for (int i = 0; i < row; i++) {
		//
    //         // 같은 열에 퀸이 있는 경우
    //         if (arr[i] == arr[row]) {
    //             return false;
    //         }
		//
    //         // 대각선에 퀸이 있는 경우
    //         // (열 차이 == 행 차이)
    //         if (Math.abs(arr[row] - arr[i]) == Math.abs(row - i)) {
    //             return false;
    //         }
    //     }
		// 
    //     // 모든 검사 통과 → 안전한 위치
    //     return true;
    // }
  	// me ------------------------------
  	private static boolean check(int row, int col) {
				for (int i = 0; i < row; i++) {
          	if (arr[row] == col) return false;
          	if (Math.abs(row - i) == Math.abs(arr[row] - col)) return false;
        }
      	return true;
    }
}
```

퀸은 일직선 공격과 대각선 공격이 있다.

일직선 공격은 같은 행 또는 같은 열에 하나의 퀸만 놓을 수 있다. -> 즉, 2차원 배열 사용은 오버스택이다. -> 1차원 배열로 충분하다.

---

17136 - 색종이 붙이기

<그림 1>과 같이 정사각형 모양을 한 다섯 종류의 색종이가 있다. 색종이의 크기는 1×1, 2×2, 3×3, 4×4, 5×5로 총 다섯 종류가 있으며, 각 종류의 색종이는 5개씩 가지고 있다.

![img](https://upload.acmicpc.net/496452ae-ce36-4d77-93f7-19d7f3f9ce28/-/preview/)

<그림 1>

색종이를 크기가 10×10인 종이 위에 붙이려고 한다. 종이는 1×1 크기의 칸으로 나누어져 있으며, 각각의 칸에는 0 또는 1이 적혀 있다. 1이 적힌 칸은 모두 색종이로 덮여져야 한다. 색종이를 붙일 때는 종이의 경계 밖으로 나가서는 안되고, 겹쳐도 안 된다. 또, 칸의 경계와 일치하게 붙여야 한다. 0이 적힌 칸에는 색종이가 있으면 안 된다.

종이가 주어졌을 때, 1이 적힌 모든 칸을 붙이는데 필요한 색종이의 최소 개수를 구해보자.

입력

총 10개의 줄에 종이의 각 칸에 적힌 수가 주어진다.

출력

모든 1을 덮는데 필요한 색종이의 최소 개수를 출력한다. 1을 모두 덮는 것이 불가능한 경우에는 -1을 출력한다.

```java
// me
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // board[r][c] == true  : 아직 덮어야 하는 칸(입력에서 1)
    // board[r][c] == false : 이미 덮었거나 원래 0인 칸(입력에서 0)
    private static boolean[][] board = new boolean[10][10];

    // paper[size] : size x size 색종이 남은 개수 (각 5장)
    // index 0은 사용하지 않음
    private static int[] paper = {0, 5, 5, 5, 5, 5};

    // best : 지금까지 찾은 최소 색종이 사용 개수
    private static int best = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 1) 입력 받기: 10x10
        // 1이면 true(덮어야 함), 0이면 false(덮을 필요 없음)
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                board[i][j] = st.nextToken().equals("1");
            }
        }

        // 2) 백트래킹 시작 (현재 사용한 색종이 개수 = 0)
        backtracking(0);

        // 3) 정답 출력
        // 끝까지 best가 갱신되지 않았다면 덮는 방법이 없는 경우
        System.out.println(best == Integer.MAX_VALUE ? -1 : best);
    }

    // count : 현재까지 사용한 색종이 개수
    private static void backtracking(int count) {

        // 가지치기 1) 이미 최소(best) 이상 사용했으면 더 볼 필요 없음
        if (count >= best) return;

        // 아직 덮어야 하는 칸(true) 중 가장 먼저 나오는 칸을 찾음
        // 항상 "첫 1"부터 처리하면 탐색이 중복되지 않고 경우의 수가 크게 줄어듦
        int[] firstPlace = findFirstTrue();

        // 더 이상 true가 없다면(= 모든 1을 덮었다면) 정답 후보
        if (firstPlace == null) {
            best = Math.min(count, best);
            return;
        }

        int r = firstPlace[0];
        int c = firstPlace[1];

        // 큰 색종이부터 시도 (5 -> 1)
        // 큰 걸 먼저 붙이면 빠르게 best를 낮출 수 있어 가지치기가 강해짐
        for (int size = 5; size >= 1; size--) {

            // 해당 크기 색종이를 다 썼으면 스킵
            if (paper[size] == 0) continue;

            // (r,c)를 좌상단으로 size x size를 덮을 수 있는지 검사
            if (isPlacable(r, c, size)) {

                // 선택 1) 해당 영역을 false로 바꿔 "덮었다" 처리
                place(r, c, size, false);

                // 선택 2) 색종이 1장 사용 처리
                paper[size]--;

                // 다음 상태로 진행 (색종이 사용 개수 +1)
                backtracking(count + 1);

                // 되돌리기 1) 영역 복원(true)
                place(r, c, size, true);

                // 되돌리기 2) 색종이 개수 복원
                paper[size]++;
            }
        }
    }

    // 아직 덮어야 하는 칸(true) 중 가장 먼저 나오는 위치를 반환
    // 없다면 null 반환
    private static int[] findFirstTrue() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (board[i][j]) return new int[]{i, j};
            }
        }
        return null;
    }

    // (r,c)를 좌상단으로 size x size 색종이를 "놓을 수 있는지" 검사
    // - 범위를 벗어나면 불가
    // - 덮을 영역이 모두 true(=1)여야 가능
    private static boolean isPlacable(int r, int c, int size) {
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {

                // 범위 밖이면 바로 불가
                if (i >= 10 || j >= 10) return false;

                // 덮을 영역 중 하나라도 false면(0이거나 이미 덮인 칸이면) 불가
                if (!board[i][j]) return false;
            }
        }
        return true;
    }

    // (r,c)부터 size x size 영역을 value로 채움
    // value=false : 색종이 붙이기(덮기)
    // value=true  : 원상복구(되돌리기)
    private static void place(int r, int c, int size, boolean value) {
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                board[i][j] = value;
            }
        }
    }
}
```

