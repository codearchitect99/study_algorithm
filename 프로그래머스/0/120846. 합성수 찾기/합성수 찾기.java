class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean[] primes = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            if (primes[i]) continue;
            int m = 2;
            while (i * m <= n) {
                primes[i * m] = true;
                m++;
            }
        }
        for (boolean p: primes) if (p) answer++;
        return answer;
    }
}