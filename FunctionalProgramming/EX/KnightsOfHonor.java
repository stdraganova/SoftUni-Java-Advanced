package JavaAdvanced.FunctionalProgramming.EX;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split("\\s+");

        Consumer<String[]> printNamesWithSir = arr -> Arrays.stream(arr).forEach(name -> System.out.println("Sir " + name));

        printNamesWithSir.accept(names);
    }
}
