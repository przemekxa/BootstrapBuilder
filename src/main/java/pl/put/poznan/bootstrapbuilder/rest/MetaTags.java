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

    /**
     * @return Meta tag title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set Meta tag title
     * @param title Meta tag title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return Meta tag type
     */
    public String getType() {
        return type;
    }

    /**
     * Set Meta tag type
     * @param type Meta tag type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return Meta tag description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set Meta tag description
     * @param description Meta tag description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return Meta tag image
     */
    public String getImage() {
        return image;
    }

    /**
     * Set Meta tag image
     * @param image Meta tag image
     */
    public void setImage(String image) {
        this.image = image;
    }

}
