package ru.itpark;

import ru.itpark.models.User;

import java.sql.*;
import java.util.Scanner;

public class Main {

    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "Zaq12wsx";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/it_park_group_5";

    //language=SQL
    private static final String SQL_SELECT_NAMES_FROM_OWNER =
        "SELECT name FROM owner";

    //language=SQL
    public static final String SQL_INSERT_OWNER =
        "INSERT INTO owner(name, age, height) VALUES (?, ?, ?);";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            Connection connection =
                DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_NAMES_FROM_OWNER);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }

            System.out.println("Please enter the name");
            String name = scanner.nextLine();
            System.out.println("Please enter the age");
            int age = scanner.nextInt();
            System.out.println("Please enter the height");
            double height = scanner.nextDouble();

//            String query = "INSERT INTO owner(name, age, height) VALUES ('"
//                + name + "', " + age + ", " + height + ");";
//            System.out.println(query);
//            statement.execute(query);
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_OWNER);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setDouble(3, height);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
