package JavaAdvanced.SetsAndMapsAdvanced.EX;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, String> phonebook = new TreeMap<>();

        while (!input.equals("search")){
            String name = input.split("-")[0];
            String number = input.split("-")[1];

            phonebook.putIfAbsent(name, "0");
            phonebook.put(name, number);

            input = scanner.nextLine();
        }

        String command = scanner.nextLine();
        while (!command.equals("stop")){

            if (phonebook.containsKey(command)){
                    System.out.printf("%s -> %s%n", command, phonebook.get(command));
            }else {
                System.out.printf("Contact %s does not exist.%n", command);
            }

            command = scanner.nextLine();
        }
    }
}
