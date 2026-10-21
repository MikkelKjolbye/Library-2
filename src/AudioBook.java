public class AudioBook extends Resource{
    private int MinuteLength;
    public AudioBook(String identifier, String title, String creator, int MinuteLength){
    super(identifier,title,creator);
    this.MinuteLength = MinuteLength;
    }


    public String toString(){
        return String.format(
        """
            Title: %s. Author: %s. ISBN: %s Minute length: %d.  """ ,getTitle(), getCreator(), getIdentifier(), getMinuteLength());
    }
    public int getMinuteLength(){
        return MinuteLength;
    }
}
