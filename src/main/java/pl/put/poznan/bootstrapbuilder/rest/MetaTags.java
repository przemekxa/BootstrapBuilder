package pl.put.poznan.bootstrapbuilder.rest;

/**
 * Object representing the meta tags to be placed in the head of the document
 */
public class MetaTags {
    private String title;
    private String type;
    private String description;
    private String image;

    public MetaTags() { }

    public MetaTags(String title, String type, String description, String image) {
        this.title = title;
        this.type = type;
        this.description = description;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
