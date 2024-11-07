package JavaAdvanced.PreparationForExam.vendingSystem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class VendingMachine {
    private int buttonCapacity;
    private List<Drink> drinks;

    public VendingMachine(int buttonCapacity) {
        this.buttonCapacity = buttonCapacity;
        this.drinks = new ArrayList<>();
    }

    public int getCount() {
        return drinks.size();
    }

    public void addDrink(Drink drink) {
        if (this.drinks.size() < this.buttonCapacity){
           this.drinks.add(drink);
        }
    }

    public boolean removeDrink(String name) {
        return this.drinks.removeIf(drink -> drink.getName().equals(name));
    }

    public Drink getLongest() {
       return this.drinks.stream().max(Comparator.comparing(Drink::getVolume)).get();
    }

    public Drink getCheapest() {
        return this.drinks.stream().min(Comparator.comparing(Drink::getPrice)).get();
    }

    public String buyDrink(String name) {
        Drink drink = this.drinks.stream().filter(d -> d.getName().equals(name)).findFirst().orElse(null);
        return drink.toString();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Drinks available:");
        sb.append(System.lineSeparator());

        for (Drink drink : drinks){
            sb.append(drink);
            sb.append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
