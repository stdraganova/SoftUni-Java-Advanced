package JavaAdvanced.IteratorsAndComparators.EX.Froggy;

import java.util.Iterator;

class Lake implements Iterable<Integer> {
    private int[] lake;

    // Constructor to initialize the lake with the given numbers
    public Lake(int[] lake) {
        this.lake = lake;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    // Inner class Frog which implements Iterator
    private class Frog implements Iterator<Integer> {
        private int currentIndex = 0;
        private boolean evensDone = false; // To check if even indices traversal is done

        @Override
        public boolean hasNext() {
            // We have more elements to iterate over if we haven't processed all even and odd indices
            return currentIndex < lake.length || (!evensDone && lake.length > 1);
        }

        @Override
        public Integer next() {
            if (!evensDone) {
                // First, process the even indices (0, 2, 4, ...)
                if (currentIndex % 2 == 0) {
                    Integer element = lake[currentIndex];
                    currentIndex += 2; // Move to the next even index
                    // If we go out of bounds, start with odd indices
                    if (currentIndex >= lake.length) {
                        currentIndex = 1; // Set to first odd index
                        evensDone = true;
                    }
                    return element;
                }
            }

            // Then, process the odd indices (1, 3, 5, ...)
            if (evensDone && currentIndex % 2 != 0) {
                Integer element = lake[currentIndex];
                currentIndex += 2; // Move to the next odd index
                return element;
            }
            return null; // This will never be reached in practice due to the hasNext() check
        }
    }
}