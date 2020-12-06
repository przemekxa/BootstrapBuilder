package pl.put.poznan.bootstrapbuilder.rest;

/**
 * META tags type for SEO
 */
public enum MetaType {
    /**
     * Regular META tags
     *
     * ex. description, author
     */
    REGULAR,

    /**
     * Open Graph META tags
     *
     * ex. og:title, og:type
     */
    OPEN_GRAPH,

    /**
     * META tags used by Twitter
     *
     * ex. twitter:title, twitter:description
     */
    TWITTER
}
