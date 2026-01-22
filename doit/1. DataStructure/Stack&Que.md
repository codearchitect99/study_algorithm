## Stack&Que

스택: LIFO

DFS, 백트래킹에 활용

- push : top에 값 추가
- pop : top 값 제거 후 출력
- peek : top 값 출력(제거x)

큐 : FIFO

BFS에 활용

- reer : 입구
- front : 출구
- add : reer에 값 추가
- poll : front 값 제거 후 출력
- peek : front 값 출력(제거x)

---

### Stack

1874 - 스택 수열

스택 (stack)은 기본적인 자료구조 중 하나로, 컴퓨터 프로그램을 작성할 때 자주 이용되는 개념이다. 스택은 자료를 넣는 (push) 입구와 자료를 뽑는 (pop) 입구가 같아 제일 나중에 들어간 자료가 제일 먼저 나오는 (LIFO, Last in First out) 특성을 가지고 있다.

1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다. 이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자. 임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지, 있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다. 이를 계산하는 프로그램을 작성하라.

입력

첫 줄에 n (1 ≤ n ≤ 100,000)이 주어진다. 둘째 줄부터 n개의 줄에는 수열을 이루는 1이상 n이하의 정수가 하나씩 순서대로 주어진다. 물론 같은 정수가 두 번 나오는 일은 없다.

출력

입력된 수열을 만들기 위해 필요한 연산을 한 줄에 한 개씩 출력한다. push연산은 +로, pop 연산은 -로 표현하도록 한다. 불가능한 경우 NO를 출력한다.

```java
import java.util.Scanner;
import java.util.Stack;

public class Main {
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        
        StringBuilder sb = new StringBuilder();

        int num = 1;
     		// me ----------
     		// * 선 push 후 진행
        // stack.push(num++);
        // sb.append("+\n");
     		// do it ----------
     		// * 선 push를 하지 않아도 됨
     		// ----------

        for (int i = 0; i < n; i++) {
          	// me ----------
          	// * stack이 비어 있으면 peek() 오류 발생
          	// * != 연산은 무한 루프 가능성
            // while (nums[i] != stack.peek()) {
            //     stack.push(num++);
            //     sb.append("+\n");
            // }
          	// doit ----------
          	// * stack top값이 아닌 num값과 비교가 적합
		        // * >= 연산을 활용하여 무한 루프 방지
          	while (nums[i] >= num) {
              	stack.push(num++);
              	sb.append("+\n");
            }
          	
          	// me ----------
          	// * stack 값이 비어있으면 peek() 오류 발생
            // if (stack.peek() == nums[i]) {
            //     stack.pop();
            //     sb.append("-\n");
            // }
          	// doit ----------
          	// * isEmpty()를 활용하여 오류 방지
          	if (!stack.isEmpty() && stack.peek() == nums[i]) {
              	stack.pop();
              	sb.append("-\n");
            }
          	// ----------
            else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb.toString());
    }
}
```

---

### Queue

2164 - 카드2

N장의 카드가 있다. 각각의 카드는 차례로 1부터 N까지의 번호가 붙어 있으며, 1번 카드가 제일 위에, N번 카드가 제일 아래인 상태로 순서대로 카드가 놓여 있다.

이제 다음과 같은 동작을 카드가 한 장 남을 때까지 반복하게 된다. 우선, 제일 위에 있는 카드를 바닥에 버린다. 그 다음, 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다.

예를 들어 N=4인 경우를 생각해 보자. 카드는 제일 위에서부터 1234 의 순서로 놓여있다. 1을 버리면 234가 남는다. 여기서 2를 제일 아래로 옮기면 342가 된다. 3을 버리면 42가 되고, 4를 밑으로 옮기면 24가 된다. 마지막으로 2를 버리고 나면, 남는 카드는 4가 된다.

N이 주어졌을 때, 제일 마지막에 남게 되는 카드를 구하는 프로그램을 작성하시오.

입력

첫째 줄에 정수 N(1 ≤ N ≤ 500,000)이 주어진다.

출력

첫째 줄에 남게 되는 카드의 번호를 출력한다.

```java
// me - ArrayDeque, offer, poll 이용
// doit - LinkedList, add, poll 이용
import java.util.Scanner;
import java.util.ArrayDeque;

public class Main {
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

       int n = sc.nextInt();

       ArrayDeque<Integer> q = new ArrayDeque<>();

       for (int i = 1; i <= n; i++) q.offer(i);

       boolean isTrash = true;
       while (q.size() > 1) {
           if (isTrash) {
               q.poll();
           } else {
               q.offer(q.poll());
           }
           isTrash = !isTrash;
       }
       System.out.println(q.poll());
    }
}
```

LinkedList: 노드, 포인터를 이용한 배열임으로 활용도는 좋으나 메모리 많이 먹음

ArrayDeque: 메모리를 효율적으로 사용 가능

---

### PriorityQueue

11286 - 절댓값 힙

절댓값 힙은 다음과 같은 연산을 지원하는 자료구조이다.

1. 배열에 정수 x (x ≠ 0)를 넣는다.
2. 배열에서 절댓값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다. 절댓값이 가장 작은 값이 여러개일 때는, 가장 작은 수를 출력하고, 그 값을 배열에서 제거한다.

프로그램은 처음에 비어있는 배열에서 시작하게 된다.

입력

첫째 줄에 연산의 개수 N(1≤N≤100,000)이 주어진다. 다음 N개의 줄에는 연산에 대한 정보를 나타내는 정수 x가 주어진다. 만약 x가 0이 아니라면 배열에 x라는 값을 넣는(추가하는) 연산이고, x가 0이라면 배열에서 절댓값이 가장 작은 값을 출력하고 그 값을 배열에서 제거하는 경우이다. 입력되는 정수는 -231보다 크고, 231보다 작다.

출력

입력에서 0이 주어진 회수만큼 답을 출력한다. 만약 배열이 비어 있는 경우인데 절댓값이 가장 작은 값을 출력하라고 한 경우에는 0을 출력하면 된다.

```java
// me - Scanner 이용
// doit - BufferedReader, InputStreamReader 이용
import java.util.Scanner;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> {
            int absA = Math.abs(a);
            int absB = Math.abs(b);
            if (absA == absB) return a - b;
            return absA - absB;
        });

        for (int i = 0; i < n; i++) {
            int input = sc.nextInt();
            if (input != 0) {
                q.offer(input);
            }
            else {
                if (q.isEmpty()) System.out.println(0);
                else System.out.println(q.poll());
            }
        }
    }
}
```

PriorityQueue 람다 함수는 compare 함수의 원리와 결이 같다.

```java
// compare(a, b) 리턴 값이 음수, 양수, 0인지만 판단하며 크기(정도)는 보지 않는다.
// a = 10, b = 12
Integer.compare(a, b)    // return -2 | 음수는 a가 작다를 의미한다.
// a = 30, b = 1
Integer.compare(a,b)    // return 29 | 양수는 a가 크다를 의미한다.
```

```java
// a가 작은 값이면 a를 우선순위로 한다 => 즉, 작은 값을 우선 순위로 한다.
new PriorityQueue<>((a, b) -> a - b);
```

