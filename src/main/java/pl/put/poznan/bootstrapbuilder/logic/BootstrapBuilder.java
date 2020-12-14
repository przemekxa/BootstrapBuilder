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
                    "}\n";

        } else {
            footerStyle = "";
        }

        return this;
    }


    //
    // Build the template
    //

    /**
     * Build the template from parameters set in this builder
     * @return HTML of
     */
    public String build() {

        logger.debug("Builder: Building template");

        String htmlStart;
        String head;
        String style;
        String body;
        String htmlEnd;

        // DOCTYPE and <html>
        htmlStart =
                "<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "\n";

        // CSS
        style =
                "body {\n" +
                "    background: #1b1f23;\n" +
                "    background-size: 100%;\n" +
                "}\n" +
                "\n" +
                "nav {\n" +
                "    background: #1b1f23;\n" +
                "    color: #fff;\n" +
                "    border-top: 1px solid #1b1f23;\n" +
                "    border-bottom: 1px solid #000;\n" +
                "    padding: 8px 30px;\n" +
                "    z-index: 1000;\n" +
                "    align-items: center;\n" +
                "    font-size: 150%;\n" +
                "    font-family: Open Sans, sans-serif;\n" +
                "    overflow-x: hidden;\n" +
                "}\n" +
                "\n" +
                "main {\n" +
                "    color: #fff;\n" +
                "}\n" +
                "\n" +
                ".nav-head {\n" +
                "    padding-right: 80px;\n" +
                "    display: inline-block;\n" +
                "}\n" +
                "\n" +
                ".nav-link {\n" +
                "    padding-right: 20px;\n" +
                "    font-size: 100%;\n" +
                "    align-items: center;\n" +
                "    display: inline-block;\n" +
                "    color: #fff;\n" +
                "}\n" +
                ".logo{\n" +
                "    width: 70px;\n" +
                "    height: 50px;\n" +
                "}\n" +
                footerStyle;

        // Adding padding (8 spaces) to style
        String stylePadded = Arrays.stream(style.split("\n"))
                .map(s -> "        " + s)
                .collect(Collectors.joining("\n"));

        // <head>
        head =
                "<head>\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n" +
                "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\"\n" +
                "          integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n" +
                "    <title>Title</title>\n" +
                "    <style>\n" +
                stylePadded +
                "    </style>\n" +
                "</head>\n";

        // <body> (including <header>, <footer> and <script>)
        body = "<body>\n";

        if(hasHeader) {
            body += "<header " + headerClass + ">\n" +
                    "    <nav>\n" +
                    "        <div class=\"nav-head\">\n" +
                    "            <img class=\"logo\" src=\"https://i.ibb.co/4j19Vgg/sprint.png\" alt=\"Logo Sprint\">\n" +
                    "        </div>\n" +
                    "        <a class=\"nav-link\" href=\"https://github.com/przemekxa/BootstrapBuilder\" target=\"_blank\">\n" +
                    "            Repozytorium\n" +
                    "        </a>\n" +
                    "        <div class=\"nav-link\">\n" +
                    "            Dokumentacja kodu\n" +
                    "        </div>\n" +
                    "    </nav>\n" +
                    "</header>\n";
        }

        body += "<main>\n" +
                "    <p> Opis </p>\n" +
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

        // </html>
        htmlEnd = "</html>";

        return htmlStart + head + body + htmlEnd;
    }

}

