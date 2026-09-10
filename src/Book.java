public class Book {
    final String title;
    final String author;
    final String isbn;
    final int idNumber;
    Member borrowedBy;


    public Book(String title, String author, String isbn, int idNumber) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.idNumber = idNumber;
        
    }

    public boolean isAvailable(Member member) {
        if (isAvailable == true) {
            isAvailable = false;
            return true;
        } else {
            return false;
        }
    }
    public void returnBook(){
        isAvailable=true;
    }

    public String toString() {
        String status = isAvailable ? " På hylden" : " Udlånt";
        return String.format(
                """ 
                        %s: %s; ISBN: %s; (%d)  """ + status + "\n", title, author, isbn, idNumber, isAvailable);
    }

}
