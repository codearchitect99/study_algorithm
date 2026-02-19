import java.util.*;
class Solution {
    public String[] solution(String myString) {
        List<String> list = new ArrayList<>();
        String[] arr = myString.split("x");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() > 0) list.add(arr[i]);
        }
        list.sort(Comparator.naturalOrder());
        return list.toArray(new String[0]);
    }
}