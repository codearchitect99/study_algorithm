import java.util.ArrayList;
class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int n : arr) {
            boolean b = false;
            for (int d : delete_list) {
                if (n == d) {
                    b = true;
                    break;
                }
            }
            if (b == false) list.add(n);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}