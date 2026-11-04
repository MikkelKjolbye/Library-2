import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public record Member(String name, int memberID) implements Comparable<Member> {

    public int getMemberID(){
        return memberID;
    }

    @Override
    public String toString() {
        return String.format("""                
                %s  (%d) \t""", name, memberID);
    }

    @Override
    public int compareTo(Member other) {
        return Integer.compare(this.memberID, other.memberID());

    }

}
