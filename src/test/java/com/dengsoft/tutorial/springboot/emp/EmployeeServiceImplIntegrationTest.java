package com.dengsoft.tutorial.springboot.emp;

import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.Assert.assertThat;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.dengsoft.tutorial.springboot.emp.db.model.Employee;
import com.dengsoft.tutorial.springboot.emp.db.repository.EmployeeRepository;
import com.dengsoft.tutorial.springboot.emp.service.EmployeeService;
import com.dengsoft.tutorial.springboot.emp.service.impl.EmployeeServiceImpl;

@RunWith(SpringRunner.class)
public class EmployeeServiceImplIntegrationTest {
 
    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {
  
        @Bean
        public EmployeeService employeeService() {
            return new EmployeeServiceImpl();
        }
    }
 
    @Autowired
    private EmployeeService employeeService;
 
    @MockBean
    private EmployeeRepository employeeRepository;
 
    // write test cases here
    @Before
    public void setUp() {
        Employee alex = new Employee("alex", "Trump", "address1", 888L);
     
        alex.setId(99L);

        // assuming last name is unique in our records...
        Mockito.when(employeeRepository.findByLastName(alex.getLname()))
          .thenReturn(Optional.of(alex));
    }
    
    @Test
    public void whenValidName_thenEmployeeShouldBeFound() {
        String name = "Trump";
        Employee found = employeeService.getEmployee(name);
      
         assertThat(found.getLname())
          .isEqualTo(name);
     }
    
}