import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [][] output = new int[n][n];
        boolean isSymmetric = true;
        for (int row = 0; row < output.length; row++) {
            for (int column = 0; column < output[row].length; column++) {
                output[row][column] = scanner.nextInt();
            }
        }

        for (int row = 0; row< output.length; row++) {
            for (int col = 0; col < output[row].length; col++) {
                if (output[row][col] != output[col][row]) {
                    isSymmetric = false;
                    break;
                }
            }
        }

        if (isSymmetric) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

}