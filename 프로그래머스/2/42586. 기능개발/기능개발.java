import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            int remains = 100 - progresses[i];
            int day = 0;
            if (remains % speeds[i] > 0) day = remains / speeds[i] + 1;
            else day = remains / speeds[i];
            days[i] = day;
        }
        List<Integer> list = new ArrayList<>();
        int count = 1;
        int deploy = 0;
        for (int i = 1; i < days.length; i++) {
            if(days[deploy] >= days[i]) count++;
            else {
                list.add(count);
                count = 1;
                deploy = i;
            }
        }
        if (count > 0) list.add(count);
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) answer[i] = list.get(i);
        return answer;
    }
}