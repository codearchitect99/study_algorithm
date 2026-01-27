## EulerPhi

오일러 피 함수 P[N]의 정의는 1부터 N까지 범위에서 N과 서로소인 자연수의 개수

```java
// GPT
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N까지 모든 P(오일러 피 함수) 값을 구한다고 가정
        int N = sc.nextInt();

        int[] P = new int[N + 1];

        /*
         * 1) 초기화
         *    P[i]를 일단 i로 둔다.
         *    (아직 i와 공약수를 가지는 수를 제거하기 전 상태)
         */
        for (int i = 0; i <= N; i++) {
            P[i] = i;
        }

        /*
         * 2) 체 방식 갱신
         *    i를 2부터 훑으면서,
         *    "아직 한 번도 갱신 기준으로 쓰이지 않은 i"를 발견하면
         *    (P[i] == i 인 상태)
         *    i의 배수들 j에 대해 P[j]에서 (P[j]/i) 만큼을 빼 준다.
         *
         *    의미:
         *    - j의 1..j 중에서 i와 공약수를 갖는 수(=i의 배수)가 일정 비율 존재
         *    - 그 비율(1/i)만큼을 P[j]에서 제거한다
         *    - 결과적으로 i가 j의 공약수 요인이 되는 경우를 "차감"하는 것
         */
        for (int i = 2; i <= N; i++) {
            // P[i] == i면, i는 아직 어떤 더 작은 수의 배수 갱신을 받은 적이 없음
            // 이런 i는 "새로운 제거 기준"이 될 수 있는 수(사실상 소수 역할)이다.
            if (P[i] == i) {
                // i의 배수 위치를 돌면서 P 값을 갱신한다.
                for (int j = i; j <= N; j += i) {
                    // 핵심 갱신식: P[j] = P[j] - P[j]/i
                    // (i 때문에 서로소가 될 수 없는 경우를 제거)
                    P[j] -= P[j] / i;
                }
            }
        }

        /*
         * 3) 출력 예시
         *    필요에 맞게 P[k]만 출력하거나, 전부 출력하면 된다.
         */
        for (int i = 1; i <= N; i++) {
            System.out.println("P(" + i + ") = " + P[i]);
        }
    }
}
```

