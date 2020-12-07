package pl.put.poznan.bootstrapbuilder.logic;

import pl.put.poznan.bootstrapbuilder.rest.Request;

public class CreateHeader implements Builder {
    private String header = "";

    @Override
    public void build(Request request) {
        header =
                "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "\n" +
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

