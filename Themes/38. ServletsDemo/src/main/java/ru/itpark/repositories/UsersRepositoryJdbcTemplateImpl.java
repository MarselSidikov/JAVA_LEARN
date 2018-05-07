package ru.itpark.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itpark.models.User;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {

  private static final String SQL_INSERT_OWNER =
      "INSERT INTO owner(name, age, height) VALUES (?,?,?)";

  private static final String SQL_FIND_ALL =
      "SELECT * FROM owner";

  private JdbcTemplate jdbcTemplate;

  public UsersRepositoryJdbcTemplateImpl(DataSource dataSource) {
    this.jdbcTemplate = new JdbcTemplate(dataSource);
  }

  @Override
  public List<User> findAllWithCars() {
    return null;
  }

  private RowMapper<User> userRowMapper = new RowMapper<User>() {
    @Override
    public User mapRow(ResultSet row, int i) throws SQLException {
      return User.builder()
          .id(row.getInt("id"))
          .name(row.getString("name"))
          .age(row.getInt("age"))
          .height(row.getDouble("height"))
          .build();
    }
  };

  @Override
  public User find(int id) {
    return null;
  }

  @Override
  public List<User> findAll() {
    return jdbcTemplate.query(SQL_FIND_ALL, userRowMapper);
  }

  @Override
  public void save(User model) {
    jdbcTemplate.update(SQL_INSERT_OWNER, model.getName(), model.getAge(), model.getHeight());
  }
}
