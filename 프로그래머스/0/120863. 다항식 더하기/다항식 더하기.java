class Solution {
    public String solution(String polynomial) {
        String[] arr = polynomial.split(" \\+ ");
        int x = 0;
        int n = 0;
        for (String p: arr) {
            if (p.endsWith("x")) {
                if (p.equals("x")) x++;
                else x += Integer.parseInt(p.substring(0, p.length() - 1));
            } else {
                n += Integer.parseInt(p);
            }
        }
        StringBuilder sb = new StringBuilder();
        if (x > 0) {
            if (x == 1) sb.append("x");
            else sb.append(x).append("x");
            
            if (n > 0) sb.append(" + ");
        }
        if (n > 0) sb.append(n);
        
        return sb.toString();
    }
}