package pl.put.poznan.bootstrapbuilder.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.put.poznan.bootstrapbuilder.rest.HeaderType;
import pl.put.poznan.bootstrapbuilder.rest.MetaTags;
import pl.put.poznan.bootstrapbuilder.rest.MetaType;

/**
 * This is Director class in builder pattern.
 */
public class BootstrapBuilder implements Builder {

    private static final Logger logger = LoggerFactory.getLogger(BootstrapBuilder.class);

    /**
     * Builder used to create the <pre><head></pre> of the document
     */
    private final HeadBuilder headBuilder = new HeadBuilder();

    /**
     * Builder used to create the <pre><body></pre> of the document
     */
    private final BodyBuilder bodyBuilder = new BodyBuilder();


    //
    // Methods used to customize the template
    //

    /**
     * Set the header of the template
     * @param type Type of the header this template should use
     * @return The builder
     */
    public BootstrapBuilder setHeader(HeaderType type) {

        logger.debug("Set header to {}", type);

        bodyBuilder.setHeader(type);

        return this;
    }

    /**
     * Set the footer of the template
     * @param footer Whether this template should include a footer
     * @return The builder
     */
    public BootstrapBuilder setFooter(boolean footer) {

        logger.debug("Set footer to {}", footer);

        bodyBuilder.setFooter(footer);

        if(footer) {
            headBuilder.addCSS(
                    "footer {\n" +
                    "    position: absolute;\n" +
                    "    bottom: 0;\n" +
                    "    height: 55px;\n" +
                    "    width: 100%;\n" +
                    "    background: #000;\n" +
                    "}\n" +
                    "\n" +
                    ".footer__animation {\n" +
                    "    width: 65px;\n" +
                    "    height: 55px;\n" +
                    "    position: relative;\n" +
                    "    animation-name: ride;\n" +
                    "    animation-duration: 60s;\n" +
                    "    animation-delay: 2s;\n" +
                    "    animation-iteration-count: infinite;\n" +
                    "}\n" +
                    "\n" +
                    "@keyframes ride {\n" +
                    "    0% {\n" +
                    "        left: 0;\n" +
                    "        top: 0;\n" +
                    "    }\n" +
                    "    100% {\n" +
                    "        left: 95%;\n" +
                    "        top: 0;\n" +
                    "    }\n" +
                    "}\n"
            );

        }

        return this;
    }

    /**
     * Add meta tags to the header section
     * @param type Type of the tags being added
     * @param tags Values in the tags
     * @return The builder
     */
    public BootstrapBuilder addMeta(MetaType type, MetaTags tags) {

        logger.debug("Add metadata of type {}", type);

        headBuilder.addMeta(type, tags);

        return this;
    }


    //
    // Building the template
    //

    /**
     * Build the template from parameters set in this builder
     * @return HTML of the template
     */
    @Override
    public String build() {

        logger.debug("Building template");

        // DOCTYPE and <html>
        String htmlStart =
                "<!doctype html>\n" +
                "<html lang=\"en\">" +
                "\n";

        // <head>...</head>
        String head = headBuilder.build();

        // <body>...</body>
        String body = bodyBuilder.build();

        // </html>
        String htmlEnd = "</html>";

        return htmlStart + head + body + htmlEnd;
    }

}

