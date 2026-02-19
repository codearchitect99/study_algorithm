import java.util.*;
class Solution {
    public String[] solution(String myStr) {
        myStr = myStr.replace("a", " ");
        myStr = myStr.replace("b", " ");
        myStr = myStr.replace("c", " ");
        List<String> list = new ArrayList<>();
        for (String str : myStr.split(" ")) {
            if (str.length() > 0) list.add(str);
        }
        if (list.size() == 0) return new String[]{"EMPTY"};
        return list.toArray(new String[0]);
    }
}