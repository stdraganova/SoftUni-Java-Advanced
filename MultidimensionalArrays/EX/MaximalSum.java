package JavaAdvanced.MultidimensionalArrays.EX;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        int[][] matrix = new int[rows][cols];
        fillMatrix(matrix, scanner);

        int[] cordinats = new int[2];
        System.out.printf("Sum = %d%n", findTheBigestSum(matrix,cordinats));

        printMatrix(matrix, cordinats);
    }

    private static void printMatrix(int[][] matrix, int[] cordinats) {
        for (int row = cordinats[0]; row < cordinats[0] + 3; row++) {
            for (int col = cordinats[1]; col < cordinats[1] + 3; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int findTheBigestSum(int[][] matrix, int[] cordinats) {
        int sum = Integer.MIN_VALUE;

        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                int currentSum = 0;

                for (int currentRow = row; currentRow < row + 3; currentRow++) {
                    for (int currentCol = col; currentCol < col + 3; currentCol++) {
                        currentSum += matrix[currentRow][currentCol];
                    }
                }

                if (currentSum > sum){
                    sum = currentSum;
                    cordinats[0] = row;
                    cordinats[1] = col;
                }
            }
        }

        return sum;
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
    }
}
