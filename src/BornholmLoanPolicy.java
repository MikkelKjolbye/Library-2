import java.time.LocalDate;

public class BornholmLoanPolicy implements LoanPolicy {

    private Resource resourceToLoan;

    public BornholmLoanPolicy(Resource resourceToLoan) {
        this.resourceToLoan = resourceToLoan;
    }

    @Override
    public boolean canLoan() {
        // Der er ingen mængdebegrænsning på lydbøger, så vi svarer altid ja
        return true;
    }

    @Override
    public LocalDate calculateDueDate(LocalDate borrowedDate) {
        // Hvis det er en lydbog (Audio), skal den afleveres efter 14 dage
        if (resourceToLoan instanceof AudioBook) {
            return borrowedDate.plusDays(14);
        }
        // Ellers er standarden 30 dage
        else
            return borrowedDate.plusDays(30);
    }
}

