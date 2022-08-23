import java.util.Objects;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        while (!Objects.equals(input, "0")) {
            try {
                int num = Integer.parseInt(input);
                int answer = num * 10;
                System.out.println(answer);

            } catch (NumberFormatException e) {
                System.out.println("Invalid user input: " + input);
            } finally {
                input = scanner.next();
            }
        }
    }
}