import java.util.HashMap;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> need = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            need.put(want[i], number[i]);
        }
        
        HashMap<String, Integer> basket = new HashMap<>();
        for (int i = 0; i < discount.length; i++) {
           	basket.put(discount[i], basket.getOrDefault(discount[i], 0) + 1);
            
            if (i >= 10) {
                int count = basket.get(discount[i - 10]) - 1;
                if (count < 0) count = 0;
                basket.put(discount[i - 10], count);
            }
            
            if (i >= 9) {
                boolean result = true;
                for (String item: need.keySet()) {
                    if (need.get(item) > basket.getOrDefault(item, 0)) {
                        result = false;
                        break;
                    }
                }
                if (result) answer++;
            }
        }
        return answer;
    }
}