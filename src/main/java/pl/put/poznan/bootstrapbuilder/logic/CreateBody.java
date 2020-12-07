package pl.put.poznan.bootstrapbuilder.logic;

import pl.put.poznan.bootstrapbuilder.rest.HeaderType;
import pl.put.poznan.bootstrapbuilder.rest.Request;

/**
 * This is ConcreteBuilder class in builder pattern.
 */
public class CreateBody implements Builder {
    private String body = "";

    @Override
    public void build(Request request) {
        String text = "";
        HeaderType headerType = request.getHeader();

        if (headerType != HeaderType.NONE) {
            text = "class='position-" + headerType.toString().toLowerCase() + "'";
        }
        body =
                "<body>\n" +
                        "<header " + text + ">\n" +
                        "    <nav>\n" +
                        "        <div class=\"nav-head\">\n" +
                        "            <img class=\"logo\" src=\"https://i.ibb.co/4j19Vgg/sprint.png\">\n" +
                        "        </div>\n" +
                        "        <a class=\"nav-link\" href=\"https://github.com/przemekxa/BootstrapBuilder\" target=\"_blank\">\n" +
                        "            Repozytorium\n" +
                        "        </a>\n" +
                        "        <div class=\"nav-link\">\n" +
                        "            Dokumentacja kodu\n" +
                        "        </div>\n" +
                        "    </nav>\n" +
                        "</header>\n" +
                        "<main>\n" +
                        "    <p> jakis opis </p>\n" +
                        "</main>";

    }

    public String getBody() {
        return body;
    }
}

