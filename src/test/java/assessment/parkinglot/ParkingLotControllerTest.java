package assessment.parkinglot;

import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ParkingLotControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void parkMotorcycle() throws Exception {
        byte[] input = Files.readAllBytes(Path.of("./src/test/java/resources/input/park_motorcycle.json"));
        byte[] output = Files.readAllBytes(Path.of("./src/test/java/resources/output/park_motorcycle.json"));

        mockMvc.perform(
                post("/park")
                        .content(input)
                        .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(status().isOk())
                .andExpect(content().json(new String(output)));
    }

}
