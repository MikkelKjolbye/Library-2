import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<Loan> loans = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public ArrayList<Loan> getLoans() {
        return loans;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public Book getBook(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }

    public Member getMember(int memberId) {
        for (Member member : members) {
            if (member.getMemberId() == memberId) {
                return member;
            }
        }
        return null;
    }

    public boolean loanBook(int bookId, int memberId) {
        Member member = getMember(memberId);
        Book book = getBook(bookId);
        if (member == null || book == null) {
            return false;

        }
        for (Loan loan : loans) {
            if (loan.getBook().getBookId() == bookId) {
                return false;

            }
        }
        Loan newLoan = new Loan(book, member);
        loans.add(newLoan);
        return true;

    }

    public boolean returnBook(int bookId) {
        for (Loan loan : loans) {
            if (loan.getBook().getBookId() == bookId) {
                loans.remove(loan);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Loan> findLoansByMemberId(int memberId) {
        ArrayList<Loan> memberLoans = new ArrayList<>();
        for (Loan loan : loans) {
            if (loan.getMember().getMemberId() == memberId) {
                memberLoans.add(loan);
            }
        }
        return memberLoans;
    }

    public void printBooks() {
        for (Book book : books) {
            IO.println(book);
        }
    }

    public void printMembers() {
        for (Member member : members) {
            IO.println(member);
        }
    }
}
