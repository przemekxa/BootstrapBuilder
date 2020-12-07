package pl.put.poznan.bootstrapbuilder.logic;


import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;
import pl.put.poznan.bootstrapbuilder.rest.Request;

/**
 * This is just an example to show that the logic should be outside the REST service.
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

