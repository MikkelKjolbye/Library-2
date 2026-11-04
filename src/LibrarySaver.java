import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
public class LibrarySaver {
    public void saveMembers(List<Member> members, String filename) throws IOException {
        Path path = Path.of(filename);
        String delimiter = ";";

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Member member : members) {
                writer.write(member.getMemberID() + delimiter + member.name());
                writer.newLine();
            }
        }
    }
    public void saveBooks(List<Book> books, String filename) throws IOException {
        Path path = Path.of(filename);
        String delimiter = ";";

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Book book : books) {
                writer.write(book.getIdentifier() + delimiter +
                        book.getTitle() + delimiter +
                        book.getCreator());
                writer.newLine();
            }
        }
    }

    public void saveMovies(List<Movie> movies, String filename) throws IOException {
        Path path = Path.of(filename);
        String delimiter = ";";

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Movie movie : movies) {
                writer.write(movie.getIdentifier() + delimiter +
                        movie.getTitle() + delimiter +
                        movie.getCreator() + delimiter +
                        movie.getMinuteLength());
                writer.newLine();
            }
        }
    }

    public void saveAudioBooks(List<AudioBook> audioBooks, String filename) throws IOException {
        Path path = Path.of(filename);
        String delimiter = ";";

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (AudioBook audioBook : audioBooks) {
                writer.write(audioBook.getIdentifier() + delimiter +
                        audioBook.getTitle() + delimiter +
                        audioBook.getCreator() + delimiter +
                        audioBook.getMinuteLength());
                writer.newLine();
            }
        }
    }

    public void saveVideoGames(List<VideoGame> videoGames, String filename) throws IOException {
        Path path = Path.of(filename);
        String delimiter = ";";

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (VideoGame game : videoGames) {
                writer.write(game.getIdentifier() + delimiter +
                        game.getTitle() + delimiter +
                        game.getCreator() + delimiter +
                        game.getPlatform());
                writer.newLine();
            }
        }
    }
    public void saveLoans(List<Loan> loans, String filename) throws IOException {
        Path path = Path.of(filename);
        String delimiter = ",";

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Loan loan : loans) {
                writer.write(
                        loan.getMember().getMemberID() + delimiter +
                                loan.getResource().getIdentifier() + delimiter +
                                loan.getBorrowedDate() + delimiter +
                                loan.getDueDate()
                );
                writer.newLine();
            }
        }
    }
    // metoder til at kalde dem: librarySaver.saveBooks(books, "books.csv");
    //librarySaver.saveMovies(movies, "movies.csv");
    //librarySaver.saveAudioBooks(audioBooks, "audiobooks.csv");
    //librarySaver.saveVideoGames(videoGames, "videogames.csv");
    //librarySaver.saveLoans(loans, "loans.csv");
}
