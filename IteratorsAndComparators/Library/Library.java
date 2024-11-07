package JavaAdvanced.IteratorsAndComparators.Library;

import java.util.Iterator;

public class Library implements Iterable<Book>{
    private Book[] books;

    public Library(Book... books){
        this.setBooks(books);
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book... books) {
        this.books = books;
    }

    public Iterator<Book> iterator(){
        return new LibraryIterator();
    }

    private final class LibraryIterator implements Iterator<Book>{
        private int index = 0;

        public boolean hasNext(){
            return index < books.length;
        }

        public Book next(){
            Book book = books[index];
            index++;

            return book;
        }
    }
}
