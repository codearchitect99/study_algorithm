class Solution {
    public int solution(int[] common) {
        int d1 = common[1] - common[0];
        int d2 = common[2] - common[1];
        if (d1 == d2) return common[common.length - 1] + d1;
        else return common[common.length - 1] * (common[1] / common[0]);
    }
}