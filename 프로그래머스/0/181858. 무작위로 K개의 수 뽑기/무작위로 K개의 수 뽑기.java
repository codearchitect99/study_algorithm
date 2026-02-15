import java.util.*;
class Solution {
    public int[] solution(int[] arr, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (list.contains(arr[i])) continue;
            list.add(arr[i]);
        }
        
        int idx = list.size();
        for (int i = idx; i < k; i++) list.add(-1);
        
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}