## PrefixSum

 합 배열을 이용하여 시간 복잡도를 더 줄이기 위해 사용하는 특수한 목적의 알고리즘

합 배열 공식 S[i] = S[i - 1] + A[i]

구각 합 ex) S[5] - S[1] = A[2] + A[3] + A[4] + A[5]

---

11659 - 구간 합 구하기 4

수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 수의 개수 N과 합을 구해야 하는 횟수 M이 주어진다. 둘째 줄에는 N개의 수가 주어진다. 수는 1,000보다 작거나 같은 자연수이다. 셋째 줄부터 M개의 줄에는 합을 구해야 하는 구간 i와 j가 주어진다.

출력
총 M개의 줄에 입력으로 주어진 i번째 수부터 j번째 수까지 합을 출력한다.

제한
1 ≤ N ≤ 100,000
1 ≤ M ≤ 100,000
1 ≤ i ≤ j ≤ N

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        // me -----------
        // * logic은 괜찮지만 입력 조건들을 고려하였을 때,
        // * Scanner 사용은 시간 초과 유발 가능
        // Scanner sc = new Scanner(System.in);
        //
        // int n = sc.nextInt();
        // int m = sc.nextInt();
        //
        // long[] nums = new long[n];
        // for (int i = 0; i < n; i++) {
        //     if (i == 0) nums[i] = sc.nextInt();
        //     else nums[i] = nums[i - 1] + sc.nextInt();
        // }
        //
        // for (int i = 0; i < m; i++) {
        //     int a = sc.nextInt();
        //     int b = sc.nextInt();
        //
        //     if (a > 1) System.out.println(nums[b - 1] - nums[a - 2]);
        //     else System.out.println(nums[b-1]);
        // }
      	// ----------
        
        // doit
        // * 위 로직에서 BufferedReader, InputStreamReader, StringTokenizer 이용
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
```

입력 값이 많을 때는 BufferedReader, InputStreamReader, StringTokenizer 이용하기