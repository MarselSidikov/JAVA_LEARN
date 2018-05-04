package ru.itpark.repository;

import ru.itpark.models.Car;
import ru.itpark.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsersRepositoryJdbcImpl implements UsersRepository {

  //language=SQL
  private static final String SQL_FIND_OWNER_BY_ID =
      "SELECT * FROM owner WHERE id = ?";

  private static final String SQL_FIND_ALL =
      "SELECT * FROM owner";

  //language=SQL
  private static final String SQL_INSERT_OWNER =
      "INSERT INTO owner(name, age, height) VALUES (?,?,?)";

  //language=SQL
  private static final String SQL_SELECT_ALL_WITH_CARS =
      "SELECT o.*, c.color, c.model, c.owner_id, c.id as car_id FROM owner o LEFT JOIN car c on o.id = c.owner_id;";


  private Connection connection = null;

  private PreparedStatement findByIdStatement;
  private PreparedStatement findAllStatement;
  private PreparedStatement insertStatement;
  private PreparedStatement findAllWithCarsStatement;

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

  private RowMapper<User> userWithCarsRowMapper = new RowMapper<User>() {
    @Override
    public User mapRow(ResultSet row) throws SQLException {
      // создаем пользователя на основе текущей строки
      User user = userRowMapper.mapRow(row);
      // если пользователя еще не обрабатывали
      // то есть его нет в map
      if (!usersMap.containsKey(user.getId())) {
        // создаем пустой список машин у пользователя
        user.setCars(new ArrayList<Car>());
        // кладем этого пользователя в map под его id
        usersMap.put(user.getId(), user);
      }
      // вытаскиваем id машины из текущей строки
      Integer carId = row.getInt("car_id");
      // если id-машины был
      if (!row.wasNull()) {
        // создаем машину на основе этой строки
        Car car = Car.builder()
            .id(carId)
            .color(row.getString("color"))
            .model(row.getString("model"))
            .build();
        // достали из мапа пользователя по его id
        // получили его список машин и добавили эту машину
        // этому пользователю
        usersMap.get(user.getId()).getCars().add(car);
      }

      return user;
    }
  };

  private Map<Integer, User> usersMap = new HashMap<>();

  public UsersRepositoryJdbcImpl(DataSource dataSource) {
    try {
      this.connection = dataSource.getConnection();
      this.findByIdStatement = connection.prepareStatement(SQL_FIND_OWNER_BY_ID);
      this.findAllStatement = connection.prepareStatement(SQL_FIND_ALL);
      this.insertStatement = connection.prepareStatement(SQL_INSERT_OWNER, Statement.RETURN_GENERATED_KEYS);
      this.findAllWithCarsStatement = connection.prepareStatement(SQL_SELECT_ALL_WITH_CARS);
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

  @Override
  public List<User> findAllWithCars() {
    try {
      // получили результат запроса
      ResultSet resultSet = findAllWithCarsStatement.executeQuery();
      // для каждой строки запроса
      while (resultSet.next()) {
        // вызвали метод mapRow, он либо кладет
        // нового пользователя в map с новой машиной
        // либо просто добавляет новую машину пользователю
        userWithCarsRowMapper.mapRow(resultSet);
      }
      // создаем список пользователей на основе значений из map
      List<User> result = new ArrayList<>(usersMap.values());
      // очищаем map
      usersMap.clear();
      // возвращаем результат
      return result;
    } catch (SQLException e) {
      throw new IllegalArgumentException(e);
    }
  }
}
