package pl.put.poznan.bootstrapbuilder.rest;

/**
 * Object representing the body of a GET request
 */
public class Request {

    private HeaderType header;
    private boolean footer;
    private MetaType metaType;
    private MetaTags metaTags;

    /**
     * @return Requested header type
     */
    public HeaderType getHeader() {
        return header == null ? HeaderType.NONE : header;
    }

    /**
     * Set requested header type
     * @param header Header type (as String, name should match enum)
     */
    public void setHeader(String header) {
        this.header = HeaderType.valueOf(header.trim().toUpperCase());
    }

    /**
     * Set requested header type
     * @param header Header type
     */
    public void setHeader(HeaderType header) {
        this.header = header;
    }

    /**
     * @return Whether footer is requested
     */
    public boolean getFooter() {
        return footer;
    }

    /**
     * Set whether footer should be present
     * @param footer Footer presence
     */
    public void setFooter(boolean footer) {
        this.footer = footer;
    }

    /**
     * Set whether footer should be present
     * @param footer String indicating footer presence (either "true", "yes" or "1")
     */
    public void setFooter(String footer) {
        String parsed = footer.trim().toLowerCase();
        this.footer = parsed.equals("true") || parsed.equals("yes") || parsed.equals("1");
    }

    /**
     * @return Requested meta type
     */
    public MetaType getMetaType() {
        return metaType == null ? MetaType.NONE : metaType;
    }

    /**
     * Set meta type
     * @param meta Meta type (as String, name should match enum)
     */
    public void setMetaType(String meta) {
        this.metaType =  MetaType.valueOf(meta.trim().toUpperCase());
    }

    /**
     * Set meta type
     * @param meta Meta type
     */
    public void setMetaType(MetaType meta) {
        this.metaType = meta;
    }

    /**
     * @return Requested meta tags
     */
    public MetaTags getMetaTags() {
        return metaTags;
    }

    /**
     * Set meta tags
     * @param metaTags Meta tags
     */
    public void setMetaTags(MetaTags metaTags) {
        this.metaTags = metaTags;
    }

}

