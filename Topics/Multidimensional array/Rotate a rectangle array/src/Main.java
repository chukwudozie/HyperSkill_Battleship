import java.util.Arrays;
import java.util.Scanner;

/**
 * Rotate an m x n to n x m (transpose of the matrix)
 */
class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int column = scanner.nextInt();
        int [][] inputArray = new int[row][column];

        for (int i = 0; i < inputArray.length;i++){
            for (int j = 0; j < inputArray[i].length; j++) {
                inputArray[i][j] = scanner.nextInt();
            }
        }
        rotateArray(inputArray);

    }

    private static void rotateArray(int[][] array) {
//        System.out.println("I came here");
        int [] [] rotatedArray = new int[array[0].length][array.length] ;

        for (int i = 0; i < rotatedArray.length; i++){
            for (int j = 0, l = array.length - 1; j < array.length && l >=0;j++,l--) {
                rotatedArray[i][j] = array[l][i];
                System.out.print(rotatedArray[i][j] +" ");
            }
            System.out.println();
        }
    }
}