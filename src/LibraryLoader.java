import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibraryLoader {

    public List<Member> loadMembers(String filename) throws IOException {
        List<Member> members = new ArrayList<>();
        Path path = Path.of(filename);

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) continue;
                String[] fields = line.split(",");
                int memberID = Integer.parseInt(fields[0]);
                String name = fields[1];
                members.add(new Member(name, memberID));
            }
        }
        return members;
    }

    public List<Book> loadBooks(String filename) throws IOException {
        List<Book> books = new ArrayList<>();
        Path path = Path.of(filename);

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) continue;
                String[] fields = line.split(";");
                books.add(new Book(fields[0], fields[1], fields[2]));
            }
        }
        return books;
    }

    public List<Movie> loadMovies(String filename) throws IOException {
        List<Movie> movies = new ArrayList<>();
        Path path = Path.of(filename);

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) continue;
                String[] fields = line.split(";");
                movies.add(new Movie(fields[0], fields[1], fields[2], Integer.parseInt(fields[3])));
            }
        }
        return movies;
    }

    public List<AudioBook> loadAudioBooks(String filename) throws IOException {
        List<AudioBook> list = new ArrayList<>();
        Path path = Path.of(filename);

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) continue;
                String[] fields = line.split(";");
                list.add(new AudioBook(fields[0], fields[1], fields[2], Integer.parseInt(fields[3])));
            }
        }
        return list;
    }

    public List<VideoGame> loadVideoGames(String filename) throws IOException {
        List<VideoGame> list = new ArrayList<>();
        Path path = Path.of(filename);

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) continue;
                String[] fields = line.split(";");
                list.add(new VideoGame(fields[0], fields[1], fields[2], fields[3]));
            }
        }
        return list;
    }

    public List<Loan> loadLoans(String filename, List<Member> members, List<Resource> resources) throws IOException {
        List<Loan> loans = new ArrayList<>();
        Path path = Path.of(filename);

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) continue;
                String[] fields = line.split(",");
                int memberId = Integer.parseInt(fields[0]);
                String resourceId = fields[1];
                LocalDate borrowedDate = LocalDate.parse(fields[2]);
                LocalDate dueDate = LocalDate.parse(fields[3]);

                Member member = findMember(members, memberId);
                Resource resource = findResource(resources, resourceId);

                if (member != null && resource != null) {
                    loans.add(new Loan(resource, member, borrowedDate, dueDate));
                }
            }
        }
        return loans;
    }

    private Member findMember(List<Member> members, int id) {
        for (Member m : members) {
            if (m.getMemberID() == id) return m;
        }
        return null;
    }

    private Resource findResource(List<Resource> resources, String id) {
        for (Resource r : resources) {
            if (r.getIdentifier().equals(id)) return r;
        }
        return null;
    }
}