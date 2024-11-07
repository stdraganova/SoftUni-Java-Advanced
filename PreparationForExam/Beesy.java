package JavaAdvanced.PreparationForExam;

import java.util.Arrays;
import java.util.Scanner;

public class Beesy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char[][]field = new char[n][n];
        int[] beePosition = fillMatrix(field, n, scanner);
        int beeRow = beePosition[0];
        int beeCol = beePosition[1];

        int beeEnergy = 15;
        int nectar = 0;

        boolean isHavierReached = false;
        boolean energyRechargerOnce = false;

        String command = scanner.nextLine();

        while (beeEnergy > 0 && !isHavierReached){

            int previousRow = beeRow;
            int previousCol = beeCol;

            switch (command){
                case "up" ->{
                    beeRow--;
                }
                case "down" ->{
                    beeRow++;
                }
                case "left" ->{
                    beeCol--;
                }
                case "right" ->{
                    beeCol++;
                }
            }

            beeEnergy--;

            if (beeRow < 0 ){
                beeRow = field.length - 1;
            } else if (beeRow > field.length - 1) {
                beeRow = 0;
            }

            if (beeCol < 0){
                beeCol = field[beeRow].length - 1;
            } else if (beeCol > field[beeRow].length - 1) {
                beeCol = 0;
            }

            char symbol = field[beeRow][beeCol];
            field[beeRow][beeCol] = 'B';
            field[previousRow][previousCol] = '-';

            if (Character.isDigit(symbol)){
                nectar += Integer.parseInt(String.valueOf(symbol));
            } else if (symbol == 'H') {
                isHavierReached = true;
                break;
            }

            if (beeEnergy <= 0 && nectar > 30 && !energyRechargerOnce){
                int difference = nectar - 30;
                nectar -= difference;
                beeEnergy = difference;
                energyRechargerOnce = true;
            }

            command = scanner.nextLine();
        }

        if (isHavierReached && nectar >= 30){
            System.out.printf("Great job, Beesy! The hive is full. Energy left: %d%n", beeEnergy);
        } else if (isHavierReached && nectar < 30) {
            System.out.println("Beesy did not manage to collect enough nectar.");
        } else if (beeEnergy <= 0 && !isHavierReached) {
            System.out.println("This is the end! Beesy ran out of energy.");
        }

        printField(field);
    }

    private static void printField(char[][] field) {
        for (char[] row : field){
            System.out.println(row);
        }
    }

    private static int[] fillMatrix(char[][] field, int n, Scanner scanner) {
        int[] startPosition = new int[2];
        boolean bIsNotFound = true;

        for (int row = 0; row < n; row++) {
            field[row] = scanner.nextLine().toCharArray();

            if (bIsNotFound) {
                for (int col = 0; col < n; col++) {
                    if (field[row][col] == 'B') {
                        startPosition[0] = row;
                        startPosition[1] = col;
                        break;
                    }
                }
            }
        }
        return startPosition;
    }
}
