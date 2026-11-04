public abstract class Resource implements Comparable<Resource> {
    private final String identifier;
    private final String title;
    private final String creator;

    public Resource(String identifier, String title, String creator) {
        this.identifier = identifier;
        this.title = title;
        this.creator = creator;
    }
    public String getIdentifier(){
        return identifier;
    }
    public String getTitle(){
        return title;
    }
    public String getCreator() {
        return creator;
    }
    @Override
    public int compareTo(Resource other){
        return this.identifier.compareTo(other.getIdentifier());
    }
}