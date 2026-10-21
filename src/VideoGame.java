public class VideoGame extends Resource{
    private String platform;
    public VideoGame(String identifier, String title, String creator, String platform){
        super(identifier,title,creator);
        this.platform = platform;
    }


    public String toString(){
        return String.format(
                """
                    Title: %s. Creator: %s. ISBN: %s Console Platform: %s.  """ ,getTitle(), getCreator(), getIdentifier(), getPlatform());
    }
    public String getPlatform(){
        return platform;
    }
}
