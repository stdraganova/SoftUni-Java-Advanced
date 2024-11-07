package JavaAdvanced.SetsAndMapsAdvanced.EX;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class FixEmailsMaps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> emails = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("stop")){
            String name = input;
            String email = scanner.nextLine();

            if (isValid(email)){
                emails.putIfAbsent(name, "");
                emails.put(name, email);
            }else {
                input = scanner.nextLine();
                continue;
            }

            input = scanner.nextLine();
        }

        for (String person : emails.keySet()){
            System.out.printf("%s -> %s%n", person, emails.get(person));
        }

    }

    private static boolean isValid(String email) {
        String domain = email.substring(email.lastIndexOf("."), email.length());
        //int indexOfDot = domain.indexOf(".");

        if (domain.equals(".com") || domain.equals(".us") || domain.equals(".uk")){
            return  false;
        }

        return  true;
    }
}
