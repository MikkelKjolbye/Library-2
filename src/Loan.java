import java.time.LocalDate;

public class Loan {
    final private Book book;
    final private Member member;
    final private LocalDate borrowedDate;

    public Loan(Book book, Member member) {
        this.book = book;
        this.member = member;
        this.borrowedDate = LocalDate.now();
    }

    public Book getBook() {
        return book;
    }

    public Member getMember() {
        return member;
    }

    public LocalDate getDueDate() {
        return borrowedDate.plusDays(14);
    }

    public boolean isOverdue() {
        LocalDate today = LocalDate.now();
        return today.isAfter(getDueDate());
    }

    public String toString(){
        String status = isOverdue() ? "Afleveringsfrist er overskredet" : "";
        return String.format("""
                %s \n%s Lånt: %s %s""",book,member,borrowedDate,status);
    }
}
