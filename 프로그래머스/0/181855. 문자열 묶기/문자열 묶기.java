import java.util.*;
class Solution {
    public int solution(String[] strArr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (String str : strArr) {
            map.put(str.length(), map.getOrDefault(str.length(), 0) + 1);
        }
        int max = 0;
        for (int v : map.values()) max = max < v ? v : max;
        return max;
    }
}