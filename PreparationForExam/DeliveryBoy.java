package JavaAdvanced.PreparationForExam;

import java.util.Scanner;

public class DeliveryBoy {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reading dimensions of the matrix
        String[] dimensions = scanner.nextLine().split(" ");
        int n = Integer.parseInt(dimensions[0]);
        int m = Integer.parseInt(dimensions[1]);

        // Reading the matrix
        char[][] matrix = new char[n][m];
        int boyRow = 0, boyCol = 0;
        for (int i = 0; i < n; i++) {
            String row = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                matrix[i][j] = row.charAt(j);
                if (matrix[i][j] == 'B') {
                    boyRow = i;
                    boyCol = j;
                }
            }
        }

        // Storing initial position
        int initialRow = boyRow;
        int initialCol = boyCol;

        boolean pizzaCollected = false;
        boolean deliveryCompleted = false;

        // Reading movement commands
        while (scanner.hasNextLine()) {
            String command = scanner.nextLine();

            // Calculate the next position based on the command
            int newRow = boyRow;
            int newCol = boyCol;
            switch (command) {
                case "up":
                    newRow--;
                    break;
                case "down":
                    newRow++;
                    break;
                case "left":
                    newCol--;
                    break;
                case "right":
                    newCol++;
                    break;
            }

            // Check if the boy is out of bounds
            if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= m) {
                System.out.println("The delivery is late. Order is canceled.");
                matrix[initialRow][initialCol] = ' ';
                printMatrix(matrix);
                return;
            }

            // If it's an obstacle, skip the move
            if (matrix[newRow][newCol] == '*') {
                continue;
            }

            // If the boy reaches the pizza restaurant ('P')
            if (matrix[newRow][newCol] == 'P' && !pizzaCollected) {
                pizzaCollected = true;
                matrix[newRow][newCol] = 'R'; // Mark it as 'R'
                System.out.println("Pizza is collected. 10 minutes for delivery.");
            }

            // If the boy reaches the address ('A') and pizza is collected
            if (matrix[newRow][newCol] == 'A' && pizzaCollected) {
                deliveryCompleted = true;
                matrix[newRow][newCol] = 'P'; // Mark the address as 'P'
                System.out.println("Pizza is delivered on time! Next order...");
                break;  // Delivery complete, break out of the loop
            }

            // Mark the road the boy passes with '.'
            if (matrix[newRow][newCol] == '-' || matrix[newRow][newCol] == '.') {
                matrix[newRow][newCol] = '.';
            }

            // Update boy's position
            boyRow = newRow;
            boyCol = newCol;
        }

        // Mark the delivery boy's initial position and print the final state of the matrix
        if (!deliveryCompleted) {
            matrix[initialRow][initialCol] = 'B';
        }
        printMatrix(matrix);
    }

    // Function to print the matrix
    public static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            System.out.println(new String(row));
        }
    }
}
