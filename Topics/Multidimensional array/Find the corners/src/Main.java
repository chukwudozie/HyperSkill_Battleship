/**
 * You need to implement printCorners method.
 * It should print all corner elements of the twoDimArray
 * in the following order: left to right and top to bottom.
 */
class ArrayOperations {
    public static void main(String[] args) {
        int [][] input = {{1,0,2},{0,0,0},{3,0,4}};
        int [][] input2 = {{1},{2},{3}};
        printCorners(input2);
    }
    public static void printCorners(int[][] twoDimArray) {
        int [] firstRow = twoDimArray[0];
        int [] lastRow = twoDimArray[twoDimArray.length - 1];
        System.out.println(firstRow[0]+" "+firstRow[firstRow.length - 1]);
        System.out.println(lastRow[0]+" "+lastRow[lastRow.length - 1]);
        // write your code here

    }
}