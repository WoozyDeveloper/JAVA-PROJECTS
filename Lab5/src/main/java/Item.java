
import java.util.HashMap;
import java.util.Map;

public abstract class Item implements Serializable{
    private String id;
    private String title;
    private String location; //file name or Web page
    private String author;
    private Map<String, Object> tags = new HashMap<>();

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Item(String id,String title, String location, String author){
        this.id=id;
        this.title=title;
        this.location=location;
        this.author=author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "{id='" + getId() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", location='" + getLocation() + '\'' +
                ", author=" + getAuthor() + '\'' +
                ", type=" + getClass().getSimpleName() + '\'' +
                "}\n";
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Map<String, Object> getTags() {
        return tags;
    }

    public void setTags(Map<String, Object> tags) {
        this.tags = tags;
    }
    public void addTag(String key, Object obj) {
        tags.put(key, obj);
    }

}
