class Solution {
    public String solution(String a, String b) {
        int aIdx = a.length() - 1;
        char[] arr = a.toCharArray();
        
        int bIdx = b.length() - 1;
        char[] brr = b.toCharArray();
        
        int cIdx = aIdx > bIdx ? aIdx + 1 : bIdx + 1;
        char[] crr = new char[cIdx + 1];
        
        int n = 0;
        int nn = 0;
        
        while (cIdx >= 0) {
            int an = aIdx >= 0 ? arr[aIdx] - '0' : 0;
            int bn = bIdx >= 0 ? brr[bIdx] - '0' : 0;
            int sum = nn + an + bn;
            n = sum % 10;
            nn = sum / 10;
            
            crr[cIdx] = (char) (n + '0');
            
            aIdx--; bIdx--; cIdx--;
        }
        String result = String.valueOf(crr);
        if (result.charAt(0) == '0') result = result.replaceFirst("0", "");
        return result;

    }
}