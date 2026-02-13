import java.util.HashSet;
import java.util.Arrays;
class Solution {
    public int solution(String[] s1, String[] s2) {
        HashSet<String> set = new HashSet<>(Arrays.asList(s1));
        int result = 0;
        for (String str : s2) {
            if (set.contains(str)) result++;
        }
        return result;

    }
}