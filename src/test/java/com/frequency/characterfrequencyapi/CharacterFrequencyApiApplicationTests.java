package com.frequency.characterfrequencyapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@AutoConfigureMockMvc
class CharacterFrequencyApiApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private static Map<String, String> requestBody;
    private static Map<String, Integer> expectedResult;

    @BeforeAll
    public static void before() {
        requestBody = new HashMap<>();
        requestBody.put("inputString", "fffwwwwwwnll");

        expectedResult = new HashMap<>();
        expectedResult.put("w", 6);
        expectedResult.put("f", 3);
        expectedResult.put("l", 2);
        expectedResult.put("n", 1);
    }

    @Test
    public void testCalculateCharacterFrequency() throws Exception {
        final MockHttpServletRequestBuilder request = post("/frequency")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestBody));

        final MockHttpServletResponse response = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn()
                .getResponse();

        Map<String, Integer> result = objectMapper.readValue(response.getContentAsString(), new TypeReference<>() { });

        assertTrue(result.entrySet().containsAll(expectedResult.entrySet()));
    }

    @Test
    public void testCalculateCharacterFrequencyFail() throws Exception {
        final MockHttpServletRequestBuilder request = post("/frequency")
                .contentType(APPLICATION_JSON)
                .content("");

        final MockHttpServletResponse response = mockMvc.perform(request)
                .andExpect(status().isBadRequest())
                .andReturn()
                .getResponse();
    }
}
