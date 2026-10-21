public record Book(String title, String author, String isbn,int id) {
    @Override
    public String toString() {
        return String.format(
                """ 
                        %s: %s; ISBN: %s; (%d) """, title, author, isbn, id);
    }
}
