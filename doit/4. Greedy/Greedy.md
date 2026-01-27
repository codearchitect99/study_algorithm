## Greedy

현재 상태에서 보는 선택지 중 최선의 선택지가 전체 선택지 중 최선의 선택지라고 가정하는 알고리즘

---

11047 - 동전 0

준규가 가지고 있는 동전은 총 N종류이고, 각각의 동전을 매우 많이 가지고 있다.

동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다. 이때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오.

입력

첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 10, 1 ≤ K ≤ 100,000,000)

둘째 줄부터 N개의 줄에 동전의 가치 Ai가 오름차순으로 주어진다. (1 ≤ Ai ≤ 1,000,000, A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수)

출력

첫째 줄에 K원을 만드는데 필요한 동전 개수의 최솟값을 출력한다.

```java
// me
// doit -> for문 사용
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

        while (k > 0) {
            int count = k / coins[idx];
            result += count;
            k %= coins[idx];
            idx--;
        }
        
        System.out.println(result);
    }
}
```

현재 남은 금액 k를 만들 때, 지금 사용할 수 있는 가장 큰 동전을 최대한 사용하는 것이 항상 동전 개수를 최소로 만든다

가능한 이유: 이 문제의 동전들은 서로 배수 관계, 큰 동전 1개 = 작은 동전 여러 개, 작은 동전을 여러 개 쓰는 선택은 항상 손해

---

1541 - 잃어버린 괄호

세준이는 양수와 +, -, 그리고 괄호를 가지고 식을 만들었다. 그리고 나서 세준이는 괄호를 모두 지웠다.

그리고 나서 세준이는 괄호를 적절히 쳐서 이 식의 값을 최소로 만들려고 한다.

괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램을 작성하시오.

입력

첫째 줄에 식이 주어진다. 식은 ‘0’~‘9’, ‘+’, 그리고 ‘-’만으로 이루어져 있고, 가장 처음과 마지막 문자는 숫자이다. 그리고 연속해서 두 개 이상의 연산자가 나타나지 않고, 5자리보다 많이 연속되는 숫자는 없다. 수는 0으로 시작할 수 있다. 입력으로 주어지는 식의 길이는 50보다 작거나 같다.

출력

첫째 줄에 정답을 출력한다.

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] str = input.split("-");

        int result = sum(str[0]);
        for (int i = 1; i < str.length; i++) {
            result -= sum(str[i]);
        }

        System.out.println(result);
    }

    private static int sum(String txt) {
        String[] str = txt.split("[+]");
        int result = Integer.parseInt(str[0]);
        for (int i = 1; i < str.length; i++) {
            result += Integer.parseInt(str[i]);
        }
        return result;
    }
}
```

이 문제는 첫 - 이후의 모든 항을 하나로 묶어 빼는 것이 항상 결과를 최소로 만든다.