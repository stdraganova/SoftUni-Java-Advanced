package JavaAdvanced.MultidimensionalArrays;

import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Четем бр.редове и колони на първата матрица и я създаваме
        int rows1 = scanner.nextInt();
        int cols1 = scanner.nextInt();

        int[][] matrix1 = new int[rows1][cols1];

        //Попълваме матрица 1
        fillMatrix(matrix1, scanner);

        //Четем бр.редове и колони на втората матрица и я създаваме
        int rows2 = scanner.nextInt();
        int cols2 = scanner.nextInt();

        int[][] matrix2 = new int[rows2][cols2];

        //Попълваме матрица 2
        fillMatrix(matrix2, scanner);

        System.out.println(compareMatrix(matrix1, matrix2) ? "equal" : "not equal");
    }

    private static boolean compareMatrix(int[][] matrix1, int[][] matrix2) {
        boolean areEqual = true;

        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length){
            areEqual = false;
        }else {
            for (int row = 0; row < matrix1.length; row++) {
                for (int col = 0; col < matrix1[row].length; col++) {
                    if (matrix1[row][col] != matrix2[row][col]) {
                        areEqual = false;
                    }
                }
            }
        }
         return areEqual;
    }

    private static int[][] fillMatrix(int[][] matrix, Scanner scanner) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
        return matrix;
    }
}
