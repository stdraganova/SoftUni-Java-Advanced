package JavaAdvanced.MultidimensionalArrays.EX;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        // Създаваме двумерен масив
        int[][] matrix = fillMatrix(rows, cols);

        String command = scanner.nextLine();

        while (!command.equals("Nuke it from orbit")) {
            String[] tokens = command.split("\\s+");
            int row = Integer.parseInt(tokens[0]);
            int col = Integer.parseInt(tokens[1]);
            int radius = Integer.parseInt(tokens[2]);

            matrix = destroy(matrix, row, col, radius);

            command = scanner.nextLine();
        }

        // Принтиране на финалната матрица
        printMatrix(matrix);
    }

    private static int[][] fillMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        int count = 1;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = count++;
            }
        }
        return matrix;
    }

    private static int[][] destroy(int[][] matrix, int targetRow, int targetCol, int radius) {
        // Унищожаваме колоните (по вертикала)
        for (int row = Math.max(0, targetRow - radius); row <= Math.min(matrix.length - 1, targetRow + radius); row++) {
            if (targetCol >= 0 && targetCol < matrix[row].length) {
                matrix[row][targetCol] = -1;  // Маркираме за премахване
            }
        }

        // Унищожаваме редовете (по хоризонтала)
        if (targetRow >= 0 && targetRow < matrix.length) {
            for (int col = Math.max(0, targetCol - radius); col <= Math.min(matrix[targetRow].length - 1, targetCol + radius); col++) {
                matrix[targetRow][col] = -1;  // Маркираме за премахване
            }
        }

        // Премахваме маркираните елементи (-1) и създаваме нов масив
        List<int[]> newMatrix = new ArrayList<>();
        for (int[] row : matrix) {
            int validElements = 0;
            for (int num : row) {
                if (num != -1) {
                    validElements++;
                }
            }
            if (validElements > 0) {
                int[] newRow = new int[validElements];
                int index = 0;
                for (int num : row) {
                    if (num != -1) {
                        newRow[index++] = num;
                    }
                }
                newMatrix.add(newRow);
            }
        }

        return newMatrix.toArray(new int[0][]);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
