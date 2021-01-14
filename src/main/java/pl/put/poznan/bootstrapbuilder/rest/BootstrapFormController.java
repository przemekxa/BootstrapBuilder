package pl.put.poznan.bootstrapbuilder.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BootstrapFormController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String bootstrapTemplateForm() {
        return "bootstrap-template-form";
    }
}
