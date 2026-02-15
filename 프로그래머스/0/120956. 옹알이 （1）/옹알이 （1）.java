class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] words = new String[]{"aya", "ye", "woo", "ma"};
        
        for (String str : babbling) {
            while (str.length() > 0) {
                boolean isMatched = false;
                for (String word : words) {
                    if (str.startsWith(word)) {
                        str = str.substring(word.length());
                        isMatched = true;
                    }
                }
                if (isMatched == false) break;
                if (str.length() == 0) answer++;
            }
        }

        return answer;
    }
}