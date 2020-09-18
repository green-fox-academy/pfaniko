package com.greenfoxacademy.testing.controllers;

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
class GuardianControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void translateMessage_testCase_withGivenParameter() throws Exception {
    mockMvc.perform(get("/groot?message=somemessage"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.received", is("somemessage")))
        .andExpect(jsonPath("$.translated", is("I am Groot!")));
  }

  @Test
  void translateMessage_testCase_withoutGivenParameter() throws Exception {
    mockMvc.perform(get("/groot"))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.error", is("I am Groot!")));
  }
}