## SlidingWindow

12891 - DNA 비밀번호

평소에 문자열을 가지고 노는 것을 좋아하는 민호는 DNA 문자열을 알게 되었다. DNA 문자열은 모든 문자열에 등장하는 문자가 {‘A’, ‘C’, ‘G’, ‘T’} 인 문자열을 말한다. 예를 들어 “ACKA”는 DNA 문자열이 아니지만 “ACCA”는 DNA 문자열이다. 이런 신비한 문자열에 완전히 매료된 민호는 임의의 DNA 문자열을 만들고 만들어진 DNA 문자열의 부분문자열을 비밀번호로 사용하기로 마음먹었다.

하지만 민호는 이러한 방법에는 큰 문제가 있다는 것을 발견했다. 임의의 DNA 문자열의 부분문자열을 뽑았을 때 “AAAA”와 같이 보안에 취약한 비밀번호가 만들어 질 수 있기 때문이다. 그래서 민호는 부분문자열에서 등장하는 문자의 개수가 특정 개수 이상이여야 비밀번호로 사용할 수 있다는 규칙을 만들었다.

임의의 DNA문자열이 “AAACCTGCCAA” 이고 민호가 뽑을 부분문자열의 길이를 4라고 하자. 그리고 부분문자열에 ‘A’ 는 1개 이상, ‘C’는 1개 이상, ‘G’는 1개 이상, ‘T’는 0개 이상이 등장해야 비밀번호로 사용할 수 있다고 하자. 이때 “ACCT” 는 ‘G’ 가 1 개 이상 등장해야 한다는 조건을 만족하지 못해 비밀번호로 사용하지 못한다. 하지만 “GCCA” 은 모든 조건을 만족하기 때문에 비밀번호로 사용할 수 있다.

민호가 만든 임의의 DNA 문자열과 비밀번호로 사용할 부분분자열의 길이, 그리고 {‘A’, ‘C’, ‘G’, ‘T’} 가 각각 몇번 이상 등장해야 비밀번호로 사용할 수 있는지 순서대로 주어졌을 때 민호가 만들 수 있는 비밀번호의 종류의 수를 구하는 프로그램을 작성하자. 단 부분문자열이 등장하는 위치가 다르다면 부분문자열이 같다고 하더라도 다른 문자열로 취급한다.

입력

첫 번째 줄에 민호가 임의로 만든 DNA 문자열 길이 |S|와 비밀번호로 사용할 부분문자열의 길이 |P| 가 주어진다. (1 ≤ |P| ≤ |S| ≤ 1,000,000)

두번 째 줄에는 민호가 임의로 만든 DNA 문자열이 주어진다.

세번 째 줄에는 부분문자열에 포함되어야 할 {‘A’, ‘C’, ‘G’, ‘T’} 의 최소 개수가 공백을 구분으로 주어진다. 각각의 수는 |S| 보다 작거나 같은 음이 아닌 정수이며 총 합은 |S| 보다 작거나 같음이 보장된다.

출력

첫 번째 줄에 민호가 만들 수 있는 비밀번호의 종류의 수를 출력해라.

```java
// me
// 중복 반복문으로 비효율
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        String dna = new String(br.readLine());

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        
        int result = 0;
        for (int i = 0; i <= S-P; i++) {
            int a = 0, c = 0, g = 0, t = 0;
            for (int j = i; j < i+P; j++) {
                switch (dna.charAt(j)) {
                    case 'A': a++;
                              break;
                    case 'C': c++;
                              break;
                    case 'G': g++;
                              break;
                    case 'T': t++;
                              break;
                }
            }
            if (a >= A && c >= C && g >= G && t >= T) result++;
        }
        System.out.println(result);
    }
}
```

```java
// doit + me
// * 슬라이딩 윈도우 활용
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[] checkArr = new int[4];
    private static int[] myCheck = new int[4];
    private static char[] input;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
       
        input = new char[S];
        input = br.readLine().toCharArray();
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;

        for (int i = 0; i < P; i++) {
            add(i);
        }

        if (checkDNA()) result++; 

        int addIdx = P;
        int removeIdx = 0;
        while (addIdx < S) {
            add(addIdx); 
            remove(removeIdx);
            if (checkDNA()) result++;
            addIdx++;
            removeIdx++;
        }

        System.out.println(result);
    }

    private static boolean checkDNA() {
        for (int i = 0; i < 4; i++) {
            if (myCheck[i] < checkArr[i]) return false;
        }
        return true;
    }

    private static void add(int idx) {
        switch (input[idx]) {
            case 'A': myCheck[0]++;
                      break;
            case 'C': myCheck[1]++;
                      break;
            case 'G': myCheck[2]++;
                      break;
            case 'T': myCheck[3]++;
                      break;
        }
    }

    private static void remove(int idx) {
        switch (input[idx]) {
            case 'A': myCheck[0]--;
                      break;
            case 'C': myCheck[1]--;
                      break;
            case 'G': myCheck[2]--;
                      break;
            case 'T': myCheck[3]--;
                      break;
        }
    }
}
```

me => 슬라이딩 윈도우인 척하는 알고리즘 / 시작점을 두고 반복문이 돌아간다 -> 중복 검증, 한 문자가 여러번 검증받는다.

doit + me => 슬라이딩 윈도우 올바르게 적용 / 기존 검증은 놔두고 양끝단만 추가 제거하며 검증 -> 중복 검증x, 이미 검증받은 문자는 재검증x