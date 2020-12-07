package pl.put.poznan.bootstrapbuilder.logic;

import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;
import pl.put.poznan.bootstrapbuilder.rest.Request;

public class CreateBody implements Builder {
    private String body = "";

    @Override
    public void build(Request request) {
        body =
                "<body>\n" +
                "   <header>\n" +
                "       <h>Strona główna</h>\n" +
                "   </header>\n" +
                "   <p> jakis opis </p>\n ";

    }

    public String getBody() {
        return body;
    }
}

