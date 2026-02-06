## Combination

조합 nCr: n개의 숫자에서 r개를 뽑은 경우의 수

- 조건: n ≧ 1, r ≧ 0, nCr = n! / ((n - r)! r!)

- nCr = (n - 1)C(r - 1) + (n - 1)Cr

  - ex) 5개 중 3개를 고르는 경우의 수

    - 임의 숫자 x를 고르고 4개 중 2개를 고르는 경우의 수와
      x를 고르지 않고 나머지 4개 중 3개를 고르는 경우의 수의 합
    - `C[5][3] = C[4][2] + C[4][3]`

  - 이항 계수, 파스칼 삼각형

    <img src="/Users/jeff/Library/Application Support/typora-user-images/image-20260131201444488.png" alt="image-20260131201444488" style="zoom:50%;" />

순열 nPr: n개의 숫자 중 r개를 뽑는 순서

- nPr = n! / (n - r)!

---

11050 - 이항 계수 1

자연수 \(N\)과 정수 \(K\)가 주어졌을 때 이항 계수 \(\binom{N}{K}\)를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 \(N\)과 \(K\)가 주어진다. (1 ≤ \(N\) ≤ 10, 0 ≤ \(K\) ≤ \(N\))

출력
 \(\binom{N}{K}\)를 출력한다.

```java
// me
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int p = factorial(n - k) * factorial(k);
        int c = factorial(n);
        System.out.println(c/p);
    }

    public static int factorial(int n) {
        if (n == 0) return 1;
        for (int i = n - 1; i >= 1; i--) {
            n *= i;
        }
        return n;
    }
}
```

```java
// doit
// * 조합 배열을 만들어서 해결
// * 점화식 사용
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[][] c = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            c[i][i] = 1;
            c[i][0] = 1;
        }
        
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                c[i][j] = c[i-1][j-1] + c[i-1][j];
            }
        }
        System.out.println(c[n][k]);
    }
}

```

