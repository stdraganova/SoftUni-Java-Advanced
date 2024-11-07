package JavaAdvanced.FunctionalProgramming.EX;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Четене на имената на гостите
        List<String> guests = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        // Обработка на командите
        while (!command.equals("Party!")) {
            String[] commandParts = command.split("\\s+");
            String action = commandParts[0];
            String criteria = commandParts[1];
            String argument = commandParts[2];

            Predicate<String> predicate = getPredicate(criteria, argument);

            if (action.equals("Remove")) {
                guests.removeIf(predicate);
            } else if (action.equals("Double")) {
                List<String> guestsToAdd = guests.stream()
                        .filter(predicate)
                        .collect(Collectors.toList());
                guests.addAll(guestsToAdd);
            }

            command = scanner.nextLine();
        }

        // Сортиране и печатане на резултата
        if (guests.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            guests.sort(String::compareTo);
            System.out.println(String.join(", ", guests) + " are going to the party!");
        }
    }

    // Метод за генериране на Predicate въз основа на критерия
    private static Predicate<String> getPredicate(String criteria, String argument) {
        switch (criteria) {
            case "StartsWith":
                return name -> name.startsWith(argument);
            case "EndsWith":
                return name -> name.endsWith(argument);
            case "Length":
                return name -> name.length() == Integer.parseInt(argument);
            default:
                throw new IllegalArgumentException("Invalid criteria: " + criteria);
        }
    }
}

