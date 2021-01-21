import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import pl.put.poznan.bootstrapbuilder.app.BootstrapBuilderApplication;
import pl.put.poznan.bootstrapbuilder.logic.BootstrapBuilder;
import pl.put.poznan.bootstrapbuilder.rest.*;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = BootstrapBuilderApplication.class)
@AutoConfigureMockMvc
public class BootstrapBuilderControllerTest {

    @Autowired
    private MockMvc mvc;

    private static final BootstrapBuilderController controller = new BootstrapBuilderController();

    private static Supplier<BootstrapBuilder> makeDummy(BootstrapBuilder builder) {
        when(builder.setHeader(any())).thenReturn(builder);
        when(builder.setFooter(anyBoolean())).thenReturn(builder);
        when(builder.addMeta(any(), any())).thenReturn(builder);
        when(builder.build()).thenReturn("DOCUMENT");

        return () -> {
            return builder;
        };
    }

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

        for (HeaderType header : HeaderType.values()) {
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

    @Test
    void addFooterTest() {
        BootstrapBuilder mockBuilder = mock(BootstrapBuilder.class);
        controller.setMakeBuilder(makeDummy(mockBuilder));

        Request request = new Request();
        request.setFooter(true);

        String response = controller.getBootstrapTemplate(request);

        assertEquals("DOCUMENT", response);
        verify(mockBuilder).setFooter(true);
        verify(mockBuilder).build();
    }

    @Test
    void addMetaTest() {
        for (MetaType type : MetaType.values()) {
            BootstrapBuilder mockBuilder = mock(BootstrapBuilder.class);
            controller.setMakeBuilder(makeDummy(mockBuilder));

            MetaTags metaTags = new MetaTags("title", "type", "description", "image");
            Set<MetaType> meta = new HashSet<>();
            meta.add(type);

            Request request = new Request();
            request.setMetaTags(metaTags);
            request.setMetaTypes(meta);

            String response = controller.getBootstrapTemplate(request);

            assertEquals("DOCUMENT", response);
            verify(mockBuilder).addMeta(type, metaTags);
            verify(mockBuilder).build();
        }
    }

    @Test
    public void requestFormEndpoint() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders
                        .get("/index.html"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML));
    }

    @Test
    public void requestTemplateEndpoint() throws Exception {
        String json = "{\n" +
                "          \"header\": \"static\",\n" +
                "          \"footer\": true,\n" +
                "          \"metaTypes\": [\"regular\", \"openGraph\"],\n" +
                "          \"metaTags\": {\n" +
                "              \"title\": \"Some title\",\n" +
                "              \"type\": \"Some type\",\n" +
                "              \"description\": \"Some description\",\n" +
                "              \"image\": \"Some image\"\n" +
                "                             }\n" +
                "      }";
        mvc.perform(
                MockMvcRequestBuilders
                        .post("/template")
                        .contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML));
    }
}