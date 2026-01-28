## SelectionSort

최대 or 최소를 찾아 데이터 나열

시간복잡도: O(n²)

1. index 0부터 시작한다.
2. 현재 index를 기준 위치로 잡는다.
3. 현재 index 이후 구간에서 가장 작은 값의 index를 찾는다.
4. 찾은 최소값 index와 현재 index를 swap한다.
5. 현재 index는 확정된 위치가 된다.
6. 다음 index로 이동해 1~5를 반복한다.

---

1427 - 소트인사이드

배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.

입력
첫째 줄에 정렬하려고 하는 수 N이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수이다.

출력
첫째 줄에 자리수를 내림차순으로 정렬한 수를 출력한다.

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);

        String input = sc.next(); 
        int length = input.length();
        char[] cArr = input.toCharArray();

        int[] nums = new int[length];
        
        for (int i = 0; i < length; i++) {
            nums[i] = cArr[i] - '0'; 
        }

        for (int i =0; i < length-1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < length; j++) {
                if (nums[maxIdx] < nums[j]) maxIdx = j;
            }
            if (maxIdx != i) {
                int temp = nums[maxIdx];
                nums[maxIdx] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i]);
        }
    }
}
```

