package ru.itpark.repository;

import ru.itpark.models.User;
import ru.itpark.util.IdGenerator;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class UsersRepositoryFileWriterImpl implements UsersRepository {

  private FileWriter writer;
  private String fileName;
  private IdGenerator idGenerator;

  public UsersRepositoryFileWriterImpl(String fileName, IdGenerator idGenerator) {
    this.fileName = fileName;
    this.idGenerator = idGenerator;
  }

  @Override
  public User find(int id) {
    return null;
  }

  @Override
  public void delete(int id) {

  }

  @Override
  public void save(User user) {
    try {
      writer = new FileWriter(fileName, true);
      int id = idGenerator.getNewId();
      writer.write(id + " "
          + user.getBirthDate().toString()
          + " " + user.getFirstName()
          + " " + user.getLastName() + "\n");
      user.setId(id);
      writer.close();
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }

  }

  @Override
  public void update(User user) {

  }
}
