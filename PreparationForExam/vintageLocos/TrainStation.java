package JavaAdvanced.PreparationForExam.vintageLocos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TrainStation {
    private String name;
    private int capacity;
    private int railGauge;
    private List<Locomotive> locomotives;

    public TrainStation(String name, int capacity, int railGauge) {
        this.name = name;
        this.capacity = capacity;
        this.railGauge = railGauge;
        this.locomotives = new ArrayList<>();
    }

    public void addLocomotive(Locomotive locomotive){
        if (!this.locomotives.contains(locomotive)) {
            if (locomotive.getGauge() == this.railGauge && this.locomotives.size() < this.capacity) {
                this.locomotives.add(locomotive);
            } else if (this.locomotives.size() >= this.capacity) {
                System.out.println("This train station is full!");
                return;
            } else {
                System.out.printf("The rail gauge of this station does not match the locomotive gauge! Difference: %d mm.", Math.abs(this.railGauge - locomotive.getGauge()));
                return;
            }
        }
    }

    public boolean removeLocomotive(String name){
            return this.locomotives.removeIf(locomotive -> locomotive.getName().equals(name));
    }

    public String getFastestLocomotive(){
        if (this.locomotives.isEmpty()) {
            return "There are no locomotives.";
        }
        Locomotive locomotive = this.locomotives.stream().max(Comparator.comparing(Locomotive::getMaxSpeed)).get();
        return String.format("%s is the fastest locomotive with a maximum speed of %d km/h.", locomotive.getName(), locomotive.getMaxSpeed());
    }

    public Locomotive getLocomotive(String name){
        return this.locomotives.stream().filter(locomotive -> locomotive.getName().equals(name)).findFirst().orElse(null);
    }

    public int getCount(){
        return locomotives.size();
    }

    public String getOldestLocomotive() {

        if (this.locomotives.isEmpty()) {
            return "There are no locomotives.";
        }

        Locomotive oldestLocomotive = this.locomotives.stream().min(Comparator.comparing(Locomotive::getBuildDate)).get();
        return oldestLocomotive.getName();
    }

    public String getStatistics(){

        if (this.locomotives.isEmpty()){
            return String.format("There are no locomotives departing from %s station.", this.name);
        }

        StringBuilder sb = new StringBuilder();
        int count = 1;

        sb.append(String.format("Locomotives departed from %s:%n", this.name));
        for (Locomotive locomotive : locomotives){
            sb.append(String.format("%d. %s", count, locomotive.getName()));
            sb.append(System.lineSeparator());
            count++;
        }

        return sb.toString().trim();
    }
}
