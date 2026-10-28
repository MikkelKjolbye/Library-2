import java.time.LocalDate;

public class StandardLoanPolicy implements LoanPolicy{
    boolean canLoan();
    LocalDate calculateDueDate();
}
