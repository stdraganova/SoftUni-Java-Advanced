package JavaAdvanced.FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> input = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).filter(number -> number % 2 == 0).collect(Collectors.toList());

        System.out.println(input.toString().replaceAll("[\\[\\]]", ""));

        Collections.sort(input);
        System.out.println(input.toString().replaceAll("[\\[\\]]", ""));
    }
}
