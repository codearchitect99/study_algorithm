class Solution {
    public int solution(int n) {
        double a = Math.sqrt(n);
        int b = (int) a;
        if (a == b) return 1;
        else return 2;
    }
}