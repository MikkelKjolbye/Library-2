import java.util.ArrayList;

public class Library {
    private ArrayList<Resource> resources;
    private ArrayList<Member> members;
    private ArrayList<Loan> loans;

    public Library() {
        resources = new ArrayList<>();
        members = new ArrayList<>();
        loans = new ArrayList<>();
    }

    public void addResource(Resource resource) {
        resources.add(resource);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public ArrayList<Loan> getLoans() {
        return loans;
    }

    public ArrayList<Resource> getResources() {
        return resources;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public Resource getResource(String identifier) {
        for (Resource resource : resources) {
            if (resource.getIdentifier().equals(identifier)) {
                return resource;
            }
        }
        return null;
    }

    public Member getMember(int memberId) {
        for (Member member : members) {
            if (member.memberNR() == memberId) {
                return member;
            }
        }
        return null;
    }

    public LoanResult loanResource(String identifier, int memberId) {
        Member member = getMember(memberId);
        Resource resource = getResource(identifier);
        if (member == null) {
            return LoanResult.NOT_MEMBER;

        }
        if (resource == null){
            return LoanResult.RESOURCE_NOT_FOUND;
        }
        for (Loan loan : loans) {
            if (loan.getResource().getIdentifier().equals(identifier)) {
                return LoanResult.RESOURCE_NOT_AVAILABLE;

            }
        }
        Loan newLoan = new Loan(resource, member);
        loans.add(newLoan);
        return LoanResult.LOANED;

    }

    public boolean returnResource(String identifier) {
        for (Loan loan : loans) {
            if (loan.getResource().getIdentifier().equals(identifier)) {
                loans.remove(loan);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Loan> findLoansByMemberId(int memberId) {
        ArrayList<Loan> memberLoans = new ArrayList<>();
        for (Loan loan : loans) {
            if (loan.getMember().memberNR() == memberId) {
                memberLoans.add(loan);
            }
        }
        return memberLoans;
    }

    public void printResource() {
        for (Resource resource : resources) {
            IO.println(resource);
        }
    }

    public void printMembers() {
        for (Member member : members) {
            IO.println(member);
        }
    }
}
