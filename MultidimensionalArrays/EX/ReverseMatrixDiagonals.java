package JavaAdvanced.MultidimensionalArrays.EX;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Четене на размерите на матрицата
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine(); // Пропускане на новия ред

        // Създаване на матрицата и попълване
        int[][] matrix = new int[rows][cols];
        fillMatrix(matrix, scanner);

        // Отпечатване на диагоналите в обратен ред
        printDiagonals(matrix, rows, cols);
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }

    private static void printDiagonals(int[][] matrix, int rows, int cols) {
        List<List<Integer>> diagonals = new ArrayList<>();

        // Първо, обхождаме диагоналите, започвайки от долния десен ъгъл
        // Обхождаме колоните на последния ред
        for (int col = cols - 1; col >= 0; col--) {
            List<Integer> currentDiagonal = new ArrayList<>();
            int r = rows - 1;
            int c = col;
            while (r >= 0 && c < cols) {
                currentDiagonal.add(matrix[r][c]);
                r--;
                c++;
            }
            diagonals.add(currentDiagonal);
        }

        // След това обхождаме диагоналите, започвайки от долната част на последната колона
        for (int row = rows - 2; row >= 0; row--) {
            List<Integer> currentDiagonal = new ArrayList<>();
            int r = row;
            int c = 0;
            while (r >= 0 && c < cols) {
                currentDiagonal.add(matrix[r][c]);
                r--;
                c++;
            }
            diagonals.add(currentDiagonal);
        }

        // Отпечатваме диагоналите в обратен ред
        for (List<Integer> diagonal : diagonals) {
            for (int i = 0; i < diagonal.size(); i++) {
                System.out.print(diagonal.get(i));
                if (i < diagonal.size() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
