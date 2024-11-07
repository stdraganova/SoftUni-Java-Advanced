package JavaAdvanced.SetsAndMapsAdvanced;

import java.util.*;
import java.util.stream.Collectors;

public class Largest3NumbersWithMaps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Collections.sort(numbers);
        Collections.reverse(numbers);

        Set<Integer> numbersSet = new LinkedHashSet<>();

        for (int number : numbers){
            numbersSet.add(number);
        }

        if (numbersSet.size() < 3){
            numbersSet.forEach(number -> System.out.print(number + " "));
        }else {
            int count = 1;
            for (int number : numbers){
                System.out.print(number + " ");

                if (count == 3){
                    break;
                }

                count++;
            }
        }
    }
}
