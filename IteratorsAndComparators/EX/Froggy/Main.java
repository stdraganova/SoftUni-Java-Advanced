package JavaAdvanced.IteratorsAndComparators.EX.Froggy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the initial numbers of the lake, separated by ", "
        int[] lakeNumbers = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // Create the lake object
        Lake lake = new Lake(lakeNumbers);

        // Read the command
        String command = scanner.nextLine();

        // If the command is "END", the Frog starts jumping
        if (command.equals("END")) {
            // Print each number the Frog has jumped over in a single line
            StringBuilder output = new StringBuilder();
            for (Integer number : lake) {
                output.append(number).append(", ");
            }

            // Remove the last ", " from the string and print the result
            if (output.length() > 0) {
                output.setLength(output.length() - 2); // Trim the last ", "
            }
            System.out.println(output);
        }
    }
}