package JavaAdvanced.SetsAndMapsAdvanced.EX;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernamesSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        scanner.nextLine();

        Set<String> usernames = new LinkedHashSet<>();

        for (int i = 0; i < number; i++) {
            String userName = scanner.nextLine();

            usernames.add(userName);
        }

        usernames.forEach(userName -> System.out.println(userName));

    }
}
