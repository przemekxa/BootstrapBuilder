import org.junit.jupiter.api.Test;
import pl.put.poznan.bootstrapbuilder.logic.BootstrapBuilder;
import pl.put.poznan.bootstrapbuilder.rest.HeaderType;
import pl.put.poznan.bootstrapbuilder.rest.MetaTags;
import pl.put.poznan.bootstrapbuilder.rest.MetaType;

import static org.junit.jupiter.api.Assertions.*;

public class BootstrapBuilderTest {

    @Test
    void setHeaderTest() {

        BootstrapBuilder bootstrapBuilder = new BootstrapBuilder();
        bootstrapBuilder.setHeader(HeaderType.FIXED);
        assertEquals("class='position-fixed'", bootstrapBuilder.getHeaderClass());

        bootstrapBuilder.setHeader(HeaderType.STATIC);
        assertEquals("class='position-static'", bootstrapBuilder.getHeaderClass());

        bootstrapBuilder.setHeader(HeaderType.NONE);
        assertEquals("", bootstrapBuilder.getHeaderClass());
    }

    @Test
    void setFooterTest() {

        BootstrapBuilder bootstrapBuilder = new BootstrapBuilder();
        bootstrapBuilder.setFooter(true);
        assertTrue(bootstrapBuilder.getFooterStyle().length() > 0);

        bootstrapBuilder.setFooter(false);
        assertEquals("", bootstrapBuilder.getFooterStyle());
    }

    @Test
    void addMetaRegularTest() {

        MetaTags tags = new MetaTags("TITLE", "TYPE", "DESCRIPTION", "IMAGE");

        String[] regularContents = {
                "<title>TITLE</title>",
                "<meta name=\"description\" content=\"DESCRIPTION\"/>"
        };

        // No tags
        BootstrapBuilder bootstrapBuilder = new BootstrapBuilder();
        String built = bootstrapBuilder.build();
        assertFalse(built.contains("TITLE"));
        assertFalse(built.contains("DESCRIPTION"));
        assertFalse(built.contains("TYPE"));
        assertFalse(built.contains("IMAGE"));

        // Regular tags
        built = bootstrapBuilder.addMeta(MetaType.REGULAR, tags).build();
        for(String contents : regularContents) {
            assertTrue(built.contains(contents), "HTML should contain " + contents);
        }

    }

    @Test
    void addMetaOpenGraphTest() {

        MetaTags tags = new MetaTags("TITLE", "TYPE", "DESCRIPTION", "IMAGE");

        String[] openGraphContents = {
                "<meta property=\"og:title\" content=\"TITLE\" />",
                "<meta property=\"og:description\" content=\"DESCRIPTION\" />",
                "<meta property=\"og:type\" content=\"TYPE\" />",
                "<meta property=\"og:image\" content=\"IMAGE\" />",
        };

        // No tags
        BootstrapBuilder bootstrapBuilder = new BootstrapBuilder();
        String built = bootstrapBuilder.build();
        assertFalse(built.contains("TITLE"));
        assertFalse(built.contains("DESCRIPTION"));
        assertFalse(built.contains("TYPE"));
        assertFalse(built.contains("IMAGE"));

        // Open Graph tags
        built = bootstrapBuilder.addMeta(MetaType.OPEN_GRAPH, tags).build();
        for(String contents : openGraphContents) {
            assertTrue(built.contains(contents), "HTML should contain " + contents);
        }

    }

    @Test
    void addMetaTwitterTest() {

        MetaTags tags = new MetaTags("TITLE", "TYPE", "DESCRIPTION", "IMAGE");

        String[] twitterContents = {
                "<meta property=\"twitter:title\" content=\"TITLE\" />",
                "<meta property=\"twitter:description\" content=\"DESCRIPTION\" />",
                "<meta property=\"twitter:card\" content=\"TYPE\" />",
                "<meta property=\"twitter:image\" content=\"IMAGE\" />",
        };

        // No tags
        BootstrapBuilder bootstrapBuilder = new BootstrapBuilder();
        String built = bootstrapBuilder.build();
        assertFalse(built.contains("TITLE"));
        assertFalse(built.contains("DESCRIPTION"));
        assertFalse(built.contains("TYPE"));
        assertFalse(built.contains("IMAGE"));

        // Twitter tags
        built = bootstrapBuilder.addMeta(MetaType.TWITTER, tags).build();
        for(String contents : twitterContents) {
            assertTrue(built.contains(contents), "HTML should contain " + contents);
        }

    }

    @Test
    void addMetaAllTest() {

        MetaTags tags = new MetaTags("TITLE", "TYPE", "DESCRIPTION", "IMAGE");

        String[] regularContents = {
                "<title>TITLE</title>",
                "<meta name=\"description\" content=\"DESCRIPTION\"/>"
        };

        String[] openGraphContents = {
                "<meta property=\"og:title\" content=\"TITLE\" />",
                "<meta property=\"og:description\" content=\"DESCRIPTION\" />",
                "<meta property=\"og:type\" content=\"TYPE\" />",
                "<meta property=\"og:image\" content=\"IMAGE\" />",
        };

        String[] twitterContents = {
                "<meta property=\"twitter:title\" content=\"TITLE\" />",
                "<meta property=\"twitter:description\" content=\"DESCRIPTION\" />",
                "<meta property=\"twitter:card\" content=\"TYPE\" />",
                "<meta property=\"twitter:image\" content=\"IMAGE\" />",
        };

        // No tags
        BootstrapBuilder bootstrapBuilder = new BootstrapBuilder();
        String built = bootstrapBuilder.build();
        assertFalse(built.contains("TITLE"));
        assertFalse(built.contains("DESCRIPTION"));
        assertFalse(built.contains("TYPE"));
        assertFalse(built.contains("IMAGE"));

        built = bootstrapBuilder
                .addMeta(MetaType.REGULAR, tags)
                .addMeta(MetaType.OPEN_GRAPH, tags)
                .addMeta(MetaType.TWITTER, tags)
                .build();

        // Regular + OpenGraph + Twitter tags
        for(String contents : regularContents) {
            assertTrue(built.contains(contents), "HTML should contain " + contents);
        }
        for(String contents : openGraphContents) {
            assertTrue(built.contains(contents), "HTML should contain " + contents);
        }
        for(String contents : twitterContents) {
            assertTrue(built.contains(contents), "HTML should contain " + contents);
        }
    }



    @Test
    void buildHeadTest() {

    }

}
