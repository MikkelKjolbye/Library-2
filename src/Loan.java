import java.time.LocalDate;

public class Loan {
    final private Resource resource;
    final private Member member;
    final private LocalDate borrowedDate;
    final private LocalDate dueDate;

    public Loan(Resource resource, Member member, LocalDate borrowedDate, LocalDate dueDate) {
        this.resource = resource;
        this.member = member;
        this.borrowedDate = borrowedDate;
        this.dueDate = dueDate;
    }

    public Resource getResource() {
        return resource;
    }

    public Member getMember() {
        return member;
    }


    public boolean isOverdue() {
        LocalDate today = LocalDate.now();
        return today.isAfter(dueDate);
    }

    public String toString(){
        String status = isOverdue() ? "Afleveringsfrist er overskredet" : "";
        return String.format("""
                %s \n%s Lånt: %s %s\n""",resource,member,borrowedDate,status);
    }
}
