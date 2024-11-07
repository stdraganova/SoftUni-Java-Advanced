package JavaAdvanced.SetsAndMapsAdvanced;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniPartyWithSets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String guestNumber = scanner.nextLine();

        Set<String> regularGuests = new TreeSet<>();
        Set<String> vipGuests = new TreeSet<>();

        while (!guestNumber.equals("PARTY")){

            if (Character.isDigit(guestNumber.charAt(0))){
                vipGuests.add(guestNumber);
            }else {
                regularGuests.add(guestNumber);
            }

            guestNumber = scanner.nextLine();
        }

        String guestsThatCame = scanner.nextLine();

        while (!guestsThatCame.equals("END")){
            vipGuests.remove(guestsThatCame);
            regularGuests.remove(guestsThatCame);

            guestsThatCame = scanner.nextLine();
        }

        System.out.println(vipGuests.size() + regularGuests.size());
        vipGuests.forEach(guest -> System.out.println(guest));
        regularGuests.forEach(guest -> System.out.println(guest));
    }
}
