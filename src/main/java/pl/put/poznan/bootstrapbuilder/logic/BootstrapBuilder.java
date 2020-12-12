package pl.put.poznan.bootstrapbuilder.logic;


import pl.put.poznan.bootstrapbuilder.rest.HeaderType;
import pl.put.poznan.bootstrapbuilder.rest.Request;

/**
 * This is Director class in builder pattern.
 */
public class BootstrapBuilder implements Builder{

    private Request request;
    private String template = "";

    public BootstrapBuilder(Request request) {
        this.request = request;
    }

    public String getResult() {
        return template;
    }

    public void build() {
        template = "";

        if (request.getFooter()) // czy tutaj nie powinno być getHeader?
            addHeader();

        addBody();

        if (request.getFooter())
            addFooter();

        addEnding();
    }


    private void addHeader() {
        String header;
        String footerStyle = "footer {\n" +
                        "            position: absolute;\n" +
                        "            bottom: 0;\n" +
                        "            height: 55px;\n" +
                        "            width: 100%;\n" +
                        "            background: #000;\n" +
                        "        }\n" +
                        "\n" +
                        "        .footer__animation {\n" +
                        "            width: 65px;\n" +
                        "            height: 55px;\n" +
                        "            position: relative;\n" +
                        "            animation-name: ride;\n" +
                        "            animation-duration: 60s;\n" +
                        "            animation-delay: 2s;\n" +
                        "            animation-iteration-count: infinite;\n" +
                        "        }\n" +
                        "\n" +
                        "        @keyframes ride {\n" +
                        "            0% {\n" +
                        "                left: 0;\n" +
                        "                top: 0;\n" +
                        "            }\n" +
                        "            100% {\n" +
                        "                left: 95%;\n" +
                        "                top: 0;\n" +
                        "            }\n" +
                        "        }";


        header =
                    "<!DOCTYPE html>\n" +
                            "<html lang=\"en\">\n" +
                            "\n" +
                            "<head>\n" +
                            "    <!-- Required meta tags -->\n" +
                            "    <meta charset=\"utf-8\">\n" +
                            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n" +
                            "\n" +
                            "    <!-- Bootstrap CSS -->\n" +
                            "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\"\n" +
                            "          integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n" +
                            "    <title>Title</title>\n" +
                            "    <style>\n" +
                            "        body {\n" +
                            "            background: #1b1f23;\n" +
                            "            background-size: 100%;\n" +
                            "        }\n" +
                            "\n" +
                            "        nav {\n" +
                            "            background: #1b1f23;\n" +
                            "            color: #fff;\n" +
                            "            border-top: 1px solid #1b1f23;\n" +
                            "            border-bottom: 1px solid #000;\n" +
                            "            padding: 8px 30px;\n" +
                            "            z-index: 1000;\n" +
                            "            align-items: center;\n" +
                            "            font-size: 150%;\n" +
                            "            font-family: Open Sans, sans-serif;\n" +
                            "            overflow-x: hidden;\n" +
                            "        }\n" +
                            "\n" +
                            "        main {\n" +
                            "            color: #fff;\n" +
                            "        }\n" +
                            "\n" +
                            "        .nav-head {\n" +
                            "            padding-right: 80px;\n" +
                            "            display: inline-block;\n" +
                            "        }\n" +
                            "\n" +
                            "        .nav-link {\n" +
                            "            padding-right: 20px;\n" +
                            "            font-size: 100%;\n" +
                            "            align-items: center;\n" +
                            "            display: inline-block;\n" +
                            "            color: #fff;\n" +
                            "        }\n" +
                            "        .logo{\n" +
                            "            width: 70px;\n" +
                            "            height: 50px;\n" +
                            "        }\n" +
                            footerStyle +
                            "    </style>\n" +
                            "</head>\n";
        template += header;
    }

    private void addBody() {
        String body;
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
        template += body;
    }

    private void addFooter() {
        template += "<footer>\n" +
                    "<img class=\"footer__animation\" src=\"http://www.cs.put.poznan.pl/wcomplak/IMG/smash.gif\">\n" +
                    "</footer>\n";
    }

    private void addEnding() {
        template += "</body>\n" +
                "<!-- Optional JavaScript -->\n" +
                "<!-- jQuery first, then Popper.js, then Bootstrap JS -->\n" +
                "<script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n" +
                "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n" +
                "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\n" +
                "</html>";
    }
}

