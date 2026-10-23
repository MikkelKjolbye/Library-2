import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class testMember {
    @Test
    void testMemberNR(){
        //arrange
        Member member = new Member("Mikkel", 100);

        //act
        int memberNR = member.getMemberNR();

        //
        assertEquals(100, memberNR);
    }


}
