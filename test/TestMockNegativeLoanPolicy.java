import java.time.LocalDate;

public class TestMockNegativeLoanPolicy implements LoanPolicy {

    @Override
    public boolean canLoan() {
        return false;
    }

    @Override
    public LocalDate calculateDueDate(LocalDate borrowedDate) {
        return LocalDate.of(3000,1,1);
    }

}
