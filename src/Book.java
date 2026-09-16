
public class Book {
    final String title;
    final String author;
    final String isbn;
    final int id;

    public Book(String title, String author, String isbn, int id) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.id = id;
    }

    public int getBookId() {
        return id;
    }


    public String toString() {
        return String.format(
                """ 
                %s: %s; ISBN: %s; (%d) """, title, author, isbn, id);
    }

}

