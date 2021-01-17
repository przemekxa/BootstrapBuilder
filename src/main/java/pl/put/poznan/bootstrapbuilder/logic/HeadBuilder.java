package pl.put.poznan.bootstrapbuilder.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.put.poznan.bootstrapbuilder.rest.MetaTags;
import pl.put.poznan.bootstrapbuilder.rest.MetaType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Builder used to build the 'head' of the document
 */
public class HeadBuilder implements Builder {

    private static final Logger logger = LoggerFactory.getLogger(HeadBuilder.class);

    /**
     * Style of the document
     */
    private String css = "";

    /**
     * Meta tags to be placed in head
     */
    private final ArrayList<String> metadata = new ArrayList<String>();


    //
    // Methods used to customize the template
    //

    /**
     * Add style to the document
     * @param style CSS to be added to the page
     * @return The builder
     */
    public HeadBuilder addCSS(String style) {

        logger.debug("Add CSS");

        css += style;

        return this;
    }

    /**
     * Add meta tags to the header section
     * @param type Type of the tags being added
     * @param tags Values in the tags
     * @return The builder
     */
    public HeadBuilder addMeta(MetaType type, MetaTags tags) {

        logger.debug("Add metadata of type {}", type);

        switch (type) {
            case REGULAR:
                if(tags.getTitle() != null) {
                    metadata.add("<title>" + tags.getTitle() + "</title>");
                }
                if(tags.getDescription() != null) {
                    metadata.add("<meta name=\"description\" content=\"" + tags.getDescription() + "\"/>");
                }
                // Type and Image not supported
                break;
            case OPEN_GRAPH:
                if(tags.getTitle() != null) {
                    metadata.add("<meta property=\"og:title\" content=\"" + tags.getTitle() + "\" />");
                }
                if(tags.getType() != null) {
                    metadata.add("<meta property=\"og:type\" content=\"" + tags.getType() + "\" />");
                }
                if(tags.getDescription() != null) {
                    metadata.add("<meta property=\"og:description\" content=\"" + tags.getDescription() + "\" />");
                }
                if(tags.getImage() != null) {
                    metadata.add("<meta property=\"og:image\" content=\"" + tags.getImage() + "\" />");
                }
                break;
            case TWITTER:
                if(tags.getTitle() != null) {
                    metadata.add("<meta property=\"twitter:title\" content=\"" + tags.getTitle() + "\" />");
                }
                if(tags.getType() != null) {
                    metadata.add("<meta property=\"twitter:card\" content=\"" + tags.getType() + "\" />");
                }
                if(tags.getDescription() != null) {
                    metadata.add("<meta property=\"twitter:description\" content=\"" + tags.getDescription() + "\" />");
                }
                if(tags.getImage() != null) {
                    metadata.add("<meta property=\"twitter:image\" content=\"" + tags.getImage() + "\" />");
                }
                break;
            default:
                break;
        }
        return this;
    }


    /**
     * Build the head
     * @return Built head part of the document
     */
    @Override
    public String build() {

        logger.debug("Building <head>");

        // Add padding (4 spaces) to metadata
        String metadataPadded = metadata.stream()
                .map(s -> "    " + s)
                .collect(Collectors.joining("\n"));

        String head =
                "<head>\n" +
                        "    <meta charset=\"utf-8\">\n" +
                        "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n" +
                        "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\"\n" +
                        "          integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n" +
                        metadataPadded + "\n";

        // If there is a style
        if(!css.isEmpty()) {

            // Add padding (8 spaces) to style
            String stylePadded = Arrays.stream(css.split("\n"))
                    .map(s -> "        " + s)
                    .collect(Collectors.joining("\n"));

            head += "    <style>\n" + stylePadded + "\n    </style>\n";
        }
        head += "</head>\n";

        return head;
    }
}
