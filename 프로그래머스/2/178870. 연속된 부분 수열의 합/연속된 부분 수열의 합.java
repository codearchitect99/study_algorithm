class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int sum = sequence[0];
        while (left < sequence.length && right < sequence.length) {
            if (sum == k) {
                if (minLength > right - left) {
                    answer[0] = left;
                    answer[1] = right;
                    minLength = right - left;
                }
                sum -= sequence[left];
                left++;
            }
            else if (sum > k) {
                if (left == right) break;
                sum -= sequence[left];
                left++;
            }
            else if (sum < k) {
                if (right == sequence.length - 1) break;
                right++;
                sum += sequence[right];
            }
            
        }
        return answer;
    }
}