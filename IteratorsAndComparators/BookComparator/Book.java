package JavaAdvanced.IteratorsAndComparators.BookComparator;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
//        this.title = title;
//        this.year = year;
//        this.authors = new ArrayList<>();

        this.setTitle(title);
        this.setYear(year);
        this.setAuthors(authors);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(String... authors) {
        if (this.authors.isEmpty()) {
            this.authors = new ArrayList<>();
        } else {
            this.authors = List.of(authors);
        }

    }

//    @Override
//    public int compareTo(JavaAdvanced.IteratorsAndComparators.BookComparator.Book book) {
//        //Връща резултат от сравненирто -1  0  1
//        int result = this.title.compareTo(book.title);
//
//        if (result == 0){
//            //сравняваме цели числа
//            result = Integer.compare(this.year, book.year);
//        }
//
//        return result;
//    }
}
