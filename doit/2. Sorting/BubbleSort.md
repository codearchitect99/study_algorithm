## BubbleSort

인접한 데이터 크기를 비교하여 swap 연산 정렬

시간복잡도: O(n²)

1. index 0부터 인접한 index끼리 비교한다.
2. 앞 index의 값이 더 크면 swap한다.
3. swap이 반복되면서 큰 값이 오른쪽 index로 이동한다.
4. 한 패스가 끝나면 가장 큰 값이 마지막 index에 확정된다.
5. 확정된 마지막 index를 제외하고 다시 1~4를 반복한다.
6. 전체가 정렬될 때까지 반복한다.

---

2750 - 수 정렬하기

N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

입력

첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.

출력

첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.

```java
// me + doit
import java.util.Scanner;

public class Main {
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        
        for (int j = 0; j < n-1; j++) {
            for (int i = 0; i < n-1-j; i++) {
                if (nums[i] > nums[i+1]) {
                    int temp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = temp;
                }
            }
        }
        

        for (int i = 0; i < n; i++) {
            System.out.println(nums[i]);
        }
    }
}
```
