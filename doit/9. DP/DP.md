## DP

Dynamic Programming 동적 계획법: 여러 개의 간단한 문제로 분리하여 해결함으로써 최종 답을 구하는 방법

1. 상태 정의
   - dp[i] 또는 dp[i][j]가 무엇을 의미하는지 정한다.
2. 점화식 정의
   - 이전 상태를 이용해 현재 상태를 계산하는 규칙을 만든다.
3. 초기값 설정
   - 가장 작은 문제의 값을 직접 지정한다.
4. 계산 순서 결정
   - 작은 문제부터 큰 문제 순서로 계산한다.

---

11726 - 2 x n 타일링

2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
아래 그림은 2×5 크기의 직사각형을 채운 한 가지 방법의 예이다.

![img](https://onlinejudgeimages.s3-ap-northeast-1.amazonaws.com/problem/11726/1.png)

입력
첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)

출력
첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long[] dp = new long[n+1];

        if (n >= 1) dp[1] = 1;
        if (n >= 2) dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }
        
        System.out.println(dp[n]);
    }
}
```

