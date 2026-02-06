class Solution {
    public int solution(int n) {
        int answer = 1;
        for (int i = 1; i < n; i++) {
            long sum = 0;
            int num = i;
            while (sum < n) {
                sum += num;
                if (sum == n) answer++;
                num++;
            }
        }
        return answer;
    }
}