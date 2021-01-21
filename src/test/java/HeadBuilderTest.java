import org.junit.jupiter.api.Test;
import pl.put.poznan.bootstrapbuilder.logic.BodyBuilder;
import pl.put.poznan.bootstrapbuilder.logic.BootstrapBuilder;
import pl.put.poznan.bootstrapbuilder.logic.HeadBuilder;
import pl.put.poznan.bootstrapbuilder.rest.*;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class HeadBuilderTest {

    @Test
    void emptyTest() {
        String result = new HeadBuilder()
                .build();

        String expected = "<head>\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n" +
                "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\"\n" +
                "          integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n" +
                "\n" +
                "</head>\n";

        assertEquals(expected, result);
    }

    @Test
    void headBuilderAddCssMockTest() {
        HeadBuilder mockHB = mock(HeadBuilder.class);
        BootstrapBuilder bootstrapBuilder = new BootstrapBuilder(mockHB, new BodyBuilder());

        bootstrapBuilder.setFooter(true);

        verify(mockHB).addCSS(anyString());
    }

    @Test
    void headBuilderAddMetaMockTest() {
        HeadBuilder mockHB = mock(HeadBuilder.class);
        BootstrapBuilder bootstrapBuilder = new BootstrapBuilder(mockHB, new BodyBuilder());

        bootstrapBuilder.addMeta(MetaType.REGULAR, new MetaTags());

        verify(mockHB).addMeta(any(), any());
    }

    @Test
    void headBuilderBuildMockTest() {
        HeadBuilder mockHB = mock(HeadBuilder.class);
        BootstrapBuilder bootstrapBuilder = new BootstrapBuilder(mockHB, new BodyBuilder());

        bootstrapBuilder.build();

        verify(mockHB).build();
    }

    @Test
    void addCSSTest() {
        String css1 = "h1 { text-align: center; }";
        String css2 = ".grid { display: grid; }";
        String css3 = "input[type=text] { text-decoration: none; }";

        String result = new HeadBuilder()
                .addCSS(css1)
                .addCSS(css2)
                .addCSS(css3)
                .build();

        assertTrue(result.contains(css1));
        assertTrue(result.contains(css2));
        assertTrue(result.contains(css3));
    }

    @Test
    void addMetaRegularTest() {

        MetaTags tags = new MetaTags("TITLE", "TYPE", "DESCRIPTION", "IMAGE");

        String[] regularContents = {
                "<title>TITLE</title>",
                "<meta name=\"description\" content=\"DESCRIPTION\"/>"
        };

        // No tags
        HeadBuilder headBuilder = new HeadBuilder();
        String built = headBuilder.build();
        assertFalse(built.contains("TITLE"));
        assertFalse(built.contains("DESCRIPTION"));
        assertFalse(built.contains("TYPE"));
        assertFalse(built.contains("IMAGE"));

        // Regular tags
        built = headBuilder.addMeta(MetaType.REGULAR, tags).build();
        for (String contents : regularContents) {
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
        HeadBuilder headBuilder = new HeadBuilder();
        String built = headBuilder.build();
        assertFalse(built.contains("TITLE"));
        assertFalse(built.contains("DESCRIPTION"));
        assertFalse(built.contains("TYPE"));
        assertFalse(built.contains("IMAGE"));

        // Open Graph tags
        built = headBuilder.addMeta(MetaType.OPEN_GRAPH, tags).build();
        for (String contents : openGraphContents) {
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
        HeadBuilder headBuilder = new HeadBuilder();
        String built = headBuilder.build();
        assertFalse(built.contains("TITLE"));
        assertFalse(built.contains("DESCRIPTION"));
        assertFalse(built.contains("TYPE"));
        assertFalse(built.contains("IMAGE"));

        // Twitter tags
        built = headBuilder.addMeta(MetaType.TWITTER, tags).build();
        for (String contents : twitterContents) {
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
        HeadBuilder headBuilder = new HeadBuilder();
        String built = headBuilder.build();
        assertFalse(built.contains("TITLE"));
        assertFalse(built.contains("DESCRIPTION"));
        assertFalse(built.contains("TYPE"));
        assertFalse(built.contains("IMAGE"));

        built = headBuilder
                .addMeta(MetaType.REGULAR, tags)
                .addMeta(MetaType.OPEN_GRAPH, tags)
                .addMeta(MetaType.TWITTER, tags)
                .build();

        // Regular + OpenGraph + Twitter tags
        for (String contents : regularContents) {
            assertTrue(built.contains(contents), "HTML should contain " + contents);
        }
        for (String contents : openGraphContents) {
            assertTrue(built.contains(contents), "HTML should contain " + contents);
        }
        for (String contents : twitterContents) {
            assertTrue(built.contains(contents), "HTML should contain " + contents);
        }
    }
}