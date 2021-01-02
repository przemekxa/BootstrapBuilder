package pl.put.poznan.bootstrapbuilder.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.put.poznan.bootstrapbuilder.rest.HeaderType;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * This is Director class in builder pattern.
 */
public class BootstrapBuilder implements Builder {

    private static final Logger logger = LoggerFactory.getLogger(BootstrapBuilder.class);



    //
    // Variables
    //

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

    /**
     * Style of the <pre><footer></pre> tag
     */
    private String footerStyle = "";



    //
    // Methods for customizing the template
    //

    /**
     * Set the header of the template
     * @param type Type of the header this template should use
     * @return The builder
     */
    public BootstrapBuilder setHeader(HeaderType type) {

        logger.debug("Builder: Set header to {}", type);

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
    public BootstrapBuilder setFooter(boolean footer) {

        logger.debug("Builder: Set footer to {}", footer);

        hasFooter = footer;

        if(footer) {
            footerStyle =
                    "<style>\n" +
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
                    "}\n" +
                    "</style>\n";

        } else {
            footerStyle = "";
        }

        return this;
    }



    //
    // Building the template
    //

    /**
     * Build <pre><head></pre> of the document
     * @return Built head part of the document
     */
    private String buildHead() {

        // CSS
        String style = footerStyle;

        // Add padding (8 spaces) to style
        String stylePadded = Arrays.stream(style.split("\n"))
                .map(s -> "        " + s)
                .collect(Collectors.joining("\n"));

        return
                "<head>\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n" +
                "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\"\n" +
                "          integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n" +
                "    <title>Title</title>\n" +
                stylePadded +
                "</head>\n";
    }

    /**
     * Build <pre><body></pre> of the document (including header, footer and script tags)
     * @return Build body part of the document
     */
    private String buildBody() {

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

        body += "<main>\n" +
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

    /**
     * Build the template from parameters set in this builder
     * @return HTML of the template
     */
    @Override
    public String build() {

        logger.debug("Builder: Building template");

        // DOCTYPE and <html>
        String htmlStart =
                "<!doctype html>\n" +
                "<html lang=\"en\">" +
                "\n";

        // <head>...</head>
        String head = buildHead();

        // <body>...</body>
        String body = buildBody();

        // </html>
        String htmlEnd = "</html>";

        return htmlStart + head + body + htmlEnd;
    }

    public String getHeaderClass() {
        return headerClass;
    }

    public String getFooterStyle() {
        return footerStyle;
    }
}

