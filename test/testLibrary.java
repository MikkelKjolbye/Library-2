import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class testLibrary {
    private Resource resource;
    private Member member;
    private Library library;
    private LoanPolicy negativeLoanPolicy;
    private LoanPolicy positiveLoanPolicy;

    @BeforeEach
    void setup() {
        negativeLoanPolicy = new TestMockNegativeLoanPolicy();
        positiveLoanPolicy = new TestMockPositiveLoanPolicy();
    }

    // ========== LoanPolicy-tests ==========

    @Test
    void testNegativeCanLoan() {
        assertFalse(negativeLoanPolicy.canLoan());
    }

    @Test
    void testPositiveCanLoan() {
        assertTrue(positiveLoanPolicy.canLoan());
    }

    @Test
    void testPositiveCalculateDueDate() {
        LocalDate borrowedDate = LocalDate.now();
        LocalDate result = positiveLoanPolicy.calculateDueDate(borrowedDate);
        assertEquals(LocalDate.of(3000, 1, 1), result);
    }

    @Test
    void testNegativeCalculateDueDate() {
        LocalDate borrowedDate = LocalDate.now();
        LocalDate result = negativeLoanPolicy.calculateDueDate(borrowedDate);
        assertEquals(LocalDate.of(3000, 1, 1), result);
    }

    // ========== Library.loanResource-tests ==========

    @Test
    void testSuccessfulLoan() {
        resource = new VideoGame("400", "WOW", "Blizzard", "Battle.net");
        member = new Member("Malthe Rasmussen", 100);
        library = new Library(positiveLoanPolicy);
        library.addMember(member);
        library.addResource(resource);

        LoanResult result = library.loanResource("400", 100);

        assertEquals(LoanResult.LOANED, result);
        assertEquals(1, library.getLoans().size());
    }

    @Test
    void testLoanWithNegativePolicy() {
        resource = new VideoGame("400", "WOW", "Blizzard", "Battle.net");
        member = new Member("Malthe Rasmussen", 100);
        library = new Library(negativeLoanPolicy);
        library.addMember(member);
        library.addResource(resource);

        LoanResult result = library.loanResource("400", 100);

        assertEquals(LoanResult.NOT_PERMITTED, result);
        assertEquals(0, library.getLoans().size());
    }

    @Test
    void testLoanWithNonExistentMember() {
        resource = new VideoGame("400", "WOW", "Blizzard", "Battle.net");
        library = new Library(positiveLoanPolicy);
        library.addResource(resource);

        LoanResult result = library.loanResource("400", 999);

        assertEquals(LoanResult.NOT_MEMBER, result);
    }

    @Test
    void testLoanWithNonExistentResource() {
        member = new Member("Malthe Rasmussen", 100);
        library = new Library(positiveLoanPolicy);
        library.addMember(member);

        LoanResult result = library.loanResource("999", 100);

        assertEquals(LoanResult.RESOURCE_NOT_FOUND, result);
    }

    @Test
    void testLoanAlreadyLoanedResource() {
        resource = new VideoGame("400", "WOW", "Blizzard", "Battle.net");
        member = new Member("Malthe Rasmussen", 100);
        library = new Library(positiveLoanPolicy);
        library.addMember(member);
        library.addResource(resource);
        library.loanResource("400", 100);

        LoanResult result = library.loanResource("400", 100);

        assertEquals(LoanResult.RESOURCE_NOT_AVAILABLE, result);
        assertEquals(1, library.getLoans().size());
    }

    @Test
    void testReturnResource() {
        resource = new VideoGame("400", "WOW", "Blizzard", "Battle.net");
        member = new Member("Malthe Rasmussen", 100);
        library = new Library(positiveLoanPolicy);
        library.addMember(member);
        library.addResource(resource);
        library.loanResource("400", 100);

        boolean returned = library.returnResource("400");

        assertTrue(returned);
        assertEquals(0, library.getLoans().size());
    }

    @Test
    void testReturnNonLoanedResource() {
        library = new Library(positiveLoanPolicy);

        boolean returned = library.returnResource("400");

        assertFalse(returned);
    }
}