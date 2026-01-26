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

        visited = new boolean[n][m];
        bfs(0, 0);

        System.out.println(board[n - 1][m - 1]);
    }

    private static void bfs(int r, int c) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c});
        visited[r][c] = true;

        while(!q.isEmpty()) {
            int[] current = q.poll();
            int currentR = current[0];
            int currentC = current[1];

            for (int d = 0; d < 4; d++) {
                int nextR = currentR + dr[d];
                int nextC = currentC + dc[d];

                if (nextR >= n || nextC >= m || nextR < 0 || nextC < 0) continue;
                if (visited[nextR][nextC]) continue;
                if (board[nextR][nextC] == 0) continue;

                board[nextR][nextC] = board[currentR][currentC] + 1;
                visited[nextR][nextC] = true;
                q.offer(new int[]{nextR, nextC});

            }
        }

    }
}