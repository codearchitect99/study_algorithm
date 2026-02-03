class Solution {
    public long solution(int n) {
        long answer = 0;
        
        if (n == 1) return 1;
        if (n == 2) return 2;
        
        long prev2 = 1;
        long prev1 = 2;
       	
        long cur = 0;
        for (int i = 3; i <= n; i++) {
            cur = (prev1 + prev2) % 1234567l;
            prev2 = prev1;
            prev1 = cur;
        }
        return cur % 1234567;
    }
}