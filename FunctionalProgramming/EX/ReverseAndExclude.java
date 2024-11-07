package JavaAdvanced.FunctionalProgramming.EX;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Collections.reverse(numbers);

        int number = Integer.parseInt(scanner.nextLine());

        BiPredicate<Integer, Integer> isNotDevisible = (digit, dividor) -> digit % dividor != 0;

        numbers.stream().filter(element -> isNotDevisible.test(element, number)).forEach(element -> System.out.print(element + " "));
    }
}
