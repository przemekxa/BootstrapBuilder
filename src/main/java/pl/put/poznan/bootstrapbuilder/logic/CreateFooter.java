package pl.put.poznan.bootstrapbuilder.logic;

import pl.put.poznan.bootstrapbuilder.rest.Request;

/**
 * This is ConcreteBuilder class in builder pattern.
 */
public class CreateFooter implements Builder {
    private String footer = "";

    @Override
    public void build(Request request) {
        String text = "";
        if (request.getFooter()) {
            text = "<footer>\n" +
                    "    <img class=\"footer__animation\" src=\"http://www.cs.put.poznan.pl/wcomplak/IMG/smash.gif\">\n" +
                    "</footer>\n";
        }
        footer = text +
                "</body>\n" +
                "<!-- Optional JavaScript -->\n" +
                "<!-- jQuery first, then Popper.js, then Bootstrap JS -->\n" +
                "<script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n" +
                "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n" +
                "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\n" +
                "</html>";
    }

    public String getFooter() {
        return footer;
    }
}
