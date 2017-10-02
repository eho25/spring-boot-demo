package com.sboot.data.repositories;

import com.sboot.data.config.RepositoryTestConfig;
import com.sboot.data.entities.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = RepositoryTestConfig.class)
public class PersonRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PersonRepository personRepo;

    private static final String NAME = "test";

    @Test
    public void testFindAll(){
        Person p = new Person();
        p.setFirstName(NAME);
        p.setLastName(NAME);
        p.setJobId(1);
        p.setId(1);
        entityManager.persistAndFlush(p);
        List<Person> foundPeople = personRepo.findAll();
        assertTrue(foundPeople.size() > 0);
    }

}
