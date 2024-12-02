package org.tctalent.anonymization.controller;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.tctalent.anonymization.model.Candidate;
import org.tctalent.anonymization.service.CandidateService;

@SpringBootTest
class CandidateControllerTest {

  @Autowired
  CandidateService candidateService;

  @Autowired
  WebApplicationContext wac;

  MockMvc mockMvc;

  Candidate testCandidate;

  @BeforeEach
  void setUp() {
    mockMvc = MockMvcBuilders.webAppContextSetup(wac)
        .build();

    Pageable pageable = PageRequest.of(0, 10);
    testCandidate = candidateService.findAll(pageable).getContent().iterator().next();
  }

  @Test
  @Transactional
  @DisplayName("Get all candidates")
  void testGetAllCandidates() throws Exception {
    mockMvc.perform(get(CandidateController.BASE_URL)
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.length()", greaterThan(0)));
  }

  @Test
  @Transactional
  @DisplayName("Get candidate by Id")
  void testGetCandidateById() throws Exception {
    mockMvc.perform(get(CandidateController.BASE_URL + "/{candidateId}", testCandidate.getId())
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(testCandidate.getId().toString()));
  }

}
