class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        long sum = Long.MAX_VALUE;
        int len = diffs.length;
        int left = 1;
        int right = 100000;
        int level = right;
        while (left <= right) {
            int mid = (left + right) / 2;
            sum = times[0];
            for (int i = 1; i < len; i++) {
                if (mid >= diffs[i]) sum += times[i];
                else sum += times[i] + (long) (diffs[i] - mid) * (times[i] + times[i - 1]);
            }
            if (sum <= limit) {
                level = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return level;
    }
}