package JavaAdvanced.MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] matrix1 = new char[rows][cols];
        fillMatrix(matrix1, scanner);

        char[][] matrix2 = new char[rows][cols];
        fillMatrix(matrix2, scanner);

        for (int row = 0; row < matrix1.length; row++) {
            for (int col = 0; col < matrix1[row].length; col++) {
                if (matrix1[row][col] != matrix2[row][col]){
                    System.out.print("* ");
                }else {
                    System.out.print(matrix1[row][col] + " ");
                }
            }
            System.out.println();
        }
    }

    private static void fillMatrix(char[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            String tokens = scanner.nextLine().replaceAll(" ","");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = tokens.charAt(col);
            }
        }
    }
}
