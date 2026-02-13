class Solution {
    public int solution(int a, int b, int c, int d) {
        int[] dice = new int[7];
        dice[a]++; dice[b]++; dice[c]++; dice[d]++;
        
        int max = 0;
        for (int i = 1; i <= 6; i++) {
            max = max < dice[i] ? dice[i] : max;
        }
        
        if (max == 4) return 1111 * a;
        
        if (max == 3) {
            int p = 0, q = 0;
            for (int i = 1; i <= 6; i++) {
                if (dice[i] == 3) p = i;
                if (dice[i] == 1) q = i;
            }
            return (int) Math.pow(10 * p + q, 2);
        }
        
        if (max == 2) {
            int pair = 0;
            for (int i = 1; i <= 6; i++) {
                if (dice[i] == 2) pair++;
            }
            if (pair == 2) {
                int p = 0, q = 0;
                for (int i = 1; i <= 6; i++) {
                    if (p == 0 && dice[i] == 2) p = i;
                    else if (p != 0 && dice[i] == 2) {
                        q = i;
                        return (p + q) * Math.abs(p - q);
                    }
                }
            }
            else {
                int q = 0, r = 0;
                for (int i = 1; i <= 6; i++) {
                    if (q == 0 && dice[i] == 1) q = i;
                    else if (q != 0 && dice[i] == 1) {
                        r = i;
                        return q * r;
                    }
                }
            }

        }
        if (max == 1) {
            for (int i = 1; i <= 6; i++) {
                if (dice[i] != 0) return i;
            }
        }
        
        return 0;
        
    }
}