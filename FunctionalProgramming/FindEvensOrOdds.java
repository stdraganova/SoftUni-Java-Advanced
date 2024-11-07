package JavaAdvanced.FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class FindEvensOrOdds {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] startEndNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        String command = scanner.nextLine();

        Predicate<Integer> predicate;
        switch (command){
            case "odd" -> {
                predicate = number -> number % 2 != 0;
                test(startEndNumbers, predicate);
            }
            case "even" -> {
                predicate = number -> number % 2 == 0;
                test(startEndNumbers, predicate);
            }
        }

    }

    private static void test(int[] startEndNumbers, Predicate<Integer> predicate) {
        for (int number = startEndNumbers[0]; number <= startEndNumbers[1]; number++) {
            if (predicate.test(number)){
                System.out.print(number + " ");
            }
        }
    }
}
