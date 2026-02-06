import java.util.Set;
import java.util.HashSet;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> used = new HashSet<>();
        used.add(words[0]);
        for (int i = 1; i < words.length; i++) { 
            String prev = words[i - 1];
            String cur = words[i];
            if (prev.charAt(prev.length() - 1) != cur.charAt(0)) {
                return new int[]{i % n + 1, i / n + 1};
            }
            if (!used.add(cur)) {
                return new int[]{i % n + 1, i / n + 1};
            }
        }
        return new int[]{0, 0};
    }
}