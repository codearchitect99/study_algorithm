import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> closet = new HashMap<>();
        
        for (String[] cloth : clothes) {
            closet.put(cloth[1], closet.getOrDefault(cloth[1], 0) + 1);
        }
        
        int combi = 1;
        
        for (int count : closet.values()) {
            combi *= (count + 1);
        }
        combi--;
        
        return combi;
    }
}