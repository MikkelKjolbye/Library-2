public class Movie extends Resource{
    private int MinuteLength;

    public Movie(String identifier, String title, String creator, int MinuteLength){
        super(identifier,title,creator);
        this.MinuteLength = MinuteLength;
    }


    public String toString(){
        return String.format(
                """
                    Title: %s. Creator: %s. EAN: %s Minute length: %d.  """ ,getTitle(), getCreator(), getIdentifier(), getMinuteLength());
    }
    public int getMinuteLength(){
        return MinuteLength;
    }
}
