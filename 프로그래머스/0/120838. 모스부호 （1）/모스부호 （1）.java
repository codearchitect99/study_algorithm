import java.util.*;
class Solution {
    public String solution(String letter) {
        String[] morse = new String[]{ 
    ".-","-...","-.-.","-..",".","..-.",
    "--.","....","..",".---","-.-",".-..",
    "--","-.","---",".--.","--.-",".-.",
    "...","-","..-","...-",".--","-..-",
    "-.--","--.."
};
        Map<String, Character> map = new HashMap<>();
        for (int i = 0; i < morse.length; i++) {
            map.put(morse[i], (char) ('a' + i)) ;
        }
        
        String[] letters = letter.split(" ");
        String answer = "";
        for (int i = 0; i < letters.length; i++) {
            answer += map.get(letters[i]);
        }
        return answer;
    }
}