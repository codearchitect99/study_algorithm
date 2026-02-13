class Solution {
    public int solution(int n) {
        int answer = 0;
        int l = 1;
        int r = n;
        while (l >= 1 && l <= n && r >= 1 && r <= n) {
            if (l * r == n) {
                answer++;
                l++;
            }
            else if (l * r > n) r--;
            else if (l * r < n) l++;
            
        }
        return answer;
    }
}