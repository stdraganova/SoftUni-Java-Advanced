package JavaAdvanced.FunctionalProgramming.EX;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        Function<int[], Integer> minNumber = arr -> {
            int min = Integer.MAX_VALUE;

            for (Integer i : arr) {
                if (min > i){
                    min = i;
                }
            }

            return min;
        };


        System.out.println(minNumber.apply(numbers));
    }
}
