package JavaAdvanced.SetsAndMapsAdvanced.EX;

import java.util.*;

public class CountSymbolsMaps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       String text = scanner.nextLine();
       char[] textCharacters = text.toCharArray();

        Map<Character, Integer> letters = new TreeMap();

        for (char character : textCharacters){

            letters.putIfAbsent(character, 0);
            letters.put(character, letters.get(character) + 1);
        }

        for (Character letter : letters.keySet()){
            System.out.println(letter + ": " + letters.get(letter) + " time/s");
        }
    }
}
