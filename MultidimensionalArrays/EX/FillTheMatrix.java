package JavaAdvanced.MultidimensionalArrays.EX;

import java.util.Arrays;
import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split(", ");

        int rowAndCol = Integer.parseInt(tokens[0]);
        String pattern = tokens[1];

        int[][] matrix = new int[rowAndCol][rowAndCol];

        switch (pattern){
            case "A" -> {
                fillMatrixA(matrix);
            }
            case "B" -> {
                fillMatrixB(matrix);
            }
        }

        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrixB(int[][] matrix) {
        int count = 1;
        for (int col = 0; col < matrix.length; col++) {
            if (col % 2 == 0){
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = count;
                    count++;
                }
            }else {
                for (int row = matrix.length - 1; row >= 0; row--) {
                    matrix[row][col] = count;
                    count++;
                }
            }
        }


    }

    private static void fillMatrixA(int[][] matrix) {
        int count = 1;
        for (int col = 0; col < matrix[0].length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = count;
                count++;
            }
        }
    }
}
