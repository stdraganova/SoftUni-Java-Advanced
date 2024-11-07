import java.util.Arrays;
import java.util.IllegalFormatCodePointException;
import java.util.Scanner;

public class BombDefusal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read dimensions of the map
        int[] dimensions = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        char[][] field = new char[rows][cols];
        int[] initialPosition = fillMatrix(field, scanner); // Store the initial position of the counter-terrorist

        boolean isKilled = false;
        boolean isKilledByTerorist = false;
        boolean isBombDefused = false;
        int counter = 16;  // Initial time counter
        int bombRow = -1, bombCol = -1;

        // Search for the bomb's coordinates
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if (field[row][col] == 'B') {
                    bombRow = row;
                    bombCol = col;
                }
            }
        }

        int[] currentPosition = Arrays.copyOf(initialPosition, 2); // Use currentPosition for moves

        // Game loop
        while (!isKilled && !isBombDefused && counter > 0) {
            String command = scanner.nextLine();
            int newRow = currentPosition[0];
            int newCol = currentPosition[1];

            // Process commands
            switch (command) {
                case "up" -> newRow--;
                case "down" -> newRow++;
                case "left" -> newCol--;
                case "right" -> newCol++;
                case "defuse" -> {
                    // Handle defuse command
                    if (newRow == bombRow && newCol == bombCol) {
                        counter -= 4;  // Defusing takes 4 seconds
                        if (counter >= 0) {
                            isBombDefused = true;
                            field[bombRow][bombCol] = 'D';  // Mark bomb as defused
                        } else {
                            isKilled = true; // The bomb exploded
                            field[bombRow][bombCol] = 'X'; // Mark the position as X if bomb exploded
                        }
                    } else {
                        field[newRow][newCol] = 'B';
                        counter -= 2;  // Wrong defuse attempt
                    }
                    continue; // Skip movement
                }
            }

            // Deduct time for movement
            counter--;

            // Validate row and column boundaries
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                char symbol = field[newRow][newCol];

                // Handle stepping on 'T'
                if (symbol == 'T') {
                    isKilledByTerorist = true;
                    isKilled = true; // Counter-terrorist is killed
                    field[newRow][newCol] = '*'; // Mark terrorist position as empty
                    field[currentPosition[0]][currentPosition[1]] = '*'; // Mark previous position as empty
                } else {

                    // Update previous position to '*'

                    currentPosition[0] = newRow;
                    currentPosition[1] = newCol;

                    if (symbol != 'B') {
                        field[currentPosition[0]][currentPosition[1]] = '*';
                        field[newRow][newCol] = 'C'; // Update current position to 'C'
                    }
                }



            }

            // Check if the bomb exploded
            if (counter == 0 && !isBombDefused) {
                isKilled = true; // Bomb explodes
                // We do not mark the bomb as '*' since it should remain on the field.
            }
        }

        // Output results based on the final state of the game
        if (isBombDefused) {
            System.out.println("Counter-terrorist wins!");
            System.out.println("Bomb has been defused: " + counter + " second/s remaining.");
        } else if (isKilled) {
            if (isKilledByTerorist){
                System.out.println("Terrorists win!");
            }else if (counter < 0) {
                System.out.println("Terrorists win!");
                System.out.println("Bomb was not defused successfully!");
                System.out.println("Time needed: " + Math.abs(counter) + " second/s."); // Use absolute value
            } else {
                System.out.println("Bomb was not defused successfully!");
                System.out.println("Time needed: 1 second/s."); // The bomb exploded on the next tick
            }
        }

        // Restore the counter-terrorist to their initial position for final output
        field[initialPosition[0]][initialPosition[1]] = 'C'; // Place counter-terrorist back at the initial position

        // Print final state of the field
        printField(field);
    }

    private static int[] fillMatrix(char[][] field, Scanner scanner) {
        int[] coordinates = new int[2];

        for (int row = 0; row < field.length; row++) {
            field[row] = scanner.nextLine().toCharArray();
            for (int col = 0; col < field[row].length; col++) {
                if (field[row][col] == 'C') {
                    coordinates[0] = row;
                    coordinates[1] = col;
                }
            }
        }

        return coordinates;
    }

    private static void printField(char[][] field) {
        for (char[] row : field) {
            System.out.println(new String(row));
        }
    }
}
