package JavaAdvanced.SetsAndMapsAdvanced;

import java.util.*;

public class CountRealNumbersWithMaps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble).toArray();

        Map<Double, Integer> numbersOccurrences = new LinkedHashMap<>();

        for (double number : numbers){
            numbersOccurrences.putIfAbsent(number, 0);
            numbersOccurrences.put(number, numbersOccurrences.get(number) + 1);
        }

       for (Double key : numbersOccurrences.keySet()){
           System.out.printf("%.1f -> %d", key,numbersOccurrences.get(key));
           System.out.println();
       }
    }
}
