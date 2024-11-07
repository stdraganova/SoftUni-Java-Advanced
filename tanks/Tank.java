package tanks;

public class Tank {
    private String brand;
    private String model;
    private int weight;
    private int barrelCaliber; // New: barrelCaliber must be set in constructor
    private int armor;

    public Tank(String brand, String model, int weight, int barrelCaliber, int armor) {
        this.brand = brand;
        this.model = model;
        this.weight = weight;
        this.barrelCaliber = barrelCaliber; // Properly initialize barrelCaliber
        this.armor = armor;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getWeight() {
        return weight;
    }

    public int getBarrelCaliber() {
        return barrelCaliber;
    }

    public int getArmor() {
        return armor;
    }

    @Override
    public String toString() {
        return String.format("Brand: %s, Model: %s, Weight: %dkg, Barrel caliber: %dmm, Armor: %dmm",
                brand, model, weight, barrelCaliber, armor);
    }
}
