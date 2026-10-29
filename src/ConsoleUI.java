import java.util.ArrayList;
import java.util.List;

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
                case 1 -> loanResource();
                case 2 -> returnResource();
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

    private void loanResource() {
        String identifier = IO.readln("Indtast id på det du vil låne: ");
        int memberID = Integer.parseInt(IO.readln("Indtast dit medlemsnummer: "));
        LoanResult status = library.loanResource(identifier, memberID);
        if (status == LoanResult.NOT_MEMBER) {
            IO.println("Medlemsnummeret findes ikke");
        }
        if (status == LoanResult.RESOURCE_NOT_FOUND) {
            IO.println("Materialet findes ikke");
        }
        if (status == LoanResult.RESOURCE_NOT_AVAILABLE) {
            IO.println("Materialet er allerede udlånt");
        } else if (status == LoanResult.LOANED) {
            IO.println("Lånet er oprettet");

        }
    }
    private void returnResource() {
        String identifier = (IO.readln("Indtast bogens ID: "));
        boolean isReturned = library.returnResource(identifier);
        if (isReturned){
            IO.println("Bogen er returneret");

        }
        else IO.println("Tryk og start forfra");
        IO.readln();
    }
    private void showLoans(){
        int memberId = Integer.parseInt(IO.readln("Indtast medlemsnummer: "));
        List<Loan> memberLoans = library.findLoansByMemberId(memberId);
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
