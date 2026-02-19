class Solution {
    public int solution(int[][] board, int k) {
        int answer = 0;
        int maxI = board.length - 1 > k ? k : board.length - 1;
        int maxJ = board[0].length - 1 > k ? k : board[0].length - 1;
        for (int i = 0; i <= maxI; i++) {
            for (int j = 0; j <= maxJ && i + j <= k; j++) answer += board[i][j];
        }
        return answer;
    }
}