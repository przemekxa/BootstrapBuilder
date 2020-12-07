package pl.put.poznan.bootstrapbuilder.logic;


import pl.put.poznan.bootstrapbuilder.rest.Request;

/**
 * This is Director class in builder pattern.
 */
public class BootstrapBuilder {

    private Request request;
    private String template = "";

    public BootstrapBuilder(Request request) {
        this.request = request;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public void buildTemplate() {
        CreateHeader createHeader = new CreateHeader();
        CreateBody createBody = new CreateBody();
        CreateFooter createFooter = new CreateFooter();

        createHeader.build(request);
        createBody.build(request);
        createFooter.build(request);

        template = createHeader.getHeader() + createBody.getBody() + createFooter.getFooter();
    }
}

