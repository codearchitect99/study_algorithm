class Solution {
    public String solution(String my_string, int num1, int num2) {
        int a = Math.min(num1, num2);
        int b = Math.max(num1, num2);
        StringBuilder sb = new StringBuilder();
        sb.append(my_string.substring(0, a));
        sb.append(my_string.charAt(b));
        sb.append(my_string.substring(a + 1, b));
        sb.append(my_string.charAt(a));
        sb.append(my_string.substring(b + 1));
        return sb.toString();
    }
}