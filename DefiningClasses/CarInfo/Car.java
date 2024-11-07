package JavaAdvanced.DefiningClasses.CarInfo;

public class Car {

    private String brand;
    private String model;
    private int horsePower;

    //getters
    public String getBrand(){
        return this.brand;
    }
    public String getModel(){
        return this.model;
    }
    public int getHorsePower(){
        return this.horsePower;
    }

    //setters
    public void setBrand(String brand){
        this.brand = brand;
    }
    public void setModel(String model){
        this.model = model;
    }
    public void setHorsePower(int horsePower){
        this.horsePower = horsePower;
    }

    //other method
    public String carInfo(){
        String carInfo = String.format("The car is: %s %s - %d HP.%n", getBrand(),getModel(),getHorsePower());
        return carInfo;
    }
}

