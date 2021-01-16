package pl.put.poznan.bootstrapbuilder.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.put.poznan.bootstrapbuilder.rest.HeaderType;

/**
 * Builder used to build the <pre><body></pre> of the document
 */
public class BodyBuilder implements Builder {

    private static final Logger logger = LoggerFactory.getLogger(BodyBuilder.class);

    /**
     * Indicate whether the template should have a header
     */
    private boolean hasHeader = false;

    /**
     * Class of the <pre><header></pre> tag
     */
    private String headerClass = "";

    /**
     * Indicate whether the template should have a footer
     */
    private boolean hasFooter = false;


    //
    // Methods used to customize the template
    //

    /**
     * Set the header of the template
     * @param type Type of the header this template should use
     * @return The builder
     */
    public BodyBuilder setHeader(HeaderType type) {

        logger.debug("Set header to {}", type);

        switch(type) {
            case FIXED:
            case STATIC:
                hasHeader = true;
                headerClass = "class='position-" + type.toString().toLowerCase() + "'";
                break;
            default:
                hasHeader = false;
                headerClass = "";
        }

        return this;
    }

    /**
     * Set the footer of the template
     * @param footer Whether this template should include a footer
     * @return The builder
     */
    public BodyBuilder setFooter(boolean footer) {

        logger.debug("Set footer to {}", footer);

        hasFooter = footer;

        return this;
    }


    /**
     * Build <pre><body></pre> of the document (including header, footer and script tags)
     * @return Build body part of the document
     */
    @Override
    public String build() {

        logger.debug("Building <body>");

        String body = "<body>\n";

        if(hasHeader) {
            body += "<header " + headerClass + ">\n" +
                    "    <nav>\n" +
                    "        <a href=\"https://github.com/przemekxa/BootstrapBuilder\" target=\"_blank\">\n" +
                    "            Repozytorium\n" +
                    "        </a>\n" +
                    "        <div>\n" +
                    "            Dokumentacja kodu\n" +
                    "        </div>\n" +
                    "    </nav>\n" +
                    "</header>\n";
        }

        body += "<main class=\"container\">\n" +
                "    <p> Hello </p>\n" +
                "</main>\n";

        if(hasFooter) {
            body += "<footer>\n" +
                    "    <img class=\"footer__animation\" src=\"http://www.cs.put.poznan.pl/wcomplak/IMG/smash.gif\" alt=\"Animacja\">\n" +
                    "</footer>\n";
        }

        body += "<script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n" +
                "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n" +
                "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\n" +
                "</body>\n";

        return body;
    }
}
