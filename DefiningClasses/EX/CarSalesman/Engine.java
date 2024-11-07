package JavaAdvanced.DefiningClasses.EX.CarSalesman;

public class Engine {
    String model;
    int power;
    int displacement;
    String efficiency;

    public Engine(String model, int power){
        this(model, power, -1,"n/a");
    }

    public Engine(String model, int power, int displacement){
        this(model, power, displacement,"n/a");
    }

    public Engine(String model, int power, String efficiency){
        this(model, power, -1,efficiency);
    }

    public Engine(String model, int power, int displacement, String efficiency){
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    public int getDisplacement() {
        return displacement;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
         if (displacement == -1){
             return String.format("%s:%nPower: %d%nDisplacement: n/a%nEfficiency: %s",model, power,efficiency);

         }else {
             return String.format("%s:%nPower: %d%nDisplacement: %d%nEfficiency: %s",model, power, displacement,efficiency);

         }
    }
}
