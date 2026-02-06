import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) coins[i] = Integer.parseInt(br.readLine());

        int result = 0;

        int idx = n - 1;

        while (k > 0 && idx >= 0) {
            if (coins[idx] <= k) {
                int count = k / coins[idx];
                result += count;
                k = k - coins[idx] * count;
            }
            if (k == 0) break;
            idx--;
        }
        
        System.out.println(result);
    }
}