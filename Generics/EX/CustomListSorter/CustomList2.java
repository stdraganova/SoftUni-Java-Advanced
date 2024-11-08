package JavaAdvanced.Generics.EX.CustomListSorter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CustomList2<T extends Comparable<T>> implements Iterable<T> {

    private List<T> data;

    public CustomList2() {
        this.data = new ArrayList<>();
    }

    // void add(T element)
    public void add(T element) {
        this.data.add(element);
    }

    //T remove(int index)
    public T remove(int index) {
        checkIndex(index);
        return this.data.remove(index);
    }

    //boolean contains(T element)
    public boolean contains(T element) {
        return this.data.contains(element);
    }

    // 	void swap(int index, int index)
    public void swap(int firstIndex, int secondIndex) {

        checkIndex(firstIndex);
        checkIndex(secondIndex);

        T firstElement = data.get(firstIndex);
        T secondElement = data.get(secondIndex);

        data.set(firstIndex, secondElement);
        data.set(secondIndex, firstElement);
    }

    // int countGreaterThan(T element)
    public int countGreaterThan(T element) {
        int count = 0;

        for (T e : data) {
            int res = e.compareTo(element);
            if (res > 0) {
                count++;
            }
        }

        return count;
    }

    // T getMax()
    public T getMax() {
        checkEmpty();
        return Collections.max(this.data);
    }

    // T getMin()
    public T getMin() {
        checkEmpty();
        return Collections.min(this.data);
    }

    public int size() {
        return this.data.size();
    }

    private void checkEmpty() {
        if (this.data.isEmpty()) {
            throw new IllegalStateException("List is empty!");
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.data.size()) {
            throw new IndexOutOfBoundsException(
                    String.format("Index %d is out of bounds for size %d"
                            , index, this.data.size())
            );
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                return this.index < data.size();
            }

            @Override
            public T next() {
                return data.get(index++);
            }
        };
    }

    public T get(int index) {
        return this.data.get(index);
    }
}