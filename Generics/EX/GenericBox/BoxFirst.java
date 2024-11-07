package JavaAdvanced.Generics.EX.GenericBox;

public class BoxFirst<T>{

    private T data;

    public BoxFirst(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return String.format("%s: %s",
                this.data.getClass().getName(), //class name
                this.data); //actual String
    }
}