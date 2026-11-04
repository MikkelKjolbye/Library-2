import java.time.LocalDate;
import java.util.List;

class AalborgLoanPolicy implements LoanPolicy {
private Resource resourceToLoan;
private List<Loan> currentLoans;

public AalborgLoanPolicy(Resource resourceToLoan, List<Loan> currentLoans) {
    this.resourceToLoan = resourceToLoan;
    this.currentLoans = currentLoans;
}

@Override
public boolean canLoan() {
    // Hvis tingen vi prøver at låne er et spil ELLER en film, skal vi tælle efter
    if (resourceToLoan instanceof VideoGame || resourceToLoan instanceof Movie) {

        int amountOfGameAndMovieLoans = 0;

        // Almindelig løkke: Gå igennem alle eksisterende lån et efter et
        for (int i = 0; i < currentLoans.size(); i++) {
            Loan loans = currentLoans.get(i);
            Resource resources = loans.getResource();

            // Hvis det gamle lån er et spil eller en film, tæller vi 1 op
            if (resources instanceof VideoGame || resources instanceof Movie) {
                amountOfGameAndMovieLoans = amountOfGameAndMovieLoans + 1;
            }
        }

        // Hvis man allerede har 3 eller flere, siger vi stop (false)
        if (amountOfGameAndMovieLoans >= 3) {
            return false;
        }
    }

    // Hvis vi ikke ramte grænsen (eller det bare er en bog/lydbog), returneres true
    return true;
}

@Override
public LocalDate calculateDueDate(LocalDate borrowedDate) {
    // Standardlån på 30 dage
    return borrowedDate.plusDays(30);
}
}