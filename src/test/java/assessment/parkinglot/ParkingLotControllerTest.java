package assessment.parkinglot;

import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Sql({"/schema.sql", "/data.sql"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ParkingLotControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void parkAndLeaveMotorcycle() throws Exception {
        byte[] input = Files.readAllBytes(Path.of("./src/test/java/resources/input/park_motorcycle.json"));
        byte[] output = Files.readAllBytes(Path.of("./src/test/java/resources/output/park_motorcycle.json"));

        mockMvc.perform(
                post("/park")
                        .content(input)
                        .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(status().isOk())
                .andExpect(content().json(new String(output)));

        byte[] secondOutput = Files.readAllBytes(Path.of("./src/test/java/resources/output/leave_motorcycle.json"));

        mockMvc.perform(
                        post("/leave")
                                .content(input)
                                .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(status().isOk())
                .andExpect(content().json(new String(secondOutput)));
    }

    @Test
    void parkAndLeaveCar() throws Exception {
        byte[] input = Files.readAllBytes(Path.of("./src/test/java/resources/input/park_car.json"));
        byte[] output = Files.readAllBytes(Path.of("./src/test/java/resources/output/park_car.json"));

        mockMvc.perform(
                        post("/park")
                                .content(input)
                                .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(status().isOk())
                .andExpect(content().json(new String(output)));

        byte[] secondOutput = Files.readAllBytes(Path.of("./src/test/java/resources/output/leave_car.json"));

        mockMvc.perform(
                        post("/leave")
                                .content(input)
                                .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(status().isOk())
                .andExpect(content().json(new String(secondOutput)));
    }

    @Test
    void parkAndLeaveVan() throws Exception {
        byte[] input = Files.readAllBytes(Path.of("./src/test/java/resources/input/park_van.json"));
        byte[] output = Files.readAllBytes(Path.of("./src/test/java/resources/output/park_van.json"));

        mockMvc.perform(
                        post("/park")
                                .content(input)
                                .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(status().isOk())
                .andExpect(content().json(new String(output)));

        byte[] secondOutput = Files.readAllBytes(Path.of("./src/test/java/resources/output/leave_van.json"));

        mockMvc.perform(
                        post("/leave")
                                .content(input)
                                .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(status().isOk())
                .andExpect(content().json(new String(secondOutput)));
    }

    @Test
    void remainingSpots() throws Exception {
        mockMvc.perform(get("/remaining_spots"))
                .andExpect(status().isOk())
                .andExpect(content().string("25"));


        byte[] input = Files.readAllBytes(Path.of("./src/test/java/resources/input/park_motorcycle.json"));

        mockMvc.perform(
                        post("/park")
                                .content(input)
                                .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(status().isOk());

        mockMvc.perform(get("/remaining_spots"))
                .andExpect(status().isOk())
                .andExpect(content().string("24"));
    }

    @Test
    void check() throws Exception {
        byte[] input = Files.readAllBytes(Path.of("./src/test/java/resources/input/park_van.json"));

        mockMvc.perform(
                        post("/check")
                                .content(input)
                                .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(status().isOk())
                .andExpect(content().string("true"));
    }
}
