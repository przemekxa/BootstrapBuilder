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
                        "        footer {\n" +
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
                        "        }\n" +
                        "    </style>\n" +
                        "</head>\n";

    }

    public String getHeader() {
        return header;
    }
}

