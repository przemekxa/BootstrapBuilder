import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;
import pl.put.poznan.bootstrapbuilder.logic.BootstrapBuilder;
import pl.put.poznan.bootstrapbuilder.rest.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BootrstrapBuilderControllerTest {

    private static BootstrapBuilderController controller = new BootstrapBuilderController();

    private static Supplier<BootstrapBuilder> makeDummy(BootstrapBuilder builder) {
        when(builder.setHeader(any())).thenReturn(builder);
        when(builder.setFooter(anyBoolean())).thenReturn(builder);
        when(builder.addMeta(any(), any())).thenReturn(builder);
        when(builder.build()).thenReturn("DOCUMENT");

        return () -> { return builder; };
    };

    /**
     * This test checks response from /template
     *
     * @throws ClientProtocolException
     * @throws IOException
     */
    /*
    @Test
    void getBootstrapTemplateResponseTest() throws ClientProtocolException, IOException {

        // Given
        HttpUriRequest request = new HttpGet("http://localhost:8080/template");

        // When
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        // Then
        assertEquals(
                httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_INTERNAL_SERVER_ERROR);
    }
     */


    @Test
    void emptyRequestTest() {
        BootstrapBuilder mockBuilder = mock(BootstrapBuilder.class);
        controller.setMakeBuilder(makeDummy(mockBuilder));

        Request request = new Request();

        String response = controller.getBootstrapTemplate(request);

        assertEquals("DOCUMENT", response);
        verify(mockBuilder).setHeader(HeaderType.NONE);
        verify(mockBuilder).setFooter(false);
        verify(mockBuilder, never()).addMeta(any(), any());
        verify(mockBuilder).build();
    }

    @Test
    void headerTest() {

        for(HeaderType header : HeaderType.values()) {
            BootstrapBuilder mockBuilder = mock(BootstrapBuilder.class);
            controller.setMakeBuilder(makeDummy(mockBuilder));

            Request request = new Request();
            request.setHeader(header);

            String response = controller.getBootstrapTemplate(request);

            assertEquals("DOCUMENT", response);
            verify(mockBuilder).setHeader(header);
            verify(mockBuilder).setFooter(false);
            verify(mockBuilder, never()).addMeta(any(), any());
            verify(mockBuilder).build();
        }

    }

    // TODO: Add footer test, meta test...
}
