package JavaAdvanced.FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Predicate<String> startsWithUpperCase = word -> Character.isUpperCase(word.charAt(0));
        List<String> upperText = Arrays.stream(scanner.nextLine().split("\\s+")).filter(startsWithUpperCase).collect(Collectors.toList());

        System.out.println(upperText.size());
        upperText.forEach(System.out::println);
    }
}
