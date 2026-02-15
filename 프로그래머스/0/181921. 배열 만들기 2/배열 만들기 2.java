import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        Deque<Integer> q = new ArrayDeque<>();
        q.push(5);
        
        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty()) {
            int po = q.poll();
            if (po > r) break;
            
            if (po >= l && po <= r) list.add(po);
            
            int zero = po * 10;
            if (zero <= r) q.push(zero);
            
            int five = po * 10 + 5;
            if (five <= r) q.push(five);
        }
        if (list.size() == 0) return new int[]{-1};
        Collections.sort(list);
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}