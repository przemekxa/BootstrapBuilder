package pl.put.poznan.bootstrapbuilder.rest;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * META tags type for SEO
 */
public enum MetaType {
    /**
     * Regular META tags
     *
     * ex. title, meta[name=description],
     */
    @JsonProperty("regular")
    @JsonAlias("REGULAR")
    REGULAR,

    /**
     * Open Graph META tags
     *
     * ex. og:title, og:type, og:description, og:image
     */
    @JsonProperty("openGraph")
    @JsonAlias("OPEN_GRAPH")
    OPEN_GRAPH,

    /**
     * META tags used by Twitter
     *
     * ex. twitter:title, twitter:card, twitter:description, twitter:image
     */
    @JsonProperty("twitter")
    @JsonAlias("TWITTER")
    TWITTER
}
