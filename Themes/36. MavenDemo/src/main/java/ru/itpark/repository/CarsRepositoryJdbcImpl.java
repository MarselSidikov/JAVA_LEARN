package ru.itpark.repository;

import ru.itpark.models.Car;
import ru.itpark.models.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarsRepositoryJdbcImpl implements CarsRepository {

  //language=SQL
  public static final String SQL_SELECT_CAR_WITH_USER_BY_ID =
      "SELECT c.*, o.name, o.age, o.height, o.id as user_id FROM car c" +
          "  LEFT JOIN owner o on c.owner_id = o.id WHERE c.id = ?";

  //language=SQL
  public static final String SQL_SELECT_ALL_WITH_USER =
      "SELECT c.*, o.name, o.age, o.height, o.id as user_id FROM car c" +
          "  LEFT JOIN owner o on c.owner_id = o.id";

  private Connection connection;

  private PreparedStatement findByIdStatement;
  private PreparedStatement findAllStatement;

  public CarsRepositoryJdbcImpl(DataSource dataSource) {
    try {
      this.connection = dataSource.getConnection();
      this.findByIdStatement = connection.prepareStatement(SQL_SELECT_CAR_WITH_USER_BY_ID);
      this.findAllStatement = connection.prepareStatement(SQL_SELECT_ALL_WITH_USER);
    } catch (SQLException e) {
      throw new IllegalArgumentException(e);
    }

  }

  private RowMapper<Car> carsRowMapper = new RowMapper<Car>() {
    @Override
    public Car mapRow(ResultSet row) throws SQLException {
      Integer carId = row.getInt("id");
      String model = row.getString("model");
      String color = row.getString("color");

      Integer userId = row.getInt("user_id");
      User owner = null;
      if (!row.wasNull()) {
        owner = User.builder()
            .id(userId)
            .age(row.getInt("age"))
            .height(row.getDouble("height"))
            .name(row.getString("name"))
            .build();
      }
      return Car.builder()
          .id(carId)
          .color(color)
          .model(model)
          .owner(owner)
          .build();
    }
  };

  @Override
  public Car find(int id) {
    try {
      findByIdStatement.setInt(1, id);
      ResultSet result = findByIdStatement.executeQuery();
      result.next();
      return carsRowMapper.mapRow(result);
    } catch (SQLException e) {
      throw new IllegalArgumentException(e);
    }
  }

  @Override
  public List<Car> findAll() {
    try {
      ResultSet resultSet = findAllStatement.executeQuery();
      List<Car> resultList = new ArrayList<>();

      while (resultSet.next()) {
        Car car = carsRowMapper.mapRow(resultSet);
        resultList.add(car);
      }

      return resultList;
    } catch (SQLException e) {
      throw new IllegalArgumentException(e);
    }
  }

  @Override
  public void save(Car model) {

  }
}
