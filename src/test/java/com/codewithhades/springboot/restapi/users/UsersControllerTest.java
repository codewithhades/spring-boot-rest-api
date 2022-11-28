package com.codewithhades.springboot.restapi.users;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UsersController.class)
class UsersControllerTest {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Test
    void usersControllerIntegrationTest() throws Exception {
        countOfUsersShouldBe(0);
        User obiWan = userShouldBeAdded(new UserRequest("Obi-Wan", "Kenobi"));
        userShouldBeRetrievable(obiWan);
        User anakin = userShouldBeAdded(new UserRequest("Anakin", "Skywalker"));
        userShouldBeRetrievable(anakin);
        countOfUsersShouldBe(2);
        User darthVader = userShouldBeUpdated(anakin.getId(), new UserRequest("Darth", "Vader"));
        userShouldBeRetrievable(darthVader);
        userShouldBeDeleted(darthVader);
        countOfUsersShouldBe(1);
    }

    private User userShouldBeAdded(UserRequest userRequest) throws Exception {
        String responseContent = mockMvc
                .perform(post("/api/users").contentType(MediaType.APPLICATION_JSON).content(getJsonStringFromBody(userRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(userRequest.getName())))
                .andExpect(jsonPath("$.surname", is(userRequest.getSurname())))
                .andReturn().getResponse().getContentAsString();
        return getUserFromJsonString(responseContent);
    }

    private void countOfUsersShouldBe(int count) throws Exception {
        mockMvc.perform(get("/api/users").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(count)));
    }

    private void userShouldBeRetrievable(User user) throws Exception {
        mockMvc
                .perform(get("/api/users/" + user.getId()).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(user.getId())))
                .andExpect(jsonPath("$.name", is(user.getName())))
                .andExpect(jsonPath("$.surname", is(user.getSurname())))
                .andReturn().getResponse().getContentAsString();
    }

    private User userShouldBeUpdated(String id, UserRequest userRequest) throws Exception {
        String responseContent = mockMvc
                .perform(put("/api/users/" + id).contentType(MediaType.APPLICATION_JSON).content(getJsonStringFromBody(userRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(id)))
                .andExpect(jsonPath("$.name", is(userRequest.getName())))
                .andExpect(jsonPath("$.surname", is(userRequest.getSurname())))
                .andReturn().getResponse().getContentAsString();
        return getUserFromJsonString(responseContent);
    }

    private void userShouldBeDeleted(User user) throws Exception {
        mockMvc
                .perform(delete("/api/users/" + user.getId()).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        mockMvc
                .perform(get("/api/users/" + user.getId()).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
        mockMvc
                .perform(put("/api/users/" + user.getId()).contentType(MediaType.APPLICATION_JSON).content("{}"))
                .andExpect(status().isNoContent());
        mockMvc
                .perform(delete("/api/users/" + user.getId()).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    private String getJsonStringFromBody(UserRequest userRequest) {
        try {
            return MAPPER.writeValueAsString(userRequest);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private User getUserFromJsonString(String json) {
        try {
            return MAPPER.readValue(json, User.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}