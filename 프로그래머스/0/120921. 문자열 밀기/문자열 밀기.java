class Solution {
    public int solution(String A, String B) {
        char[] arr = A.toCharArray();
       	char[] brr = B.toCharArray();
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int count = 0;
            for (int j = 0; j < len; j++) {
                if (arr[j] == brr[(i + j) % len]) count++;
            }
            if (count == len) return i;
        }
        return -1;
    }
}