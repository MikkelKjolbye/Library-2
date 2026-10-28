import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class testLibrary {
    Resource resource;
    Member member;
    Library library;
    LoanPolicy negativeLoanPolicy;
    LoanPolicy positiveLoanPolicy;

    @BeforeEach
    void setup(){
        negativeLoanPolicy = new TestMockNegativeLoanPolicy();
        positiveLoanPolicy = new TestMockPositiveLoanPolicy();
    }

    @Test
    void testSuccesfulLoan() {
        //arrange
        resource = new VideoGame("400", "WOW", "Blizzard", "Battle.net");
        member = new Member("Malthe Rasmussen", 100);
        library = new Library(positiveLoanPolicy);
        library.addMember(member);
        library.addResource(resource);
        //act
        LoanResult result = library.loanResource("400", 100);
        //arrange
        assertEquals(LoanResult.LOANED, result);
    }
    @Test
    void testNegativeCanLoan (){
        //arrange

        //act
        boolean result = negativeLoanPolicy.canLoan();
        IO.println(result);
    }
    @Test
    void testPositiveCanLoan (){
        //arrange

        //act
        boolean result = positiveLoanPolicy.canLoan();
        IO.println(result);
    }
    @Test
    void testPositiveCaculateduedate (){
        //arrange

        //act
        LocalDate borrowedDate = LocalDate.now();
        LocalDate result = positiveLoanPolicy.calculateDueDate(borrowedDate);
        IO.println(result);
    }
}
