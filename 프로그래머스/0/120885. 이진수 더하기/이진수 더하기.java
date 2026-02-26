class Solution {
    public String solution(String bin1, String bin2) {
        int a = 0;
        int binary = 0;
        for (int i = bin1.length() - 1; i >= 0; i--) {
            if (bin1.charAt(i) == '1') a += (int) Math.pow(2, binary);
            binary++;
        }
        int b = 0;
        binary = 0;
        for (int i = bin2.length() - 1; i >= 0; i--) {
            if (bin2.charAt(i) == '1') a += (int) Math.pow(2, binary);
            binary++;
        }
        int v = a + b;
        if (v == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (v > 0) {
            if (v % 2 == 0) sb.append(0);
            else sb.append(1);
            v /= 2;
        }
        return sb.reverse().toString();
    }
}