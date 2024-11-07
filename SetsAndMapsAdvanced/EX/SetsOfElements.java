package JavaAdvanced.SetsAndMapsAdvanced.EX;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstSetSize = scanner.nextInt();
        int secondSetSize = scanner.nextInt();

        //Попълваме първия сет
        Set<Integer> firstSet = new LinkedHashSet<>();
        for (int number = 0; number < firstSetSize; number++) {
            firstSet.add(scanner.nextInt());
        }

        //Попълваме втория сет
        Set<Integer> secondSet = new LinkedHashSet<>();
        for (int number = 0; number < secondSetSize; number++) {
            secondSet.add(scanner.nextInt());
        }

        //Маха всички елементи от сет 1, които не са еднакви със сет 2
        firstSet.retainAll(secondSet);

        firstSet.forEach(number -> System.out.print(number + " "));
    }
}
