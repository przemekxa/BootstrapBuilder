package pl.put.poznan.bootstrapbuilder.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.put.poznan.bootstrapbuilder.logic.BootstrapBuilder;
import pl.put.poznan.bootstrapbuilder.logic.Builder;

@RestController
public class BootstrapBuilderController {

    private static final Logger logger = LoggerFactory.getLogger(BootstrapBuilderController.class);

    /**
     * Default API endpoint for creating webpage templates based on Bootstrap 4 framework
     * <p>
     * Example body payload:
     * <pre>
     * {
     *     "header": "static",
     *     "footer": true,
     *     "metaType": "twitter",
     *     "metaTags": {
     *         "title": "Some title",
     *         "type": "Some type",
     *         "description": "Some description",
     *         "image": "Some image"
     *     }
     * }
     * </pre>
     *
     * @param request Request object representing user request
     * @return Webpage template
     */
    @RequestMapping(value = "/template", method = RequestMethod.GET, produces = "application/json")
    public String getBootstrapTemplate(@RequestBody(required = false) Request request) {

        // log the parameters
        logger.debug("GET Template: Header: '{}', Footer: '{}', MetaType: '{}'",
                (request.getHeader() != null ? request.getHeader() : "NULL"),
                request.getFooter(),
                (request.getMetaType() != null ? request.getMetaType() : "NULL")
        );

        MetaTags tags = request.getMetaTags();
        if (tags != null) {
            logger.debug("\tMeta tags: Title: '{}', Type: '{}', Desc: '{}', Image: '{}'",
                    (tags.getTitle() != null ? tags.getTitle() : "NULL"),
                    (tags.getType() != null ? tags.getType() : "NULL"),
                    (tags.getDescription() != null ? tags.getDescription() : "NULL"),
                    (tags.getImage() != null ? tags.getImage() : "NULL")
            );
        } else {
            logger.debug("\tMeta tags: NULL");
        }

        HeaderType h = HeaderType.FIXED;

        Builder bootstrapBuilder = new BootstrapBuilder(request);
        bootstrapBuilder.build();
        String template = bootstrapBuilder.getResult();

        return template;
    }
}