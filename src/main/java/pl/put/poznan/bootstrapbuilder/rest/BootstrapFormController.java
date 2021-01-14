package pl.put.poznan.bootstrapbuilder.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This is Controller class which handles form page that sens JSON to api
 */
@Controller
public class BootstrapFormController {
    /**
     * Form endpoint used for user to design his generated html template
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String bootstrapTemplateForm() {
        return "bootstrap-template-form";
    }
}
