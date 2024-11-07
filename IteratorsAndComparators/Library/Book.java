package JavaAdvanced.IteratorsAndComparators.Library;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors){
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

    public void setAuthors(String...authors) {
        if (this.authors.isEmpty()){
            this.authors = new ArrayList<>();
        }else {
            this.authors = List.of(authors);
        }

    }
}
