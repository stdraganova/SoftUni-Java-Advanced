package tanks;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Terrain {
    private String type;
    private List<Tank> tanks; // List to hold Tank objects
    private int area;

    public Terrain(String type, int area) {
        this.type = type;
        this.area = area;
        this.tanks = new ArrayList<>(); // Initialize the tank list
    }

    public String addTank(Tank tank) {
        if (checkTank(tank)) {
            return "Tank with this brand and model already exists!";
        }

        if ("Swamp".equals(type) && tank.getWeight() > 14000) {
            return String.format("This %s is too heavy for this terrain!", tank.getBrand());
        }

        tanks.add(tank);
        return String.format("Tank %s %s added.", tank.getBrand(), tank.getModel());
    }

    public boolean removeTank(String brand, String model) {
        return tanks.removeIf(tank -> tank.getBrand().equals(brand) && tank.getModel().equals(model));
    }

    public String getTanksByBarrelCaliberMoreThan(int barrelCaliber) {
        List<Tank> matchingTanks = tanks.stream()
                .filter(tank -> tank.getBarrelCaliber() > barrelCaliber)
                .toList();

        if (matchingTanks.isEmpty()) {
            return "There are no tanks with the specified caliber.";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Tanks with caliber more than %dmm: ", barrelCaliber));
        for (int i = 0; i < matchingTanks.size(); i++) {
            sb.append(matchingTanks.get(i).getBrand());
            if (i < matchingTanks.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public Tank getTankByBrandAndModel(String brand, String model) {
        return tanks.stream()
                .filter(tank -> tank.getBrand().equals(brand) && tank.getModel().equals(model))
                .findFirst()
                .orElse(null);
    }

    public String getTheMostArmoredTank() {
        return tanks.stream()
                .max(Comparator.comparing(Tank::getArmor))
                .map(tank -> String.format("%s %s is the most armored tank with %dmm armor thickness.",
                        tank.getBrand(), tank.getModel(), tank.getArmor()))
                .orElse("There are no tanks in this terrain.");
    }

    public int getCount() {
        return tanks.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tanks located in the ").append(type.toLowerCase()).append(":").append(System.lineSeparator());
        if (tanks.isEmpty()) {
            return String.format("There are no tanks in the %s.", type.toLowerCase());
        }
        for (Tank tank : tanks) {
            sb.append("-- ").append(tank.getBrand()).append(" ").append(tank.getModel()).append(System.lineSeparator());
        }
        return sb.toString();
    }

    private boolean checkTank(Tank tank) {
        return tanks.stream().anyMatch(t -> t.getBrand().equals(tank.getBrand()) && t.getModel().equals(tank.getModel()));
    }
}
