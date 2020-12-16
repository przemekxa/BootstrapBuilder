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
    // Building the template
    //

    /**
     * Build <pre><head></pre> of the document
     * @return Built head part of the document
     */
    private String buildHead() {

        // CSS
        String style =
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
                "    <style>\n" +
                stylePadded +
                "    </style>\n" +
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
                    "        <div class=\"nav-head\">\n" +
                    "            <img class=\"logo\" src=\"https://scontent.xx.fbcdn.net/v/t1.15752-9/73295358_1829658583844371_4379619284632993792_n.png?_nc_cat=107&ccb=2&_nc_sid=58c789&_nc_ohc=4u_wWZaGxCYAX9lc8zY&_nc_ad=z-m&_nc_cid=0&_nc_ht=scontent.xx&oh=e5beae40955f8d61ddfae90ef13afbbf&oe=60017C57\" alt=\"Logo Sprint\">\n" +
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

        return body;
    }

    /**
     * Build the template from parameters set in this builder
     * @return HTML of the template
     */
    public String build() {

        logger.debug("Builder: Building template");

        // DOCTYPE and <html>
        String htmlStart =
                "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "\n";

        // <head>...</head>
        String head = buildHead();

        // <body>...</body>
        String body = buildBody();

        // </html>
        String htmlEnd = "</html>";

        return htmlStart + head + body + htmlEnd;
    }

}

