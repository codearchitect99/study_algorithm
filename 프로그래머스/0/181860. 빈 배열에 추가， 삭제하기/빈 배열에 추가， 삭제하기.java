import java.util.*;
class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < flag.length; i++) {
            if (flag[i]) {
                for (int j = 0; j < arr[i] * 2; j++) {
                    st.push(arr[i]);
                }
            }
            else {
                for (int j = 0; j < arr[i]; j++) {
                    st.pop();
                }
            }
        }
        int[] answer = new int[st.size()];
        for (int i = answer.length - 1; i >= 0; i--) {
            answer[i] = st.pop();
        }
        return answer;
        
    }
}