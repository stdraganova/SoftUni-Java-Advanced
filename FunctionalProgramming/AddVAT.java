package JavaAdvanced.FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Double::parseDouble).collect(Collectors.toList());

        UnaryOperator<Double> numbersWithVAT = number -> number * 1.2;

        System.out.println("Prices with VAT:");

        for (Double number : numbers) {
            System.out.printf("%.2f%n",numbersWithVAT.apply(number));
        }
    }
}
