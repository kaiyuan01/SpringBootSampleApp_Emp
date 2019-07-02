package com.dengsoft.tutorial.springboot.emp;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.dengsoft.tutorial.springboot.emp.db.model.Employee;
import com.dengsoft.tutorial.springboot.emp.db.repository.EmployeeRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryIntegrationTest {
 
    @Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private EmployeeRepository employeeRepository;
 
    // Some test cases here
    @Test
    public void whenFindByName_thenReturnEmployee() {
        // given
        Employee alex = new Employee("alex", "Trump", "address1", 888L);
        entityManager.persist(alex);
        entityManager.flush();
     
        // when
        Employee found = employeeRepository.findByLastName(alex.getLname()).get();
     
        // then
        assertThat(found.getLname())
          .isEqualTo(alex.getLname());
    }
}