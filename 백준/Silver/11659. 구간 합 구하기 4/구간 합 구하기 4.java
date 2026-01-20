import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] nums = new long[n + 1];
        nums[0] = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            nums[i] = nums[i - 1] + Long.parseLong(st.nextToken());

        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(nums[b] - nums[a - 1]).append("\n");
        }
        
        System.out.println(sb);

    }
}