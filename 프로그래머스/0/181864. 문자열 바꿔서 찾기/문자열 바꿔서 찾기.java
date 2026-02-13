class Solution {
    public int solution(String myString, String pat) {
        if (pat.length() > myString.length()) return 0;
        char[] arr = myString.toCharArray();
        int len = myString.length() - pat.length();
        for (int start = 0; start <= len; start++) {
        	int result = 1;
            for (int j = start; j < start + pat.length(); j++) {
                if (myString.charAt(j) == pat.charAt(j - start)) {
                    result = 0;
                    break;
                }
            }
            if (result == 1) return result;
        }
        return 0;
        
    }
}