package JavaAdvanced.Generics.EX.GenericBoxOfInteger;

public class Box<T>{

    private T data;

    public Box(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return String.format("%s: %d",
                this.data.getClass().getName(), //class name
                this.data); //actual String
    }
}
