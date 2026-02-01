class Solution {
    private static int[] numbers;
    private static int target;
    private static int result;
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        
        result = 0;
        
        dfs(0, 0);
        
        return result;
    }
    
    private static void dfs(int idx, int value) {
        if (idx == numbers.length) {
            if (value == target) result++;
            return;
        }
        
        // minus branch
        value -= numbers[idx];
        dfs(idx + 1, value);
        
        // restore
        value += numbers[idx];
        
        // plus branch
        value += numbers[idx];
        dfs(idx + 1, value);
        
        // restore
        value -= numbers[idx];
    }
}