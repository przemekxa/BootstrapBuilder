import org.junit.jupiter.api.Test;
import org.mockito.Mockito.*;
import pl.put.poznan.bootstrapbuilder.logic.BodyBuilder;
import pl.put.poznan.bootstrapbuilder.logic.BootstrapBuilder;
import pl.put.poznan.bootstrapbuilder.logic.HeadBuilder;
import pl.put.poznan.bootstrapbuilder.rest.HeaderType;
import pl.put.poznan.bootstrapbuilder.rest.MetaTags;
import pl.put.poznan.bootstrapbuilder.rest.MetaType;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BootstrapBuilderTest {

    private static final String emptyDocument =
            "<!doctype html>\n" +
            "<html lang=\"en\">\n" +
            "<head></head>\n" +
            "<body></body>\n" +
            "</html>";

    private static final MetaTags tags = new MetaTags("TITLE", "TYPE", "DESCRIPTION", "IMAGE");

    @Test
    void emptyDocumentTest() {
        String expected =
                "<!doctype html>\n" +
                "<html lang=\"en\">\n" +
                "</html>";

        HeadBuilder mockHead = mock(HeadBuilder.class);
        when(mockHead.build()).thenReturn("");

        BodyBuilder mockBody = mock(BodyBuilder.class);
        when(mockBody.build()).thenReturn("");

        String result = new BootstrapBuilder(mockHead, mockBody)
                .build();

        assertEquals(expected, result);
        verify(mockHead).build();
        verify(mockBody).build();
    }

    @Test
    void setHeaderTest() {

        for(HeaderType header : HeaderType.values()) {

            HeadBuilder mockHead = mock(HeadBuilder.class);
            when(mockHead.build()).thenReturn("<head></head>\n");
            BodyBuilder mockBody = mock(BodyBuilder.class);
            when(mockBody.build()).thenReturn("<body></body>\n");

            String result = new BootstrapBuilder(mockHead, mockBody)
                    .setHeader(header)
                    .build();

            verify(mockBody).setHeader(header);
            assertEquals(emptyDocument, result);

        }
    }

    @Test
    void setFooterTrueTest() {
        HeadBuilder mockHead = mock(HeadBuilder.class);
        when(mockHead.build()).thenReturn("<head></head>\n");
        BodyBuilder mockBody = mock(BodyBuilder.class);
        when(mockBody.build()).thenReturn("<body></body>\n");

        String result = new BootstrapBuilder(mockHead, mockBody)
                .setFooter(false)
                .build();

        verify(mockBody).setFooter(false);
        verify(mockHead, never()).addCSS(anyString());
        assertEquals(emptyDocument, result);
    }

    @Test
    void setFooterFalseTest() {
        HeadBuilder mockHead = mock(HeadBuilder.class);
        when(mockHead.build()).thenReturn("<head></head>\n");
        BodyBuilder mockBody = mock(BodyBuilder.class);
        when(mockBody.build()).thenReturn("<body></body>\n");

        String result = new BootstrapBuilder(mockHead, mockBody)
                .setFooter(true)
                .build();

        verify(mockBody).setFooter(true);
        verify(mockHead).addCSS(anyString());
        assertEquals(emptyDocument, result);
    }

    @Test
    void addMetaTagsTest() {
        for(MetaType type : MetaType.values()) {
            HeadBuilder mockHead = mock(HeadBuilder.class);
            when(mockHead.build()).thenReturn("<head></head>\n");
            BodyBuilder mockBody = mock(BodyBuilder.class);
            when(mockBody.build()).thenReturn("<body></body>\n");

            String result = new BootstrapBuilder(mockHead, mockBody)
                    .addMeta(type, tags)
                    .build();

            verify(mockHead).addMeta(type, tags);
            assertEquals(emptyDocument, result);
        }
    }

}
