package JavaAdvanced.FunctionalProgramming.EX;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiPredicate;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BiPredicate<Integer, Integer> isNotDevisable = (first, second) -> first % second != 0;

        int nthNumber = Integer.parseInt(scanner.nextLine());
        int[] devidors = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        for (int number = 1; number <= nthNumber; number++) {
            boolean predicator = false;
            for (int i = 0; i < devidors.length; i++) {
                if (isNotDevisable.test(number,devidors[i])){
                    predicator = false;
                    break;
                }else {
                    predicator = true;
                }
            }

            if (predicator){
                System.out.print(number + " ");
            }
        }
    }
}
