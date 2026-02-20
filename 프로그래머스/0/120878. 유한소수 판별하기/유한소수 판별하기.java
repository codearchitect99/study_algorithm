class Solution {
    public int solution(int a, int b) {
        int g = gcd(a ,b);
        b = b / g;
        while (b % 2 == 0) b /= 2;
        while (b % 5 == 0) b /= 5;
        if (b == 1) return 1;
        else return 2;
    }
    private static int gcd(int a, int b) {
        while (b != 0) {
            int mod = a % b;
            a = b;
            b = mod;
        }
        return a;
    }
}