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