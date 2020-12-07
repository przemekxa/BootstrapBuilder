package pl.put.poznan.bootstrapbuilder.logic;

import pl.put.poznan.bootstrapbuilder.rest.Request;

/**
 * This is ConcreteBuilder class in builder pattern.
 */
public class CreateHeader implements Builder {
    private String header = "";

    @Override
    public void build(Request request) {
        header =
                "<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <!-- Required meta tags -->\n" +
                        "    <meta charset=\"utf-8\">\n" +
                        "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n" +
                        "\n" +
                        "    <!-- Bootstrap CSS -->\n" +
                        "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n" +
                        "    <title>Title</title>\n" +
                        "    <style>\n" +
                        "        body {\n" +
                        "            background-image: url(\"http://www.cs.put.poznan.pl/wcomplak/IMG/smash.gif\");\n" +
                        "            background-size: 100%;\n" +
                        "        }\n" +
                        "    </style>\n" +
                        "</head>\n";

    }

    public String getHeader() {
        return header;
    }
}

