import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        Queue<Integer> q = new PriorityQueue<>((a, b) -> a - b);
        for (int i = 0; i < scoville.length; i++) {
            q.offer(scoville[i]);
        }
        int count = 0;
        while (!q.isEmpty()) {
            int first = q.poll();
            if (first >= K) break;
            if (q.isEmpty()) return -1;
            int second = q.poll();
            int mix = first + second * 2;
            count++;
            q.offer(mix);
        }
        return count;
        
    }
}