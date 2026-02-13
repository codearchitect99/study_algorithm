class Solution {
    public int[][] solution(int n) {
        int[][] board = new int[n][n];
        int num = 1;
        int r = 0;
        int c = 0;
        loop:
        while (num <= n * n) {
            while (board[r][c] == 0) {
                board[r][c] = num++;
                if (num > n * n) break loop;
                if (c == n - 1 || board[r][c + 1] != 0){
                    r++;
                    break;
                }
                c++;
            }
            while (board[r][c] == 0) {
                board[r][c] = num++;
                if (num > n * n) break loop;
                if (r == n - 1 || board[r + 1][c] != 0){
                    c--;
                    break;
                }
                r++;
            }
            while (board[r][c] == 0) {
                board[r][c] = num++;
                if (num > n * n) break loop;
                if (c == 0 || board[r][c - 1] != 0){
                    r--;
                    break;
                }
                c--;
            }
            while (board[r][c] == 0) {
                board[r][c] = num++;
                if (num > n * n) break loop;
                if (r == 0 || board[r - 1][c] != 0){
                    c++;
                    break;
                }
                r--;
            }
        }
        return board;

    }
}