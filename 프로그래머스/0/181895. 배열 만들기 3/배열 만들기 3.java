import java.util.*;
class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        int a1 = intervals[0][0];
        int b1 = intervals[0][1];
        int a2 = intervals[1][0];
        int b2 = intervals[1][1];
        List<Integer> list = new ArrayList<>();
        for (int i = a1; i <= b1; i++) list.add(arr[i]);
        for (int i = a2; i <= b2; i++) list.add(arr[i]);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}