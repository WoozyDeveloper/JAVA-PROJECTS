
import java.util.HashMap;
import java.util.Map;

public class Item implements Serializable{
    private String id;
    private String title;
    private String location; //file name or Web page

    private Map<String, Object> tags = new HashMap<>();
    //…

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
