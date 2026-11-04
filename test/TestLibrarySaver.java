import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLibrarySaver {

    private final LibrarySaver saver = new LibrarySaver();

    @Test
    void testSaveBooks() throws IOException {
        var books = List.of(
                new Book("100", "Think Java", "Allan B. Downey"),
                new Book("101", "Omrids", "Rachel Cusk")
        );

        saver.saveBooks(books, "test-books.csv");

        var expected = """
                100;Think Java;Allan B. Downey
                101;Omrids;Rachel Cusk
                """;

        var actual = Files.readString(Path.of("test-books.csv"));
        assertEquals(expected, actual);
    }

    @Test
    void testSaveMovies() throws IOException {
        var movies = List.of(
                new Movie("300", "Lord of the Rings", "Peter Jackson", 232),
                new Movie("301", "Home Alone", "Chris Columbus", 103)
        );

        saver.saveMovies(movies, "test-movies.csv");

        var expected = """
                300;Lord of the Rings;Peter Jackson;232
                301;Home Alone;Chris Columbus;103
                """;

        var actual = Files.readString(Path.of("test-movies.csv"));
        assertEquals(expected, actual);
    }

    @Test
    void testSaveAudioBooks() throws IOException {
        var audioBooks = List.of(
                new AudioBook("200", "Smølferne", "Mikkel Kjølbye Sørensen", 489)
        );

        saver.saveAudioBooks(audioBooks, "test-audiobooks.csv");

        var expected = """
                200;Smølferne;Mikkel Kjølbye Sørensen;489
                """;

        var actual = Files.readString(Path.of("test-audiobooks.csv"));
        assertEquals(expected, actual);
    }

    @Test
    void testSaveVideoGames() throws IOException {
        var games = List.of(
                new VideoGame("400", "GTA 6", "Rockstar", "Playstation 5")
        );

        saver.saveVideoGames(games, "test-videogames.csv");

        var expected = """
                400;GTA 6;Rockstar;Playstation 5
                """;

        var actual = Files.readString(Path.of("test-videogames.csv"));
        assertEquals(expected, actual);
    }

    @Test
    void testSaveLoans() throws IOException {
        var member = new Member("Signe Borch", 1111);
        var resource = new Book("9788700000001", "Den lille Havfrue", "H.C. Andersen");
        var loan = new Loan(resource, member, LocalDate.of(2026, 8, 1), LocalDate.of(2023, 8, 15));

        saver.saveLoans(List.of(loan), "test-loans.csv");

        var expected = """
                1111,9788700000001,2026-08-01,2023-08-15
                """;

        var actual = Files.readString(Path.of("test-loans.csv"));
        assertEquals(expected, actual);
    }
}
