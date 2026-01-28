## Array&List

배열

- 연속 공간에 값이 채워져 있는 형태의 자료구조
- 인덱스를 사용하여 값에 접근할 수 있다.
- 값을 삽입하거나 삭제하기 어렵다.
- 값을 삽입하거나 삭제하려면 해당 인덱스 주변 값을 이동시키는 과정이 필요하다.
- 배열의 크기는 한 번 선언하면 크기를 늘리거나 줄일 수 없다.

리스트

- 값과 포인터를 묶은 노드라는 것을 포인터로 연결한 자료구조
- 값에 접근하려면 Head 포인터부터 순서대로 접근해야한다.
- 데이터를 삽입하거나 삭제하는 연산 속도가 빠르다.
- 선언할 때, 크기를 별도로 지정하지 않아도 된다. -> 크기가 변하기 쉬운 데이터를 다룰 때 적절하다.
- 포인터를 지정할 공간이 필요하므로 구조가 복잡하다.

---

11720 - 숫자의 합

N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 숫자의 개수 N (1 ≤ N ≤ 100)이 주어진다. 둘째 줄에 숫자 N개가 공백없이 주어진다.

출력
입력으로 주어진 숫자 N개의 합을 출력한다.

```java
import java.util.Scanner;
// import java.lang.Character;		// getNumericValue() 사용하지 않고 가능

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int num = sc.nextInt();
        String input = sc.next();

        // doit code - char array로 변환 추가
				char[] cInput = input.toCharArray();
      
        int result = 0;

        for (int i = 0; i < num; i++) {
          	// my code
            // result += Character.getNumericValue(input.charAt(i));
          
          	// doit code
            result += cInput[i] - '0';
        }
        
        System.out.println(result);
    }
}
```

- getNumberticValue()를 사용하냐 vs char[] 배열을 이용하여 " - '0' "를 사용하냐
- char[] 배열을 이용하는 것이 더 효율적

---

1546 - 평균

세준이는 기말고사를 망쳤다. 세준이는 점수를 조작해서 집에 가져가기로 했다. 일단 세준이는 자기 점수 중에 최댓값을 골랐다. 이 값을 M이라고 한다. 그리고 나서 모든 점수를 점수/M*100으로 고쳤다.*
예를 들어, 세준이의 최고점이 70이고, 수학점수가 50이었으면 수학점수는 50/70*100이 되어 71.43점이 된다.
세준이의 성적을 위의 방법대로 새로 계산했을 때, 새로운 평균을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 시험 본 과목의 개수 N이 주어진다. 이 값은 1000보다 작거나 같다. 둘째 줄에 세준이의 현재 성적이 주어진다. 이 값은 100보다 작거나 같은 음이 아닌 정수이고, 적어도 하나의 값은 0보다 크다.

출력
첫째 줄에 새로운 평균을 출력한다. 실제 정답과 출력값의 절대오차 또는 상대오차가 10-2 이하이면 정답이다.

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] grades = new int[n];

        // ----------
        // me
        // * 최댓값을 입력받으면서 구하고 각각 double 연산
        // int max = Integer.MIN_VALUE;
        // for (int i = 0; i < num; i++) {
        //     grades[i] = sc.nextInt();
        //     max = max < grades[i] ? grades[i] : max;
        // }
        //
        // double result = 0;
        // for (int i = 0; i < num; i++) {
        //     result += (double) grades[i] / max * 100.0;
        // }
        //
        // System.out.println(result/num);
        // ----------

        // doit
        // * 최댓값, 입력 동시에 작동하고 마지막에 한번에 연산
        // * 한번에 연산하기에 double 연산 필요x
        int max = 0;
        int sum = 0;
 
        for (int i = 0; i < n; i++) {
            grades[i] = sc.nextInt();
            max = (max < grades[i]) ? grades[i] : max;
            sum += grades[i];
        }

        System.out.println(sum * 100.0 / max / n);
    }
}
```
