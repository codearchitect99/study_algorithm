class Solution {
    public int[] solution(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            if (arr[l] == 2 && arr[r] == 2) break;
            if (arr[l] != 2) l++;
            if (arr[r] != 2) r--;
        }
        if (l >= r) {
            if (l > r) return new int[]{-1};
            else if (l == r) {
                if (arr[l] == 2) return new int[]{2};
                else return new int[]{-1};
            }
        }
        int[] answer = new int[r - l + 1];
        int idx = l;
        for (int i = 0; i < answer.length; i++) {
            answer[i] = arr[idx++];
        }
        return answer;
        
    }
}