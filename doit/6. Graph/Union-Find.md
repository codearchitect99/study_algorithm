## Union-Find

Union 연산: 두 집합을 하나의 집합으로 하나로 합치는 연산

- 한 집합의 대표를 다른 집합의 대표에 연결

Find 연산: 어떤 원소가 속한 집합의 대표를 찾는 연산

- Path Comprassion(경로 압축)을 사용

1. 초기화: 모든 노드는 자기 자신을 대표 노드로 가지고 있는 집합으로 시작
2. Find: 부모 노드를 따라가며 대표 노드에 도달할 때까지 이동한다.
   - 경로 압축을 사용하여 바로 대표 노드를 가리키도록 갱신한다.
3. Union: 두 노드의 대표 노드를 각각 찾는다.
   - 하나의 대표 노드를 다른 대표 노드에 연결하여 두 집합을 하나로 합친다.
4. 판별: 두 노드의 대표 노드가 같으면 같은 집합, 다르면 서로 다른 집합

---

1717 - 집합의 표현

초기에 n+1개의 집합 {0\}, \{1\}, \{2\}, ... , {n}이 있다. 여기에 합집합 연산과, 두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산을 수행하려고 한다.
집합을 표현하는 프로그램을 작성하시오.

입력
첫째 줄에 n, m이 주어진다. m은 입력으로 주어지는 연산의 개수이다. 다음 m개의 줄에는 각각의 연산이 주어진다. 합집합은 0 a b의 형태로 입력이 주어진다. 이는 a가 포함되어 있는 집합과, b가 포함되어 있는 집합을 합친다는 의미이다. 두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산은 1 a b의 형태로 입력이 주어진다. 이는 a와 b가 같은 집합에 포함되어 있는지를 확인하는 연산이다.

출력
1로 시작하는 입력에 대해서 a와 b가 같은 집합에 포함되어 있으면 YES 또는 yes를, 그렇지 않다면 NO 또는 no를 한 줄에 하나씩 출력한다.

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static int[] arr; // 노드 배열

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // n: 노드 수, m: 연산 수
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        
        // 초기화: 각 노드는 자기 자신이 대표
        arr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = i;
        }

      	// 연산
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int check = Integer.parseInt(input[0]);
            int a = Integer.parseInt(input[1]);
            int b = Integer.parseInt(input[2]);

            if (check == 0) {
                union(a, b);    // 두 집합 합치기
            }

            if (check == 1) {    // 같은 집합인지 확인
                if (find(a) == find(b)) sb.append("yes\n");
                else sb.append("no\n");
            }
        }
        System.out.print(sb);
    }

    // 대표 노드 찾기 (경로 압축)
    public static int find(int node) {
        if (node == arr[node]) return node;
        arr[node] = find(arr[node]);
        return arr[node];
    }
    
    // 두 집합 합치기
    public static void union(int a, int b) {
				a = find(a);
        b = find(b);
        if (a == b) return;    // 이미 같은 집합
        if (a < b) arr[b] = a;    // 대표 노드 번호가 작은 쪽을 대표로 사용
        else arr[a] = b;
    }
}
```

union 연산에서는 합집합 수행 시,  대표 노드의 부모만 변경하면 된다.
다른 노드들의 부모 정보는 이후 find 연산에서 경로 압축을 통해 갱신된다.
