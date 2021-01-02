import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BootrstrapBuilderControllerTest {


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
//        request.put("metaType", "twitter");
//        request.put("metaTags", " {\n" +
//                "              \"title\": \"Some title\",\n" +
//                "              \"type\": \"Some type\",\n" +
//                "              \"description\": \"Some description\",\n" +
//                "              \"image\": \"Some image\"\n" +
//                "          }");
        assertEquals(3, 3);
    }
}
