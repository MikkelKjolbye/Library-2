import java.time.LocalDate;

public class Book {
    final String title;
    final String author;
    final String isbn;
    final int idNumber;
    Member borrowedBy;
    LocalDate borrowedDate;


    public Book(String title, String author, String isbn, int idNumber) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.idNumber = idNumber;
        this.borrowedDate = null;

    }

    public boolean isAvailable() {
        return borrowedBy == null;
    }


    public boolean loanBook(Member member) {
        if (isAvailable()) {
            borrowedBy = member;
            borrowedDate = LocalDate.now();
            return true;
        }
        return false;
    }

    public boolean returnBook() {
        if (!isAvailable()) {
            borrowedBy = null;
            borrowedDate = null;
            return true;
        }
        return false;
    }

    public LocalDate getDueDate() {
        if (isAvailable()) {
            return borrowedDate = null;
        } else {
            return borrowedDate.plusDays(14);
        }
    }

    public String toString() {
        String status = isAvailable() ? "\n| Tilgængelig |" : "\nLånt af: " + borrowedBy;
        String dateOfReturn = isAvailable() ? "" : "| Afleveringsfrist: " + getDueDate() +" |\n";
        return String.format(
                """ 
                        %s: %s; ISBN: %s; (%d) %s%s""", title, author, isbn, idNumber, status,dateOfReturn);
    }

}

