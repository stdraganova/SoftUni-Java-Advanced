package JavaAdvanced.DefiningClasses.EX.PokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] command = scanner.nextLine().split("\\s+");

        Map<String, List<Pokemon>> trainersAndPokemons = new LinkedHashMap<>();
        Map<String, Trainer> trainersBadges = new LinkedHashMap<>();

        // Четене на входните данни до командата "Tournament"
        while (!command[0].equals("Tournament")) {
            String trainerName = command[0];
            String pokemonName = command[1];
            String pokemonElement = command[2];
            int pokemonHealth = Integer.parseInt(command[3]);

            // Създаване на нов покемон
            Pokemon pokemon = new Pokemon();
            pokemon.setName(pokemonName);
            pokemon.setElement(pokemonElement);
            pokemon.setHealth(pokemonHealth);

            // Добавяне на треньор и покемон в картата
            trainersAndPokemons.putIfAbsent(trainerName, new ArrayList<>());

            List<Pokemon> pokemonList = trainersAndPokemons.get(trainerName);  // Взима списъка с покемони по име на треньор
            pokemonList.add(pokemon);  // Добавяне на новия покемон

            // Ако треньорът вече не съществува в trainersBadges, създаваме нов
            Trainer trainer = trainersBadges.getOrDefault(trainerName, new Trainer());
            trainer.setName(trainerName);
            trainer.setPokemonsList(pokemonList);  // Задаване на списъка с покемони на треньора
            trainer.setBadgesNumber(trainer.getBadgesNumber());  // Уверяваме се, че не нулираме баджовете

            trainersBadges.put(trainerName, trainer);  // Актуализиране на trainersBadges

            command = scanner.nextLine().split("\\s+");
        }

        // Команди за елементите
        String element = scanner.nextLine();

        // Fire, Water, Electricity
        // Ако има поне 1 покемон с този елемент badge++
        // Иначе pokemonHealth - 10
        while (!element.equals("End")) {

            for (Map.Entry<String, List<Pokemon>> entry : trainersAndPokemons.entrySet()) {
                String trainerName = entry.getKey();
                List<Pokemon> pokemonList = entry.getValue();

                // Проверка дали треньорът има покемон с посочения елемент
                if (hasPokemon(element, pokemonList)) {
                    Trainer trainer = trainersBadges.get(trainerName);
                    int badge = trainer.getBadgesNumber();
                    trainer.setBadgesNumber(badge + 1);  // Увеличаване на броя баджове
                } else {
                    // Намаляне на здравето на всеки покемон
                    for (Iterator<Pokemon> iterator = pokemonList.iterator(); iterator.hasNext(); ) {
                        Pokemon pokemon = iterator.next();
                        pokemon.setHealth(pokemon.getHealth() - 10);  // Намаляване на здравето с 10

                        if (pokemon.getHealth() <= 0) {
                            iterator.remove();  // Премахване на покемона от списъка, ако здравето му е 0 или по-малко
                        }
                    }
                }
            }
            element = scanner.nextLine();
        }

        // Извеждане на резултатите
        printTrainer(trainersBadges);
    }

    private static void printTrainer(Map<String, Trainer> trainersBadges) {
        trainersBadges.entrySet()
                .stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().getBadgesNumber(), e1.getValue().getBadgesNumber()))
                .forEach(entry -> {
                    Trainer trainer = entry.getValue();
                    System.out.printf("%s %d %d%n", trainer.getName(), trainer.getBadgesNumber(), trainer.getPokemonsList().size());
                });
    }

    private static boolean hasPokemon(String element, List<Pokemon> pokemonList) {
        // Проверява дали има покемон с дадения елемент
        return pokemonList.stream().anyMatch(pokemon -> pokemon.getElement().equals(element));
    }
}
