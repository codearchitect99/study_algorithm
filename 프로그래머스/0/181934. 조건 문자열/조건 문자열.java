class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        int answer = 0;
        if (eq.equals("=")) {
            if (n == m) return 1;
            if (ineq.equals(">")) {
                if (n > m) return 1;
                else return 0;
            }
            else if (ineq.equals("<")) {
                if (n < m) return 1;
                else return 0;
            }
        }
        else if (eq.equals("!")) {
            if (n == m) return 0;
            if (ineq.equals(">")) {
                if (n > m) return 1;
                else return 0;
            }
            else if (ineq.equals("<")) {
                if (n < m) return 1;
                else return 0;
            }
        }
        return answer;
    }
}