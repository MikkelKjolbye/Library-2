import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class testBook {

    @Test
    void TestBookGetCreator() {
        //Arrange
        Book book = new Book("100", "Harry Potter", "JK Rowling");

        //Act
        String creator = book.getCreator();

        //Assert
        assertEquals("JK Rowling", creator);


    }


}