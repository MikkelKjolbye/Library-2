import java.time.LocalDate;

public class TestMockPositiveLoanPolicy implements LoanPolicy {

    @Override
    public boolean canLoan() {
        return true;
    }

    @Override
    public LocalDate calculateDueDate(LocalDate borrowedDate) {
        return LocalDate.of(3000,1,1);
    }

}

