package JavaAdvanced.MultidimensionalArrays.EX;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowAndCol = scanner.nextInt();
        scanner.nextLine();

        int[][] matrix = new int[rowAndCol][rowAndCol];
        fillMatrix(matrix, scanner);

        System.out.println(Math.abs(sumPrimaryDiagonal(matrix) - sumSecondaryDiagonal(matrix)));
    }

    private static int sumSecondaryDiagonal(int[][] matrix) {
        int sum = 0;
        int count = 0;

        for (int row = matrix.length - 1; row >= 0; row--) {
            sum += matrix[row][count];
            count++;
        }

        return sum;
    }

    private static int sumPrimaryDiagonal(int[][] matrix) {
        int sum = 0;

        for (int row = 0; row < matrix.length; row++) {
                sum += matrix[row][row];

        }

        return sum;
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] =Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
    }
}
