class Solution {
    public String solution(String my_string, int s, int e) {
        String answer = my_string.substring(0, s);
        for (int i = e; i >= s; i--) {
            answer += String.valueOf(my_string.charAt(i));
        }
        if (e < my_string.length() - 1) answer += my_string.substring(e + 1);
        return answer;
    }
}