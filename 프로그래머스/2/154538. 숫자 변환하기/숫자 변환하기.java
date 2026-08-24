import java.util.ArrayDeque;
class Solution {
    public int solution(int x, int y, int n) {
        if (x == y) return 0;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[y+1];
        q.offer(new int[]{x, 0});
        visited[x] = true;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int v = cur[0];
            int count = cur[1];
            int next[] = {v+n, v*2, v*3};
            for (int nv: next) {
                if (nv > y || visited[nv]) continue;
                if (nv == y) return count+1;
                q.offer(new int[]{nv, count+1});
                visited[nv] = true;
            }
        }
        return -1;
    }
}