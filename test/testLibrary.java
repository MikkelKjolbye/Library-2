import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class testLibrary {
    Resource resource;
    Member member;
    Loan loan;
    Library library;

    @BeforeEach
    void setup() {
        resource = new VideoGame("400", "WOW", "Blizzard", "Battle.net");
        member = new Member("Malthe Rasmussen", 100);
       loan = new Loan(resource, member);
       library = new Library();
       library.addMember(member);
       library.addResource(resource);
    }
    @Test
    void testSuccesfulLoan(){
        //arrange

        //act
        LoanResult result = library.loanResource("400",100);
        //arrange
        assertEquals(LoanResult.LOANED, result);
    }



}
