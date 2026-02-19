import java.util.*;

class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < todo_list.length; i++) {
            if (finished[i]) continue;
            list.add(todo_list[i]);
        }
        return list.toArray(new String[0]);
    }
}