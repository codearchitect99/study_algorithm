## TwoPointer

2018 - 수들의 합 5

어떠한 자연수 N은, 몇 개의 연속된 자연수의 합으로 나타낼 수 있다. 당신은 어떤 자연수 N(1 ≤ N ≤ 10,000,000)에 대해서, 이 N을 몇 개의 연속된 자연수의 합으로 나타내는 가지수를 알고 싶어한다. 이때, 사용하는 자연수는 N이하여야 한다.

예를 들어, 15를 나타내는 방법은 15, 7+8, 4+5+6, 1+2+3+4+5의 4가지가 있다. 반면에 10을 나타내는 방법은 10, 1+2+3+4의 2가지가 있다.

N을 입력받아 가지수를 출력하는 프로그램을 작성하시오.

입력

첫 줄에 정수 N이 주어진다.

출력

입력된 자연수 N을 몇 개의 연속된 자연수의 합으로 나타내는 가지수를 출력하시오

```java
// me
// * 결과는 나오지만 반복문 중첩으로 비효율적 -> 메모리 초과
// * 투 포인터로 해결해보기
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long[] nums = new long[n + 1];
        nums[0] = 0;

        int length = (n+1)/2; 

        for (int i = 1; i <= length; i++) {
            nums[i] = nums[i - 1] + i;
        }
        
        int result = 1;
        for (int i = 1; i < length; i++) {
            for (int j = i + 1; j <= length; j++) {
                if (nums[j] - nums[i-1] == n) {
                    result++;
                    break;
                }
            }
        }
        System.out.println(result);
    }
}
```

```java
// doit
// * 투 포인터 활용
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        
        long start = 1;
        long end = 1;
        long sum = 1;
        int result = 0;
        
        while (start <= n) {
            if (sum < n) {
                end++;
                if (end > n) break;	// 없어도 되지만 있으면 훨씬 더 효율적
                sum += end;
            }
            else if (sum == n) {
                result++;
                sum -= start;
                start++;
            }
            else if (sum > n) {
                sum -= start;
                start++;
            }
        }
        System.out.println(result);
    }
}
```

기존 코드는 중첩 반복문을 써서 시간복잡도 N^2이 나오지만 투 포인터를 활용하면 시간복잡도 N -> 훨씬 효율적

---

1940 - 주몽

주몽은 철기군을 양성하기 위한 프로젝트에 나섰다. 그래서 야철대장을 통해 철기군이 입을 갑옷을 만들게 하였다. 야철대장은 주몽의 명에 따르기 위하여 연구에 착수하던 중 아래와 같은 사실을 발견하게 되었다.

갑옷을 만드는 재료들은 각각 고유한 번호를 가지고 있다. 갑옷은 두 개의 재료로 만드는데 두 재료의 고유한 번호를 합쳐서 M(1 ≤ M ≤ 10,000,000)이 되면 갑옷이 만들어 지게 된다. 야철대장은 자신이 만들고 있는 재료를 가지고 갑옷을 몇 개나 만들 수 있는지 궁금해졌다. 이러한 궁금증을 풀어 주기 위하여 N(1 ≤ N ≤ 15,000) 개의 재료와 M이 주어졌을 때 몇 개의 갑옷을 만들 수 있는지를 구하는 프로그램을 작성하시오.

입력

첫째 줄에는 재료의 개수 N(1 ≤ N ≤ 15,000)이 주어진다. 그리고 두 번째 줄에는 갑옷을 만드는데 필요한 수 M(1 ≤ M ≤ 10,000,000) 주어진다. 그리고 마지막으로 셋째 줄에는 N개의 재료들이 가진 고유한 번호들이 공백을 사이에 두고 주어진다. 고유한 번호는 100,000보다 작거나 같은 자연수이다.

출력

첫째 줄에 갑옷을 만들 수 있는 개수를 출력한다.

```java
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
      	// me ----------
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long m = sc.nextLong();

        long[] nums = new long[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextLong();
        }
      
      	// doit ----------
      	// * Scanner를 써도 되지만 입력값이 많기 때문에 BufferedReader가 더 유리
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st;

        // int n = Integer.parseInt(br.readLine());
        // int m = Integer.parseInt(br.readLine());

        // st = new StringTokenizer(br.readLine());

        // int[] nums = new int[n];
        // for (int i = 0; i < n; i++) {
        //     nums[i] = Integer.parseInt(st.nextToken()); 
        //}
      	// ----------
        
        Arrays.sort(nums);

        int start = 0;
        int end = n-1;

        long result = 0;
        while (start < end) {
            long sum = nums[start] + nums[end];
            if (sum < m) start++;
            else if (sum == m) {
                result++;
                start++;
                end--;
            }
            else if (sum > m) end--; 
        }
        System.out.println(result);
    }
}
```