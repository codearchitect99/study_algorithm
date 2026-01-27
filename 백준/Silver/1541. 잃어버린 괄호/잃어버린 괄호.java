import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] str = input.split("-");

        int result = sum(str[0]);
        for (int i = 1; i < str.length; i++) {
            result -= sum(str[i]);
        }

        System.out.println(result);
    }

    private static int sum(String txt) {
        String[] str = txt.split("[+]");
        int result = Integer.parseInt(str[0]);
        for (int i = 1; i < str.length; i++) {
            result += Integer.parseInt(str[i]);
        }
        return result;
    }
}