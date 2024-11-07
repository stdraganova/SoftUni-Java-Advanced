package JavaAdvanced.IteratorsAndComparators.EX.StrategyPattern;

import java.util.Comparator;

public class PersonComparator1 implements Comparator<Person> {
    @Override
    public int compare(Person person1, Person person2) {
        // First compare by the length of the name
        int lengthComparison = Integer.compare(person1.getName().length(), person2.getName().length());

        if (lengthComparison != 0) {
            return lengthComparison; // Return the result of the length comparison
        }

        // If lengths are equal, compare first characters (case-insensitive)
        char firstChar1 = Character.toLowerCase(person1.getName().charAt(0));
        char firstChar2 = Character.toLowerCase(person2.getName().charAt(0));
        return Character.compare(firstChar1, firstChar2);
    }
}
