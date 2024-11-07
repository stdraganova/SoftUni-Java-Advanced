package JavaAdvanced.FunctionalProgramming.EX;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        Function<int[], Integer> minNumberIndex = arr -> {
           int min = Integer.MAX_VALUE;
           int index = 0;

            for (int number = 0; number < arr.length; number++) {
                if (min >= arr[number]){
                    min = arr[number];
                    index = number;
                }
            }
            return index;
        };

        System.out.println(minNumberIndex.apply(numbers));
    }
}
