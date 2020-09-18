package com.greenfoxacademy.rest.controllers;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class WorkshopControllerTest {

  private final MockMvc mockMvc;

  @Autowired
  public WorkshopControllerTest(MockMvc mockMvc) {
    this.mockMvc = mockMvc;
  }

  @Test
  void givenInput_whenGetDoubling_returnDoubledInput() throws Exception {
    mockMvc.perform(get("/doubling").param("input", "5"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.received", is(5)))
        .andExpect(jsonPath("$.result", is(10)));
  }

  @Test
  void givenNoInput_whenGetDoubling_returnNotFoundStatusWithErrorMessage() throws Exception {
    mockMvc.perform(get("/doubling"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.error", is("Please provide an input!")));
  }

  @Test
  void givenAppendableInput_whenAppendA_returnAppendableWithAppendedA() throws Exception {
    mockMvc.perform(get("/appenda/{appendable}", "kuty"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.appended", is("kutya")));
  }

  @Test
  void givenNoInput_whenAppendA_returnNotFoundStatus() throws Exception {
    mockMvc.perform(get("/appenda/"))
        .andExpect(status().isNotFound());
  }

  @Test
  void givenNameAndTitle_whenGetGreeting_returnGreetingWithInput() throws Exception {
    mockMvc.perform(get("/greeter").param("name", "Vader").param("title", "sith"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.welcome_message", is("Oh, hi there Vader, my dear sith!")));
  }

  @Test
  void missingBothInput_whenGetGreeting_returnBadRequestStatusWithErrorMessage() throws Exception {
    mockMvc.perform(get("/greeter"))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.error", is("Please provide a name and a title!")));
  }

  @Test
  void missingNameInput_whenGetGreeting_returnBadRequestStatusWithErrorMessage() throws Exception {
    mockMvc.perform(get("/greeter").param("title", "sith"))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.error", is("Please provide a name!")));
  }

  @Test
  void missingTitleInput_whenGetGreeting_returnBadRequestStatusWithErrorMessage() throws Exception {
    mockMvc.perform(get("/greeter").param("name", "Vader"))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.error", is("Please provide a title!")));
  }
}