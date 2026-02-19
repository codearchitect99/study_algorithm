class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        for (int i = 0; i < myString.length() - pat.length() + 1; i++) {
            if (myString.substring(i, i + pat.length()).equals(pat)) answer++; 
        }
        return answer;
    }
}