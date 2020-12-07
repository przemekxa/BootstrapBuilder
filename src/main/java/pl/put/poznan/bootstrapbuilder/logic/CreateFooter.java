package pl.put.poznan.bootstrapbuilder.logic;

import pl.put.poznan.bootstrapbuilder.rest.Request;

public class CreateFooter implements Builder {
    private String footer = "";


    @Override
    public void build(Request request) {
        footer =
                "   <footer>\n" +
                "       siema\n" +
                "   </footer>\n" +
                "</body>\n" +
                "</html>";
    }

    public String getFooter() {
        return footer;
    }
}
