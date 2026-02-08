class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        int answer = 0;
        String e = ineq + eq;
        switch (e) {
            case "<=": return (n <= m) ? 1 : 0;
            case ">=": return (n >= m) ? 1 : 0;
            case "<!": return (n < m) ? 1 : 0;
            case ">!": return (n > m) ? 1 : 0;
        }
        return answer;
    }
}