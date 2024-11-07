package JavaAdvanced.DefiningClasses.EX.CarSalesman;

public class Car {
    String model;
    Engine engine;
    int weight;
    String color;

    public Car(String model, Engine engine){
        this(model, engine, -1, "n/a");
    }

    public Car(String model, Engine engine, int weight){
        this(model, engine, weight, "n/a");
    }

    public Car(String model, Engine engine, String color){
        this(model, engine, -1, color);
    }

    public Car(String model, Engine engine, int weight, String color){
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        if (weight == -1){
            return String.format("%s:%n%s%nWeight: n/a%nColor: %s%n", model, engine,color);
        }else {
            return String.format("%s:%n%s%nWeight: %d%nColor: %s%n", model, engine,weight,color);
        }
    }
}
