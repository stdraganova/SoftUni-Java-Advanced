package JavaAdvanced.SetsAndMapsAdvanced;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class VoinWithSets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstPlayerCards = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        Set<Integer> firstPlayer = new LinkedHashSet<>();
        for (int number : firstPlayerCards){
            firstPlayer.add(number);
        }

        int[] secondPlayerCards = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        Set<Integer> secondPlayer = new LinkedHashSet<>();
        for (int number : secondPlayerCards){
            secondPlayer.add(number);
        }

        int rounds = 50;

        while (rounds > 0 && firstPlayer.size() > 0 && secondPlayer.size() > 0){
            int firstCard = firstPlayer.iterator().next();
            firstPlayer.remove(firstCard);
            int secondCard = secondPlayer.iterator().next();
            secondPlayer.remove(secondCard);

            if (firstCard > secondCard){
                firstPlayer.add(firstCard);
                firstPlayer.add(secondCard);

            } else if (secondCard > firstCard) {
                secondPlayer.add(firstCard);
                secondPlayer.add(secondCard);
            }

            rounds--;
        }

        if (firstPlayer.size() == secondPlayer.size()){
            System.out.println("Draw!");
        } else if (firstPlayer.size() > secondPlayer.size()) {
            System.out.println("First player win!");
        }else {
            System.out.println("Second player win!");
        }
    }
}
