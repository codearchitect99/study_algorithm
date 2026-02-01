import java.util.ArrayDeque;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        int rsize = maps.length;
        int csize = maps[0].length;
        int[] dr = new int[]{-1, 1, 0, 0};
        int[] dc = new int[]{0, 0, -1, 1};
        
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cr = cur[0];
            int cc = cur[1];
            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                if (nr < 0 || nr >= rsize || nc < 0 || nc >= csize) continue;
                
                int nv = maps[nr][nc];
                int cv = maps[cr][cc];
                if (nv == 0) continue;
                if (nv == 1 || nv > cv + 1) {
                	maps[nr][nc] = maps[cr][cc] + 1;
                	q.offer(new int[]{nr, nc});    
                }
                
            }
        }
        if (maps[rsize-1][csize-1] == 1) return -1;
        else return maps[rsize-1][csize-1];
    }
}