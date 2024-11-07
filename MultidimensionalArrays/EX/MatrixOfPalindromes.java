package JavaAdvanced.MultidimensionalArrays.EX;

import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        String[][] matrix = new String[rows][cols];
        fillMatrix(matrix);
        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(String[][] matrix) {
        char initialLetter = 'a';
        for (int row = 0; row < matrix.length; row++) {
             char firstLetter = (char)(initialLetter + row);
            for (int col = 0; col < matrix[row].length; col++) {
                char middleLetter = (char)(firstLetter + col);
                String palindrome = String.valueOf(firstLetter) + middleLetter + firstLetter;

                matrix[row][col] = palindrome;
            }
        }
    }
}
