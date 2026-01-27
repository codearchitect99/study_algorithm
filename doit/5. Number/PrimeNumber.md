## PrimeNumber

소수 : 1과 자기 자신 외의 약수가 존재하지 않는 수

소수를 구하는 방법론: 에라토스테네스의 체 원리

에라토스테네스의 체 원리

1. 2부터 N까지 모든 수를 나열
2. 2의 배수(4, 6, 8, …)를 전부 제거
3. 3의 배수(6, 9, 12, …) 제거
4. 이 과정을 반복
5. √N까지만 반복하면 충분
6. 끝까지 지워지지 않은 수 = 소수

시간복잡도: O(nlogn)

- 에라토스테네스의 체는 소수를 직접 찾는 알고리즘이 아니라, 합성수를 제거하는 알고리즘이다.
- 0과 1을 제외한 자연수는 소수 또는 합성수로만 구성된다.
  - 따라서 합성수를 모두 제거하면 남는 수는 소수이다.
- N 이하의 합성수는 반드시 √N 이하의 약수를 하나 이상 가지므로, √N까지만 배수를 제거하면 모든 합성수를 제거할 수 있다.

---

1929 - 소수 구하기

M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.

입력

첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.

출력

한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.

```java
// me
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        boolean[] arr = new boolean[n + 1];
        arr[0] = arr[1] = true;
        for (int i = 2; i * i <= n; i++) {
            if (arr[i]) continue;
            int num = i * 2;
            while (num <= n) {
                arr[num] = true;
                num += i;
            }
        }
        for (int i = m; i <= n; i++) {
            if (!arr[i]) System.out.println(i);
        }

    }
}
```

