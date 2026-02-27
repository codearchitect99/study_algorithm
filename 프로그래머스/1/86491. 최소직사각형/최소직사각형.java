class Solution {
    public int solution(int[][] sizes) {
        int a = 0;
        int b = 0;
        for (int[] size: sizes) {
            int big = 0;
            int small = 0;
            if (size[0] > size[1]) {
                big = size[0];
                small = size[1];
            } else {
                big = size[1];
                small = size[0];
            }
            if (big > a) a = big;
            if (small > b) b = small;
        }
        return a * b;
    }
}