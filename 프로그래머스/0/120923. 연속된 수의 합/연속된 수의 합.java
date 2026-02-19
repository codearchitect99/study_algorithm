class Solution {
    public int[] solution(int num, int total) {
        int s = (total * 2 / num - num + 1) / 2;
        int[] answer = new int[num];
        for (int i = 0; i < num; i++) {
            answer[i] = s + i;
        }
        return answer;
    }
}