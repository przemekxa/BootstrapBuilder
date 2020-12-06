package pl.put.poznan.bootstrapbuilder.rest;

/**
 * Request object representing user GET request body
 */
public class Request {

    private HeaderType header;
    private boolean footer;
    private MetaType metaType;
    private MetaTags metaTags;

    public HeaderType getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = HeaderType.valueOf(header.toUpperCase());
    }

    public void setHeader(HeaderType header) {
        this.header = header;
    }

    public boolean getFooter() {
        return footer;
    }

    public void setFooter(boolean footer) {
        this.footer = footer;
    }

    public void setFooter(String footer) {
        this.footer = footer.toLowerCase().equals("true") || footer.toLowerCase().equals("yes");
    }

    public MetaType getMetaType() {
        return metaType;
    }

    public void setMetaType(String meta) {
        this.metaType =  MetaType.valueOf(meta.toUpperCase());
    }

    public void setMetaType(MetaType meta) {
        this.metaType = meta;
    }

    public MetaTags getMetaTags() {
        return metaTags;
    }

    public void setMetaTags(MetaTags metaTags) {
        this.metaTags = metaTags;
    }

}

