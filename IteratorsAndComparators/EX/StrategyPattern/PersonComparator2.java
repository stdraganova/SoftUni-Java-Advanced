package JavaAdvanced.IteratorsAndComparators.EX.StrategyPattern;

import java.util.Comparator;

public class PersonComparator2 implements Comparator<Person> {
    @Override
    public int compare(Person person1, Person person2) {
        // Compare ages directly using Integer.compare()
        return Integer.compare(person1.getAge(), person2.getAge());
    }
}
