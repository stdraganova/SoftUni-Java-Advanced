package JavaAdvanced.MultidimensionalArrays.EX;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tokens = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows = tokens[0];
        int cols = tokens[1];

        String[][] matrix = new String[rows][cols];
        fillMatrix(matrix, scanner);

        String[] command = scanner.nextLine().split("\\s+");
        while (!command[0].equals("END")) {
            boolean isValid = true;

            if (command.length != 5 || !command[0].equals("swap") || !checkCordinats(command, matrix,rows, cols)) {
                isValid = false;
            }

            if (isValid) {
                swapElements(matrix, command);
            } else {
                System.out.println("Invalid input!");
            }

            command = scanner.nextLine().split("\\s+");
        }
    }

    private static boolean checkCordinats(String[] command, String[][] matrix, int rows, int cols) {
        boolean isValid = true;

        int firstRow = Integer.parseInt(command[1]);
        int firstCol = Integer.parseInt(command[2]);

        int secondRow = Integer.parseInt(command[3]);
        int secondCol = Integer.parseInt(command[4]);

        if ((firstRow < 0 || firstRow >= rows) || (secondRow < 0 || secondRow >= rows)
        && (firstCol < 0 || firstCol >= cols) || (secondCol < 0 || secondCol >= cols)){
            isValid = false;
        }
        return isValid;
    }

    private static void swapElements(String[][] matrix, String[] command) {
        int firstRow = Integer.parseInt(command[1]);
        int firstCol = Integer.parseInt(command[2]);

        int secondRow = Integer.parseInt(command[3]);
        int secondCol = Integer.parseInt(command[4]);

        String controlStr = matrix[firstRow][firstCol];
        matrix[firstRow][firstCol] = matrix[secondRow][secondCol];
        matrix[secondRow][secondCol] = controlStr;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
           matrix[row] = scanner.nextLine().split("\\s+");
        }
    }
}
