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
                        "    <h>Strona główna</h>\n" +
                        "</header>\n" +
                        "<main>\n" +
                        "    <p> jakis opis </p>\n" +
                        "</main>\n";

    }

    public String getBody() {
        return body;
    }
}

