package com.security.ATMDemo;

import com.security.ATMDemo.dao.UserRepository;
import com.security.ATMDemo.entity.User;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

/**
 * Created by Liviu
 */

@DataJpaTest
public class UserRepositoryIntegrationTest {

    private static final Logger log =
            LoggerFactory.getLogger(UserRepositoryIntegrationTest.class);

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;


    // In the below test, we're using the TestEntityManager
    // to insert an User in the DB and afterwards
    // reading it via the findByUserName method from the userRepository
    @Test
    public void whenFindByName_thenReturnUser() {
        // given
        User alex = new User("Alex",
                "$2a$10$xwixRXlYmi01WsvSULIZP.VUMO6BGViVxxGpB3sX1L6oB.t4F28kq", 30000);
        entityManager.persist(alex);
        entityManager.flush();

        log.info("===Alex user: " + alex);

        // when
        User found = userRepository.findByUserName(alex.getUserName());
        log.info("===Found user: " + found);

        // then
        assert(found.getUserName()).equals(alex.getUserName());
    }
}
