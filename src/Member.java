public record Member(String name, int memberNR) {
    @Override
    public String toString() {
        return String.format("""                
                %s  (%d) \t""", name, memberNR);
    }
}
