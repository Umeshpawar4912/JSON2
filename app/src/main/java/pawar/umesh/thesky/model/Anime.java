package pawar.umesh.thesky.model;

public class Anime {

    private String title ;
    private String caption ;
    private String image ;

    public Anime() {
    }

    public Anime(String title, String caption, String image) {
        this.title = title;
        this.caption = caption;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getCaption() {
        return caption;
    }

    public String getImage() {
        return image;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
