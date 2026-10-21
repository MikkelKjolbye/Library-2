import java.util.ArrayList;

public class ConsoleUI {
    private Library library;

    public ConsoleUI(Library library) {
        this.library = library;
    }

    public void run() {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(IO.readln("Indtast dit valg: "));
            switch (choice) {
                case 1 -> borrowBook();
                case 2 -> returnBook();
                case 3 -> showLoans();
                case 0 -> running = false;
                default -> IO.println("Ugyldig indtastning, prøv igen");
            }
        }

    }

    public void showMenu() {
        IO.println("""
                Velkommen til biblioteket´s selvbetjening
                
                1. Lån
                2. Aflever bog
                3. Vis alle lån
                0. Afslut
                """);
    }

    private void borrowBook() {
        int bookId = Integer.parseInt(IO.readln("Indtast bogens ID: "));
        int memberID = Integer.parseInt(IO.readln("Indtast dit medlemsnummer: "));
        boolean isBorrowed = library.loanBook(bookId, memberID);
        if (isBorrowed) {
            IO.println("Lån oprettet");
        } else IO.println("Tryk og start forfra");
        IO.readln();
    }

    private void returnBook() {
        int bookId = Integer.parseInt(IO.readln("Indtast bogens ID: "));
        boolean isReturned = library.returnBook(bookId);
        if (isReturned){
            IO.println("Bogen er returneret");

        }
        else IO.println("Tryk og start forfra");
        IO.readln();
    }
    private void showLoans(){
        int memberId = Integer.parseInt(IO.readln("Indtast medlemsnummer: "));
        ArrayList<Loan> memberLoans = library.findLoansByMemberId(memberId);
        if(memberLoans.isEmpty()){
            IO.println("Der blev ikke fundet nogle lån");
        }
        else {
            IO.println("Udlån for medlem "+memberId+";");
            for(Loan loan : memberLoans){
                IO.println(loan);
            }
        }

    }
}
