package com.dengsoft.tutorial.springboot.emp;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import com.dengsoft.tutorial.springboot.emp.db.model.Employee;
import com.dengsoft.tutorial.springboot.emp.service.EmployeeService;

//@WebMvcTest(EmployeeRestController.class)
@RunWith(SpringRunner.class)
@SpringBootTest(
  webEnvironment=SpringBootTest.WebEnvironment.MOCK,
  classes = Application.class)
@AutoConfigureMockMvc
@TestPropertySource(
  locations = "classpath:application-integrationtest.properties")
public class EmployeeRestControllerIntegrationTest {
 
    @Autowired 
    private MockMvc mvc;
 
    @MockBean
    private EmployeeService service;
 
    // write our test cases here
    @Test
    public void givenEmployees_whenGetEmployees_thenReturnJsonArray()
      throws Exception {
         
        Employee alex = new Employee("alex", "Trump", "address1", 888L);
     
        List<Employee> allEmployees = Arrays.asList(alex);
     
        given(service.retrieveEmployees()).willReturn(allEmployees);
     
        mvc.perform(get("/api/employees")
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andExpect(jsonPath("$", hasSize(1)))  //          .andExpect(jsonPath("$", hasSize(1)))
          .andExpect(jsonPath("$[0].lname", is(alex.getLname())));
    }
    
    // unit test (not integration test), as here no mocks are involved. 
    //Put here just for simplicity for a small project
    /*@Test
    public void givenEmployees_whenGetEmployees_thenStatus200()
      throws Exception {
     
        //createTestEmployee("bob");
     
        mvc.perform(get("/api/employees")
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andExpect((ResultMatcher) content())
          .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
          .andExpect(jsonPath("$[0].name", is("bob")));
    }*/
}