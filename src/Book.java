public class Book extends Resource {

    public Book(String identifier, String title, String creator){
        super(identifier,title,creator);

    }

    @Override
    public String toString() {
        return String.format(
                """ 
                        Titel: %s. Forfatter: %s. ISBN: %s.""", getTitle(), getCreator(), getIdentifier());
    }
}
