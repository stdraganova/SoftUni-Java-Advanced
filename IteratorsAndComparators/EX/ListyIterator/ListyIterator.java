package JavaAdvanced.IteratorsAndComparators.EX.ListyIterator;

import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String>{
    private List<String> elements;
    private int index;

    public ListyIterator(String... elements){
        this.setElements(elements);
        this.index = 0;
    }

    public boolean move(){
        //Moves the index to the next position if it exists
        if (hasNext()){
            index++;
            return true;
        }

        return false;
    }

    public boolean hasNext(){
        //трябва индекса да е < от последния индекс на листа
        //ако са равни, няма да има следващ елемент
        if (index < elements.size() - 1){
            return true;
        }

        return false;
    }

    public void setElements(String... elements) {
        this.elements = List.of(elements);
    }

    public void print(){
        if (!elements.isEmpty()){
            System.out.println(elements.get(index));
        }else {
            System.out.println("Invalid Operation!");
        }
    }

    public void printAll(){
        elements.forEach(e -> System.out.print(e + " "));
        System.out.println();
    }

    @Override
    public Iterator<String> iterator() {
        return new StringIterator();
    }

    public class StringIterator implements Iterator<String>{
        int currentIndex = 0;
        @Override
        public boolean hasNext() {
            return currentIndex < elements.size() - 1;
        }

        @Override
        public String next() {
            String element = elements.get(currentIndex);
            index++;
            return element;
        }
    }
}
