package JavaAdvanced.DefiningClasses.EX.RawData;

import java.util.List;

public class Car {
    String model;
    int engineSpeed;
    int enginePower;
    int cargoWeight;
    String cargoType;
    List<Double>tires;

    public Car(String model, int engineSpeed, int enginePower, int cargoWeight, String cargoType, List<Double> tires){
        this.model = model;
        this.engineSpeed = engineSpeed;
        this.enginePower = enginePower;
        this.cargoWeight = cargoWeight;
        this.cargoType = cargoType;
        this.tires = tires;
    }
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getEngineSpeed() {
        return engineSpeed;
    }

    public void setEngineSpeed(int engineSpeed) {
        this.engineSpeed = engineSpeed;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    public int getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(int cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    public String getCargoType() {
        return cargoType;
    }

    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }

    public List<Double> getTires() {
        return tires;
    }

    public void setTires(List<Double> tires) {
        this.tires = tires;
    }
}
