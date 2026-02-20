class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int video = getSec(video_len);
        int current = getSec(pos);
        int start = getSec(op_start);
        int end = getSec(op_end);

        current = skipOpening(current, start, end);

        for (String cmd : commands) {
            if (cmd.equals("next")) {
                current = Math.min(video, current + 10);
            } else { // "prev"
                current = Math.max(0, current - 10);
            }
            current = skipOpening(current, start, end);
        }

        return String.format("%02d:%02d", current / 60, current % 60);
    }

    private int skipOpening(int cur, int start, int end) {
        return (start <= cur && cur <= end) ? end : cur;
    }

    private int getSec(String str) {
        int m = Integer.parseInt(str.substring(0, 2));
        int s = Integer.parseInt(str.substring(3, 5));
        return m * 60 + s;
    }
}