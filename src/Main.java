import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

void main(String[] args) throws IOException {
    if (args.length == 0) {
        System.out.println("Angiv sti til biblioteksmappen");
        return;
    }

    String libraryPath = args[0];

    LoanPolicy loanPolicy = new StandardLoanPolicy();
    Library library = new Library(loanPolicy);
    LibraryLoader loader = new LibraryLoader();
    ConsoleUI consoleUI = new ConsoleUI(library);

    String membersFile = Path.of(libraryPath, "members.csv").toString();

    List<Member> members = loader.loadMembers(membersFile);
    for (Member m : members) {
        library.addMember(m);
    }

    consoleUI.run();
}