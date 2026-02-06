## TopologicalSort

위상 정렬은 사이클이 없는 방향 그래프에서 노드 순서를 찾는 알고리즘

- 노드 간의 순서를 결정
- 사이클이 없어야 함
- 항상 유일한 값으로 정렬되지 않는다.

시간복잡도: O(V + E) (V: 노드 수, E: 엣지 수)

In Degree 진입 차수: 자기 자신을 가리키는 에지 갯수

1. 각 노드의 진입 차수를 배열 D[n]에 저장한다.
2. D[i] == 0 인 노드를 큐에 넣는다.
3. 큐에서 노드를 하나 꺼내 결과 순서에 추가한다.
4. 해당 노드에서 받는 노드들의 진입 차수를 1 감소시킨다.
5. 진입 차수가 0이 된 노드를 큐에 추가한다.
6. 큐가 빌 때까지 3~5 과정을 반복한다.
7. 모든 노드가 결과에 포함되면 위상 정렬 성공,
   중간에 더 이상 처리할 노드가 없으면 사이클이 존재한다.

---

2252 - 줄 세우기

N명의 학생들을 키 순서대로 줄을 세우려고 한다. 각 학생의 키를 직접 재서 정렬하면 간단하겠지만, 마땅한 방법이 없어서 두 학생의 키를 비교하는 방법을 사용하기로 하였다. 그나마도 모든 학생들을 다 비교해 본 것이 아니고, 일부 학생들의 키만을 비교해 보았다.
일부 학생들의 키를 비교한 결과가 주어졌을 때, 줄을 세우는 프로그램을 작성하시오.

입력
첫째 줄에 N(1 ≤ N ≤ 32,000), M(1 ≤ M ≤ 100,000)이 주어진다. M은 키를 비교한 횟수이다. 다음 M개의 줄에는 키를 비교한 두 학생의 번호 A, B가 주어진다. 이는 학생 A가 학생 B의 앞에 서야 한다는 의미이다.
학생들의 번호는 1번부터 N번이다.

출력
첫째 줄에 학생들을 앞에서부터 줄을 세운 결과를 출력한다. 답이 여러 가지인 경우에는 아무거나 출력한다.

```java
// me
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.ArrayDeque;

public class Main {
    private static ArrayDeque<Integer> q = new ArrayDeque<>();    // 위상정렬 큐
    private static StringBuilder sb = new StringBuilder();    // 결괏값 입력 용도
    private static int n;
    private static int m;
    private static ArrayList<Integer>[] edges;    // idx에 있는 사람은 edges[idx] 사람들보다 앞에 서야한다.
    private static int[] counts;    // idx 사람 앞에 최소 몇명 있어야하는지
    private static boolean[] used;    // 이미 줄 선 사람
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        used = new boolean[n + 1];
        edges = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }
        counts = new int[n + 1];

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int front = Integer.parseInt(input[0]);
            int back = Integer.parseInt(input[1]);
            edges[front].add(back);
            counts[back]++;
        }

        sort(0);    // 맨 앞 0 번째 학생 세우기

        System.out.println(sb);
    }

    private static void sort(int idx) {
        if (q.isEmpty()) {    // 큐가 비어있으면 또는 첫 시작일 때, 줄 세울 사람 찾기
            for (int i = 1; i <= n; i++) {
                if (counts[i] == 0 && used[i] == false) {    // 줄을 서지 않은 사람 중 줄 설 사람
                    q.offer(i);
                }
            }
        }
        if (q.isEmpty()) return;    // 줄 설 사람이 더 이상 존재하지 않으면 종료
        int current = q.poll();    // 줄 설 사람 줄 세우기
        used[current] = true;    // 줄 섰으니 true
        sb.append(current).append(" ");
        for (int i : edges[current]) {
            counts[i]--;    // 한명 줄 섰으니 그 뒤에 올 사람의 값을 줄임
            if (counts[i] == 0 && used[i] == false) q.offer(i);    // 값을 줄이고 줄 설 차례되면 큐에 추가
        }
        sort(idx + 1);    // 그 다음 줄 서기 실행
    }
}
```

```java
// doit + me
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.ArrayDeque;

public class Main {
    private static ArrayDeque<Integer> q = new ArrayDeque<>();
    private static StringBuilder sb = new StringBuilder();
    private static int n;
    private static int m;
    private static ArrayList<Integer>[] edges;
    private static int[] counts;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        edges = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }
        counts = new int[n + 1];
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int front = Integer.parseInt(input[0]);
            int back = Integer.parseInt(input[1]);
            edges[front].add(back);
            counts[back]++;
        }

        for (int i = 1; i <= n; i++) {
            if (counts[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int current = q.poll();
            sb.append(current).append(" ");
            for (int i : edges[current]) {
                counts[i]--;
                if (counts[i] == 0) q.offer(i);
            }
        }

        System.out.println(sb);
    }
}
```

me: 재귀를 이용하여 다 세울 때까지 반복 실행

- 시간 복잡도: O(n²)

doit

- while 반복분을 이용하여 큐가 빌 때까지 반복 실행
- 위상 정렬 정석
- 시간복잡도: O(n + m)

위상정렬하는 방식에서 me 코드는 빌 때마다 스캔하여 큐에 추가 하지만 위상 정렬은 굳이 재스캔할 필요가 없다