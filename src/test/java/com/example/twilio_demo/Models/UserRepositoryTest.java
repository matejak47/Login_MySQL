package com.example.twilio_demo.Models;
import static org.assertj.core.api.Assertions.assertThat;

import com.example.twilio_demo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository repo;
    @Test
    public void testCreateUser() {

        User user = new User();
        user.setPassword("ravi2020");
        user.setUsername("Ravffi");
        user.setRole("USER");

        User savedUser = repo.save(user);

        User existUser = entityManager.find(User.class, savedUser.getId());

        assertThat(user.getUsername()).isEqualTo(existUser.getUsername());

    }
    @Test
    public void testFindByUsername() {
        String username = "Jan";
        User user = repo.findByUsername(username);
        assertThat(user.getUsername()).isEqualTo(username);
    }
}
