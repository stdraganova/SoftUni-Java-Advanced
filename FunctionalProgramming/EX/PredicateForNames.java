package JavaAdvanced.FunctionalProgramming.EX;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int neededLength = Integer.parseInt(scanner.nextLine());
        String[] names = scanner.nextLine().split("\\s+");

        BiPredicate<String, Integer> checkLength = (name, length) -> name.length() <= length;

        Arrays.stream(names).filter(name -> checkLength.test(name, neededLength)).forEach(name -> System.out.println(name));
    }
}
