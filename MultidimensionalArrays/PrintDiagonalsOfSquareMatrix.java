package JavaAdvanced.MultidimensionalArrays;

import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowsAndCols = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[rowsAndCols][rowsAndCols];
        fillMatrix(matrix, scanner);

        primaryDiagonal(matrix);
        System.out.println();
        secondaryDiagonal(matrix);
    }

    private static void secondaryDiagonal(int[][] matrix) {
        int count = 0;

        for (int row = matrix.length - 1 ; row >= 0; row--) {
            System.out.print(matrix[row][count] + " ");
            count++;
        }
    }

    private static void primaryDiagonal(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            System.out.print(matrix[row][row] + " ");
        }
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = Integer.parseInt(tokens[col]);
            }
        }
    }
}
