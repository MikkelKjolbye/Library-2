import java.time.LocalDate;

public class StandardLoanPolicy implements LoanPolicy {

    @Override
    public boolean canLoan() {
        return true;
    }

    @Override
    public LocalDate calculateDueDate(LocalDate borrowedDate) {
        return borrowedDate.plusDays(30);
    }

}
