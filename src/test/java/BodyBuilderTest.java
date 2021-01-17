import org.junit.jupiter.api.Test;
import pl.put.poznan.bootstrapbuilder.logic.BodyBuilder;
import pl.put.poznan.bootstrapbuilder.rest.HeaderType;

import static org.junit.jupiter.api.Assertions.*;

class BodyBuilderTest {

    @Test
    void setNullHeaderTest() {
        String result;

        result = new BodyBuilder()
                .setHeader(HeaderType.NONE)
                .build();
        assertFalse(result.contains("header"));
    }

    @Test
    void setStaticHeaderTest() {
        String result;

        result = new BodyBuilder()
                .setHeader(HeaderType.STATIC)
                .build();

        assertTrue(result.contains("header"));
        assertTrue(result.contains("class='position-static'"));
    }

    @Test
    void setFixedHeaderTest() {
        String result;

        result = new BodyBuilder()
                .setHeader(HeaderType.FIXED)
                .build();

        assertTrue(result.contains("header"));
        assertTrue(result.contains("class='position-fixed'"));
    }

    @Test
    void setNoFooterTest() {
        String result;

        result = new BodyBuilder()
                .setFooter(false)
                .build();

        assertFalse(result.contains("footer"));
    }

    @Test
    void setFooterTest() {
        String result;

        result = new BodyBuilder()
                .setFooter(true)
                .build();

        assertTrue(result.contains("footer"));
    }

    @Test
    void noFooterHeaderTest() {
        String result;
        HeaderType[] headers = HeaderType.values();

        for(HeaderType header : headers) {
            result = new BodyBuilder()
                    .setHeader(header)
                    .setFooter(false)
                    .build();


            if(header == HeaderType.NONE) {
                assertFalse(result.contains("header"));
            } else {
                assertTrue(result.contains("header"));
                assertTrue(result.contains("class='position-" + header.name().toLowerCase() + "'"));
            }
            assertFalse(result.contains("footer"));

        }

    }

    @Test
    void footerHeaderTest() {
        String result;
        HeaderType[] headers = HeaderType.values();

        for(HeaderType header : headers) {
            result = new BodyBuilder()
                    .setHeader(header)
                    .setFooter(true)
                    .build();


            if(header == HeaderType.NONE) {
                assertFalse(result.contains("header"));
            } else {
                assertTrue(result.contains("header"));
                assertTrue(result.contains("class='position-" + header.name().toLowerCase() + "'"));
            }
            assertTrue(result.contains("footer"));

        }

    }

}