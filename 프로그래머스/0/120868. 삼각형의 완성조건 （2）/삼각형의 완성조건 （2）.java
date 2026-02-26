class Solution {
    public int solution(int[] sides) {
        int l = 0;
        int s = 0;
        if (sides[0] > sides[1]) {
            l = sides[0];
            s = sides[1];
        } else {
            l = sides[1];
            s = sides[0];
        }
        int t = l + s;
        int answer = 0;
        while (t > 0) {
            if (t > l && t < l + s) answer++;
            else if (t <= l && l < t + s) answer++;
            t--;
        }
        return answer;
    }
}