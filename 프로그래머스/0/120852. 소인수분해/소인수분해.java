import java.util.*;
class Solution {
    public int[] solution(int n) {
        int p = 2;
        List<Integer> list = new ArrayList<>();
        while (n > 1) {
            if (n % p == 0) {
                list.add(p);
                while (n % p == 0) n /= p;
            }
            p++;
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}