import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class testSaveMembers {

    @Test
    void testSaveMembers() throws IOException {
        // Arrange
        var members = List.of(
                new Member("Signe Borch", 1111),
                new Member("Ian Bridwood", 2222),
                new Member("Jakob Kofoed Janot", 3333)
        );
        var librarySaver = new LibrarySaver();

        // Act
        librarySaver.saveMembers(members, "test-members.csv");

        // Assert
        var expected = """
                1111;Signe Borch
                2222;Ian Bridwood
                3333;Jakob Kofoed Janot
                """;

        var actual = Files.readString(Path.of("test-members.csv"));
        assertEquals(expected, actual);
    }
}