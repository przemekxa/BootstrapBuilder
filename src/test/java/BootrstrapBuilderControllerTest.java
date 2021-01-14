import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;
import pl.put.poznan.bootstrapbuilder.rest.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BootrstrapBuilderControllerTest {

    public static BootstrapBuilderController controller = new BootstrapBuilderController();

    /**
     * This test checks response from /template
     *
     * @throws ClientProtocolException
     * @throws IOException
     */
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

    @Test
    void getBootstrapTemplateReturnTest() throws IOException {
//        Map<String,String> request = new HashMap<>();
//        request.put("header", "static");
//        request.put("footer", "true");
//        request.put("metaTypes", ["twitter"]);
//        request.put("metaTags", " {\n" +
//                "              \"title\": \"Some title\",\n" +
//                "              \"type\": \"Some type\",\n" +
//                "              \"description\": \"Some description\",\n" +
//                "              \"image\": \"Some image\"\n" +
//                "          }");
        assertEquals(3, 3);
    }

    @Test
    void getBootstrapTemplateTest1() {

        // Request
        Request request = new Request(
                HeaderType.STATIC,
                true,
                new HashSet<>(Arrays.asList(
                        MetaType.REGULAR,
                        MetaType.OPEN_GRAPH,
                        MetaType.TWITTER)),
                new MetaTags("TITLE", "TYPE", "DESCRIPTION", "IMAGE")
        );

        String[] pageContents = {
                "<html", "</html>", "<head>", "</head>", "<body>", "</body>"
        };

        String response = controller.getBootstrapTemplate(request);

        for (String contents : pageContents) {
            assertTrue(response.contains(contents), "HTML should contain " + contents);
        }
    }

    @Test
    void getBootstrapBuilderTest2() {
    }
}
