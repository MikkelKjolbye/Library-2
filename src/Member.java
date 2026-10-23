public record Member(String name, int memberNR) {

    public int getMemberNR(){
        return memberNR;
    }

    @Override
    public String toString() {
        return String.format("""                
                %s  (%d) \t""", name, memberNR);
    }
}
