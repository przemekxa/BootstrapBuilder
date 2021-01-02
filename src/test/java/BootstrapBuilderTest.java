import org.junit.jupiter.api.Test;
import pl.put.poznan.bootstrapbuilder.logic.BootstrapBuilder;
import pl.put.poznan.bootstrapbuilder.rest.HeaderType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    void buildHeadTest() {

    }

}
