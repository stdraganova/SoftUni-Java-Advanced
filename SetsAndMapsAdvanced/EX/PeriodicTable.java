package JavaAdvanced.SetsAndMapsAdvanced.EX;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfInputs = Integer.parseInt(scanner.nextLine());
        Set<String> periodicElements = new TreeSet<>();

        for (int i = 0; i < numberOfInputs; i++) {
            String[] elements = scanner.nextLine().split("\\s+");

            for (String element : elements){
                periodicElements.add(element);
            }
        }

        periodicElements.forEach(element -> System.out.print(element + " "));
    }
}
