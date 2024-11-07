package JavaAdvanced.SetsAndMapsAdvanced.EX;

import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> players = new LinkedHashMap<>();
        Map<String, Integer> playersScore = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("JOKER")){
            String playerName = input.split(": ")[0];
            String[] playerCards = (input.split(": ")[1]).split(", ");

            playersScore.putIfAbsent(playerName, 0);
            players.putIfAbsent(playerName, new LinkedHashSet<>());

            Set<String> playerCardsSet = players.get(playerName);

            for (String card : playerCards){
                playerCardsSet.add(card);
            }

            players.put(playerName, playerCardsSet);

            input = scanner.nextLine();
        }

        for (String player : playersScore.keySet()){

            int score = calculateScore(players.get(player));

            playersScore.put(player, playersScore.get(player) + score);
        }

        for (String player : playersScore.keySet()){
            System.out.printf("%s: %d%n",player, playersScore.get(player));
        }
    }

    private static int calculateScore(Set<String> playerCardsSet) {
        Map<String, Integer> cardsPower = new TreeMap<>(Map.of(
                "2",2,
                "3",3,
                "4",4,
                "5",5,
                "6",6,
                "7",7,
                "8",8,
                "9",9,
                "10",10));

        cardsPower.put("J", 11);
        cardsPower.put("Q", 12);
        cardsPower.put("K", 13);
        cardsPower.put("A", 14);

        Map<String, Integer> cardsType = new TreeMap<>(Map.of(
                "S", 4,
                "H",3,
                "D",2,
                "C",1
        ));

        int score = 0;

        for (String card : playerCardsSet){
            String power = card.substring(0, card.length() - 1);
            String type = card.substring(card.length() - 1, card.length());

            int powerValue = cardsPower.get(power);
            int typeValue = cardsType.get(type);

            score += powerValue * typeValue;
        }

        return score;
    }
}
