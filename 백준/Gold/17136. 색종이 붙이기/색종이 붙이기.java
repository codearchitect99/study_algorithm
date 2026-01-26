import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static boolean[][] board = new boolean[10][10];
    private static int[] paper = {0, 5, 5, 5, 5, 5};
    private static int best = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                board[i][j] = st.nextToken().equals("1");
            }
        }

        backtracking(0);

        System.out.println(best == Integer.MAX_VALUE ? -1 : best);
    }

    private static void backtracking(int count) {
        if (count >= best) return;

        int[] firstPlace = findFirstTrue();

        if (firstPlace == null) {
            best = Math.min(count, best);
            return;
        }
        int r = firstPlace[0];
        int c = firstPlace[1];

        for (int size = 5; size >= 1; size--) {
            if (paper[size] == 0) continue;
            if (isPlacable(r, c, size)) {
                place(r, c, size, false);
                paper[size]--;
                backtracking(count + 1);

                place(r, c, size, true);
                paper[size]++;
            }
        }

    }

    private static int[] findFirstTrue() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (board[i][j]) return new int[]{i, j};
            }
        }
        return null;
    }

    private static boolean isPlacable(int r, int c, int size) {
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (i >= 10 || j >= 10) return false;
                if (!board[i][j]) return false;
            }
        }
        return true;
    }

    private static void place(int r, int c, int size, boolean value) {
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                board[i][j] = value;
            }
        }
    }
}