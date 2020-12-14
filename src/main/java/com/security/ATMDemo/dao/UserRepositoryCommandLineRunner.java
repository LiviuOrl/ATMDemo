package com.security.ATMDemo.dao;

import com.security.ATMDemo.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by Liviu
 *
 * This class uses a Functional interface (Java 8 new feature)
 *
 * We make use of the "CommandLineRunner" interface to populate
 * the DB after the bean has been created
 */

@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner {

    private static final Logger log =
            LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);

    // inject userRepository
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        // Populate the user table from H2 (in memory DB) at StartUp

        User newUser1 = new User("Billy",
                "$2a$10$RtH5yPzrDeFzpfaJPPno9.B/zfDINUOUPcfP351Sjtd/yIFxuaNEe", 20000);
        userRepository.save(newUser1);
        log.info("New client created: " + newUser1);

        User newUser2 = new User("Bobby",
                "$2a$10$1uByxhMlbrINrFd3ZZXloOQGVuUyvieWbRC.FZkSuOlrm1Fcw03PC", 15000);
        userRepository.save(newUser2);
        log.info("New client created: " + newUser2);

        User newUser3 = new User("Johnny",
                "$2a$10$uZ88FD2GgJ3glCOI5cmXYOm6cFhOzmBPNAgjm0KHbANE9tHyQnfwq", 10000);
        userRepository.save(newUser3);
        log.info("New client created: " + newUser3);
    }
}
