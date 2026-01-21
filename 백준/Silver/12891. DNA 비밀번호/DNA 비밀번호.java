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