package JavaAdvanced.MultidimensionalArrays.EX;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] command = scanner.nextLine().split("\\(");
        int degrees = (Integer.parseInt(command[1].replace(")", ""))) % 360; // 810 % 360 = 90dgr
        int rotationsNumber = degrees / 90 ;

        List<String> matrixCols = new ArrayList<>();
        String col = scanner.nextLine();

        int cols = 0;
        while (!col.equals("END")){
            matrixCols.add(col);

            if (cols < col.length()){
                cols = col.length();
            }

            col = scanner.nextLine();
        }

        for (int element = 0; element < matrixCols.size(); element++) {
            String currentElement = matrixCols.get(element);

            if (currentElement.length() < cols){
                for (int letter = currentElement.length(); letter < cols; letter++) {
                    currentElement = currentElement + " ";
                }
                matrixCols.set(element, currentElement);
            }

        }

        String[][] matrix = new String[matrixCols.size()][cols];
        fillMatrix(matrix, matrixCols);

            rotateMatrix(matrix, rotationsNumber, degrees);

    }

    private static void rotateMatrix(String[][] matrix, int rotationsNumber, int degrees) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        if (rotationsNumber % 2 == 1){
            int control = rows;
            rows = cols;
            cols = control;
        }

        String[][] matrixB = new String[rows][cols];

        for (int col = 0; col < matrix[0].length; col++) {
            int newRow = 0;
            int newCol = 0;
            for (int row = matrix.length - 1; row >= 0; row--) {
                if (degrees == 90){
                    newRow = col;
                    matrixB[newRow][newCol] = matrix[row][col];
                    newCol++;
                } else if (degrees == 180) {
                    newCol = matrix[0].length - 1 - col;
                    newRow = matrix.length - 1 - row;

                    matrixB[newRow][newCol] = matrix[row][col];

                }else if (degrees == 270){
                    newRow = matrix[0].length - 1 - col;
                    newCol = row;

                    matrixB[newRow][newCol] = matrix[row][col];

                }else /* 360 */ {
                    matrixB[row][col] = matrix[row][col];
                }
            }
        }

        for (int row = 0; row < matrixB.length; row++) {
            for (int col = 0; col < matrixB[row].length; col++) {
                System.out.print(matrixB[row][col]);
            }
            System.out.println();
        }
    }

    private static void fillMatrix(String[][] matrix, List<String> matrixCols) {
        for (int row = 0; row < matrix.length; row++) {
            String[] elements = matrixCols.get(row).split("");
            matrix[row] = elements;

        }
    }
}
