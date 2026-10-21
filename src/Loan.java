import java.time.LocalDate;

public class Loan {
    final private Resource resource;
    final private Member member;
    final private LocalDate borrowedDate;

    public Loan(Resource resource, Member member) {
        this.resource = resource;
        this.member = member;
        this.borrowedDate = LocalDate.now();
    }

    public Resource getResource() {
        return resource;
    }

    public Member getMember() {
        return member;
    }

    public LocalDate getDueDate() {
        return borrowedDate.plusDays(14);
    }

    public boolean isOverdue() {
        LocalDate today = LocalDate.now();
        return today.isAfter(getDueDate());
    }

    public String toString(){
        String status = isOverdue() ? "Afleveringsfrist er overskredet" : "";
        return String.format("""
                %s \n%s Lånt: %s %s\n""",resource,member,borrowedDate,status);
    }
}
