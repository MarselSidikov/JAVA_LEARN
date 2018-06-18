package ru.itpark.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import ru.itpark.test.models.User;
import ru.itpark.test.service.app.Application;
import ru.itpark.test.repositories.UsersRepository;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest(classes = Application.class)
public class UsersRepositoryTest {

  @Autowired
  private UsersRepository testingRepository;

  private User expectedUser = User.builder()
      .id(10L)
      .age(24)
      .name("Игорь")
      .login("marsel")
      .build();

  @Test
  public void findAllByAge() {
    User actualUser = testingRepository
        .findOne(10L);
    assertEquals(expectedUser, actualUser);
  }
}