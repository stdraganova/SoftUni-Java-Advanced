package JavaAdvanced.FunctionalProgramming.EX;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // a > b   1    swap
        // a = b   0    no swap
        // a < b  -1    no swap

       Comparator<Integer> compare = (first, second) -> {
               if (first % 2 == 0 && second % 2 != 0){
                   return  -1; // no swap
               } else if (first % 2 != 0 && second % 2 == 0) {
                   return 1; // swap
               }else { // sort ascending order
                   return  first.compareTo(second);
               }
       };

       //четем листа и директно го принтираме
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .sorted(compare)
                .forEach(number -> System.out.print(number + " "));
    }
}
