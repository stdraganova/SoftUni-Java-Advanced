package JavaAdvanced.DefiningClasses.EX.PokemonTrainer;

import java.util.List;

public class Trainer {
    private String name;
    private int badgesNumber;
    private List<Pokemon> pokemonsList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBadgesNumber() {
        return badgesNumber;
    }

    public void setBadgesNumber(int badgesNumber) {
        this.badgesNumber = badgesNumber;
    }

    public List<Pokemon> getPokemonsList() {
        return pokemonsList;
    }

    public void setPokemonsList(List<Pokemon> pokemonsList) {
        this.pokemonsList = pokemonsList;
    }
}
