public class Member {
    final String name;
    final int memberNR;

    public Member(String name, int memberNR) {
        this.name = name;
        this.memberNR = memberNR;
    }

    public String toString() {
        return String.format("""
                %s  (%d) """, name, memberNR);
    }
}
