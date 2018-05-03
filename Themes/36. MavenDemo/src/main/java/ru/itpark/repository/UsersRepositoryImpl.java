package ru.itpark.repository;

import ru.itpark.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersRepositoryImpl implements UsersRepository {

  //language=SQL
  public static final String SQL_FIND_OWNER_BY_ID =
      "SELECT * FROM owner WHERE id = ?";

  public static final String SQL_FIND_ALL =
      "SELECT * FROM owner";

  //language=SQL
  public static final String SQL_INSERT_OWNER =
      "INSERT INTO owner(name, age, height) VALUES (?,?,?)";

  private Connection connection;

  private PreparedStatement findByIdStatement;
  private PreparedStatement findAllStatement;
  private PreparedStatement insertStatement;

  // анонимный класс
  private RowMapper<User> userRowMapper = new RowMapper<User>() {
    @Override
    public User mapRow(ResultSet row) throws SQLException {
      return User.builder()
              .id(row.getInt("id"))
              .name(row.getString("name"))
              .age(row.getInt("age"))
              .height(row.getDouble("height"))
              .build();
    }
  };

  public UsersRepositoryImpl(Connection connection) {
    this.connection = connection;
    try {
      this.findByIdStatement = connection.prepareStatement(SQL_FIND_OWNER_BY_ID);
      this.findAllStatement = connection.prepareStatement(SQL_FIND_ALL);
      this.insertStatement = connection.prepareStatement(SQL_INSERT_OWNER, Statement.RETURN_GENERATED_KEYS);
    } catch (SQLException e) {
      throw new IllegalArgumentException(e);
    }
  }

  @Override
  public User find(int id) {
    try {
      findByIdStatement.setInt(1, id);
      ResultSet resultSet = findByIdStatement.executeQuery();
      resultSet.next();
      return userRowMapper.mapRow(resultSet);
    } catch (SQLException e) {
      throw new IllegalArgumentException(e);
    }
  }

  @Override
  public List<User> findAll() {
    try {
      ResultSet resultSet = findAllStatement.executeQuery();
      List<User> resultList = new ArrayList<>();

      while (resultSet.next()) {
        User newUser = userRowMapper.mapRow(resultSet);
        resultList.add(newUser);
      }

      return resultList;
    } catch (SQLException e) {
      throw new IllegalArgumentException(e);
    }
  }

  @Override
  public void save(User model) {
    try {
      insertStatement.setString(1, model.getName());
      insertStatement.setInt(2, model.getAge());
      insertStatement.setDouble(3, model.getHeight());

      // выполнили запрос и получили количество добавленных строк
      int affectedRows = insertStatement.executeUpdate();

      if (affectedRows == 0) {
        throw new IllegalArgumentException("Something wrong");
      }
      // получили список сгенерированных ключей из бд
      ResultSet generatedKeys = insertStatement.getGeneratedKeys();
      generatedKeys.next();
      // получаем сгенерированный id и кладем в модель
      model.setId(generatedKeys.getInt(1));
    } catch (SQLException e) {
      throw new IllegalArgumentException(e);
    }
  }
}
