package JavaAdvanced.DefiningClasses.Constructors_CarConstructors;

public class Car {
    private String brand;
    private String model;
    private int horsePower;

    //Custom Constructor 1 - задава само стойност за бранд(марка)
    public Car (String brand){
        this.brand = brand;
        this.model = "unknown";
        this.horsePower = -1;
    }
    //Custom Constructor 2 - задава стойност на всички полета
    public Car (String brand, String model, int horsePower){
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }

    //Print method
    public String printInfo(){
        String carInfo = String.format("The car is: %s %s - %d HP.", brand, model, horsePower);
        return carInfo;
    }
}
