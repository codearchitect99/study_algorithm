import java.util.Scanner;
import java.lang.Character;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int num = sc.nextInt();
        String input = sc.next();

        long result = 0;

        for (int i = 0; i < num; i++) {
            result += Character.getNumericValue(input.charAt(i));
        }
        
        System.out.println(result);
    }
}