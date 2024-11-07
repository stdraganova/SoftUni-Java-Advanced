package JavaAdvanced.FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toList());

        //Printing numbers count
        System.out.println("Count = " + numbers.size());

        Function<List<Integer>, Integer> sumNumbers = numbersList -> {
            int sum = 0;
            for (Integer number : numbers) {
                sum += number;
            }

            return sum;
        };

        //Printing sum
        System.out.println("Sum = " + sumNumbers.apply(numbers));
    }
}
